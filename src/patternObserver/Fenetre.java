package patternObserver;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel label = new JLabel();
	JPanel pan = new JPanel();
	
	Horloge horloge;
	
	public Fenetre() {
		this.setTitle("Horloge");
		this.setSize(300,120);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		horloge = new Horloge();
		horloge.addObservateur((String str) -> label.setText(str));
		
		Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
	    this.label.setFont(police);
	    this.label.setHorizontalAlignment(JLabel.CENTER);
		
		this.setLayout(new BorderLayout());
		pan.add(label);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		
		this.setVisible(true);
		
		horloge.run();
	}
	
	public void name() {
		
	}
}
