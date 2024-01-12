package io.mowitnow.mower.manager;

import java.io.IOException;
import java.io.InputStream; 

public class Application {
	
	public static void main(String[] args) throws IOException {
		/* Lire le fichier à partir du dossier src/main/resources. 
        Cette méthode permet de rechercher une resource figurant dans le classpath du projet. */
		InputStream inputStream = Application.class.getClassLoader().getResourceAsStream("mowerFile.txt");
		try {
			MowerUtils.explore(inputStream);
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			inputStream.close();
		}
		
	}

}
