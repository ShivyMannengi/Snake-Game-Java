package assignment9;
import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;
public class Food {
	public static final double FOOD_SIZE = 0.02;
	private double x, y;

	/**
	 * 
	 * Creates a new Food at a random location
	 * 
	 */

	public Food() {

//FIXME
		this.x = Math.random();
		this.y = Math.random();
	}

	/**
	 * 
	 * Draws the Food
	 * 
	 */

	public void draw() {

//FIXME

//StdDraw.setPenColor(ColorUtils.solidColor());

		StdDraw.setPenColor(201, 0, 0);
		StdDraw.circle(x, y, FOOD_SIZE);
	}

	public double getX() {
		
// TODO Auto-generated method stub

		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
// TODO Auto-generated method stub

		return this.y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
