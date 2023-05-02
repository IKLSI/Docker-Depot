/* Equipe 12 - SAE 2.03
 * LEVESQUE Kyliann, LE BRETON Kyllian, MENARD Esteban 
 * Fichier java permettant de lister les fichiers du dossier uploads et de les écrire dans un fichier data */

// Déclaration des packages

import java.io.*;
import java.util.Scanner;

public class Fichiers 
{
	public static void main(String[] args) 
	{

		// Déclaration des variables

		String cheminDossier = "/home/TP/TP-GIT-equipe12/docker-sae203-equipe12/src/uploads";
		File dossier = new File(cheminDossier);
		File[] fichiers = dossier.listFiles();
		FileReader fr;
		Scanner sc;
		FileWriter fw;

		int cptLig = 0;

		// Vérification de l'existence du dossier

		if (!dossier.isDirectory()) 
		{
			System.out.println("Le chemin spécifié n'est pas un dossier.");
			return;
		}

		System.out.println("Liste des fichiers dans le dossier " + dossier.getAbsolutePath() + ":");

		// Boucle permettant de parcourir le fichier index.html et d'écrire la liste des fichiers dans le dossier à la ligne prévu à cet effet
		
		try
		{
			fr = new FileReader ( "index.html" );
			sc = new Scanner ( fr );
			fw = new FileWriter ( "index.html.tmp" );

			while ( sc.hasNextLine() )
			{
				cptLig++;

				if ( cptLig == 50 )
				{
					for (int i = 0; i < fichiers.length; i++) 
					{
						if (fichiers[i].isFile()) 
						{
							System.out.println(fichiers[i].getName());
							fw.write("\t\t\t\t<li>" + fichiers[i].getName() + "</li>\n");
						}
					}
				}

				fw.write(sc.nextLine() + "\n");
			}

			fw.close();
			fr.close();
			sc.close();

			File fichierTmp = new File("index.html.tmp");
			File fichierExist = new File("index.html");
			fichierExist.delete();
			fichierTmp.renameTo(fichierExist);
		}
		catch (IOException e)
		{
			System.out.println("Erreur d'entrée/sortie");
		}
	}
}