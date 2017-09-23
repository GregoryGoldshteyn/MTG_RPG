package mtg_rpg;

import javax.swing.ImageIcon;

public class Card {

	public int id;
	public String title;
	public String manaCost;
	public String rulesText;
	public String typeText;
	public int power;
	public int toughness;
	public int damage;
	public ImageIcon image;
	
	public Card(String title, String manaCost, String rulesText, String typeText, int power, int toughness, ImageIcon image){
		this.title = title;
		this.manaCost = manaCost;
		this.rulesText = rulesText;
		this.typeText = typeText;
		this.power = power;
		this.toughness = toughness;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
