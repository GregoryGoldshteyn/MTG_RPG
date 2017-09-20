package mtg_rpg;

import javax.swing.*;

public class Main {
	
	private static void init_GUI(){
		//Set up GUI
		JFrame frame = new JFrame("MTG RPG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Hello world");
		frame.getContentPane().add(label);
		
		//Display frame
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				init_GUI();
			}
		});
		
	}

}
