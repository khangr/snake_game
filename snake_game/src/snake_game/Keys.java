package snake_game;

import java.awt.event.KeyEvent;

public class Keys extends Koor {

	private boolean up, down, left, right;
	private boolean dead;
	
	public void dead() {
		dead = true;
	}
	
	public void keyPress(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if(left == false && getDirection() != Direction.right) {
				left = true;
				setDirection(Direction.left);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(right == false && getDirection() != Direction.left) {
				right = true;
				setDirection(Direction.right);
			}
			break;
		case KeyEvent.VK_UP:
			if(up == false && getDirection() != Direction.down) {
				up = true;
				setDirection(Direction.up);
			}
			break;
		case KeyEvent.VK_DOWN:
			if(down == false && getDirection() != Direction.up) {
				down = true;
				setDirection(Direction.down);
			}
			break;
		case KeyEvent.VK_SPACE:
			if(dead == true) {
				dead = false;
				
			}
			break;
		}
	}

	public void keyRelease(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}
}
