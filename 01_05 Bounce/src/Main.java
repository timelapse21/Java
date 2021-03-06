import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Main extends JApplet implements Runnable {
	int x, y;
	int dx = 2;
	int dy = 2;
	final int WIDTH = 400;
	final int HEIGHT = 400;
	public void init() {
		x = HEIGHT / 2;
		y = WIDTH / 2;
		this.setSize(WIDTH, HEIGHT);
		this.setIgnoreRepaint(true);
	}
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 10, 10);
	}
	@Override
	public void run() {
		while (true) {
			if (x + dx < 0 || x + dx > WIDTH) {
				dx = -dx;
			}
			if (y + dy < 0 || y + dy > HEIGHT) {
				dy = -dy;
			}
			x += dx;
			y += dy;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
