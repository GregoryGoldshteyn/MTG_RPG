package mtg_rpg;

import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;

public class TheStack extends JInternalFrame{
	
	static final int xOffset = 30, yOffset = 30;
	public int currentEffect = 0;
	public Effect[] effectStack;
	
	public JLayeredPane cardStack; 
	
	public TheStack(int insetx, int insety){
		super("The Stack", true, false, false, true);
		setLocation(insetx, insety);
		setSize(255, 360);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		effectStack = new Effect[1000];
		cardStack = new JLayeredPane();
		cardStack.setPreferredSize(new Dimension(250, 400));
	}
	
	public void addToStack(Effect e){
		effectStack[currentEffect] = e;
		currentEffect += 1;
	}
	
	public boolean resolveEffect(){
		currentEffect -= 1;
		return effectStack[currentEffect].resolve();
	}

}
