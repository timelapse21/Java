import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

public class CatCatcher extends JPanel implements ActionListener, MouseListener {
	private final int W = 800;
	private final int H = 600;
	private final int X = 30;
	private final int Y = 30;
	
	private JPanel p = new JPanel();
	
	private ImageIcon cat_icon = new ImageIcon("image/cat1s.png");
	private ImageIcon backdrop_icon =  new ImageIcon("image/back.png");
	private JLabel cat = new JLabel(cat_icon);
	private JLabel backdrop = new JLabel(backdrop_icon);
	private JLabel health_label  = new JLabel("1");
	
	private Timer cat_timer = new Timer(1000, this);
	private Timer death_timer = new Timer(60, this);
    private Random random = new Random();
    
    private DecimalFormat f = new DecimalFormat("#0.00");
    
    private double health = 1;
    private double difficulty = 0.01;
    
    private long sm = System.currentTimeMillis();
    private long hits = 0;
	
	public void start() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame jf = new JFrame();
		jf.setTitle("Cat Catcher");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(X, Y, W, H);
		
		cat.setBounds(random.nextInt(W - cat_icon.getIconWidth()), random.nextInt(H - cat_icon.getIconHeight()), cat_icon.getIconWidth(), cat_icon.getIconHeight());
		cat.addMouseListener(this);
		
		health_label.setBounds(507, 343, 100, 100);
		health_label.setHorizontalAlignment(JLabel.CENTER);
		backdrop.setBounds(0, 0, W, H);
		
		jf.getContentPane().setPreferredSize(new Dimension(W, H));
		setLayout(null);
		
		add(cat, 0);
		add(health_label, 1);
		add(backdrop, 2);

		cat_timer.start();
		death_timer.start();
		jf.add(this);
		jf.setResizable(false);
		jf.pack();
		jf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cat_timer) {
			moveCat(false);
		}
		else if (e.getSource() == death_timer) {
			health -= difficulty;
			difficulty += 0.00001;
			health_label.setText(f.format(hits / ((double) (System.currentTimeMillis() - sm) / 1000)) +"");
			super.repaint();
			if (health < 0) {
				cat_timer.stop();
				death_timer.stop();
				JOptionPane.showMessageDialog(this, "You failed to capture the cat. You died with a clickrate of " + f.format(hits / ((double) (System.currentTimeMillis() - sm) / 1000)) + " clicks per second.");
				System.exit(0);
			}
			else if (health >= 2) {
				cat_timer.stop();
				death_timer.stop();
				JOptionPane.showMessageDialog(this, "You captured the cat! Well done. You had a clickrate of " + f.format(hits / ((double) (System.currentTimeMillis() - sm) / 1000)) + " clicks per second.");
				System.exit(0);
			}
		}
	}
	
	
	public void moveCat(boolean click) {
		cat.setBounds(random.nextInt(W - cat_icon.getIconWidth()), random.nextInt(H - cat_icon.getIconHeight()), cat_icon.getIconWidth(), cat_icon.getIconHeight());
		cat_timer.restart();
		if (click) {
			hits += 1;
			health += 0.1;
			health_label.setText(f.format(hits / ((double) (System.currentTimeMillis() - sm) / 1000)) +"");
		}
	}
	
	@Override
	public void paintChildren(Graphics g) {
		super.paintChildren(g);
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(0, H - 25, Color.RED, (int) (health * 400), 25, Color.GREEN);
	    g2d.setPaint(gradient);
	    g2d.fill(new Rectangle(0, H - 25, (int) (health * 400), 25));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		moveCat(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
