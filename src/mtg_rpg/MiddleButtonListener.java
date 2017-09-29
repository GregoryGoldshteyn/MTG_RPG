package mtg_rpg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.basic.BasicButtonListener;

public class MiddleButtonListener implements ActionListener{

	private GameController gameController;
	
	public MiddleButtonListener(GameController gameController){
		this.gameController = gameController;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		gameController.step(e.getActionCommand());
	}

}
