package mtg_rpg;

import javax.swing.*;

public class Duel extends JFrame{

	public JDesktopPane playArea;
	public Hand hand;
	
	public void displayHand(){
		hand = new Hand();
		hand.setVisible(true);
		playArea.add(hand);
		try{
			hand.setSelected(true);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public Duel(){
		super("DUEL!");
		setBounds(Res.DUEL_INSET, Res.DUEL_INSET, Res.SCREEN_SIZE.width/2, Res.SCREEN_SIZE.height/2);
		playArea = new JDesktopPane();
		displayHand();
		setContentPane(playArea);
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
