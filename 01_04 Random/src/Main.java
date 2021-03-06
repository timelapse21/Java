import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Main extends JApplet {
	final int WIDTH = 400;
	final int HEIGHT = 400;
	final int RADIUS = 20;
	int x, y;
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
	}
	
	public void paint(Graphics g) {
		for (int i = 1; i <= 10; i ++) {
			x = (int) (Math.random() * (WIDTH - 2 * RADIUS)) + RADIUS;
			y = (int) (Math.random() * (HEIGHT - 2 * RADIUS)) + RADIUS;
            drawBall(g, x, y, RADIUS, Color.BLUE);
		}
		
	}
	public void drawBall(Graphics g, int x, int y, int radius, Color color) {
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
}