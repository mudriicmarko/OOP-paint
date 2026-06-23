package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Vezbe 2
		Point p = new Point();

		p.setX(10);
		p.setY(15);
		p.setSelected(true);

		System.out.println("Koordinata X tačke p je: " + p.getX());
		System.out.println("Koordinata Y tačke p je: " + p.getY());
		System.out.println("Obeležje selected tačke p je: " + p.isSelected());

		// Vezbe 3
		System.out.println("Rastojanje izmedju tacaka je: " + p.distance(15, 20));

		Point p1 = new Point();
		p1.setX(15);
		p1.setY(27);
		p1.setSelected(true);

		Line l1 = new Line();
		Rectangle r1 = new Rectangle();
		Circle c1 = new Circle();

		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1

		p.setX(p1.getY());
		System.out.println("X of p = " + p.getX());

		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a
		// za krajnju tacku linije l1 tacku p1

		l1.setStartPoint(p);
		l1.setEndPoint(p1);

		// 3. Postaviti y koordinatu krajnje tacke l1 na 23

		l1.getEndPoint().setY(23);
		System.out.println("Y of end point of line l1 = " + l1.getEndPoint().getY());
		System.out.println("X of p1 = " + p1.getY());

		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1

		l1.getStartPoint().setX(l1.getEndPoint().getY());
		System.out.println("X of start point of line l1 = " + l1.getStartPoint().getX());

		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1

		l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX() + l1.getEndPoint().getY())));

		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15

		r1.setUpperLeftPoint(new Point());
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		System.out.println("X of U.L.P of r1 = " + r1.getUpperLeftPoint().getX());
		System.out.println("Y of U.L.P of r1 = " + r1.getUpperLeftPoint().getY());

		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1

		c1.setCenter(r1.getUpperLeftPoint());
		System.out.println("X of center of c1 = " + c1.getCenter().getX());
		System.out.println("Y of center of c1 = " + c1.getCenter().getY());

		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1

		r1.setHeight(20);
		r1.setWidth(30);
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		System.out.println("X of center of c1 = " + c1.getCenter().getX());

		// Vezbe 4
		/*
		 * Postaviti x koordinatu centra ranije kreiranog kruga circle1 na vrednost
		 * zbira vrednosti poluprečnika kruga circle1 i vrednosti koja predstavlja
		 * udaljenost početne i krajnje tačke prethodno kreirane linije line1 (koristiti
		 * metodu distance(), a ne length()).
		 */

		Circle c3 = new Circle();
		try {
			c3.setRadius(-10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		c3.setCenter(new Point());
		c3.getCenter().setX(
				(int) (c1.getRadius() + l1.getStartPoint().distance(l1.getEndPoint().getX(), l1.getEndPoint().getY())));

		Point p3 = new Point(10, 10);
		p3.setSelected(true);
		System.out.println(p3.getX());

		Point p4 = new Point(10, 10, true);
		System.out.println(p4.isSelected());

		System.out.println(p3.equals(p4));

		// p3 = p4;
		System.out.println(p3 == p4);

		// Vezbe 5
		Donut d1 = new Donut(p1, 20, 10);
		System.out.println(d1.toString());

		// Vezbe 6
		// Shape shape1 = new Shape();
		Shape shape1 = new Point(10, 10, true);
		System.out.println(shape1.isSelected());
		// System.out.println(shape1.getX());

	}

}
