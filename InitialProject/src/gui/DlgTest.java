package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgTest extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCrvena;
	private JTextField txtZelena;
	private JTextField txtPlava;
	protected boolean isOK;

	public JTextField getTxtCrvena() {
		return txtCrvena;
	}

	public void setTxtCrvena(JTextField txtCrvena) {
		this.txtCrvena = txtCrvena;
	}

	public JTextField getTxtZelena() {
		return txtZelena;
	}

	public void setTxtZelena(JTextField txtZelena) {
		this.txtZelena = txtZelena;
	}

	public JTextField getTxtPlava() {
		return txtPlava;
	}

	public void setTxtPlava(JTextField txtPlava) {
		this.txtPlava = txtPlava;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTest dialog = new DlgTest();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTest() {
		setModal(true);
		setTitle("Unos boje");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCrvena = new JLabel("Crvena");
			GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
			gbc_lblCrvena.anchor = GridBagConstraints.EAST;
			gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
			gbc_lblCrvena.gridx = 0;
			gbc_lblCrvena.gridy = 0;
			contentPanel.add(lblCrvena, gbc_lblCrvena);
		}
		{
			txtCrvena = new JTextField();
			GridBagConstraints gbc_txtCrvena = new GridBagConstraints();
			gbc_txtCrvena.insets = new Insets(0, 0, 5, 0);
			gbc_txtCrvena.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCrvena.gridx = 1;
			gbc_txtCrvena.gridy = 0;
			contentPanel.add(txtCrvena, gbc_txtCrvena);
			txtCrvena.setColumns(10);
		}
		{
			JLabel lblZelena = new JLabel("Zelena");
			GridBagConstraints gbc_lblZelena = new GridBagConstraints();
			gbc_lblZelena.anchor = GridBagConstraints.EAST;
			gbc_lblZelena.insets = new Insets(0, 0, 5, 5);
			gbc_lblZelena.gridx = 0;
			gbc_lblZelena.gridy = 1;
			contentPanel.add(lblZelena, gbc_lblZelena);
		}
		{
			txtZelena = new JTextField();
			GridBagConstraints gbc_txtZelena = new GridBagConstraints();
			gbc_txtZelena.insets = new Insets(0, 0, 5, 0);
			gbc_txtZelena.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtZelena.gridx = 1;
			gbc_txtZelena.gridy = 1;
			contentPanel.add(txtZelena, gbc_txtZelena);
			txtZelena.setColumns(10);
		}
		{
			JLabel lblPlava = new JLabel("Plava");
			GridBagConstraints gbc_lblPlava = new GridBagConstraints();
			gbc_lblPlava.anchor = GridBagConstraints.EAST;
			gbc_lblPlava.insets = new Insets(0, 0, 0, 5);
			gbc_lblPlava.gridx = 0;
			gbc_lblPlava.gridy = 2;
			contentPanel.add(lblPlava, gbc_lblPlava);
		}
		{
			txtPlava = new JTextField();
			GridBagConstraints gbc_txtPlava = new GridBagConstraints();
			gbc_txtPlava.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPlava.gridx = 1;
			gbc_txtPlava.gridy = 2;
			contentPanel.add(txtPlava, gbc_txtPlava);
			txtPlava.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int red = Integer.parseInt(txtCrvena.getText());
							int green = Integer.parseInt(txtZelena.getText());
							int blue = Integer.parseInt(txtPlava.getText());

							if (red >= 0 && red < 256 && green >= 0 && green < 256 && blue >= 0 && blue < 256) {
								isOK = true;
							} else {
								JOptionPane.showMessageDialog(null, 
										"Vrednosti moraju biti u opsegu!", 
										"Upozorenje",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, 
									"Vrednosti moraju biti brojevi!", 
									"Upozorenje",
									JOptionPane.ERROR_MESSAGE);
						}
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
