package mtg_rpg;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Duel extends JFrame{

	public static JDesktopPane playArea;
	
	public CardListInternalFrame player_hand;
	public CardListInternalFrame player_graveyard;
	public CardListInternalFrame player_exile;
	public CardListInternalFrame player_deck;
	
	public CardListInternalFrame enemy_hand;
	public CardListInternalFrame enemy_graveyard;
	public CardListInternalFrame enemy_exile;
	public CardListInternalFrame enemy_deck;
	
	public TheStack theStack;
	
	public static JButton[] stateButtons;
	
	public static JButton[] enemyManaButtons;
	public static JButton[] playerManaButtons;
	public static JLabel[] enemyManaValues;
	public static JLabel[] playerManaValues;
	
	public static JButton enemyHandButton;
	public static JButton enemyDeckButton;
	public static JButton enemyExileButton;
	public static JButton enemyGraveyardButton;
	
	public static JButton playerHandButton;
	public static JButton playerDeckButton;
	public static JButton playerExileButton;
	public static JButton playerGraveyardButton;
	
	public static JLabel enemyHandValue;
	public static JLabel enemyDeckValue;
	public static JLabel enemyExileValue;
	public static JLabel enemyGraveyardValue;
	
	public static JLabel playerHandValue;
	public static JLabel playerDeckValue;
	public static JLabel playerExileValue;
	public static JLabel playerGraveyardValue;
	
	public static JButton playerLife;
	public static JButton enemyLife;
	
	public static JPanel statePanel;
	
	public void setupHand(Card[] playerDeck, Card[] enemyDeck){
		
		player_hand = new CardListInternalFrame("Your hand", RES.P_HAND_INSET, RES.P_HAND_INSET, null);
		player_graveyard = new CardListInternalFrame("Your graveyard", RES.P_GRAVE_INSET, RES.P_GRAVE_INSET, null);
		player_exile = new CardListInternalFrame("Your exiled cards", RES.P_EXILE_INSET, RES.P_EXILE_INSET, null);
		player_deck = new CardListInternalFrame("Your deck", RES.P_DECK_INSET, RES.P_DECK_INSET, playerDeck);
		
		enemy_hand = new CardListInternalFrame("Enemy hand", RES.E_HAND_INSET, RES.E_HAND_INSET, null);
		enemy_graveyard = new CardListInternalFrame("Enemy graveyard", RES.E_GRAVE_INSET, RES.E_GRAVE_INSET, null);
		enemy_exile = new CardListInternalFrame("Enemy exiled cards", RES.E_EXILE_INSET, RES.E_EXILE_INSET, null);
		enemy_deck = new CardListInternalFrame("Enemy deck", RES.E_DECK_INSET, RES.E_DECK_INSET, enemyDeck);
		
		theStack = new TheStack(RES.STACK_INSET, RES.STACK_INSET);
		
		player_graveyard.setVisible(false);
		player_exile.setVisible(false);
		player_deck.setVisible(false);
		player_hand.setVisible(true);
		
		enemy_graveyard.setVisible(false);
		enemy_exile.setVisible(false);
		enemy_deck.setVisible(false);
		enemy_hand.setVisible(false);
		
		theStack.setVisible(false);
		
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
	
	public static void startGrid(Container p, GridBagConstraints c){
		
		JButton button;
		
		enemyManaButtons = new JButton[6];
		playerManaButtons = new JButton[6];
		enemyManaValues = new JLabel[6];
		playerManaValues = new JLabel[6];
		
		enemyHandButton = new JButton("Hand");
		enemyDeckButton = new JButton("Deck");
		enemyGraveyardButton = new JButton("Graveyard");
		enemyExileButton = new JButton("Exile");
		
		playerHandButton = new JButton("Hand");
		playerDeckButton = new JButton("Deck");
		playerGraveyardButton = new JButton("Graveyard");
		playerExileButton = new JButton("Exile");
		
		enemyHandValue = new JLabel("0");
		enemyDeckValue = new JLabel("60");
		enemyGraveyardValue = new JLabel("0");
		enemyExileValue = new JLabel("0");
		
		playerHandValue = new JLabel("0");
		playerDeckValue = new JLabel("60");
		playerGraveyardValue = new JLabel("0");
		playerExileValue = new JLabel("0");
		
		playerLife = new JButton("20");
		enemyLife = new JButton("20");
		
		stateButtons = new JButton[16];
		
		//Enemy life
		addToGrid(p, enemyLife, c, RES.LIFE_GRDIX, RES.E_LIFE_GRIDY, RES.LIFE_GRIDWIDTH, RES.LIFE_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		
		//Enemy mana labels
		for (RES.COLOR color : RES.COLOR.values()){
		enemyManaButtons[color.getVal()] = new JButton(color.getString());
		addToGrid(p, enemyManaButtons[color.getVal()], c, RES.MANA_L_GRIDX, RES.E_MANA_W_GRIDY + color.getVal(), RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		}
		
		//Enemy mana values
		for (RES.COLOR color : RES.COLOR.values()){
		enemyManaValues[color.getVal()] = new JLabel("0");
		addToGrid(p, enemyManaValues[color.getVal()], c, RES.MANA_V_GRIDX, RES.E_MANA_W_GRIDY + color.getVal(), RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		}	
		
		//Player mana labels
		for (RES.COLOR color : RES.COLOR.values()){
		playerManaButtons[color.getVal()] = new JButton(color.getString());
		addToGrid(p, playerManaButtons[color.getVal()], c, RES.MANA_L_GRIDX, RES.P_MANA_W_GRIDY + color.getVal(), RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		}
		
		//Player mana values
		for (RES.COLOR color : RES.COLOR.values()){
		playerManaValues[color.getVal()] = new JLabel("0");
		addToGrid(p, playerManaValues[color.getVal()], c, RES.MANA_V_GRIDX, RES.P_MANA_W_GRIDY + color.getVal(), RES.MANA_L_GRIDWIDTH, RES.MANA_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		}	
		
		//Enemy hand, deck, grave, exile labels
		addToGrid(p, enemyHandButton, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.E_HAND_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, enemyDeckButton, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.E_DECK_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, enemyGraveyardButton, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.E_GRAVE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, enemyExileButton, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.E_EXILE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Values
		addToGrid(p, enemyHandValue, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.E_HAND_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, enemyDeckValue, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.E_DECK_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, enemyGraveyardValue, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.E_GRAVE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, enemyExileValue, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.E_EXILE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Player life
		addToGrid(p, playerLife, c, RES.LIFE_GRDIX, RES.P_LIFE_GRIDY, RES.LIFE_GRIDWIDTH, RES.LIFE_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		
		//Player hand, deck, grave, exile labels
		addToGrid(p, playerHandButton, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.P_HAND_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, playerDeckButton, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.P_DECK_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, playerGraveyardButton, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.P_GRAVE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, playerExileButton, c, RES.HAND_DECK_GRAVE_EXILE_L_GRIDX, RES.P_EXILE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Values
		addToGrid(p, playerHandValue, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.P_HAND_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, playerDeckValue, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.P_DECK_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, playerGraveyardValue, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.P_GRAVE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		addToGrid(p, playerExileValue, c, RES.HAND_DECK_GRAVE_EXILE_V_GRIDX, RES.P_EXILE_GRIDY, RES.HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH, RES.HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT, 0.001, 0.001, 0, 0);
		//Card Display
		button = new JButton("Card Display");
		addToGrid(p, new JLabel(new ImageIcon("images/m2011pics/PIX_205024.jpg")), c, RES.CARD_DISPLAY_GRIDX, RES.CARD_DISPLAY_GRIDY, RES.CARD_DISPLAY_GRIDWIDTH, RES.CARD_DISPLAY_GRIDHEIGHT, 0.001, 1.0, 0, 300);
		//Battlefield
		//playArea.setLayout(new BoxLayout(playArea, BoxLayout.Y_AXIS));
		addToGrid(p, playArea, c, RES.BATTLE_GRIDX, RES.BATTLE_GRIDY, RES.BATTLE_GRIDWIDTH, RES.BATTLE_GRIDHEIGHT, 1.0, 1.0,0,0);
		
		//StateList
		statePanel = new JPanel();
		statePanel.setLayout(new GridLayout(0,1));
		//State buttons
		for(RES.GAME_STATE state : RES.GAME_STATE.values()){
			if(state.val >= 0){
				stateButtons[state.val] = new JButton(state.representation);
				if(state.val == 8){
					JLabel l = new JLabel();
					statePanel.add(l);
				}
				if(state.val >= 8){
					stateButtons[state.val].setBackground(Color.red);
				}
				statePanel.add(stateButtons[state.val]);
			}
		}
		
		addToGrid(p, statePanel, c, 4, 0, 1, 13, 0.01, 0.01, 0, 0);
	}
	
	public boolean init(){
		playerLife.setText("20");
		enemyLife.setText("20");
		return true;
	}
	
	public boolean gameLoop(){
		return true;
	}
	
	public Duel(Card[] playerDeck, Card[] enemyDeck){
		super("DUEL!");
		IMAGES i = new IMAGES();
		setBounds(RES.DUEL_INSET, RES.DUEL_INSET, RES.SCREEN_SIZE.width/2 + 600, RES.SCREEN_SIZE.height/2 + 200);
		
		JPanel buttonPanel = new JPanel();
		playArea = new JDesktopPane();
		buttonPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints grid_cons = new GridBagConstraints();
		grid_cons.fill = GridBagConstraints.HORIZONTAL;
		setContentPane(buttonPanel);
		startGrid(buttonPanel, grid_cons);
		playArea.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		setupHand(playerDeck, enemyDeck);
		player_hand.addCard(new CardSmallLayered("0", "Mana Leak", i.imageMap.get(204981), RES.CARD_COLORS.BLUE_BORDER.getColor()));
		player_hand.addCard(new CardSmallLayered("1", "Duress", i.imageMap.get(205024), RES.CARD_COLORS.BLACK_BORDER.getColor()));
		player_hand.addCard(new CardSmallLayered("2", "Mana Leak", i.imageMap.get(204981), RES.CARD_COLORS.RED_BORDER.getColor()));
		player_hand.addCard(new CardSmallLayered("3", "Duress", i.imageMap.get(205024), RES.CARD_COLORS.GREEN_BORDER.getColor()));
		player_hand.addCard(new CardSmallLayered("4", "Mana Leak", i.imageMap.get(204981), RES.CARD_COLORS.WHITE_BORDER.getColor()));
		
	}
	
	private static void test(Card[] playerDeck, Card[] enemyDeck){
		JFrame.setDefaultLookAndFeelDecorated(true);
		Duel duel = new Duel(playerDeck, enemyDeck);
		duel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		duel.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				test(null, null);
			}
		});
	}

}
