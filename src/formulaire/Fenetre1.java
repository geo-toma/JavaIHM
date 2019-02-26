package formulaire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private JTextField jtf = new JTextField();
	private JLabel label = new JLabel("Un JTextField");

	public Fenetre1() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		Font police = new Font("Arial", Font.BOLD, 14);
		
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf.setForeground(Color.BLUE);
		jtf.addKeyListener(new ClavierListener());
		
		
		top.add(label);
		top.add(jtf);
		
		container.add(top, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	public void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isNumeric(char c) {
		try {
		Integer.parseInt(String.valueOf(c));
		}catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	class ClavierListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("Code touche taper "+e.getKeyCode()+" Caractere touche taper "+e.getKeyChar());
			pause();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("Code touche presser "+e.getKeyCode()+" Caractere touche presser "+e.getKeyChar());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			if(isNumeric(e.getKeyChar()))
				System.out.println("Code touche relacher "+e.getKeyCode()+" Caractere touche relacher "+e.getKeyChar());
			else
				jtf.setText(jtf.getText().replace(String.valueOf(e.getKeyChar()), ""));
			pause();
		}
		
	}
}
