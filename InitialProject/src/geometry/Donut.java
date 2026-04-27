package geometry;

public class Donut extends Circle {

	private int innerRadius;

	public Donut() {

	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut (Point center, int radius, int innerRadius, boolean selected) {
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
			if (getCenter().equals(secondDonut.getCenter()) && 
					getRadius() == secondDonut.getRadius() &&
					this.innerRadius == secondDonut.innerRadius)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public boolean contains(int x, int y) {
		return super.contains(x,y) && getCenter().distance(x, y) > innerRadius;
	}
	
	public String toString() {
		return super.toString() + ", inner radius = " + innerRadius;
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

}
