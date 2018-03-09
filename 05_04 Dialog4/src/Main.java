import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		JRadioButton cf = new JRadioButton("Celsius to Fahrenheit");
        JRadioButton fc = new JRadioButton("Fahrenheit to Celsius", true);
        ButtonGroup group = new ButtonGroup();
        group.add(cf);
        group.add(fc);
        JTextField input = new JTextField(10);
        Object[] options = {fc, cf, input, "Done"};
        JOptionPane.showOptionDialog(null, "Choose a conversion option:", "Temperature Converter", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		double num = 0;
        try {
			num = Double.parseDouble(input.getText());
		}
		catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "You did not enter a valid number", "Temperature Converter", JOptionPane.INFORMATION_MESSAGE);
	        System.exit(0);
		}
        if (cf.isSelected()) {
			DecimalFormat number_format = new DecimalFormat("#0.00°F");
	        JOptionPane.showMessageDialog(null, number_format.format(num) + " in Celcius is " + number_format.format(num*9/5+32), "Temperature Converter", JOptionPane.INFORMATION_MESSAGE);

		}
		else {
			DecimalFormat number_format = new DecimalFormat("#0.00°C");
	        JOptionPane.showMessageDialog(null, number_format.format(num) + " in Fahrenheit is " + number_format.format((num-32)*5/9), "Temperature Converter", JOptionPane.INFORMATION_MESSAGE);

		}	}

}
