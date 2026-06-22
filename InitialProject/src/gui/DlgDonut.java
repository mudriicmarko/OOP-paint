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

	private JTextField txtInnerRadius;
	private JTextField txtOuterRadius;
	private boolean confirm = false; 

	public DlgDonut() {
		
		setModal(true);
		setTitle("Donut properties");
		setSize(300, 180); 
		setLocationRelativeTo(null); 
		getContentPane().setLayout(new BorderLayout());


		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(2, 2, 5, 5)); 
		
		JLabel lblInnerRadius = new JLabel("Inner radius:", SwingConstants.CENTER);
		txtInnerRadius = new JTextField();
		
		JLabel lblOuterRadius = new JLabel("Outer radius:", SwingConstants.CENTER);
		txtOuterRadius = new JTextField();
		
		pnlCenter.add(lblInnerRadius);
		pnlCenter.add(txtInnerRadius);
		pnlCenter.add(lblOuterRadius);
		pnlCenter.add(txtOuterRadius);
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
					int innerRadius = Integer.parseInt(txtInnerRadius.getText().trim());
					int outerRadius = Integer.parseInt(txtOuterRadius.getText().trim());
					
		
					if (innerRadius <= 0 || outerRadius <= 0) {
						JOptionPane.showMessageDialog(null, "Radii must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
					} 
					
					else if (innerRadius >= outerRadius) {
						JOptionPane.showMessageDialog(null, "Inner radius must be smaller than outer radius!", "Error", JOptionPane.ERROR_MESSAGE);
					} 
					else {
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

	
	public boolean isConfirm() {
		return confirm;
	}

	public int getInnerRadius() {
		return Integer.parseInt(txtInnerRadius.getText().trim());
	}

	public int getOuterRadius() {
		return Integer.parseInt(txtOuterRadius.getText().trim());
	}


	public void setTxtInnerRadiusText(String valueOf) {
		// TODO Auto-generated method stub
		
	}


	public void setTxtOuterRadiusText(String valueOf) {
		// TODO Auto-generated method stub
		
	}
}