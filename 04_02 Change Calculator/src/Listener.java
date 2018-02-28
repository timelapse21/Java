import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Listener implements ActionListener, DocumentListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Base.exit_button) {
			Base.frame.dispose();
			System.exit(0);
		}
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		Base.updateOutput();
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		Base.updateOutput();
	}

}
