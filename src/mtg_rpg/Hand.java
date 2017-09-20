package mtg_rpg;

import java.awt.Dimension;

import javax.swing.*;



public class Hand extends JInternalFrame{
	
	static final int xOffset = 30, yOffset = 30;
	public int numberOfCards;
	public Card[] cardArray;
	
	public JLayeredPane cardStack; 
	
	public Hand(){
		super("Your Hand", true, false, false, true);
		setLocation(Res.DUEL_INSET, Res.DUEL_INSET);
		setSize(255, 420);
		
		cardStack = new JLayeredPane();
		cardStack.setPreferredSize(new Dimension(250, 400));
	}
	
}
