import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Main extends Applet {
	public void paint(Graphics g) {
		int size = 5;
		int radius = 90;
		g.setColor(Color.RED);
		for (int angle = 0; angle < 360; angle += 20)
        {
            int x = 100 + (int) (Math.sin(angle * Math.PI / 180) * radius);
            int y = 100 + (int) (Math.cos(angle * Math.PI / 180) * radius);
            g.fillRect(x, y, size, size);
        }

	}
}
