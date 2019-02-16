package bouton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre1 extends JFrame {
	

	private static final long serialVersionUID = 1L;
	CardLayout c1 = new CardLayout();
	JPanel content =  new JPanel();
	
	String[] listContent = {"CARD_1", "CARD_2", "CARD_3"};
	int indice = 0;
	
	public Fenetre1() {
		this.setTitle("card layout");
		this.setSize(300,120);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel card1 = new JPanel();
		card1.setBackground(Color.RED);
		JPanel card2 = new JPanel();
		card2.setBackground(Color.BLUE);
		JPanel card3 = new JPanel();
		card3.setBackground(Color.GREEN);
		
		JPanel boutonPane = new JPanel();
		
		JButton bouton1 = new JButton("conteneur suivant");
		bouton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c1.next(content);
			}
		});
		
		JButton bouton2 = new JButton("conteneut par indice");
		bouton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(++indice > 2)
					indice = 0;
				
				c1.show(content, listContent[indice]);
			}
		});
		
		boutonPane.add(bouton1);
		boutonPane.add(bouton2);
		
		content.setLayout(c1);
		
		content.add(card1, listContent[0]);
		content.add(card2, listContent[1]);
		content.add(card3, listContent[2]);
		
		this.getContentPane().add(boutonPane, BorderLayout.NORTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
	public void name() {
		
	}

}
