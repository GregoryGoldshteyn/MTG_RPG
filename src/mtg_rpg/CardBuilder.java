package mtg_rpg;
import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class CardBuilder extends DefaultHandler{

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		System.out.println(qName);
		System.out.println(attributes.getValue("value"));
	}
	
	public CardBuilder(String cardListPath){
		try{
			File inputFile = new File(cardListPath);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(inputFile, this);
		} catch(Exception e){
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CardBuilder b = new CardBuilder("cards/smallSet.xml");
		
	}

}
