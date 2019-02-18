package animation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interactionButton.Bouton;

public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Panneau pan = new Panneau();
	Bouton bouton = new Bouton("Go");
	Bouton bouton1 = new Bouton("Stop");
	JPanel bcontent = new JPanel();
	JPanel content = new JPanel();
	
	int x,y;
	boolean animated = true;
	
	public Fenetre() {
		this.setTitle("animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		bouton.addActionListener(new BoutonListener());
		bouton.setEnabled(false);
		bouton1.addActionListener(new Bouton2Listener());
		
		bcontent.add(bouton);
		bcontent.add(bouton1);
		
		content.setBackground(Color.WHITE);
		content.setLayout(new BorderLayout());
		content.add(pan, BorderLayout.CENTER);
		content.add(bcontent, BorderLayout.SOUTH);
		this.setContentPane(content);
		this.setVisible(true);
		go();
	}

	private void go() {
		boolean backX = false, backY = false;
		x = pan.getPosX();
		y = pan.getPosY();
		while(animated) {
			if(x < 1)
				backX = false;
			if(x > pan.getWidth()-50)
				backX = true;
			if(y < 1)
				backY = false;
			if(y > pan.getHeight()-50)
				backY = true;
			
			if(backX)
				pan.setPosX(--x);
			else
				pan.setPosX(++x);
			
			if(backY)
				pan.setPosY(--y);
			else
				pan.setPosY(++y);
			
			pan.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void name() {
		
	}
	
	class BoutonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			animated = true;
			bouton.setEnabled(false);
			bouton1.setEnabled(true);
		}
		
	}
	
	class Bouton2Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			animated = false;
			bouton.setEnabled(true);
			bouton1.setEnabled(false);
		}
		
	}

}
