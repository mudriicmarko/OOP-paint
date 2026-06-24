package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DlgDonut extends JDialog {

	private JTextField txtX, txtY, txtOuterRadius, txtInnerRadius;
	private boolean confirm = false;

	public DlgDonut() {
		setModal(true);
		setTitle("Donut properties");
		setSize(300, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(4, 2, 5, 5));
		
		pnlCenter.add(new JLabel("Center X:", SwingConstants.CENTER));
		txtX = new JTextField();
		pnlCenter.add(txtX);
		
		pnlCenter.add(new JLabel("Center Y:", SwingConstants.CENTER));
		txtY = new JTextField();
		pnlCenter.add(txtY);
		
		pnlCenter.add(new JLabel("Outer Radius:", SwingConstants.CENTER));
		txtOuterRadius = new JTextField();
		pnlCenter.add(txtOuterRadius);
		
		pnlCenter.add(new JLabel("Inner Radius:", SwingConstants.CENTER));
		txtInnerRadius = new JTextField();
		pnlCenter.add(txtInnerRadius);
		
		getContentPane().add(pnlCenter, BorderLayout.CENTER);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton btnOK = new JButton("OK");
		JButton btnCancel = new JButton("Cancel");
		pnlButtons.add(btnOK);
		pnlButtons.add(btnCancel);
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int x = Integer.parseInt(txtX.getText().trim());
					int y = Integer.parseInt(txtY.getText().trim());
					int outer = Integer.parseInt(txtOuterRadius.getText().trim());
					int inner = Integer.parseInt(txtInnerRadius.getText().trim());
					
					if (outer <= 0 || inner <= 0) {
						JOptionPane.showMessageDialog(null, "Radius must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (inner >= outer) {
						JOptionPane.showMessageDialog(null, "Inner radius must be smaller than outer radius!", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						confirm = true;
						setVisible(false);
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Please enter valid integer numbers!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirm = false;
				setVisible(false);
			}
		});
	}

	public boolean isConfirm() { return confirm; }
	public int getXCoord() { return Integer.parseInt(txtX.getText().trim()); }
	public int getYCoord() { return Integer.parseInt(txtY.getText().trim()); }
	public int getOuterRadius() { return Integer.parseInt(txtOuterRadius.getText().trim()); }
	public int getInnerRadius() { return Integer.parseInt(txtInnerRadius.getText().trim()); }

	public void setTxtXText(String val) { txtX.setText(val); }
	public void setTxtYText(String val) { txtY.setText(val); }
	public void setTxtOuterRadiusText(String val) { txtOuterRadius.setText(val); }
	public void setTxtInnerRadiusText(String val) { txtInnerRadius.setText(val); }

	
	public void setFieldsEnabled(boolean enabled) {
		txtX.setEnabled(enabled);
		txtY.setEnabled(enabled);
		txtOuterRadius.setEnabled(enabled);
		txtInnerRadius.setEnabled(enabled);
	}
}