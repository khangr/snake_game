package snake_game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Data {
	
	private Image body = new ImageIcon("src/imgs/blue.png").getImage();
	private Image head = new ImageIcon("src/imgs/red.png").getImage();
	private Image apple = new ImageIcon("src/imgs/green.png").getImage();
	
	public Image getBody() {
		return body;
	}
	
	public Image getApple() {
		return apple;
	}

	public Image getHead() {
		return head;
	}
}
