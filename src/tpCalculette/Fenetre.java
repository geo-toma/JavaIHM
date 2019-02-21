package tpCalculette;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private String display = "";
	private String temp = "";
	private Operateur operateur[] = {Operateur.ADDITION,Operateur.SOUSTRATION,Operateur.MULTIPLICATION,Operateur.DIVISION};
	
	Panneau panneau = new Panneau();
	Bouton bouton[] = new Bouton[5];
	
	JPanel pan = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel content = new JPanel();
	JPanel tabPan[] = new JPanel[5];
	JButton boutons[] = new JButton[12];
	
	public Fenetre() {
		this.setTitle("Calculette");
		this.setSize(220, 240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		// ecran d'affichage
		pan.setOpaque(false);
		pan.setLayout(new FlowLayout());
		pan.add(panneau);
		// les boutons d'interactions
		for (int i = 0; i < boutons.length; i++)
			boutons[i] = new JButton();
		for (int i = 1; i < bouton.length; i++)
			bouton[i] = new Bouton(45, 23);
		for (int i = 0; i < tabPan.length; i++)
			tabPan[i] = new JPanel();
		
		panel.setLayout(new GridLayout(4,3,5,5));
		panel.setPreferredSize(new Dimension(135, 135));
		boutons[9].setText("0");
		boutons[10].setText(".");
		boutons[11].setText("=");
		boutons[11].addActionListener(new BoutonEgalListener());
		for (int i = 0; i < 12; i++) {
			if(i < 9)
				boutons[i].setText(""+(i+1));
			if(i < 11)
				boutons[i].addActionListener(this);
			panel.add(boutons[i]);
		}
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		bouton[0] = new Bouton(45, 30);		
		bouton[0].setForeground(Color.RED);
		bouton[0].setText("C");
		bouton[1].setText("+");
		bouton[2].setText("-");
		bouton[3].setText("x");
		bouton[4].setText("/");
		tabPan[0].setPreferredSize(new Dimension(45, 35));
		for (int i = 0; i < 5; i++) {
			bouton[i].addActionListener(new BoutonDeCalculListener());
			if(i > 0)
				tabPan[i].setPreferredSize(new Dimension(45, 29));
			tabPan[i].add(bouton[i]);
			panel1.add(tabPan[i]);
		}
		panel2.add(panel);
		
		pan2.setLayout(new BoxLayout(pan2, BoxLayout.LINE_AXIS));
		pan2.setPreferredSize(new Dimension(50, 160));
		pan2.add(panel2);
		pan2.add(panel1);
		
		ecran();
		this.setVisible(true);
	}

	public void name() {}
	
	public void ecran() {
		temp = "";
		content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.add(pan);
		content.add(pan2);
		this.setContentPane(content);
	}
	
	public double resultat(Operateur operateur, double a, double b) throws DibisionParZeroException {
		if(operateur == Operateur.ADDITION)
			return a+b;
		if(operateur == Operateur.SOUSTRATION)
			return a-b;
		if(operateur == Operateur.MULTIPLICATION)
			return a*b;
		if(operateur == Operateur.DIVISION) {
			if(b == 0)
				throw new DibisionParZeroException();
			return a/b;
		}
		return 0.0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Panneau.label.getText().equals("ERREUR DE SYNTAX") || Panneau.label.getText().equals("ERREUR DE MATHS"))
			Panneau.label.setText("");
		for (int i = 0; i < 9; i++) {
			if(e.getSource() == boutons[i])
				display = Panneau.label.getText()+(i+1);
		}
		if(e.getSource() == boutons[9])
			display = Panneau.label.getText()+0;
		if(e.getSource() == boutons[10])
			display = Panneau.label.getText()+".";
		Panneau.label.setText(display);
		ecran();
	}
	
	class BoutonDeCalculListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 1; i < bouton.length; i++) {
				if( e.getSource() == bouton[i]) {
					if( Panneau.label.getText().equals("ERREUR DE SYNTAX") || Panneau.label.getText().equals("ERREUR DE MATHS"))
						Panneau.label.setText("");
					display = Panneau.label.getText();
					if(display.length() == 0)
						Panneau.label.setText("0");
					else {
						if(("-").contains(Character.toString(display.charAt(0)))) {
							display = display.replaceFirst(Character.toString(display.charAt(0)), "");
							temp = "-";
						}
						if(("+-x/").contains(Character.toString(display.charAt(display.length() - 1))))
							Panneau.label.setText(temp+display.substring(0, display.length() - 1));
						else {
							for(Operateur op : operateur) {
								if(display.contains(op.toString())) {
									String a = op.toString();
									String[] tab;
									if(a.equals("+"))
										tab = display.split("\\+");
									else
										tab = display.split(a);
									try {
										Panneau.label.setText(""+resultat(op, Double.parseDouble(temp+tab[0]), Double.parseDouble(tab[1])));
									} catch (DibisionParZeroException e1) {
									}
									break;
								}
							}
						}
					}
					display = Panneau.label.getText()+operateur[i-1];
					break;
				}
			}
			if(e.getSource() == bouton[0])
				display = "";
			Panneau.label.setText(display);
			ecran();
		}
		
	}
	
	class BoutonEgalListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			display = Panneau.label.getText();
			if( Panneau.label.getText().equals("ERREUR DE SYNTAX") || Panneau.label.getText().equals("ERREUR DE MATHS"))
				Panneau.label.setText("");
			if(display.length() == 0)
				Panneau.label.setText("0");
			else {
				if(("-").contains(Character.toString(display.charAt(0)))) {
					display = display.replaceFirst(Character.toString(display.charAt(0)), "");
					temp = "-";
				}
				if(("+-x/").contains(Character.toString(display.charAt(display.length() - 1))))
					Panneau.label.setText("ERREUR DE SYNTAX");
				else {
					for(Operateur op : operateur) {
						if(display.contains(op.toString())) {
							String a = op.toString();
							String[] tab;
							if(a.equals("+"))
								tab = display.split("\\+");
							else
								tab = display.split(a);
							try {
								Panneau.label.setText(""+resultat(op, Double.parseDouble(temp+tab[0]), Double.parseDouble(tab[1])));
							} catch (DibisionParZeroException e1) {
							}
							break;
						}
					}
				}
			}
			
			ecran();
		}
		
	}
}
