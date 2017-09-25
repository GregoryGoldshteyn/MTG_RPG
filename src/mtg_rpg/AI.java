package mtg_rpg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.*;
import javax.json.stream.JsonParser;

public class AI {

	private String targetAI;
	private URL targetURL;
	
	public AI(String targetAI, Duel duel){
		try{
			
			InputStream is = new FileInputStream("AI/duelAI/" + targetAI);
			JsonReader jsonReader = Json.createReader(is);
			JsonObject root = jsonReader.readObject();
			
			System.out.println(root);
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AI testAI = new AI("TIMMY.json", null);
	}

}
