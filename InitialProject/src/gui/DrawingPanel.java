package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingPanel extends JPanel {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Circle c = new Circle(new Point(150, 150), 50);
		c.draw(g);

		// Vezbe 7
		Point p1 = new Point(50, 50, true);
		p1.draw(g);

		p1.moveTo(60, 60);
		p1.draw(g);

		p1.moveBy(60, 60);
		p1.draw(g);

		System.out.println(p1.compareTo(new Point(80, 80, false)));

		// Vezbe 8.
		//Domaći zadatak
		Point[] niz = new Point[3];
		niz[0] = new Point(3, 4);
		niz[1] = new Point(1, 1);
		niz[2] = new Point(0, 5);

		System.out.println("Nesortiran niz:");
		for (int i = 0; i < niz.length; i++) {
		System.out.println(niz[i]);
		}

		Arrays.sort(niz);

		System.out.println("Sortiran niz:");
		for (int i = 0; i < niz.length; i++) {
		System.out.println(niz[i]);
		} 

		Point p = new Point(50, 50);
		Line l1 = new Line(new Point(100, 100), new Point(200, 200));
		Circle c1 = new Circle(new Point(500, 100), 80);
		Donut d1 = new Donut(new Point(200, 100), 50, 25, true);
		Rectangle r1 = new Rectangle(l1.getEndPoint(), 100, 50);

		// Zadatak 2.
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p);
		shapes.add(l1);
		shapes.add(c1);
		shapes.add(d1);
		shapes.add(r1);

		Iterator<Shape> it = shapes.iterator();
		while (it.hasNext()) {
			Shape s = it.next(); // trenutni objekat
			s.moveBy(10, 0);
			// System.out.println(it.next());
		}
		
		Collections.sort(shapes);
		// moze i
		shapes.sort(null);

		it = shapes.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// Zadatak 3.
		shapes.get(3).draw(g);
		shapes.get(shapes.size() - 1).draw(g);
		shapes.remove(1);
		// pomera se lista
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, l1);

		// Zadatak 4.

		HashMap<String, Shape> hmShapes = new HashMap<String, Shape>();
		hmShapes.put("point", p);
		hmShapes.put("line", l1);
		System.out.println(hmShapes.get("line"));

		// Primer obrade izuzetka
		//Integer.parseInt("pet");
		System.out.println("1 - Da li cu se izvrsiti?");
		try {
			Integer.parseInt("pet");
			System.out.println("Bice greska");
		} catch (NumberFormatException nfe) {
			System.out.println("Greska NFE");
			nfe.printStackTrace();
		} finally {
			System.out.println("Finally - Da li cu se izvrsiti?");
		}
		System.out.println("2 - Da li cu se izvrsiti?");
		
		it=shapes.iterator();
		while(it.hasNext()) {
			Shape pomocniS=it.next();
			pomocniS.setSelected(true);
			pomocniS.draw(g);
		}

	}

}
