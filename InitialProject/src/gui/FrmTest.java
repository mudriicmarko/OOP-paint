package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JLabel lblCrvena;
	private JLabel lblPlava;
	private JLabel lblZuta;
	private JTextField txtDodajBoju;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(127, 255, 0));
		contentPane.add(pnlNorth, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("Zadatak 1");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnlNorth.add(lblTitle);

		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlCenter.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlCenter.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlCenter.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pnlCenter.setLayout(gbl_pnlCenter);

		JToggleButton btnCrvena = new JToggleButton("Crvena");
		btnCrvena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblCrvena.getText());
			}
		});
		GridBagConstraints gbc_btnCrvena = new GridBagConstraints();
		gbc_btnCrvena.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrvena.gridx = 0;
		gbc_btnCrvena.gridy = 0;
		pnlCenter.add(btnCrvena, gbc_btnCrvena);
		btnGroup.add(btnCrvena);

		lblCrvena = new JLabel("Crvena");
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.anchor = GridBagConstraints.WEST;
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 0;
		pnlCenter.add(lblCrvena, gbc_lblCrvena);

		JToggleButton btnPlava = new JToggleButton("Plava");
		btnPlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblPlava.getText());
			}
		});

		JLabel lblDodatneBoje = new JLabel("Dodatne boje:");
		GridBagConstraints gbc_lblDodatneBoje = new GridBagConstraints();
		gbc_lblDodatneBoje.anchor = GridBagConstraints.EAST;
		gbc_lblDodatneBoje.insets = new Insets(0, 0, 5, 5);
		gbc_lblDodatneBoje.gridx = 2;
		gbc_lblDodatneBoje.gridy = 0;
		pnlCenter.add(lblDodatneBoje, gbc_lblDodatneBoje);

		JComboBox cmbDodatneBoje = new JComboBox();
		cmbDodatneBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(cmbDodatneBoje.getSelectedItem().toString());
				switch (cmbDodatneBoje.getSelectedItem().toString()) {
				case "Zelena":
					lblDodatneBoje.setForeground(Color.green);
					break;
				case "Narandzasta":
					lblDodatneBoje.setForeground(Color.orange);
					break;
				case "Ljubicasta":
					lblDodatneBoje.setForeground(Color.magenta);
				}
			}
		});
		cmbDodatneBoje.setModel(new DefaultComboBoxModel(new String[] { "Zelena", "Narandzasta", "Ljubicasta" }));
		GridBagConstraints gbc_cmbDodatneBoje = new GridBagConstraints();
		gbc_cmbDodatneBoje.insets = new Insets(0, 0, 5, 0);
		gbc_cmbDodatneBoje.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDodatneBoje.gridx = 3;
		gbc_cmbDodatneBoje.gridy = 0;
		pnlCenter.add(cmbDodatneBoje, gbc_cmbDodatneBoje);
		GridBagConstraints gbc_btnPlava = new GridBagConstraints();
		gbc_btnPlava.fill = GridBagConstraints.BOTH;
		gbc_btnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlava.gridx = 0;
		gbc_btnPlava.gridy = 1;
		pnlCenter.add(btnPlava, gbc_btnPlava);
		btnGroup.add(btnPlava);

		lblPlava = new JLabel("Plava");
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.anchor = GridBagConstraints.WEST;
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 1;
		pnlCenter.add(lblPlava, gbc_lblPlava);

		JToggleButton btnZuta = new JToggleButton("Zuta");
		btnZuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblZuta.getText());
			}
		});

		txtDodajBoju = new JTextField();
		txtDodajBoju.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtDodajBoju.getText());
					txtDodajBoju.setText("");
				}
			}
		});
		GridBagConstraints gbc_txtDodajBoju = new GridBagConstraints();
		gbc_txtDodajBoju.insets = new Insets(0, 0, 5, 0);
		gbc_txtDodajBoju.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDodajBoju.gridx = 3;
		gbc_txtDodajBoju.gridy = 1;
		pnlCenter.add(txtDodajBoju, gbc_txtDodajBoju);
		txtDodajBoju.setColumns(10);
		GridBagConstraints gbc_btnZuta = new GridBagConstraints();
		gbc_btnZuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnZuta.insets = new Insets(0, 0, 5, 5);
		gbc_btnZuta.gridx = 0;
		gbc_btnZuta.gridy = 2;
		pnlCenter.add(btnZuta, gbc_btnZuta);
		btnGroup.add(btnZuta);

		lblZuta = new JLabel("Zuta");
		GridBagConstraints gbc_lblZuta = new GridBagConstraints();
		gbc_lblZuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuta.anchor = GridBagConstraints.WEST;
		gbc_lblZuta.gridx = 1;
		gbc_lblZuta.gridy = 2;
		pnlCenter.add(lblZuta, gbc_lblZuta);

		JScrollPane scrlPnBoje = new JScrollPane();
		GridBagConstraints gbc_scrlPnBoje = new GridBagConstraints();
		gbc_scrlPnBoje.fill = GridBagConstraints.BOTH;
		gbc_scrlPnBoje.gridx = 3;
		gbc_scrlPnBoje.gridy = 3;
		pnlCenter.add(scrlPnBoje, gbc_scrlPnBoje);

		JList lstBoje = new JList();
		scrlPnBoje.setViewportView(lstBoje);
		lstBoje.setModel(dlm);

		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);

		JButton btnKlikniMe = new JButton("Klikni me");
		btnKlikniMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)", "Proba dugmeta",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton btnDodajBoju = new JButton("Dodaj boju");
		btnDodajBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlgTest = new DlgTest();
				dlgTest.setVisible(true);

				if (dlgTest.isOK) {
					dlm.addElement(dlgTest.getTxtCrvena().getText() + " " + dlgTest.getTxtZelena().getText() + " "
							+ dlgTest.getTxtPlava().getText());
					pnlCenter.setBackground(new Color(Integer.parseInt(dlgTest.getTxtCrvena().getText()),
							Integer.parseInt(dlgTest.getTxtZelena().getText()),
							Integer.parseInt(dlgTest.getTxtPlava().getText())));
				}
			}
		});
		pnlSouth.add(btnDodajBoju);

		JButton btnIzmeniBoju = new JButton("Izmeni boju");
		btnIzmeniBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlgTest = new DlgTest();
				try {
					String[] split = dlm.getElementAt(lstBoje.getSelectedIndex()).toString().split(" ");
					dlgTest.getTxtCrvena().setText(split[0]);
					dlgTest.getTxtZelena().setText(split[1]);
					dlgTest.getTxtPlava().setText(split[2]);
					dlgTest.setVisible(true);

					if (dlgTest.isOK) {
						dlm.removeElementAt(lstBoje.getSelectedIndex());
						dlm.addElement(dlgTest.getTxtCrvena().getText() + " " + dlgTest.getTxtZelena().getText() + " "
								+ dlgTest.getTxtPlava().getText());
						pnlCenter.setBackground(new Color(Integer.parseInt(dlgTest.getTxtCrvena().getText()),
								Integer.parseInt(dlgTest.getTxtZelena().getText()),
								Integer.parseInt(dlgTest.getTxtPlava().getText())));
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Morate selektovati RGB boju!", "Upozorenje",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pnlSouth.add(btnIzmeniBoju);

		JButton btnPozadina = new JButton("Boja pozadine");
		btnPozadina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color bgdColor = JColorChooser.showDialog(null, "Boja pozadine", Color.black);
				if (bgdColor != null) {
					pnlCenter.setBackground(bgdColor);
				}
			}
		});
		pnlSouth.add(btnPozadina);
		pnlSouth.add(btnKlikniMe);

	}

}
