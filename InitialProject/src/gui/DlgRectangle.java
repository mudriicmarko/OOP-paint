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

public class DlgRectangle extends JDialog {

	private JTextField txtWidth;
	private JTextField txtHeight;
	private boolean confirm = false; 

	public DlgRectangle() {
		
		setModal(true);
		setTitle("Rectangle properties");
		setSize(300, 180); 
		setLocationRelativeTo(null); 
		getContentPane().setLayout(new BorderLayout());

	
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(2, 2, 5, 5)); 
		
		JLabel lblWidth = new JLabel("Width:", SwingConstants.CENTER);
		txtWidth = new JTextField();
		
		JLabel lblHeight = new JLabel("Height:", SwingConstants.CENTER);
		txtHeight = new JTextField();
		
		pnlCenter.add(lblWidth);
		pnlCenter.add(txtWidth);
		pnlCenter.add(lblHeight);
		pnlCenter.add(txtHeight);
		getContentPane().add(pnlCenter, BorderLayout.CENTER);

		// 2. Donji panel za dugmiće
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
					int width = Integer.parseInt(txtWidth.getText().trim());
					int height = Integer.parseInt(txtHeight.getText().trim());
					
				
					if (width <= 0 || height <= 0) {
						JOptionPane.showMessageDialog(null, "Width and Height must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
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


	public boolean isConfirm() {
		return confirm;
	}

	public int getRectangleWidth() {
		return Integer.parseInt(txtWidth.getText().trim());
	}

	public int getRectangleHeight() {
		return Integer.parseInt(txtHeight.getText().trim());
	}
}