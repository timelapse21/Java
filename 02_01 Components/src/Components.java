import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Components extends JFrame implements ActionListener, ItemListener, ListSelectionListener {
	
	JLabel label;
	JButton button1, button2;
	JTextField text;
	JRadioButton radio1, radio2;
	JCheckBox chkbox1, chkbox2;
	JList<String> list;
	JComboBox<String> combo;
	
	public Components() {
		super("Components");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 300, 200, 350);
		
		JPanel content = new JPanel();
		JPanel outer = new JPanel(new BorderLayout());
		
		label = new JLabel("This is a label.", JLabel.CENTER);
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		text = new JTextField(10);
		radio1 = new JRadioButton("Radio Button 1");
		radio2 = new JRadioButton("Radio Button 2");
		chkbox1 = new JCheckBox("Checkbox 1");
		chkbox2 = new JCheckBox("Checkbox 2");
		
		String[] listItems = {"Ewan", "Dawson", "Abi", "Tim", "Jimmie", "Mr. Miller", "Rucoplh - rudolph's brother"};
		list = new JList<String>(listItems);
		
		String[] comboItems = {"Tardigrade", "Dalek", "Borg", "CyberMen", "Dawson"};
		combo = new JComboBox<String>(comboItems);
		combo.setEditable(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		text.addActionListener(this);
		radio1.addActionListener(this);
		radio2.addActionListener(this);
		chkbox1.addItemListener(this);
		chkbox2.addItemListener(this);
		list.addListSelectionListener(this);
		combo.addActionListener(this);
		
		
		content.add(button1);
		content.add(button2);
		content.add(text);
		content.add(radio1);
		content.add(radio2);
		content.add(chkbox1);
		content.add(chkbox2);
		content.add(list);
		content.add(combo);
		outer.add(label, BorderLayout.NORTH);
		outer.add(content, BorderLayout.CENTER);
		
		this.setContentPane(outer);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			label.setText("Button 1 was pressed");
		}
		else if (e.getSource() == button2) {
			label.setText("Button 2 was pressed");
		}
		else if (e.getSource() == text) {
			label.setText("You typed: " + text.getText());
		}
		else if (e.getSource() == radio1) {
			label.setText("Radio Button 1 was pressed");
		}
		else if (e.getSource() == radio2) {
			label.setText("Radio Button 2 was pressed");
		}
		else if (e.getSource() == combo) {
			label.setText("Combo Item #" + combo.getSelectedIndex() + ":" + combo.getSelectedItem());
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if (source == chkbox1) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				label.setText("Checkbox 1 was checked.");
			}
			else {
				label.setText("Checkbox 1 was unchecked.");
			}
		}
		else if (source == chkbox2) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				label.setText("Checkbox 2 was checked.");
			}
			else {
				label.setText("Checkbox 2 was unchecked.");
			}
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == list) {
			label.setText("List Item #" + list.getSelectedIndex() + ": " + list.getSelectedValue());
		}
	}
}
