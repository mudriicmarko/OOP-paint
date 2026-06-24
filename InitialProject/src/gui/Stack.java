package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import geometry.Donut;
import geometry.Point;

public class Stack {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Stack)");
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());

		// Model i JList za vizuelni prikaz steka
		DefaultListModel<Donut> listModel = new DefaultListModel<Donut>();
		JList<Donut> list = new JList<Donut>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton btnPush = new JButton("Add (Push)");
		JButton btnPop = new JButton("Remove (Pop)");
		pnlButtons.add(btnPush);
		pnlButtons.add(btnPop);
		frame.getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDonut dialog = new DlgDonut();
				dialog.setVisible(true);

				if (dialog.isConfirm()) {
					Donut d = new Donut(
						new Point(dialog.getXCoord(), dialog.getYCoord()), 
						dialog.getOuterRadius(), 
						dialog.getInnerRadius()
					);
					
					listModel.add(0, d);
				}
			}
		});


		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listModel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "The stack is empty!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				
				Donut topDonut = listModel.getElementAt(0);

				DlgDonut dialog = new DlgDonut();
				dialog.setTitle("Review Donut before removal");
				
				
				dialog.setTxtXText(String.valueOf(topDonut.getCenter().getX()));
				dialog.setTxtYText(String.valueOf(topDonut.getCenter().getY()));
				dialog.setTxtOuterRadiusText(String.valueOf(topDonut.getOuterRadius()));
				dialog.setTxtInnerRadiusText(String.valueOf(topDonut.getInnerRadius()));
				
			
				dialog.setFieldsEnabled(false);
				dialog.setVisible(true);

	
				if (dialog.isConfirm()) {
					listModel.remove(0);
				}
			}
		});

		frame.setVisible(true);
	}
}