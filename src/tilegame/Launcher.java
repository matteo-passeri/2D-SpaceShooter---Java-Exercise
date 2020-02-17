package tilegame;

public class Launcher {
	public static final int SCREEN_WIDTH = 400;
	public static final int SCREEN_HEIGHT = 600;
	
	public static void main(String[] args) {
		Game game = new Game("New Game", SCREEN_WIDTH, SCREEN_HEIGHT);
		game.start();
	}

}
