import javax.swing.JLabel;
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
		input = input.toUpperCase();
		char[] cinput = input.toCharArray();
		String output = new String();
		for (int i = 0; i < cinput.length; i ++) {
			if (cinput[i] == 'Z') {
				cinput[i] = 'A';
			}
			else {
				cinput[i] += 1;
			}
			output = output + cinput[i];
		}
		JOptionPane.showMessageDialog(null, output);
	}

}
