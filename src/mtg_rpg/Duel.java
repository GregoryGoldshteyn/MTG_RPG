package mtg_rpg;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Duel extends JFrame{

	public JDesktopPane playArea;
	
	public CardListInternalFrame player_hand;
	public CardListInternalFrame player_graveyard;
	public CardListInternalFrame player_exile;
	public CardListInternalFrame player_deck;
	
	public CardListInternalFrame enemy_hand;
	public CardListInternalFrame enemy_graveyard;
	public CardListInternalFrame enemy_exile;
	public CardListInternalFrame enemy_deck;
	
	
	
	public void displayHand(){
		
		player_hand = new CardListInternalFrame("Your hand");
		player_graveyard = new CardListInternalFrame("Your graveyard");
		player_exile = new CardListInternalFrame("Your exiled cards");
		player_deck = new CardListInternalFrame("Your deck");
		
		enemy_hand = new CardListInternalFrame("Enemy hand");
		enemy_graveyard = new CardListInternalFrame("Enemy graveyard");
		enemy_exile = new CardListInternalFrame("Enemy exiled cards");
		enemy_deck = new CardListInternalFrame("Enemy deck");
		
		player_graveyard.setVisible(false);
		player_exile.setVisible(false);
		player_deck.setVisible(false);
		player_hand.setVisible(true);
		
		enemy_graveyard.setVisible(false);
		enemy_exile.setVisible(false);
		enemy_deck.setVisible(false);
		enemy_hand.setVisible(false);
		
		playArea.add(player_hand);
		try{
			player_hand.setSelected(true);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void addToGrid(Container p, Component comp, GridBagConstraints c, int gridx, int gridy, int gridw, int gridh, double weightx, double weighty, int padx, int pady){
		
		c.fill = GridBagConstraints.BOTH;
		c.weighty = weighty;
		c.weightx = weightx;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridheight = gridh;
		c.gridwidth = gridw;
		p.add(comp, c);
		
	}
	
	public static void testGrid(Container p, GridBagConstraints c){
		
		JButton button;
		//Enemy life
		button = new JButton("E_LIFE");
		addToGrid(p, button, c, RES.LIFE_GRDIX, RES.E_LIFE_GRIDY, RES.LIFE_GRIDWIDTH, RES.LIFE_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Enemy mana labels
		button = new JButton("E_L_W");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.E_MANA_W_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("E_L_U");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.E_MANA_U_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("E_L_R");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.E_MANA_R_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("E_L_G");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.E_MANA_G_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("E_L_B");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.E_MANA_B_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("E_L_X");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.E_MANA_X_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Enemy mana values
		button = new JButton("E_V_W");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.E_MANA_W_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.002, 0.001, 0, 0);
		button = new JButton("E_V_U");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.E_MANA_U_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("E_V_R");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.E_MANA_R_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("E_V_G");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.E_MANA_G_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("E_V_B");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.E_MANA_B_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("E_V_X");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.E_MANA_X_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Enemy hand, deck, grave, exile labels
		button = new JButton("Hand");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.E_HAND_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("Deck");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.E_DECK_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("Grave");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.E_GRAVE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("Exile");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.E_EXILE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Values
		button = new JButton("7E");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.E_HAND_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("53E");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.E_DECK_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("1E");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.E_GRAVE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("2E");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.E_EXILE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Player life
		button = new JButton("P_LIFE");
		addToGrid(p, button, c, RES.LIFE_GRDIX, RES.P_LIFE_GRIDY, RES.LIFE_GRIDWIDTH, RES.LIFE_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Player mana labels
		button = new JButton("P_L_W");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.P_MANA_W_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_L_U");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.P_MANA_U_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_L_R");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.P_MANA_R_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_L_G");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.P_MANA_G_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_L_B");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.P_MANA_B_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_L_X");
		addToGrid(p, button, c, RES.MANA_L_GRIDX, RES.P_MANA_X_GRIDY, RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Player mana values
		button = new JButton("P_V_W");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.P_MANA_W_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_V_U");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.P_MANA_U_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_V_R");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.P_MANA_R_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_V_G");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.P_MANA_G_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_V_B");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.P_MANA_B_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("P_V_X");
		addToGrid(p, button, c, RES.MANA_V_GRIDX, RES.P_MANA_X_GRIDY, RES.MANA_V_GRIDWIDTH, RES.MANA_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Player hand, deck, grave, exile labels
		button = new JButton("Hand");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.P_HAND_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("Deck");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.P_DECK_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("Grave");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.P_GRAVE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("Exile");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.P_EXILE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Values
		button = new JButton("7");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.P_HAND_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("53");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.P_DECK_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("1");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.P_GRAVE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		button = new JButton("2");
		addToGrid(p, button, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.P_EXILE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Card Display
		button = new JButton("Card Display");
		addToGrid(p, button, c, RES.CARD_DISPLAY_GRIDX, RES.CARD_DISPLAY_GRIDY, RES.CARD_DISPLAY_GRIDWIDTH, RES.CARD_DISPLAY_GRIDHEIGHT, 0.001, 1.0, 0, 300);
		//Battlefield
		button = new JButton("Battlefield");
		addToGrid(p, button, c, RES.BATTLE_GRIDX, RES.BATTLE_GRIDY, RES.BATTLE_GRIDWIDHT, RES.BATTLE_GRIDHEIGHT, 1.0, 1.0,0,0);
		
	}
	
	public Duel(){
		super("DUEL!");
		setBounds(RES.DUEL_INSET, RES.DUEL_INSET, RES.SCREEN_SIZE.width/2, RES.SCREEN_SIZE.height/2);
		playArea = new JDesktopPane();
		
		playArea.setLayout(new GridBagLayout());
		
		GridBagConstraints grid_cons = new GridBagConstraints();
		grid_cons.fill = GridBagConstraints.HORIZONTAL;
		
		
		//displayHand();
		setContentPane(playArea);
		
		testGrid(playArea, grid_cons);
		
		playArea.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
	}
	
	private static void test(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		Duel duel = new Duel();
		duel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		duel.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				test();
			}
		});
	}

}
