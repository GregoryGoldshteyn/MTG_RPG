package mtg_rpg;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class CardSmallLayered extends JLayeredPane{

	public Card card;
	
	private ImageIcon createImageIcon(String path){
		java.net.URL imgURL = this.getClass().getResource(path);
		//System.out.println(imgURL.getFile());
		if(imgURL != null){
			return new ImageIcon(imgURL);
		}
		else{
			return null;
		}
	}
	
	public CardSmallLayered(String title, String manaCost, String rulesText, String typeText, int power, int toughness, ImageIcon image){
		card = new Card(title, manaCost, rulesText, typeText, power, toughness, image);
		ImageIcon icon = new ImageIcon("ICON_204972.bmp");
		this.setLayout(new GridLayout(2,0));
		JLabel titleLabel = new JLabel(title);
		JLabel imageLabel = new JLabel(icon);
		this.add(titleLabel);
		this.add(imageLabel);
	}
	
	public static void test(){
		IMAGES i = new IMAGES();
		JFrame frame = new JFrame("Testing small layered card");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new CardSmallLayered("Negate", "1B", "Counter target noncreature spell", "Instant", -1, -1, i.imageMap.get(204972)));
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//System.out.println(System.getProperty("user.dir"));
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				test();
			}
		});
		
	}

}
