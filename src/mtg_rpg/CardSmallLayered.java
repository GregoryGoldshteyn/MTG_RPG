package mtg_rpg;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;

public class CardSmallLayered extends JInternalFrame{

	private GridBagConstraints c;
	
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
	
	public int gameID;
	
	public CardSmallLayered(String gameID, String title, ImageIcon image, Color color){
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.anchor = GridBagConstraints.WEST;
		JLabel titleLabel = new JLabel(title);
		JLabel imageLabel = new JLabel(image);
		if(color.getRGB() == RES.CARD_COLORS.WHITE_BORDER.getColor().getRGB()){
			titleLabel.setForeground(Color.BLACK);
		}
		else{
			titleLabel.setForeground(Color.WHITE);
		}
		c.gridy = 0;
		this.add(titleLabel, c);
		c.ipadx = 10;
		c.ipady = 10;
		c.gridy = 1;
		this.add(imageLabel, c);
		this.setBackground(color);
		this.pack();
		this.addMouseListener(new SmallCardMouseListener());
		this.setName(gameID);
		this.setVisible(true);
	}
	
	public static void test(){
		IMAGES i = new IMAGES();
		JFrame frame = new JFrame("Testing small layered card");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new CardSmallLayered("MLEAK", "Mana Leak", i.imageMap.get(204981), RES.CARD_COLORS.BLUE_BORDER.getColor()));
		//frame.setBackground(RES.CARD_COLORS.BLUE_BORDER.getColor());
		frame.pack();
		frame.setVisible(true);
	}
	/*
	public static void main(String[] args) {
		//System.out.println(System.getProperty("user.dir"));
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				test();
			}
		});
		
	}*/

}
