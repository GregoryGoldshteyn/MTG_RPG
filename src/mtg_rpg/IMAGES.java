package mtg_rpg;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class IMAGES {
	public Map<Integer, ImageIcon> imageMap;
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
	private ImageIcon getScaledImage(ImageIcon icon, int scalex, int scaley){
		Image image = icon.getImage();
		Image retImage = image.getScaledInstance(icon.getIconWidth() * scalex, icon.getIconHeight() * scaley, Image.SCALE_FAST);
		return new ImageIcon(retImage);
	}
	public IMAGES(){
		imageMap = new HashMap<Integer, ImageIcon>();
		for(int i = 204972; i <= 213629; i++){
			//ImageIcon icon = createImageIcon("\\images\\icons\\ICON_" + Integer.toString(i) + ".bmp");
			ImageIcon icon = getScaledImage(new ImageIcon("images/icons/ICON_" + Integer.toString(i) + ".png"), 3, 3);
			if(icon != null){
				imageMap.put(i, icon);
			}
			else{
				System.out.println(i);
			}
		}
	}
}
