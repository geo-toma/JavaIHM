package formulaire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private JComboBox<String> combo = new JComboBox<>();
	private JCheckBox box = new JCheckBox("Case 1");
	private JCheckBox box2 = new JCheckBox("Case 2");
	private JRadioButton jr1 = new JRadioButton("Rcase 1");
	private JRadioButton jr2 = new JRadioButton("Rcase 2");
	private ButtonGroup bg = new ButtonGroup();
	private JLabel label = new JLabel("une comboBox : ");
	private String[] tab = {"option 0", "option 1", "option 2"};
	
	public Fenetre() {
		this.setName("Fenetre");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		
		Font font = new Font("Time New Roman", Font.ITALIC, 14);
		
		combo = new JComboBox<>(tab);
		combo.addItemListener(new ItemState());
		combo.addActionListener(new ItemAction());
		combo.setPreferredSize(new Dimension(100, 30));
		combo.setFont(font);
		//combo.setSelectedIndex(2);
		combo.addItem("option 3");
		combo.addItem("option 4");
		
		box.addActionListener(new BoxAction());
		box2.addActionListener(new BoxAction());
		//box.setSelected(true);
		bg.add(jr1);
		bg.add(jr2);
		jr1.addActionListener(new RadioAction());
		jr2.addActionListener(new RadioAction());
		//jr1.setSelected(true);
		
		JPanel top = new JPanel();
		JPanel top1 = new JPanel();
		JPanel top2 = new JPanel();
		JPanel top3 = new JPanel();
		top1.setLayout(new BorderLayout());
		top.add(label);
		top.add(combo);
		top2.add(jr1);
		top2.add(jr2);
		top3.add(box);
		top3.add(box2);
		top1.add(top2, BorderLayout.NORTH);
		top1.add(top3, BorderLayout.SOUTH);
		container.add(top, BorderLayout.NORTH);
		container.add(top1, BorderLayout.SOUTH);
		
		this.setContentPane(container);
		this.setVisible(true);
		
	}
	
	public void name() {
		
	}
	
	class ItemState implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			System.out.println("une action declanche sur "+ e.getItem());	
		}		
	}
	class ItemAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("action effectué sur "+combo.getSelectedItem());
		}		
	}
	class BoxAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Source "+((JCheckBox)e.getSource()).getText()+" - Etat : "+((JCheckBox)e.getSource()).isSelected());
		}		
	}
	class RadioAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("source : " + jr1.getText() + " - état : " + jr1.isSelected());
		    System.out.println("source : " + jr2.getText() + " - état : " + jr2.isSelected());
		}	
	}

}
