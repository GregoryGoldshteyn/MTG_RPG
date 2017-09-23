package mtg_rpg;

import java.awt.Dimension;
import java.awt.Toolkit;

public class RES {
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final int DUEL_INSET = 100;
	public static final int P_HAND_INSET = 200;
	public static final int P_DECK_INSET = 10;
	public static final int P_GRAVE_INSET = 20;
	public static final int P_EXILE_INSET = 30;
	public static final int E_HAND_INSET = 40;
	public static final int E_DECK_INSET = 50;
	public static final int E_GRAVE_INSET = 60;
	public static final int E_EXILE_INSET = 70;
	public static final int STACK_INSET = 80;
	
	public static enum GAME_STATE{
		CHOOSE_FIRST (-5, "_"),
		PLAYER_MULLIGAN (-4, "_"),
		ENEMY_MULLIGAN (-3, "_"),
		PLAYER_TURN_0 (-2, "_"),
		ENEMY_TURN_0 (-1, "_"),
		
		ENEMY_UNTAP (0, "UT"),
		ENEMY_UPKEEP (1, "UP"),
		ENEMY_DRAW (2, "DR"),
		ENEMY_PRE_MAIN (3, "M1"),
		ENEMY_BEGIN_COMBAT (4, "CB"),
		ENEMY_POST_MAIN (5, "M2"),
		ENEMY_END (6, "END"),
		ENEMY_CLEANUP (7, "CL"),
		
		PLAYER_UNTAP (8, "UT"),
		PLAYER_UPKEEP (9, "UP"),
		PLAYER_DRAW (10, "DR"),
		PLAYER_PRE_MAIN (11, "M1"),
		PLAYER_BEGIN_COMBAT (12, "CB"),
		PLAYER_POST_MAIN (13, "M2"),
		PLAYER_END (14, "END"),
		PLAYER_CLEANUP (15, "CL");
		
		public int val;
		public String representation;
		
		GAME_STATE(int val, String representation){
			this.val = val;
			this.representation = representation;
		}
	}
	public static enum EFFECT_TYPE{
		STATIC, TRIGGERED, CAST, ACTIVATED
	}
	//Values for the locations of items in the Duel screen
	public static final int 
	//Life Counter
	LIFE_GRDIX = 0,
	LIFE_GRIDWIDTH = 2,
	LIFE_GRIDHEIGHT = 2,
	
	E_LIFE_GRIDY = 0,
	P_LIFE_GRIDY = 11,
	
	//Mana labels
	MANA_L_GRIDX = 2,
	MANA_L_GRIDWIDTH = 1,
	MANA_L_GRIDHEIGHT = 1,
	
	E_MANA_W_GRIDY = 0,
	E_MANA_U_GRIDY = 1,
	E_MANA_R_GRIDY = 2,
	E_MANA_G_GRIDY = 3,
	E_MANA_B_GRIDY = 4,
	E_MANA_X_GRIDY = 5,
	
	P_MANA_W_GRIDY = 7,
	P_MANA_U_GRIDY = 8,
	P_MANA_R_GRIDY = 9,
	P_MANA_G_GRIDY = 10,
	P_MANA_B_GRIDY = 11,
	P_MANA_X_GRIDY = 12,
	
	//ManaValues
	MANA_V_GRIDX = 3,
	MANA_V_GRIDWIDTH = 1,
	MANA_V_GRIDHEIGHT = 1,
	
	//Hand, Deck, Grave, Exile
	HAND_DECK_GRAVE_EXILE_L_GRIDX = 0,
	HAND_DECK_GRAVE_EXILE_V_GRIDX = 1,
	HAND_DECK_GRAVE_EXILE_L_GRIDWIDTH = 1,
	HAND_DECK_GRAVE_EXILE_L_GRIDHEIGHT = 1,
	HAND_DECK_GRAVE_EXILE_V_GRIDWIDTH = 1,
	HAND_DECK_GRAVE_EXILE_V_GRIDHEIGHT = 1,
	
	E_HAND_GRIDY = 2,
	E_EXILE_GRIDY = 3,
	E_GRAVE_GRIDY = 4,
	E_DECK_GRIDY = 5,
	
	P_HAND_GRIDY = 7,
	P_EXILE_GRIDY = 8,
	P_GRAVE_GRIDY = 9,
	P_DECK_GRIDY = 10,
	
	//Card Display
	CARD_DISPLAY_GRIDX = 0,
	CARD_DISPLAY_GRIDY = 6,
	CARD_DISPLAY_GRIDWIDTH = 4,
	CARD_DISPLAY_GRIDHEIGHT = 1,
	
	//Battlefield
	BATTLE_GRIDX = 5,
	BATTLE_GRIDWIDTH = 1,
	BATTLE_GRIDHEIGHT = 13,
	BATTLE_GRIDY = 0,
	
	STATE_BUTTONS_GRIDX = 4;
	
	public static enum COLOR{
		WHITE ("White", 0),
		BLUE ("Blue", 1),
		RED ("Red", 2),
		GREEN ("Green", 3),
		BLACK ("Black", 4),
		COLORLESS ("Colorless", 5);
		
		private final String str;
		private final int val;
		COLOR(String str, int val){
			this.str = str;
			this.val = val;
		}
		public String getString(){ return str; }
		public int getVal(){ return val; }
		public int getGridx(boolean isLabel){ return (isLabel) ? MANA_L_GRIDX : MANA_V_GRIDX; }
		public int getGridy(boolean isEnemy){ return (isEnemy) ? E_MANA_W_GRIDY + val : P_MANA_W_GRIDY + val; }
	}
		
}
