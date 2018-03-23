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
		String output = new String();
		int l = input.length() * 2 - 1;
		for (int i1 = - input.length() + 1; i1 < input.length(); i1 ++) {
			char c = input.charAt((input.length() - 1) - Math.abs(i1));
			char[] ca = new char[l];
			for (int i2 = 0; i2 < ca.length; i2 ++) {
				ca[i2] = ' ';
			}
			ca[(Math.abs(i1))] = c;		
			ca[l - (Math.abs(i1)) - 1] = c;
			for (char character : ca) {
				output = output + character;
			}
			output = output + "\r\n";
		}
		System.out.println(output); // message dialog doesn't output the center line correctly. not sure why.
//		JOptionPane.showMessageDialog(null, output);
	}

}
