package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	private Point center;
	private int radius;
	private Color edgeColor = Color.BLACK;   // Dodato kao osiguranje ako fali u Shape
	private Color innerColor = Color.WHITE;  // Dodato kao osiguranje ako fali u Shape

	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}

	public double area() {
		return radius * radius * Math.PI;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
	}

	@Override
	public String toString() {
		return "Center: " + center.toString() + ", radius = " + radius;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle secondCircle = (Circle) obj;
			if (this.center.equals(secondCircle.center) && this.radius == secondCircle.radius)
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return this.center.distance(x, y) <= this.radius;
	}

	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	@Override
	public void draw(Graphics g) {
		// 1. Prvo bojimo unutrašnjost kruga
		g.setColor(getInnerColor());
		g.fillOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);

		// 2. Preko toga crtamo ivicu (konturu) kruga
		g.setColor(getEdgeColor());
		g.drawOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);

		// 3. Ako je selektovan, crtamo plave kvadrate na centru i ivicama
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		this.center.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.center.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (int) (this.area() - ((Circle) o).area());
		}
		return 0;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws Exception {
		// ISPRAVLJENO: Radijus ne sme biti ni 0 ni negativan po tekstu zadatka!
		if (radius <= 0) {
			throw new Exception("Radius must be greater than 0!");
		}
		this.radius = radius;
	}

	// Geteri i seteri koji bezbedno rukuju bojama i skidaju crvenilo
	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
}