package assignment9;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;
public class Game {
	Snake newSnake;
	Food newFood;
	public Game() {
		StdDraw.enableDoubleBuffering();

//FIXME - construct new Snake and Food objects

		newSnake = new Snake();
		newFood = new Food();
	}

	public void play() {
		while (newSnake.isInbounds()) { // TODO: check if snake is in bounds
			int dir = getKeypress(); 
//Testing only: you will eventually need to do more work here, dir= value of key that is pressed

			System.out.println("Keypress: " + dir);
			newSnake.changeDirection(dir);
			newSnake.move(); //moves snake
			updateDrawing(); //draws the snake
			if (newSnake.eatFood(newFood) == true) { //if food eaten, it draws another one
				newFood = new Food();
				updateDrawing(); //draws it
			}
			System.out.println("Keypress: End of Loop");
			/*
			 * 
			 * 1. Pass direction to your snake 2. Tell the snake to move 3. If the food has
			 * 
			 * been eaten, make a new one 4. Update the drawing
			 * 
			 */
		}
		drawGameOverScreen();
	}
	private int getKeypress() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}

	/**
	 * 
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 * 
	 */

	private void updateDrawing() {
		StdDraw.clear();
		newSnake.draw();
		newFood.draw();
		StdDraw.pause(50);
		StdDraw.show();

		/*
		 * 
		 * 1. Clear screen 2. Draw snake and food 3. Pause (50 ms is good) 4. Show
		 * 
		 */

	}
	public static void drawStart() {

//StdDraw.clear(StdDraw.BOOK_BLUE);

		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.text(0.5, 0.5, "WELCOME TO SNAKE");
		StdDraw.pause(2000);
		StdDraw.clear();
	}

	private void drawGameOverScreen() {

		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.text(0.5, 0.6, "GAME OVER");
		StdDraw.text(0.5, 0.55, "Press 'R' to restart or 'Q' to quit");
		StdDraw.show();
		waitForInput();

	}

	private void waitForInput() {
		while (true) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_R)) {
				newSnake = new Snake();
				newFood = new Food();
				play();
				break;
			} else if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
				System.exit(0);
			}
		}
	}
	public static void main(String[] args) {
		drawStart();
		Game g = new Game();
		g.play();
	}
}