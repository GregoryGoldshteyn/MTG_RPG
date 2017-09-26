package mtg_rpg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.*;
import java.util.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class AI {

	private String targetAI;
	private URL targetURL;
	
	public AI(String targetAI, Duel duel){
		try{
			
			InputStream is = new FileInputStream("AI/duelAI/" + targetAI);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AI testAI = new AI("TIMMY.json", null);
	}

}
