package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingApp {
	
	private static String ActiveBtn = "NONE";
	
	
	private static JButton btnPoint;
	private static JButton btnLine;
	private static JButton btnCircle;
	private static JButton btnRectangle;
	private static JButton btnSelect;
	private static JButton btnDelete;
	private static JButton btnUnselect;
	
	
	
	

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Drawing OOIT - Paint");
		frame.setSize(1024, 768); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel toolbar = new JPanel();
		toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
		toolbar.setBackground(Color.cyan);
		
		
		btnPoint = new JButton("Tačka");
		btnLine = new JButton("Linija");
		btnCircle = new JButton("Krug");
		btnRectangle = new JButton("Pravougaonik");
		btnSelect = new JButton("Selektuj");
		btnDelete = new JButton("Obriši");
		btnUnselect = new JButton("Deselektuj");
		
		
		
		btnPoint.setFocusPainted(false);
		btnLine.setFocusPainted(false);
		btnCircle.setFocusPainted(false);
		btnRectangle.setFocusPainted(false);
		btnSelect.setFocusPainted(false);
		btnDelete.setFocusPainted(false);
		btnUnselect.setFocusPainted(false);
		
		//Ove linije brisu pravougaonik oko teksta u buttonima
		
		
		
		
		
		toolbar.add(btnPoint);
		toolbar.add(btnLine);
		toolbar.add(btnCircle);
		toolbar.add(btnRectangle);
		toolbar.add(btnSelect);
		toolbar.add(btnDelete);
		toolbar.add(btnUnselect);
	
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

		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveBtn = "SELECT";
				updateButtonColors(btnSelect); 
			}
		});

		DrawingPanel drawingPanel = new DrawingPanel();
		drawingPanel.setBackground(Color.WHITE); 

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateButtonColors(btnDelete); 
			}
		});
		
		btnUnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveBtn = "NONE";
				updateButtonColors(null); 
			}
		});

		frame.getContentPane().add(toolbar, BorderLayout.NORTH); 
		frame.getContentPane().add(drawingPanel, BorderLayout.CENTER); 

		frame.setVisible(true);
	}

	private static void updateButtonColors(JButton clickedButton) {
		JButton[] buttons = {btnPoint, btnLine, btnCircle, btnRectangle, btnSelect, btnDelete};
		
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
}