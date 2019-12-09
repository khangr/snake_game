package snake_game;

public class Koor {

	private int x;
	private int y;
	
	public enum Direction {
		up, down, left, right
	}
	
	private Direction direction = Direction.right;
	
	public void setX(int x) {
		this.x += x;
	}
	
	public void setY(int y) {
		this.y += y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return direction;
	}
}
