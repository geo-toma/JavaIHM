package tpCalculette;

import java.awt.Dimension;

import javax.swing.JButton;

public class Bouton extends JButton {

	private static final long serialVersionUID = 1L;
	
	public Bouton(int x, int y) {
		this.setPreferredSize(new Dimension(x, y));
	}

}
