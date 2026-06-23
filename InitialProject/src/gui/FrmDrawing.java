package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class FrmDrawing {

	private static String ActiveBtn = "NONE";

	private static Color edgeColor = Color.BLACK;
	private static Color innerColor = Color.WHITE;

	private static JButton btnPoint;
	private static JButton btnLine;
	private static JButton btnCircle;
	private static JButton btnRectangle;
	private static JButton btnDonut;
	private static JButton btnSelect;
	private static JButton btnModify;
	private static JButton btnDelete;
	private static JButton btnEdgeColor;
	public static JButton btnInnerColor;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Paint");
		frame.setSize(1150, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		JPanel toolbar = new JPanel();
		toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
		toolbar.setBackground(Color.cyan);

		JPanel bottomToolbar = new JPanel();
		bottomToolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
		bottomToolbar.setBackground(Color.cyan);

		btnPoint = new JButton("Point");
		btnLine = new JButton("Line");
		btnCircle = new JButton("Circle");
		btnRectangle = new JButton("Rectangle");
		btnDonut = new JButton("Donut");
		btnSelect = new JButton("Select");
		btnModify = new JButton("Modify");
		btnDelete = new JButton("Delete");
		btnEdgeColor = new JButton("Edge color");
		btnInnerColor = new JButton("Inner color");

		btnEdgeColor.setBackground(edgeColor);
		btnInnerColor.setBackground(innerColor);

		btnPoint.setFocusPainted(false);
		btnLine.setFocusPainted(false);
		btnCircle.setFocusPainted(false);
		btnRectangle.setFocusPainted(false);
		btnDonut.setFocusPainted(false);
		btnSelect.setFocusPainted(false);
		btnModify.setFocusPainted(false);
		btnDelete.setFocusPainted(false);
		btnEdgeColor.setFocusPainted(false);
		btnInnerColor.setFocusPainted(false);

		toolbar.add(btnPoint);
		toolbar.add(btnLine);
		toolbar.add(btnCircle);
		toolbar.add(btnRectangle);
		toolbar.add(btnDonut);
		bottomToolbar.add(btnSelect);
		bottomToolbar.add(btnModify);
		bottomToolbar.add(btnDelete);
		bottomToolbar.add(btnEdgeColor);
		bottomToolbar.add(btnInnerColor);

		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveBtn = "POINT";
				updateButtonColors(btnPoint);
			}
		});

		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveBtn = "LINE";
				updateButtonColors(btnLine);
			}
		});

		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveBtn = "CIRCLE";
				updateButtonColors(btnCircle);
			}
		});

		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveBtn = "RECTANGLE";
				updateButtonColors(btnRectangle);
			}
		});

		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveBtn = "DONUT";
				updateButtonColors(btnDonut);
			}
		});

		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveBtn = "SELECT";
				updateButtonColors(btnSelect);
			}
		});

		final PnlDrawing drawingPanel = new PnlDrawing();
		drawingPanel.setBackground(Color.WHITE);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButtonColors(btnDelete);
				Shape selected = drawingPanel.getSelectedShape();

				if (selected == null) {
					JOptionPane.showMessageDialog(null, "No shape selected for deletion!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this shape?",
							"Confirm Deletion", JOptionPane.YES_NO_OPTION);

					if (option == JOptionPane.YES_OPTION) {
						drawingPanel.getShapes().remove(selected);
						drawingPanel.repaint();
						btnInnerColor.setEnabled(true);
					}
				}
			}
		});

		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButtonColors(btnModify);
				Shape selected = drawingPanel.getSelectedShape();

				if (selected == null) {
					JOptionPane.showMessageDialog(null, "Please select a shape first!", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (selected instanceof Point) {
					Point p = (Point) selected;
					Color newColor = JColorChooser.showDialog(null, "Izaberi novu boju tačke", p.getEdgeColor());
					if (newColor != null) {
						p.setEdgeColor(newColor);
					}
					p.setSelected(false);
				} else if (selected instanceof Line) {
					Line l = (Line) selected;
					Color newColor = JColorChooser.showDialog(null, "Izaberi novu boju linije", l.getEdgeColor());
					if (newColor != null) {
						l.setEdgeColor(newColor);
					}
					l.setSelected(false);
				} else if (selected instanceof Circle && !(selected instanceof Donut)) {
					Circle c = (Circle) selected;
					DlgCircle dialog = new DlgCircle();
					dialog.setTxtRadiusText(String.valueOf(c.getRadius()));
					dialog.setVisible(true);

					if (dialog.isConfirm()) {
						try {
							c.setRadius(dialog.getRadius());

							Color newEdge = JColorChooser.showDialog(null, "Izaberi novu boju ivice kruga",
									c.getEdgeColor());
							if (newEdge != null)
								c.setEdgeColor(newEdge);

							Color newInner = JColorChooser.showDialog(null, "Izaberi novu boju unutrašnjosti kruga",
									c.getInnerColor());
							if (newInner != null)
								c.setInnerColor(newInner);

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
						}
					}
					c.setSelected(false);
				} else if (selected instanceof Donut) {
					Donut d = (Donut) selected;
					DlgDonut dialog = new DlgDonut();
					dialog.setTxtInnerRadiusText(String.valueOf(d.getInnerRadius()));
					dialog.setTxtOuterRadiusText(String.valueOf(d.getOuterRadius()));
					dialog.setVisible(true);

					if (dialog.isConfirm()) {
						d.setInnerRadius(dialog.getInnerRadius());
						d.setOuterRadius(dialog.getOuterRadius());

						Color newEdge = JColorChooser.showDialog(null, "Izaberi novu boju ivice krofne",
								d.getEdgeColor());
						if (newEdge != null)
							d.setEdgeColor(newEdge);

						Color newInner = JColorChooser.showDialog(null, "Izaberi novu boju unutrašnjosti krofne",
								d.getInnerColor());
						if (newInner != null)
							d.setInnerColor(newInner);
					}
					d.setSelected(false);
				} else if (selected instanceof Rectangle) {
					Rectangle r = (Rectangle) selected;
					DlgRectangle dialog = new DlgRectangle();
					dialog.setTxtWidthText(String.valueOf(r.getRectangleWidth()));
					dialog.setTxtHeightText(String.valueOf(r.getRectangleHeight()));
					dialog.setVisible(true);

					if (dialog.isConfirm()) {
						r.setWidth(dialog.getRectangleWidth());
						r.setHeight(dialog.getRectangleHeight());

						Color newEdge = JColorChooser.showDialog(null, "Izaberi novu boju ivice pravougaonika",
								r.getEdgeColor());
						if (newEdge != null)
							r.setEdgeColor(newEdge);

						Color newInner = JColorChooser.showDialog(null, "Izaberi novu boju unutrašnjosti pravougaonika",
								r.getInnerColor());
						if (newInner != null)
							r.setInnerColor(newInner);
					}
					r.setSelected(false);
				}

				btnInnerColor.setEnabled(true);
				drawingPanel.repaint();
			}
		});

		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color chosenColor = JColorChooser.showDialog(null, "Choose Edge Color", edgeColor);
				if (chosenColor != null) {
					edgeColor = chosenColor;
					btnEdgeColor.setBackground(edgeColor);
				}
			}
		});

		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color chosenColor = JColorChooser.showDialog(null, "Choose Inner Color", innerColor);
				if (chosenColor != null) {
					innerColor = chosenColor;
					btnInnerColor.setBackground(innerColor);
				}
			}
		});

		frame.getContentPane().add(toolbar, BorderLayout.NORTH);
		frame.getContentPane().add(bottomToolbar, BorderLayout.SOUTH);
		frame.getContentPane().add(drawingPanel, BorderLayout.CENTER);

		frame.setVisible(true);
	}

	private static void updateButtonColors(JButton clickedButton) {
		JButton[] buttons = { btnPoint, btnLine, btnCircle, btnRectangle, btnDonut, btnSelect, btnDelete, btnModify };
		for (JButton btn : buttons) {
			if (btn == clickedButton) {
				btn.setBackground(Color.white);
				btn.setForeground(Color.GREEN);
			} else {
				btn.setBackground(null);
				btn.setForeground(Color.BLACK);
			}
		}
	}

	public static String getActiveMode() {
		return ActiveBtn;
	}

	public static Color getEdgeColor() {
		return edgeColor;
	}

	public static Color getInnerColor() {
		return innerColor;
	}
}