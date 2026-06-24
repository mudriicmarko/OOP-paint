package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import geometry.Donut;
import geometry.Point;

public class Sort {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Donut Sorting by Area");
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());

		DefaultListModel<Donut> listModel = new DefaultListModel<Donut>();
		JList<Donut> list = new JList<Donut>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton btnAdd = new JButton("Add");
		pnlButtons.add(btnAdd);
		frame.getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDonut dialog = new DlgDonut();
				dialog.setVisible(true);

				if (dialog.isConfirm()) {
					Donut d = new Donut(
						new Point(dialog.getXCoord(), dialog.getYCoord()), 
						dialog.getOuterRadius(), 
						dialog.getInnerRadius()
					);
					listModel.addElement(d);
				}
			}
		});

		frame.setVisible(true);
	}
}