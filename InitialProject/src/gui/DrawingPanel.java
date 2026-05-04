package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Point;

public class DrawingPanel extends JPanel {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Circle c1 = new Circle(new Point(150,150),50);
		c1.draw(g);
	}

}
