import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		double num;
		DecimalFormat number_format = new DecimalFormat("#.00");
		try {
			num = Double.parseDouble(JOptionPane.showInputDialog (null, "Enter your number to square:", "Dialog2", JOptionPane.INFORMATION_MESSAGE));
		}
		catch (Exception e) {
			num = 0;
		}
		JOptionPane.showMessageDialog(null, number_format.format(num) + " squared is " + number_format.format(Math.pow(num, 2)), "Your Number Squared", JOptionPane.INFORMATION_MESSAGE);
	}
}
