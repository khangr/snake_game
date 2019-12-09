package snake_game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import snake_game.Koor.Direction;

import javax.swing.Timer;

public class Game extends Panel implements ActionListener {

	private Apple apple = new Apple();
	private Dimension apple_koor;
	private Direction direction = Direction.right;
	private Data data = new Data();
	private Keyboard keyboard = new Keyboard();
	private Matrix matrix = new Matrix(getW(), getH());
	private final int fps = 1000 / 30;
	private int dif = 13;
	private final int move_speed = 1000 / dif;
	private Timer timer = new Timer(fps, this);
	private final int up = -1, down = 1, right = 1, left = -1;
	private List<Dimension> body = new ArrayList<Dimension>();
	private int point = 0;
	
	private ActionListener tick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = body.size() - 1; i >= 0; i--) {
				if(i == 0) {
					body.get(i).width = keyboard.keys.getX();
					body.get(i).height = keyboard.keys.getY();
				} else {
					body.get(i).width = body.get(i - 1).width;
					body.get(i).height = body.get(i - 1).height;
				}	
			}
			direction = keyboard.keys.getDirection();
			switch (direction) {
			case up: keyboard.keys.setY(up); break;
			case down: keyboard.keys.setY(down); break;
			case left: keyboard.keys.setX(left); break;
			case right: keyboard.keys.setX(right); break;
			}
		}
	};
	
	private void restart() {
		direction = Direction.right;
		body = new ArrayList<Dimension>();
		point = 0;
		keyboard.keys.setX(0);
		keyboard.keys.setY(0);
		timer.restart();
		game_timer.restart();
	}
	
	private Timer game_timer = new Timer(move_speed, tick);
	
	public Game() {
		addKeyListener(keyboard);
		timer.start();
		game_timer.start();
		apple_koor = apple.newApple();
		body.add(new Dimension(keyboard.keys.getX() - 1, keyboard.keys.getY()));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawApple(g);
		drawSnake(g);
		drawBody(g);
	}
	
	private void drawBody(Graphics g) {
		for(int i = 0; i < body.size(); i++) {
			g.drawImage(data.getBody(), body.get(i).width * getPixel(), body.get(i).height * getPixel(), this);
		}
	}
	
	private void drawApple(Graphics g) {
		g.drawImage(data.getApple(),
				apple_koor.width * getPixel(),
				apple_koor.height * getPixel(),
				this);
	}
	
	private void drawSnake(Graphics g) {
		g.drawImage(data.getHead(), 
				keyboard.keys.getX() * getPixel(), 
				keyboard.keys.getY() * getPixel(), 
				this);
		Toolkit.getDefaultToolkit().sync();
	}
	
	public List<Dimension> getBody() {
		return body;
	}
	
	public int getPoint() {
		return point;
	}
	
	private void newApple() {
		apple_koor = apple.newApple();
		if(keyboard.keys.getX() == apple_koor.width && keyboard.keys.getY() == apple_koor.height)
			this.newApple();
		for(int i = 0; i < body.size(); i++) {
			if(apple_koor.width == body.get(i).width && apple_koor.height == body.get(i).height)
				this.newApple();
		}
	}
	
	private void eat() {
		body.add(new Dimension(body.get(body.size() - 1).width, body.get(body.size() - 1).height));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (keyboard.keys.getX() == apple_koor.width && keyboard.keys.getY() == apple_koor.height) {
			eat();
			point += dif;
			newApple();
		}
		for(int i = 0; i < body.size(); i++) {
			if(keyboard.keys.getX() == body.get(i).width && keyboard.keys.getY() == body.get(i).height) {
				timer.stop();
				game_timer.stop();
				keyboard.keys.dead();
			}
		}
		if(keyboard.keys.getX() < 0 || keyboard.keys.getX() > 15 || 
		   keyboard.keys.getY() < 0 || keyboard.keys.getY() > 15) {
				timer.stop();
				game_timer.stop();
				keyboard.keys.dead();
		} else repaint();
	}
}
