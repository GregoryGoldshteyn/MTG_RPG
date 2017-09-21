package mtg_rpg;

import java.awt.Dimension;
import javax.swing.*;

public class CardListInternalFrame extends JInternalFrame{
	
	static final int xOffset = 30, yOffset = 30;
	public int numberOfCards;
	public Card[] cardArray;
	
	public JLayeredPane cardStack; 
	
	public CardListInternalFrame(String windowTitle){
		super(windowTitle, true, false, false, true);
		setLocation(RES.DUEL_INSET, RES.DUEL_INSET);
		setSize(255, 360);
		
		cardStack = new JLayeredPane();
		cardStack.setPreferredSize(new Dimension(250, 400));
	}
	
}

