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
		for (int i = 1; i < input.length(); i ++) {
			output = output + input.substring(0, i) + "\r\n";
		}
		JOptionPane.showMessageDialog(null, output);
	}

}
