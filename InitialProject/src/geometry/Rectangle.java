package geometry;

public class Rectangle {

	private Point upperLeftPoint;
	private int width;
	private int height;
	private boolean selected;

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
			if (this.upperLeftPoint.equals(secondRect.upperLeftPoint) 
					&& this.width == secondRect.width
					&& this.height == secondRect.height) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		if (this.upperLeftPoint.getX() <= x && /*levo*/
				this.upperLeftPoint.getY() <= y && /*iznad*/
				x <= this.upperLeftPoint.getX() + width /*desno*/ && 
				y <= this.upperLeftPoint.getY() + height /*ispod*/) {
			return true;
		}
		return false;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
