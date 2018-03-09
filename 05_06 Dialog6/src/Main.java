import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat number_format = new DecimalFormat("#0.00");
		JTextField numfield1 = new JTextField(15);
		JTextField numfield2 = new JTextField(15);
		Object[] options = {numfield1, numfield2, "Done"};
        JOptionPane.showOptionDialog(null, "Enter 2 numbers to see which one is larger", "Dialog6", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        double num1 = 0;
        double num2 = 0;
        try {
        	num1 = Double.parseDouble(numfield1.getText());
        	num2 = Double.parseDouble(numfield2.getText());
        }
        catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "One of your numbers was invalid", "Number Checker", JOptionPane.INFORMATION_MESSAGE);
        }
        if (num1 == num2) {
        	JOptionPane.showMessageDialog(null, "Your numbers are equal.", "Number Checker", JOptionPane.INFORMATION_MESSAGE);
        	System.exit(0);
        }
        JOptionPane.showMessageDialog(null, (num1 > num2 ? number_format.format(num1) : number_format.format(num2)) + " is largest.", "Number Checker", JOptionPane.INFORMATION_MESSAGE);

	}

}
