package first_graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		g.fillOval(5, 5, 30, 30);
		g.drawOval(345, 5, 30, 30);
		g.drawRect(5, 40, 30, 20);
		g.fillRect(345, 40, 30, 20);
		g.fillRoundRect(5, 65, 30, 20, 10, 10);
		g.drawRoundRect(345, 65, 30, 20, 10, 10);
		g.drawLine(35, 85, this.getWidth(), this.getHeight());
		g.drawLine(345, 85, 0, this.getHeight());
	    int x[] = {25, 45, 65, 85, 85, 65, 45, 25};
	    int y[] = {190, 170, 170, 190, 210, 230, 230, 210};
	    int x2[] = {295, 315, 335, 355, 355, 335, 315, 295};
	    int x3[] = {165, 185, 205, 225, 225, 205, 185, 165};
	    int y2[] = {290, 270, 270, 290, 310, 330, 330, 310};
	    g.drawPolygon(x, y, 8);
	    g.fillPolygon(x2, y, 8);
	    g.drawPolyline(x3, y2, 8);
	    
	    Font font = new Font("Courrier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.red);
	    g.drawString("interfaces graphiques", 90, 30);
	    
	    try {
			Image image = ImageIO.read(new File("image.png"));
			g.drawImage(image, 130, 40, 100, 40, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    Graphics2D g2d = (Graphics2D) g;
	    GradientPaint gp = new GradientPaint(130, 90, Color.RED, 160, 120, Color.CYAN, true);
	    g2d.setPaint(gp);
	    g2d.fillRect(130, 90, 100, 60);
   
	}
}
