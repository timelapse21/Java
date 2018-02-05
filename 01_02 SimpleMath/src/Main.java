import java.applet.Applet;
import java.awt.Graphics;

public class Main extends Applet {
	double x, y;
	public void init() {
		x = 3;
		y = 4;
	}
	public void paint(Graphics g) {
		double z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		g.drawString("The hypoteneuse is: " + z, 0, 20);
	}
}
