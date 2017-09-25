package mtg_rpg;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SmallCardMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getComponent().getName() + " MouseClick");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getComponent().getName() + " MouseOver");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.toString());
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.toString());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.toString());
	}

}
