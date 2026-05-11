package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int width;
	private int height;

	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		this.selected = selected;
	}

	public int area() {
		return width * height;
	}

	public int circumference() {
		return 2 * (width + height);
	}

	public String toString() {
		return "Upper left point: " + upperLeftPoint.toString() + ", width = " + width + ", height = " + height;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle secondRect = (Rectangle) obj;
			if (this.upperLeftPoint.equals(secondRect.upperLeftPoint) && this.width == secondRect.width
					&& this.height == secondRect.height) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(int x, int y) {
		if (this.upperLeftPoint.getX() <= x && /* levo */
				this.upperLeftPoint.getY() <= y && /* iznad */
				x <= this.upperLeftPoint.getX() + width /* desno */
				&& y <= this.upperLeftPoint.getY() + height /* ispod */) {
			return true;
		}
		return false;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
	}

	@Override
	public void moveTo(int x, int y) {
		this.upperLeftPoint.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.upperLeftPoint.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return this.area() - ((Rectangle) o).area();
		}
		return 0;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
