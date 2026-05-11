package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Point;

public class DrawingPanel extends JPanel {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Circle c1 = new Circle(new Point(150, 150), 50);
		c1.draw(g);

		// Vezbe 7
		Point p1 = new Point(50, 50, true);
		p1.draw(g);

		p1.moveTo(60, 60);
		p1.draw(g);
		
		p1.moveBy(60, 60);
		p1.draw(g);
		
		System.out.println(p1.compareTo(new Point(80,80,false)));

	}

}
