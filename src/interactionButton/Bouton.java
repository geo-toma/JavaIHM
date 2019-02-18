package interactionButton;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {

	private static final long serialVersionUID = 1L;
	private String name;
	private Image img;
	
	public Bouton(String str) {
		super(str);
		this.name = str;
		try {
			img = ImageIO.read(new File("img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp = new GradientPaint(0, 0, Color.BLUE, 0, 20, Color.CYAN, true);
		g2d.setPaint(gp);
		//g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g2d.setColor(Color.BLACK);
		g2d.drawString(name, this.getWidth()/2 - (this.getWidth()/8), this.getHeight()/2 + 5);
		// cette classe a ete utilise dans le package animation pour son test
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// quand on click sur le bouton
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// click du bouton gauche
		try {
			img = ImageIO.read(new File("img2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// relache du click de la souris
		if (e.getY() > 0 && e.getY() < this.getWidth() && e.getX() > 0 && e.getY() < this.getHeight()) {
			try {
				img = ImageIO.read(new File("img1.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// survol de la souris
		try {
			img = ImageIO.read(new File("img2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// la souris quitte la zone du bouton
		try {
			img = ImageIO.read(new File("img.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
