package assignment9;
import java.util.LinkedList;
import assignment8.Entity;
public class Snake {
	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	public Snake() {
//FIXME - set up the segments instance variable

		segments = new LinkedList<BodySegment>();
		BodySegment segment1 = new BodySegment(0.2, 0.2, SEGMENT_SIZE);
		segments.add(segment1);
		deltaX = 0;
		deltaY = 0;
	}
	public void changeDirection(int direction) { 
		if (direction == 1) { // up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { // down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { // left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { // right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	/**
	 * 
	 * Moves the snake by updating the position of each of the segments based on the
	 * 
	 * current direction of travel
	 * 
	 */
	public void move() {

//FIXME
		for (int i = segments.size() - 1; i >= 0; i--) {
			if (i == 0) {
				double newX = segments.get(i).getX() + deltaX;
				System.out.println("New x:" + newX);
				segments.get(i).setX(newX);
				double newY = segments.get(i).getY() + deltaY;
				System.out.println("New y:" + newY);
				segments.get(i).setY(newY);
			} else {
				segments.get(i).setX(segments.get(i - 1).getX());
				segments.get(i).setY(segments.get(i - 1).getY());
			}
		}
	} 
	/**
	 * for loop iterates thru link list segments, this link list is filled with body segments(objects
	 *  *updated from tail to head, each body segment gets its X and Y from its previous segment)
	 * @param xOther x-coordinate of the other point.
	 * 
	 * @param yOther y-coordinate of the other point.
	 * 
	 * @return distance between this Entity's center and the specified other point.
	 * 
	 *updated from tail to head, each body segment gets its X and Y from its previous segment
	/**
	 * 
	 */
	public double distanceCenterToPoint(Food food) {
	 
		double distance = Math.sqrt(Math.pow((segments.element().getX() - food.getX()), 2)
				+ Math.pow((segments.element().getY() - food.getY()), 2));
		return distance;
	}

	/**
	 * 
	 * @param xOther      the x-coordinate of another Entity's center.
	 * 
	 * @param yOther      the y-coordinate of another Entity's center.
	 * 
	 * @param radiusOther the radius of another Entity.
	 * 
	 * @return the distance between this Entity's edge and the specified other
	 * 
	 *         Entity's edge.
	 * 
	 */

	public double distanceEdgeToEdge(Food food) {
// FIXME
		double edgeDistance = distanceCenterToPoint(food) - (segments.element().getSize() + Food.FOOD_SIZE);
		return edgeDistance;
	}

	/**
	 * 
	 * Draws the snake by drawing each segment
	 * 
	 */
	public void draw() {

//FIXME
		for (BodySegment segment : segments) {
			segment.draw();
		}
	}

	/**
	 * 
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * 
	 * 
	 * 
	 * @param f the food to be eaten
	 * 
	 * @return true if the snake successfully ate the food
	 * 
	 */

	public boolean eatFood(Food f) {
//FIXME
		if (distanceEdgeToEdge(f) <= 0) {

//BodySegment newSegment = new BodySegment(segments.element().getX()+SEGMENT_SIZE*2, segments.element().getY(), SEGMENT_SIZE);
			segments.add(new BodySegment(segments.element().getX() + SEGMENT_SIZE * 2, segments.element().getY(),
					SEGMENT_SIZE));
			return true;
		} else
			return false;
	}
	/**
	 * 
	 * Returns true if the head of the snake is in bounds
	 * 
	 * 
	 * 
	 * @return whether or not the head is in the bounds of the window
	 * 
	 */

	public boolean isInbounds() {
//FIXME
		if (segments.element().getX() - segments.element().getSize() < 0
				|| segments.element().getX() + segments.element().getSize() > 1
				|| segments.element().getY() - segments.element().getSize() < 0
				|| segments.element().getY() + segments.element().getSize() > 1) {
			return false;
		}
		return true;
	}
}