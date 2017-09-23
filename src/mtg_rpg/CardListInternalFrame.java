package mtg_rpg;

import java.awt.Dimension;
import javax.swing.*;

public class CardListInternalFrame extends JInternalFrame{
	
	static final int xOffset = 30, yOffset = 30;
	public int numberOfCards;
	public Card[] cardArray;
	
	public JLayeredPane cardStack; 
	
	public CardListInternalFrame(String windowTitle, int insetx, int insety, Card[] cards){
		super(windowTitle, true, false, false, true);
		this.cardArray = cards;
		setLocation(insetx, insety);
		setSize(255, 360);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		cardStack = new JLayeredPane();
		cardStack.setPreferredSize(new Dimension(250, 400));
	}
	
	public Card getCardByID(int id){
		for(Card c : cardArray){
			if(c.id == id){
				return c;
			}
		}
		return null;
	}
	
}

