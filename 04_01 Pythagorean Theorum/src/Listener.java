import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Base.calc_button) {
			try {
			Base.result_label.setText("Hypoteneuse = " + Math.sqrt(Math.pow(Double.parseDouble(Base.x_field.getText()), 2) + Math.pow(Double.parseDouble(Base.y_field.getText()), 2)));
			}
			catch (Exception exception){
				Base.result_label.setText("Invalid Input");
			}
		}
		else if (e.getSource() == Base.exit_button) {
			Base.frame.dispose();
			System.exit(0);
		}
	}

}
