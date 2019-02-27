package animation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interactionButton.Bouton;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private Panneau pan = new Panneau();
	private Bouton bouton = new Bouton("Go");
	private Bouton bouton1 = new Bouton("Stop");
	private JPanel bcontent = new JPanel();
	private JPanel content = new JPanel();
	private String[] tab = { "ROND", "CARRE", "TRIANGLE", "ETOILE" };
	private JComboBox<String> combo = new JComboBox<>(tab);
	private JCheckBox box = new JCheckBox("Morphing");
	private JLabel label = new JLabel("Choix de forme");

	int x, y;
	boolean animated = true;
	boolean backX = false, backY = false;

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

		JPanel top = new JPanel();
		combo.addActionListener(new ItemAction());
		box.addActionListener(new BoxAction());
		top.add(label);
		top.add(combo);
		top.add(box);

		content.setBackground(Color.WHITE);
		content.setLayout(new BorderLayout());
		content.add(top, BorderLayout.NORTH);
		content.add(pan, BorderLayout.CENTER);
		content.add(bcontent, BorderLayout.SOUTH);
		this.setContentPane(content);
		this.setVisible(true);
		go();
	}

	private void go() {
		x = pan.getPosX();
		y = pan.getPosY();
		while (animated) {
			if (x < 1)
				backX = false;
			if (x > pan.getWidth() - pan.getDrawSize())
				backX = true;
			if (y < 1)
				backY = false;
			if (y > pan.getHeight() - pan.getDrawSize())
				backY = true;

			if (backX)
				pan.setPosX(--x);
			else
				pan.setPosX(++x);

			if (backY)
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

	class BoutonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int option = JOptionPane.showConfirmDialog(null, "Voulez vous lancer l'animation ?",
					"lancement de l'animation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.OK_OPTION) {
				animated = true;
				bouton.setEnabled(false);
				bouton1.setEnabled(true);
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						go();
					}
				});
				thread.start();
			}
		}

	}

	class Bouton2Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int option = JOptionPane.showConfirmDialog(null, "Voulez vous arretez l'animatoin", "arret de l'animation",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION
					&& option != JOptionPane.NO_OPTION) {
				animated = false;
				bouton.setEnabled(true);
				bouton1.setEnabled(false);
			}
		}

	}

	class ItemAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			pan.setForme(combo.getSelectedItem().toString());
		}

	}

	class BoxAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (((JCheckBox) e.getSource()).isSelected())
				pan.setMorph(true);
			else
				pan.setMorph(false);
		}

	}

}
