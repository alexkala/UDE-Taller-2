package grafica;
import grafica.TextPrompt;
import grafica.VentanaPartida;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.JToolBar;
import javax.swing.JSeparator;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import javax.swing.ImageIcon;


public class VentanaLogin {

	private JFrame frmPruebaVentana;
	private JTextField txtNombre;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frmPruebaVentana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPruebaVentana = new JFrame();
		frmPruebaVentana.getContentPane().setBackground(new Color(247, 247, 247));
		frmPruebaVentana.setTitle("Prueba ventana - Login");
		frmPruebaVentana.setResizable(false);
		frmPruebaVentana.setBounds(100, 100, 580, 456);
		frmPruebaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// NOMBRE
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.DARK_GRAY);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		TextPrompt tpNombre = new TextPrompt("Nombre", txtNombre);
		tpNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		tpNombre.setForeground( Color.LIGHT_GRAY );
		tpNombre.changeAlpha(0.5f);
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setBorder(BorderFactory.createCompoundBorder(
				txtNombre.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		txtNombre.setColumns(40);
		
		
		// CODIGO
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 13));
		passwordField.setForeground(Color.DARK_GRAY);
		TextPrompt tpPasswordField = new TextPrompt("Password", passwordField);
		tpPasswordField.setFont(new Font("Arial", Font.PLAIN, 13));
		tpPasswordField.setForeground(Color.LIGHT_GRAY);
		tpPasswordField.changeAlpha(0.5f);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBorder(BorderFactory.createCompoundBorder(
				passwordField.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		
		// BOTON
		
		
		
		JButton btnNewButton = new JButton("Iniciar sesi\u00F3n");		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPartida ventana = new VentanaPartida();
				ventana.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setForeground(Color.DARK_GRAY);
		
		JLabel lblNewLabel = new JLabel("ADIVINA LA PEL\u00CDCULA");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 34));
		
		
		// LAYOUT
		GroupLayout groupLayout = new GroupLayout(frmPruebaVentana.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(passwordField, Alignment.TRAILING, 263, 263, Short.MAX_VALUE)
						.addComponent(txtNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
					.addContainerGap(155, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(305, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(105))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel)
					.addGap(64)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
					.addGap(113))
		);
		frmPruebaVentana.getContentPane().setLayout(groupLayout);
		frmPruebaVentana.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, btnNewButton, passwordField, tpPasswordField, txtNombre, tpNombre}));
		
	
	}
	public void setVisible (boolean visible) {
		frmPruebaVentana.setVisible(visible);
	}
}
