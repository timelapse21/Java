import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("input.txt"));
		String key, coded;
		key = f.readLine ();
        coded = f.readLine ();
		JOptionPane.showMessageDialog(null, decode(key, coded));
	}
	
	public static String decode(String key_phrase, String coded_message) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String decoded_key = new String();
		key_phrase = Normalizer.normalize(key_phrase, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		key_phrase = key_phrase.toUpperCase() + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		List<Character> whitelist = new ArrayList<Character>();
		for (char c : new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}) {
			whitelist.add(c);
		}
		for (char c: key_phrase.toCharArray()) {
			if (!whitelist.contains(c)) {
				key_phrase = key_phrase.replaceAll(Character.toString(c), "");
			}
		}
		for (char c : key_phrase.toCharArray()) {
			if (!decoded_key.contains(Character.toString(c)))
				decoded_key = decoded_key + c;
		}
		String o = new String();
		boolean first = true; // ensures jump to i = 1 for first loop
		boolean odd = true; // switch for odd or even char
		for (int i = -2; i < coded_message.length() + 1; i += odd ? 3 : -1) {
			if (first) {
				first = false;
			}
			else {
				if (odd) {
					int p = decoded_key.indexOf(coded_message.charAt(i)) + 1;
					if (p == -1) 
						p = 25;
					if (p == 26) {
						p = 0;
					}
					o = o + decoded_key.charAt(p);
				}
				else {
					int p = decoded_key.indexOf(coded_message.charAt(i)) - 1;
					if (p == -1) 
						p = 25;
					if (p == 26) {
						p = 0;
					}
					o = o + decoded_key.charAt(p);
				}
				odd = odd ? false : true;
			}
		}
		o = o.replaceAll("X", " ").replaceAll("KCS", "X");
		
		return o;
	}
}
