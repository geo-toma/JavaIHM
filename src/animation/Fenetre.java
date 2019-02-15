package animation;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Panneau pan = new Panneau();
	
	public Fenetre() {
		this.setTitle("animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
		go();
	}

	private void go() {
		boolean backX = false, backY = false;
		for (; ;) {
			int x = pan.getPosX(), y = pan.getPosY();
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

}
