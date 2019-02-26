package formulaire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class Fenetre2 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel container = new JPanel();
	private JFormattedTextField jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JFormattedTextField jtf2 = new JFormattedTextField();
	private JLabel label = new JLabel("Un JTextField");
	private JButton b = new JButton("OK");

	public Fenetre2() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		try {
			MaskFormatter tel = new MaskFormatter("####%");
			jtf2 = new JFormattedTextField(tel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		Font police = new Font("Arial", Font.BOLD, 14);
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf.setForeground(Color.BLUE);
		jtf2.setPreferredSize(new Dimension(150, 30));
		b.addActionListener(new BoutonListener());
		top.add(label);
		top.add(jtf);
		top.add(jtf2);
		top.add(b);
		this.setContentPane(top);
		this.setVisible(true);
	}

	public void name() {

	}

	class BoutonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("TEXT : jtf " + jtf.getText());
			System.out.println("TEXT : jtf2 " + jtf2.getText());
		}
	}
}
