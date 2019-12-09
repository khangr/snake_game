package snake_game;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class Matrix {
	
	private enum item {
		snake, apple, empty
	}
	
	private item[][] matrix;
	
	public Matrix(int w, int h) {
		matrix = new item[w][h];
		
	}
	
	public item getMatrix(int x, int y) {
		return matrix[x][y];
	}
}
