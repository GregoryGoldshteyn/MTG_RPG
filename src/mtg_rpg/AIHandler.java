package mtg_rpg;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class AIHandler extends DefaultHandler{

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		System.out.println(qName);
		System.out.println(attributes.getValue("name"));
		System.out.println(attributes.getValue("value"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			File inputFile = new File("AI/duelAI/AI.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			AIHandler aih = new AIHandler();
			saxParser.parse(inputFile, aih);
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
