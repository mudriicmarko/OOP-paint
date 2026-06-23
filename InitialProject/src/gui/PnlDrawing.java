package gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class PnlDrawing extends JPanel {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPointLine = null;

	public PnlDrawing() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mode = FrmDrawing.getActiveMode();
				int x = e.getX();
				int y = e.getY();

				if (mode.equals("POINT")) {
					Point p = new Point(x, y);
					p.setEdgeColor(FrmDrawing.getEdgeColor());
					shapes.add(p);
					startPointLine = null;
				} else if (mode.equals("LINE")) {
					if (startPointLine == null) {
						startPointLine = new Point(x, y);
					} else {
						Point endPoint = new Point(x, y);
						Line line = new Line(startPointLine, endPoint);
						line.setEdgeColor(FrmDrawing.getEdgeColor());
						shapes.add(line);
						startPointLine = null;
					}
				} else if (mode.equals("CIRCLE")) {
					startPointLine = null;
					DlgCircle dialog = new DlgCircle();
					dialog.setVisible(true);

					if (dialog.isConfirm()) {
						try {
							Circle c = new Circle(new Point(x, y), dialog.getRadius());
							c.setEdgeColor(FrmDrawing.getEdgeColor());
							c.setInnerColor(FrmDrawing.getInnerColor());
							shapes.add(c);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else if (mode.equals("RECTANGLE")) {
					startPointLine = null;
					DlgRectangle dialog = new DlgRectangle();
					dialog.setVisible(true);

					if (dialog.isConfirm()) {
						Rectangle r = new Rectangle(new Point(x, y), dialog.getRectangleWidth(),
								dialog.getRectangleHeight());
						r.setEdgeColor(FrmDrawing.getEdgeColor());
						r.setInnerColor(FrmDrawing.getInnerColor());
						shapes.add(r);
					}
				} else if (mode.equals("DONUT")) {
					startPointLine = null;
					DlgDonut dialog = new DlgDonut();
					dialog.setVisible(true);

					if (dialog.isConfirm()) {
						Donut d = new Donut(new Point(x, y), dialog.getOuterRadius(), dialog.getInnerRadius());
						d.setEdgeColor(FrmDrawing.getEdgeColor());
						d.setInnerColor(FrmDrawing.getInnerColor());
						shapes.add(d);
					}
				} else if (mode.equals("SELECT")) {
					startPointLine = null;
					Shape clickedShape = null;

					for (int i = shapes.size() - 1; i >= 0; i--) {
						if (shapes.get(i).contains(x, y)) {
							clickedShape = shapes.get(i);
							break;
						}
					}

					if (clickedShape != null) {

						if (clickedShape.isSelected()) {
							clickedShape.setSelected(false);
						} else {
							for (Shape s : shapes) {
								s.setSelected(false);
							}
							clickedShape.setSelected(true);
						}
					} else {

						for (Shape s : shapes) {
							s.setSelected(false);
						}
					}
				}

				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Shape s : shapes) {
			s.draw(g);
		}
	}

	public Shape getSelectedShape() {
		for (Shape s : shapes) {
			if (s.isSelected()) {
				return s;
			}
		}
		return null;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}
}