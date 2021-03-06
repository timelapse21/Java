import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Base {
	static final int W = 300;
	static final int H = 300;
	static final int X = 100;
	static final int Y = 100;
	
	static JFrame frame;
	
	static Listener listener = new Listener();;
	
	static JPanel main_panel = new JPanel(new BorderLayout());
	static JPanel button_panel = new JPanel(new GridLayout(2, 1));
	static JPanel field_panel = new JPanel(new GridLayout(2, 1));
	public static JButton calc_button = new JButton("Calculate");
	public static JButton exit_button = new JButton("Exit");
	public static JTextField x_field = new JTextField();
	public static JTextField y_field = new JTextField();
	public static JLabel result_label = new JLabel("No Input Yet", JLabel.CENTER);	
	static JLabel x_field_label = new JLabel("X Value", JLabel.CENTER);
	static JLabel y_field_label = new JLabel("Y Value", JLabel.CENTER);
	
	public static void init() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		frame = new JFrame("Pythagorean Theorum");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		List<Image> icons = new ArrayList<Image>();
		try {
		icons.add(ImageIO.read(new File("image/64x64.png")));
		icons.add(ImageIO.read(new File("image/32x32.png")));
		icons.add(ImageIO.read(new File("image/16x16.png")));
		icons.add(ImageIO.read(new File("image/8x8.png")));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		frame.setIconImages(icons);
		frame.setBounds(X, Y, W, H);
		addComponents();
		frame.setVisible(true);
		
	}
	
	public static void addComponents() {
		x_field.setHorizontalAlignment(JLabel.CENTER);
		y_field.setHorizontalAlignment(JLabel.CENTER);
		button_panel.add(calc_button);
		button_panel.add(exit_button);
		field_panel.add(x_field);
		field_panel.add(y_field);
		field_panel.add(x_field_label);
		field_panel.add(y_field_label);
		main_panel.add(field_panel, BorderLayout.NORTH);
		main_panel.add(button_panel, BorderLayout.SOUTH);
		main_panel.add(result_label, BorderLayout.CENTER);
		frame.setContentPane(main_panel);
		
		calc_button.addActionListener(listener);
		exit_button.addActionListener(listener);
	}
	
}
