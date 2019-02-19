package tpCalculette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Panneau extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel label = new JLabel("du texte");
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	public Panneau() {
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.setPreferredSize(new Dimension(180, 30));
		
		panel2.setLayout(new BorderLayout());
		label.setHorizontalAlignment(JLabel.RIGHT);
		
		panel.setBackground(Color.RED);
		panel2.setBackground(Color.BLUE);
		panel.setOpaque(false);
		panel2.setOpaque(false);
		panel2.add(label);
		this.add(panel);
		this.add(panel2);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
	}

}
