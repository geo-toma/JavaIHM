package interactionButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	int conteur = 0;
	String str = "vous n'avez pas cliquer un bouton";
	JPanel pan = new JPanel();
	JLabel label = new JLabel(str);
	JButton bouton1 = new JButton("bouton 1");
	JButton bouton2 = new JButton("bouton 2");
	
	public Fenetre() {
		this.setTitle("interaction bouton");
		this.setSize(400, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		bouton1.addActionListener(this);
		bouton1.addActionListener(new BoutonListener());
		bouton2.addActionListener(this);
		bouton2.addActionListener(new Bouton2Listener());
		
		pan.add(bouton1);
		pan.add(bouton2);
		
		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);
		label.setForeground(Color.BLUE);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.getContentPane().add(pan, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	public void name() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == bouton1)
//			str = "vous avez cliquer sur le bouton 1";
//		if(e.getSource() == bouton2)
//			str = "vous avez cliquer sur le bouton 2";
//		label.setText(str);
	}
	
	class BoutonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			str = "vous avez cliquer sur le bouton 1";
			label.setText(str);
		}
	}
	
	class Bouton2Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			str = "vous avez cliquer sur le bouton 2";
			label.setText(str);
		}
		
	}
}
