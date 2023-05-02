/* Equipe 12 - SAE 2.03
 * LEVESQUE Kyliann, LE BRETON Kyllian, MENARD Esteban 
 * Script en javascript permettant de stocker les fichiers envoyés par le client de la page index.html dans le dossier uploads */

// Déclaration des modules

const express = require('express');
const multer = require('multer');
const path = require('path');
const app = express();

/* Configuration de multer pour le téléchargement des fichiers
 * Déclaration du répértoire de destination à savoir uploads ainsi que l'intitulé du fichier qui sera identique à celui d'origine */

const storage = multer.diskStorage({
	destination: function (req, file, cb) {
		cb(null, 'uploads/')
	},
	filename: function (req, file, cb) {
		cb(null, file.originalname);
	}	
});
const upload = multer({ storage: storage });

// Récupération des fichiers envoyés par le client depuis l'index.html

app.get('/', function (req, res) {
	res.sendFile(path.join(__dirname, 'index.html'));
});

// Si le fichier est deposé avec succès on met un message de confirmation et de redirection vers la page d'accueil

app.post('/partage', upload.single('file'), function (req, res) {
	res.send('<center><input type="button" value="Cliquez ici pour retourner sur le site" onclick="history.go(-1)"><p>Le fichier a été envoyé avec succès !</p></center>');
});

// Ecoute du script sur le port 3000

app.listen(3000, function () {
	console.log('Le serveur est en écoute sur le port 3000');
});