import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.swing.JApplet;

public class Main extends JApplet {
	public void paint(Graphics g) {
		g.drawString("Jordan was a naught boy", 0, 20);
		g.drawString("He ate a rubber ducky toy", 0, 40);
		g.drawString("It stuck along his GI tract", 0, 60);
		g.drawString("Alas, he had no time to act", 0, 80);
		g.setColor(Color.RED);
		g.drawString("He died at once, so sad, poor lad", 0, 120);
	}
}
