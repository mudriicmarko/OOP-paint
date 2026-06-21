package gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingPanel extends JPanel {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPoint = null;

	public DrawingPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String mode = DrawingApp.getActiveMode();

		
				if (mode.equals("NONE")) {
					return; 
				}
				
				int x = e.getX();
				int y = e.getY();
				
				
				if (mode.equals("POINT")) {
					Point p = new Point(x, y);
					shapes.add(p); 
					
				} else if (mode.equals("LINE")) {
					if (startPoint == null) {
						startPoint = new Point(x, y);
					} else {
						Point endPoint = new Point(x, y);
						Line l = new Line(startPoint, endPoint);
						shapes.add(l);
						startPoint = null; 
					}
					
				} else if (mode.equals("CIRCLE")) {
					DlgCircle dialog = new DlgCircle();
					dialog.setVisible(true);
					
					if (dialog.isConfirm()) {
						int radius = dialog.getRadius(); 
						Point center = new Point(x, y);  
						Circle c = new Circle(center, radius);
						shapes.add(c);
					}
					
				} else if (mode.equals("RECTANGLE")) {
					DlgRectangle dialog = new DlgRectangle();
					dialog.setVisible(true);
					
					if (dialog.isConfirm()) {
						int width = dialog.getRectangleWidth();
						int height = dialog.getRectangleHeight();
						Point upperLeft = new Point(x, y); 
						Rectangle r = new Rectangle(upperLeft, width, height);
						shapes.add(r);
					}
					
				} else if (mode.equals("DONUT")) {
					DlgDonut dialog = new DlgDonut();
					dialog.setVisible(true);
					
					if (dialog.isConfirm()) {
						int innerRadius = dialog.getInnerRadius();
						int outerRadius = dialog.getOuterRadius();
						Point center = new Point(x, y);
						Donut d = new Donut(center, innerRadius, outerRadius);
						shapes.add(d);
					}
				} 
				
				else if (mode.equals("SELECT")) {
					Shape selectedShape = null;

					
					for (int i = shapes.size() - 1; i >= 0; i--) {
						Shape s = shapes.get(i);
						if (s.contains(x, y)) {
							selectedShape = s;
							break; 
						}
					}

					
					for (Shape s : shapes) {
						if (s == selectedShape) {
							s.setSelected(!s.isSelected()); 
						} else {
							s.setSelected(false);
						}
					}
				}
				
				repaint(); 
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); 
		for (Shape s : shapes) {
			if (s != null) {
				s.draw(g); 
			}
		}
	}

	// --- POMOĆNE METODE ZA KOMUNIKACIJU SA GLAVNOM FORMOM ---
	
	// Vraća celu listu oblika
	public ArrayList<Shape> getShapes() {
		return this.shapes;
	}

	// Traži i vraća trenutno selektovani oblik (ili null ako nema nijednog)
	public Shape getSelectedShape() {
		for (Shape s : shapes) {
			if (s.isSelected()) {
				return s;
			}
		}
		return null;
	}
}