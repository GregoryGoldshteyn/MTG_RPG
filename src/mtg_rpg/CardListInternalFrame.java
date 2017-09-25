package mtg_rpg;

import java.awt.Dimension;
import javax.swing.*;

public class CardListInternalFrame extends JInternalFrame{
	
	static final int xOffset = 30, yOffset = 30;
	public int numberOfCards;
	public Card[] cardArray;
	
	public JLayeredPane cardStack; 
	private JScrollPane scrollPane;
	
	public CardListInternalFrame(String windowTitle, int insetx, int insety, Card[] cards){
		super(windowTitle, true, false, false, true);
		
		this.cardArray = cards;
		setLocation(insetx, insety);
		setSize(180, 360);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		cardStack = new JLayeredPane();
		cardStack.setPreferredSize(new Dimension(180, 135));
		scrollPane = new JScrollPane(cardStack);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		setContentPane(scrollPane);
	}
	
	public Card getCardByID(int id){
		for(Card c : cardArray){
			if(c.id == id){
				return c;
			}
		}
		return null;
	}
	
	public void addCard(CardSmallLayered c){
		c.setBounds(0, numberOfCards * 20, 170, 135);
		cardStack.add(c, new Integer(numberOfCards));
		cardStack.setPreferredSize(new Dimension(180, 135 + (numberOfCards * 20)));
		numberOfCards += 1;
	}
	
}

