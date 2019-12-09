package snake_game;

import java.awt.Dimension;
import java.util.Random;

public class Apple {
	
	private int x, y;
	
	public Dimension newApple() {
		x = new Random().nextInt(16);
		y = new Random().nextInt(16);
		return new Dimension(x, y);
	}
}
