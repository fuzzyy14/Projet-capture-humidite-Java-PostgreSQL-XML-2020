# TUTORIEL INSTALLATION
Le code tourne avec l'IDE Eclipse, OpenJDK 14.0.2 et javafx-sdk-11.0.2
- Dans l'IDE, faire clic droit sur le projet puis propriétés-> Java Build Path

- Aller dans Libraries et configurer JRE System Library avec OpenJDK 14.0.2 et JavaFX en créant une librairie et ajouter les jars externes compris dans le package téléchargé sur le site officiel de JavaFX

- Installer et configurer XAMPP : https://www.apachefriends.org/fr/download.html
Note: la version utilisée pour ce projet est celle avec PHP 7.4.15, impossible de garantir le fonctionnement pour PHP 8 et supérieur.

- Placer le dossier "service-humidite" dans /htdoc , c'est à partir des fichiers contenus dans ce dossier que le service de données peut fonctionner

- Installer PostgreSQL, suivre ce tuto pour l'installation : https://www.postgresqltutorial.com/install-postgresql/
Bien cocher la case PGAdmin 4 car cela nous permettera de créer la base de données et de remplir les données.

- Sur PGAdmin, faire la configuration initiale puis créer une base de données nommée "normandiemeteo".
Ensuite clic droit sur la base de données -> Query Tool puis copiez le code situé dans service-humidite/humidite.sql et collez le dans le Query Editor, puis executez le code avec le bouton Play ou avec la touche F5



Delarue Simon
Escudero Esteban
d’Albignac Guillaume

données de capture : humidité dans l’air

http://devoircapture.ddns.net/humidite/bureau/jour
http://devoircapture.ddns.net/humidite/bureau/mois
http://devoircapture.ddns.net/humidite/bureau/annee
http://devoircapture.ddns.net/humidite/mobile/apercu
http://devoircapture.ddns.net/humidite/mobile/alerte


XML-JOUR	-------------------------------------------------

<humidite>
	<bureau>
		<jour>
			<min>12</min>
		<moyenne>84</moyenne>	
		<max>84</max>	
			<heure>
				<valeur>1</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</heure>
<heure>
				<valeur>2</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</heure>	
<heure>
				<valeur>3</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</heure>
<heure>
				<valeur>4</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</heure>
<heure>
				<valeur>5</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</heure>	
		</jour>
	</bureau>
</humidite>


XML-MOIS -------------------------------------------------

<humidite>
	<bureau>
		<mois>
			<min>12</min>
		<moyenne>48</moyenne>	
		<max>84</max>	
			<jour>
				<valeur>1</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</jour>
<jour>
				<valeur>2</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</jour>	
<jour>
				<valeur>3</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</jour>
<jour>
				<valeur>04</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</jour>
<jour>
				<valeur>05</valeur>
				<min>12</min>
			<moyenne>84</moyenne>	
			<max>84</max>	
</jour>	
		</mois>
	</bureau>
</humidite>


XML-ANNEES -------------------------------------------------

<humidite>
	<bureau>
		<annee>
			<mois>
				<valeur>1</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>2</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>3</valeur>
				<min>1</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>4</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>5</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>6</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>7</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>8</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>9</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>10</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>11</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
			<mois>
				<valeur>12</valeur>
				<min>12</min>
				<moyenne>84</moyenne>
				<max>84</max>
</mois>
		</annee>
	</bureau>
</humidite>



XML-APERCUMOBILE  -------------------------------------------------

<humidite>
	<mobile>
		<apercu>
			<mesureactuelle>64</mesureactuelle>
			<moyenne>
				<journee>69</journee>
				<annee>84</annee>	
			</moyenne>
		</apercu>
	</mobile>
</humidite>

XML-ALERTEMOBILE  -------------------------------------------------

<humidite>
	<mobile>
		<alerte>0</alerte>
		<seuil>80</seuil>
	</mobile>
</humidite>
