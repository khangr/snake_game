package snake_game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Panel extends JPanel {

	private final int pixel = 16;
	private final int w = pixel * 16 - 10;
	private final int h = pixel * 16 - 10;
	
	public Panel() {
		setFocusable(true);
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(w, h));
	}
	
	public int getW() {
		return w;
	}
	
	public int getPixel() {
		return pixel;
	}
	
	public int getH() {
		return h;
	}
}
