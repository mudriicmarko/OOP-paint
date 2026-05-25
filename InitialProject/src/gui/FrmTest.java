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
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JLabel lblCrvena;
	private JLabel lblPlava;
	private JLabel lblZuta;
	
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
		gbl_pnlCenter.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JButton btnCrvena = new JButton("Crvena");
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
		
		JButton btnPlava = new JButton("Plava");
		btnPlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblPlava.getText());
			}
		});
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
		
		JButton btnZuta = new JButton("Zuta");
		btnZuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblZuta.getText());
			}
		});
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
				JOptionPane.showMessageDialog(null, "Antistres dugme :)", "Proba dugmeta", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pnlSouth.add(btnKlikniMe);

	}

}
