package grafica;
import grafica.VentanaPartida;
import grafica.auxiliares.TextPrompt;
import grafica.controladoras.ControladoraLogin;

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

import logica.ValueObjetcs.DataLogin;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionsJugadores;

import javax.swing.UIManager;


public class VentanaLogin {

	private JFrame frmLogin;
	private JTextField txtNombre;
	private JPasswordField passwordField;
	private ControladoraLogin controladoraLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frmLogin.setVisible(true);
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
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(247, 247, 247));
		frmLogin.setTitle("Adivina la pel\u00EDcula - Login");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 580, 456);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraLogin = new ControladoraLogin();
		
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
				
				String nombreJugador = txtNombre.getText();
				char[] array = passwordField.getPassword();
				String codigoJugador = new String(array);
				Border border = BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.RED, 2), 
				        BorderFactory.createEmptyBorder(5, 10, 5, 10));
				try {
					controladoraLogin.login(nombreJugador, codigoJugador);
					VentanaMenuJugador menuJugador = new VentanaMenuJugador();
					menuJugador.setVisible(true);
					frmLogin.setVisible(false);
				} catch (ExceptionsJugadores e1) {
					txtNombre.setBorder(border);
					passwordField.setBorder(border);
				} catch (ExceptionCodigoIncorrecto e1) {
					txtNombre.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createLineBorder(Color.GRAY, 1), 
					        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
					passwordField.setBorder(border);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setForeground(Color.DARK_GRAY);
		
		JLabel lblNewLabel = new JLabel("ADIVINA LA PEL\u00CDCULA");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 34));
		
		
		// LAYOUT
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
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
					.addContainerGap(106, Short.MAX_VALUE)
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
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addGap(113))
		);
		frmLogin.getContentPane().setLayout(groupLayout);
		frmLogin.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, btnNewButton, passwordField, tpPasswordField, txtNombre, tpNombre}));
		
	
	}
	public void setVisible (boolean visible) {
		frmLogin.setVisible(visible);
	}
}
