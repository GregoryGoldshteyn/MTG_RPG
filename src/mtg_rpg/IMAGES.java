package mtg_rpg;

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
	public IMAGES(){
		imageMap = new HashMap();
		for(int i = 204972; i <= 213629; i++){
			//ImageIcon icon = createImageIcon("\\images\\icons\\ICON_" + Integer.toString(i) + ".bmp");
			ImageIcon icon = new ImageIcon("ICON_204972");
			if(icon != null){
				imageMap.put(i, icon);
			}
			else{
				System.out.println(i);
			}
		}
	}
}
