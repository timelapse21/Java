import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Listener implements ActionListener, ItemListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Base.display.setFont(new Font((String) Base.fonts_combo.getSelectedItem(), Base.display.getFont().getStyle(), 24));
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource() == Base.bold) {
				Base.display.setFont(new Font(Base.display.getFont().getFamily(), Base.display.getFont().getStyle() | Font.BOLD, 24));
			}
			else if (e.getSource() == Base.italic) {
				Base.display.setFont(new Font(Base.display.getFont().getFamily(), Base.display.getFont().getStyle() | Font.ITALIC, 24));
			}
		}
		else {
			if (e.getSource() == Base.bold) {
				Base.display.setFont(new Font(Base.display.getFont().getFamily(), Base.display.getFont().getStyle() & Font.ITALIC, 24));
			}
			else if (e.getSource() == Base.italic) {
				Base.display.setFont(new Font(Base.display.getFont().getFamily(), Base.display.getFont().getStyle() & Font.BOLD, 24));
			}
		}
	}
}
