## SAE 2.03 Equipe 12

## Présentation du projet

* Pour ce projet nous avons décider de faire un container docker qui permet de lancer un serveur web ayant pour but de créer un serveur de dépot de stockage de fichiers.
* Ce container est basé sur une image de base debian et est construit à partir d'un DockerFile.

## Prérequis pour lancer le container 

* Avoir docker d'installer sur sa machine
* Avoir git d'installer sur sa machine

## Lancement du container

* Se placer dans le dossier docker-sae-203-equipe12-depot puis dans le dossier src
* Lancer la commande suivante : <b>docker build -t nom_du_container -f DockerFile chemin/absolu</b>
* Puis la commande suivante : <b>sudo docker run -p 3000:3000 -v $(pwd)/uploads:/app/uploads nom_du_container</b> pour Linux ou <b>sudo docker run -p 3000:3000 -v chemin_absolu/uploads:/app/uploads nom_du_container</b> pour Windows
* Enfin, ouvrir un navigateur et taper l'adresse suivante : <b>localhost:3000</b>

## LEVESQUE Kyliann, LE BRETON Kyllian, MENARD Esteban