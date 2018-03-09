import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name = JOptionPane.showInputDialog (null, "Enter your name:", "Dialog1", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog (null, "Have a nice day " + name + ".", "Reply", JOptionPane.INFORMATION_MESSAGE);
	}
}
