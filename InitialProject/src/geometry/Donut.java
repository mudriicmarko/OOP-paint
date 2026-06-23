package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle {

	private int innerRadius;

	public Donut() {

	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}

	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	public double circumference() {
		return super.circumference() + 2 * innerRadius * Math.PI;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut secondDonut = (Donut) obj;
			if (getCenter().equals(secondDonut.getCenter()) && getRadius() == secondDonut.getRadius()
					&& this.innerRadius == secondDonut.innerRadius)
				return true;
			else
				return false;
		} else
			return false;
	}

	@Override
	public boolean contains(int x, int y) {
		double d = getCenter().distance(x, y);
		return d <= getRadius() && d >= innerRadius;
	}

	@Override
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	public String toString() {
		return super.toString() + ", inner radius = " + innerRadius;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		Ellipse2D outerCircle = new Ellipse2D.Double(getCenter().getX() - getRadius(), getCenter().getY() - getRadius(),
				2 * getRadius(), 2 * getRadius());

		Ellipse2D innerCircle = new Ellipse2D.Double(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius,
				2 * innerRadius, 2 * innerRadius);

		Area donutArea = new Area(outerCircle);
		Area holeArea = new Area(innerCircle);

		donutArea.subtract(holeArea);

		g2d.setColor(getInnerColor());
		g2d.fill(donutArea);

		g2d.setColor(getEdgeColor());
		g2d.draw(outerCircle);
		g2d.draw(innerCircle);

		if (isSelected()) {
			g2d.setColor(Color.BLUE);
			g2d.drawRect(getCenter().getX() - 2, getCenter().getY() - 2, 4, 4);

			g2d.drawRect(getCenter().getX() - getRadius() - 2, getCenter().getY() - 2, 4, 4);
			g2d.drawRect(getCenter().getX() + getRadius() - 2, getCenter().getY() - 2, 4, 4);
			g2d.drawRect(getCenter().getX() - 2, getCenter().getY() - getRadius() - 2, 4, 4);
			g2d.drawRect(getCenter().getX() - 2, getCenter().getY() + getRadius() - 2, 4, 4);

			g2d.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g2d.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g2d.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g2d.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
		}
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public void setOuterRadius(int outerRadius) {
		try {
			super.setRadius(outerRadius);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getOuterRadius() {
		return super.getRadius();
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