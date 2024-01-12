package io.mowitnow.mower.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List; 

public class MowerUtils {
	private static List<Mower> mowers = new ArrayList<Mower>();

	public static void explore(InputStream file) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(file));
		try {
	    	String[] lines = br.lines().toArray(String[]::new);
	    	String firstLine = lines[0];
	    	// Créer la position correspondant au coin supérieur
	    	Position topCorner = new Position(Integer.parseInt(firstLine.substring(0, 1)), 
	    										Integer.parseInt(firstLine.substring(2, 3)));
	    	
	    	// Créer les tondeuses figurant dans le fichier en entrée
	    	for (int i = 1; i < lines.length; i = i + 2) {
	    		Mower t = new Mower();
	    		t.setPosition(new Position(Integer.parseInt(lines[i].substring(0, 1)), 
	    									Integer.parseInt(lines[i].substring(2, 3))));
	    		t.setOrientation(Orientation.valueOf(lines[i].trim().substring(4)));
	    		t.setInstructions(lines[i + 1].trim());
	    		mowers.add(t);
	    	}
	    
	    	// Déplacer les tondeuses
	    	mowers.forEach(t -> t.control(topCorner));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
    }
}
