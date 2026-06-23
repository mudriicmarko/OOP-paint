package geometry;

import java.awt.Color;
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
		if (this.upperLeftPoint.getX() <= x && this.upperLeftPoint.getY() <= y
				&& x <= this.upperLeftPoint.getX() + width && y <= this.upperLeftPoint.getY() + height) {
			return true;
		}
		return false;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public Point getUpperLeft() {
		return upperLeftPoint;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(getInnerColor());
		g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);

		g.setColor(getEdgeColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);

		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() + height - 2, 4, 4);
		}
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
		if (o instanceof Rectangle) {
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

	public int getRectangleWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getRectangleHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void setEdgeColor(Color edgeColor) {
		super.setEdgeColor(edgeColor);
	}

	@Override
	public void setInnerColor(Color innerColor) {
		super.setInnerColor(innerColor);
	}
}