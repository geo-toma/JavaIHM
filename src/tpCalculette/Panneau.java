package tpCalculette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panneau extends JPanel {

	private static final long serialVersionUID = 1L;
	static JLabel label = new JLabel();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	
	public Panneau() {
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.setPreferredSize(new Dimension(195, 30));
		
		panel2.setLayout(new BorderLayout());
		Font police = new Font("Tahoma", Font.BOLD, 14);
		label.setFont(police);
		label.setForeground(Color.BLUE);
		label.setHorizontalAlignment(JLabel.RIGHT);
		
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
