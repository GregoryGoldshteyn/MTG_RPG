package mtg_rpg;

import java.util.concurrent.TimeUnit;

public class GameController {
	
	public RES.GAME_STATE gameState;
	public Duel duel;
	
	public boolean playerPriority;
	public boolean playerFirst;
	
	public int mulliganSize = 7;
	
	public GameController(Duel duel){
		gameState = RES.GAME_STATE.CHOOSE_FIRST;
		this.duel = duel;
	}
	
	public void pushMessage(String message, long duration){
		System.out.println(message);
		duel.middleButton1.setVisible(false);
		duel.middleButton2.setVisible(false);
		duel.middleButton3.setVisible(false);
		duel.middleLabel.setText(message);
		playerPriority = true;
	}
	
	public void step(String stepString){
		switch(gameState){
			case CHOOSE_FIRST:
				if (System.currentTimeMillis() % 2 == 1){
					pushMessage("You won! You go first", 2500);
					gameState = RES.GAME_STATE.PLAYER_MULLIGAN;
				}
				else{
					pushMessage("Enemy won, you draw first", 2500);
					gameState = RES.GAME_STATE.ENEMY_MULLIGAN;
				}
				break;
			case PLAYER_MULLIGAN:
				for(int i = 0; i < mulliganSize; i++){
					
				}
		}
	}
	
}
