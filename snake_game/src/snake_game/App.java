package snake_game;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.Timer;

public class App extends JFrame {

	Game game = new Game();
	private Timer timer;
	
	private ActionListener tick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			setTitle("Puan: " + game.getPoint());
		}
	};

	public App() {
		timer = new Timer(1000 / 10, tick);
		add(game);
		pack();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		timer.start();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			App app = new App();
			app.setVisible(true);
		});
	}

}
