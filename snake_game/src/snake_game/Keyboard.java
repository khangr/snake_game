package snake_game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

	Keys keys = new Keys();
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys.keyPress(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		keys.keyRelease(e);
	}
}
