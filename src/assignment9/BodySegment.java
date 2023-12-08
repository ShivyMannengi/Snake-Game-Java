package assignment9;
import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;
public class BodySegment {
	private double x, y, size;
	private Color color;
	public BodySegment(double x, double y, double size) {

//FIXME

		color = ColorUtils.solidColor();
		this.x = x;
		this.y = y;
		this.size = size;

//See ColorUtils for some color options (or choose your own)

	}

	/**
	 * 
	 * Draws the segment
	 * 
	 */

	public void draw() {

//FIXME

		StdDraw.setPenColor(15, 150, 83);
		StdDraw.filledCircle(x, y, size);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getSize() {
// TODO Auto-generated method stub
		return this.size;
	}
	public void setSize(double size) {
		this.size = size;
	}
}