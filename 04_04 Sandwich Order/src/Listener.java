import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

public class Listener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		double total = 0;
		for (Topping topping : Base.toppings) {
			if (topping.isSelected()) {
				total += topping.price;
			}
		}
		if (Base.small.isSelected()) {
			total += 2.50;
		}
		else {
			total += 4;
		}
		DecimalFormat formatter = new DecimalFormat("$ 0.00");
		Base.result.setText(formatter.format(total));
	}

}
