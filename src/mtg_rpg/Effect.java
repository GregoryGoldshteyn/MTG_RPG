package mtg_rpg;

public class Effect {
	public int GAME_ID;
	public int target;
	public boolean isCountered;
	
	public Effect(){
		
	}
	
	public boolean resolve(){
		if(target == -1){
			return false;
		}
		else if(isCountered){
			return false;
		}
		else{
			return true;
		}
	}
	
}
