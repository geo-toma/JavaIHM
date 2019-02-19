package tpCalculette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private String reslt = "";
	JLabel label = new JLabel("du texte");
	JPanel pan = new JPanel();
	Panneau pan1 = new Panneau();
	Panneau pan2 = new Panneau();
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel content = new JPanel();
	JButton boutons[] = new JButton[12];
	Bouton bouton[] = new Bouton[5];
	JPanel tabPan[] = new JPanel[5];
	
	public Fenetre() {
		this.setTitle("Calculette");
		this.setSize(220, 240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		
		pan.setBackground(Color.YELLOW);
		pan.setOpaque(false);
		pan.setLayout(new FlowLayout());
		panel.setBackground(Color.GREEN);
		panel.setLayout(new GridLayout(2, 1, 0, 10));
		panel.setPreferredSize(new Dimension(50, 130));
	
		pan.add(pan1);
		panel.add(pan2);
		
		content.add(pan);
		content.add(panel);
		
		this.add(content);
		this.setVisible(true);
	}
	
	public void name() {
		
	}
	

}
