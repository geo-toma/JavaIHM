package first_graph;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Fenetre() {
		this.setTitle("Ma premi�re fen�tre Java");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new Panneau());

		this.setVisible(true);
	}
	
	public void name() {
	}
}