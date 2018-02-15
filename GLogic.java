public class GLogic {
	
	//The active player starts with priority
	public boolean playerHasPriority = true;
	//Number of passes, needed to check if time to resolve effect
	public int passCount = 0;
	
	//Array of effect lists
	//The size is equal to the number of phases
	//The keys are based on constants in the RES class
	//Ex. The list of player effects that trigger on upkeep is playerOnPhaseEffects[RES.UPKEEP]
	public List<Effect>[] playerOnPhaseEffects;
	public List<Effect>[] enemyOnPhaseEffects;
	//The stack
	public Stack theStack;
	
	//executes a phase based on the phase and whose turn it is
	public static int executePhase(int phase, boolean isPlayerTurn){
		
		//Put static on[PHASE] effects on the stack
		while(theStack.duelObjects.length != playerOnPhaseEffects[phase].length){
			theStack.list.push(player.chooseEffect(playerOnPhaseEffects[phase]));
		}
		while(theStack.duelObjects.length != enemyOnPhaseEffects[phase].length + playerOnPhaseEffects[phase].length){
			theStack.list.push(enemy.chooseEffect(enemyOnPhaseEffects[phase]));
		}
		
		//Go through the phase as is tradition
		while(theStack.list.length > 0 || playerHasPriority){
			
			if(playerHasPriority){
				playerHasPriority = player.takeAction(phase);
				if(playerHasPriority){
					passCount = 0;
				}
				else{
					passCount++;
				}
			}
			else{
				playerHasPriority = enemy.takeAction(phase);
				if(playerHasPriority){
					passCount++;
				}
				else{
					passCount = 0;
				}
			}
			if(passCount > 1){
				theStack.resolve();
				passCount = 0;
			}
		}
		if(phase == RES.BEFORECOMBAT){
			duel.declareAttackers(isPlayerTurn);
		}
		if(phase == RES.ATTACKERSDECLARED){
			duel.declareBlockers(isPlayerTurn);
		}
		if(phase == RES.FIRSTSTRIKEDAMAGE){
			duel.resolveFirstStrike();
		}
		if(phase == RES.COMBATDAMAGE){
			duel.resolveCombatDamage();
		}
		
		return phase;
		//Next Phase	
	}
}
