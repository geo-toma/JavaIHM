package bouton;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel pan = new JPanel();
	JButton bouton = new JButton("Mon bouton");
	
	public Fenetre() {
		this.setTitle("bouton");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		pan.add(bouton);
		this.setContentPane(pan);
		this.setVisible(true);
	}
	
	public Fenetre(BorderLayout b) {
		this.setTitle("bouton");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setLayout(b);
		this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
		this.getContentPane().add(new JButton("NORTH"), BorderLayout.NORTH);
		this.getContentPane().add(new JButton("EAST"), BorderLayout.EAST);
		this.getContentPane().add(new JButton("WEST"), BorderLayout.WEST);
		this.getContentPane().add(new JButton("SOUTH"), BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public Fenetre(GridLayout b) {
		this.setTitle("bouton");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setLayout(new GridLayout(3,2)) pour definir la ligne et la colonne a la construction
		this.setLayout(b);
		b.setColumns(2);
		b.setRows(3);
		b.setHgap(5);
		b.setVgap(2);
		this.getContentPane().add(new JButton("1"));
		this.getContentPane().add(new JButton("2"));
		this.getContentPane().add(new JButton("3"));
		this.getContentPane().add(new JButton("4"));
		this.getContentPane().add(new JButton("5"));
		this.getContentPane().add(new JButton("6"));
		this.setVisible(true);
	}
	
	public Fenetre(String str) {
		this.setTitle(str);
		this.setSize(300,120);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel a = new JPanel();
		a.setLayout(new BoxLayout(a, BoxLayout.LINE_AXIS));
		a.add(new JButton("bouton 1"));
		
		JPanel b1 = new JPanel();
		b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		b1.add(new JButton("bouton 2"));
		b1.add(new JButton("bouton 3"));
		
		JPanel b2 = new JPanel();
		b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
		b2.add(new JButton("bouton 4"));
		b2.add(new JButton("bouton 5"));
		b2.add(new JButton("bouton 6"));
		
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		pan.add(a);
		pan.add(b1);
		pan.add(b2);
		
		this.getContentPane().add(pan);
		this.setVisible(true);
	}

	public Fenetre(String str, int i) {
		this.setTitle(str);
		this.setSize(300,i);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Box a = Box.createHorizontalBox();
		a.add(new JButton("bouton 1"));
		
		Box b1 = Box.createHorizontalBox();
		b1.add(new JButton("bouton 2"));
		b1.add(new JButton("bouton 3"));
		
		Box b2 = Box.createHorizontalBox();
		b2.add(new JButton("bouton 4"));
		b2.add(new JButton("bouton 5"));
		b2.add(new JButton("bouton 6"));
		
		Box b3 = Box.createVerticalBox();
		b3.add(a);
		b3.add(b1);
		b3.add(b2);
		
		this.setContentPane(b3);
		this.setVisible(true);
	}
	
	
	
	
	
	public void name() {
		
	}

}
