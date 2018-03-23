import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String input = JOptionPane.showInputDialog("Enter a word");
		String output = new String();
		for (int i1 = -input.length() + 1; i1 < input.length(); i1 ++) {
			for (int i2 = 0; i2 < (input.length()) - Math.abs(i1); i2 ++) {
				output = output + " ";
			}
			output = output +  input.charAt((input.length() - 1) - Math.abs(i1))  + "\r\n";
		}
		JOptionPane.showMessageDialog(null, output);
	}

}
