<?php
    require_once "./BaseDeDonnees.php";
    $basededonnees = BaseDeDonnees::getConnexion();

    $SQL_LISTE_HUMIDITE = "SELECT tauxhumidite FROM humidite ORDER BY id ASC LIMIT 1";
    $requete = $basededonnees->prepare($SQL_LISTE_HUMIDITE);
    $requete->execute();
    $humidites = $requete->fetchAll();
    ?><?php

    header ("Content-Type:text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>'; 

    $valeurSeuil = 60;
    $activerAlerte = 0;

    if($humidites >= $valeurSeuil){
        $activerAlerte = 1;
    }else{
        $activerAlerte = 0;
    }

    //print_r($humidites);
    ?>
    
    <humidite>
        <mobile>
            <alerte><?=$activerAlerte?></alerte>  
	        <seuil><?=$valeurSeuil?></seuil>  
        </mobile>
    </humidite>
