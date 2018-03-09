import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String mark_s = JOptionPane.showInputDialog (null, "Enter your mark:", "Dialog5", JOptionPane.INFORMATION_MESSAGE);
		double mark;
		try {
			mark = Double.parseDouble(mark_s);
		}
		catch (Exception e) {
			mark = 0;
		}
		JOptionPane.showMessageDialog (null, "You " + (mark >= 50 ? "passed." : "failed."), "Verdict", JOptionPane.INFORMATION_MESSAGE);
	}

}
