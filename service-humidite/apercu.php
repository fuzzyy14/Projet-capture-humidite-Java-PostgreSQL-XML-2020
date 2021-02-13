<?php
    require_once "./BaseDeDonnees.php";
    $basededonnees = BaseDeDonnees::getConnexion();

    //$SQL_MOYENNES = "SELECT * FROM humidite";
    $SQL_MOYENNES = "SELECT AVG(tauxhumidite) as moyenne FROM humidite 
    WHERE date_part('year', moment) = date_part('year', moment)
    GROUP BY date_part('month',moment) LIMIT 1";
    $requete = $basededonnees->prepare($SQL_MOYENNES);
    $requete->execute();
    $moyennes = $requete->fetchAll(PDO::FETCH_OBJ);
    ?><?php

    header ("Content-Type:text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>';
    ?>

    <humidite>
        <mobile>

<?php
    //print_r($moyennes);
    foreach ($moyennes as $moyenne) 
    {
?>           
                <apercu>                	
	                    <mesureactuelle>56</mesureactuelle>
	                    <moyenne>
	                   		<journee>44</journee>  
	                    	<annee><?=round($moyenne->moyenne)?></annee>  
	                	</moyenne>
                </apercu>
<?php
    }
?>
        </mobile>
    </humidite>
