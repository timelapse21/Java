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
		for (char c : input.toCharArray()) {
			output = output + c + c;
		}
		JOptionPane.showMessageDialog(null, output);
	}

}
