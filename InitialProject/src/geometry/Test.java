package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point();
		
		p.setX(10);
		p.setY(15);
		p.setSelected(true);
		
		System.out.println("Koordinata X tačke p je: " + p.getX());
		System.out.println("Koordinata Y tačke p je: " + p.getY());
		System.out.println("Obeležje selected tačke p je: " + p.isSelected());

	}

}
