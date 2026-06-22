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

public class DlgCircle extends JDialog {

	private JTextField txtRadius;
	private boolean confirm = false; 

	public DlgCircle() {
	
		setModal(true);
		setTitle("Circle properties");
		setSize(300, 150);
		setLocationRelativeTo(null); 
		getContentPane().setLayout(new BorderLayout());

	
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(1, 2, 5, 5)); 
		
		JLabel lblRadius = new JLabel("Radius:", SwingConstants.CENTER);
		txtRadius = new JTextField();
		
		pnlCenter.add(lblRadius);
		pnlCenter.add(txtRadius);
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
				
					int radius = Integer.parseInt(txtRadius.getText().trim());
					
				
					if (radius <= 0) {
						JOptionPane.showMessageDialog(null, "Radius must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						confirm = true;    
						setVisible(false); 
					}
				} catch (NumberFormatException nfe) {
					
					JOptionPane.showMessageDialog(null, "Please enter a valid integer number!", "Error", JOptionPane.ERROR_MESSAGE);
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


	public int getRadius() {
		return Integer.parseInt(txtRadius.getText().trim());
	}




	public void setTxtRadiusText(String valueOf) {
		// TODO Auto-generated method stub
		
	}
}