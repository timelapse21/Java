import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Base {
	private static final int W = 350;
	private static final int H = 150;
	private static final int X = 100;
	private static final int Y = 100;
	
	private static JFrame frame = new JFrame();
	
	private static Listener listener = new Listener();
	
	public static JCheckBox bold = new JCheckBox();
	public static JCheckBox italic = new JCheckBox();
	
	public static JLabel display = new JLabel("I am Text");
	
	public static JComboBox<String> fonts_combo = new JComboBox<String>();
	
	private static JPanel panel = new JPanel(new GridLayout(2, 1));
	private static JPanel button_panel = new JPanel();
	
	public static void init() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame.setTitle("Font Changer");
		frame.setBounds(X, Y, W, H);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
		frame.setVisible(true);
	}
	public static void addComponents() {
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.X_AXIS));
		bold.setText("Bold");
		bold.setFont(new Font(display.getFont().getFamily(), Font.BOLD, 12));
		bold.setHorizontalAlignment(JCheckBox.CENTER);
		bold.setVerticalAlignment(JCheckBox.BOTTOM);
		italic.setText("Italic");
		italic.setHorizontalAlignment(JCheckBox.CENTER);
		italic.setVerticalAlignment(JCheckBox.BOTTOM);
		italic.setFont(new Font(display.getFont().getFamily(), Font.ITALIC, 12));
		display.setFont(new Font(display.getFont().getFamily(), Font.PLAIN, 24));
		display.setHorizontalAlignment(JLabel.CENTER);
		display.setVerticalAlignment(JLabel.BOTTOM);
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); // from https://alvinalexander.com/blog/post/jfc-swing/swing-faq-list-fonts-current-platform
		for (String font: fonts) {
			fonts_combo.addItem(font);
		}
		fonts_combo.setMaximumSize(new Dimension(200, 20));
		panel.add(display);
		button_panel.add(bold);
		button_panel.add(italic);
		button_panel.add(Box.createHorizontalGlue());
		button_panel.add(fonts_combo);
		button_panel.add(Box.createRigidArea(new Dimension(5, 1)));
		panel.add(button_panel);
		
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		fonts_combo.addActionListener(listener);
		
		frame.setContentPane(panel);
	}
}
