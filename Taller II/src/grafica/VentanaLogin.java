package grafica;
import grafica.VentanaPartida;
import grafica.auxiliares.BackgroundPanel;
import grafica.auxiliares.Constantes;
import grafica.auxiliares.TextPrompt;
import grafica.controladoras.ControladoraLogin;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Image;

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
import java.io.File;
import java.io.IOException;

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
	 * @throws IOException 
	 */
	public VentanaLogin() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(247, 247, 247));
		frmLogin.setTitle("Adivina la pel\u00EDcula - Login");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 800, 700);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraLogin = new ControladoraLogin();
		/*passwordField.setBorder(BorderFactory.createCompoundBorder(
				passwordField.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		*/
		frmLogin.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Image backgroundImage = ImageIO.read(new File(Constantes.RUTA_BACKGROUND));
		
		BackgroundPanel panelContenido = new BackgroundPanel(backgroundImage);
		frmLogin.getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel panelArriba = new JPanel();
		panelArriba.setBackground(Color.PINK);
		panelContenido.add(panelArriba, BorderLayout.NORTH);
		panelArriba.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(231, 76, 60));
		panelArriba.add(panelTitulo);
		panelTitulo.setBorder(new EmptyBorder(15, 0, 15, 0));
		
		JLabel lblTitulo = new JLabel("");
		panelTitulo.add(lblTitulo);
		lblTitulo.setIcon(new ImageIcon(Constantes.RUTA_TITULO));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 34));
		
		JPanel panelLogin = new JPanel();
		panelContenido.add(panelLogin, BorderLayout.CENTER);
		
		JPanel panelCampos = new JPanel();
		panelCampos.setBackground(new Color(52, 73, 94));
		panelCampos.setBorder(new EmptyBorder(40, 40, 30, 40));
		
		// NOMBRE
		txtNombre = new JTextField();
		TextPrompt tpNombre = new TextPrompt("Nombre", txtNombre);
		tpNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		tpNombre.setForeground( Color.LIGHT_GRAY );
		txtNombre.setForeground(Color.DARK_GRAY);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		
		
		// CODIGO
		passwordField = new JPasswordField();
		TextPrompt tpPasswordField = new TextPrompt("Password", passwordField);
		tpPasswordField.setFont(new Font("Arial", Font.PLAIN, 13));
		tpPasswordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 13));
		passwordField.setForeground(Color.DARK_GRAY);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		// BOTON
		JButton btnLogin = new JButton("Iniciar sesi\u00F3n");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreJugador = txtNombre.getText();
				char[] array = passwordField.getPassword();
				String codigoJugador = new String(array);
				Border border = BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.RED, 2), 
				        BorderFactory.createEmptyBorder(5, 10, 5, 10));
				try {
					controladoraLogin.login(nombreJugador, codigoJugador);
					
					BufferSesion.getInstancia().setNombreJugador(nombreJugador);
					BufferSesion.getInstancia().setCodigoJugador(codigoJugador);
					VentanaMenuJugador menuJugador = new VentanaMenuJugador();
					frmLogin.setVisible(false);
					menuJugador.setVisible(true);
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
		btnLogin.setFont(new Font("Arial", Font.BOLD, 13));
		btnLogin.setForeground(Color.DARK_GRAY);
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addGap(223)
					.addComponent(panelCampos, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		gl_panelLogin.setVerticalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addGap(56)
					.addComponent(panelCampos, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		
		JLabel lblIconoLogin = new JLabel("");
		lblIconoLogin.setIcon(new ImageIcon(Constantes.RUTA_ICONO_LOGIN));
		lblIconoLogin.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panelCampos = new GroupLayout(panelCampos);
		gl_panelCampos.setHorizontalGroup(
			gl_panelCampos.createParallelGroup(Alignment.LEADING)
				.addComponent(btnLogin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
				.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
				.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
				.addComponent(lblIconoLogin, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
		);
		gl_panelCampos.setVerticalGroup(
			gl_panelCampos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCampos.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIconoLogin)
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
		);
		panelCampos.setLayout(gl_panelCampos);
		panelLogin.setLayout(gl_panelLogin);
		
	
	}
	public void setVisible (boolean visible) {
		frmLogin.setVisible(visible);
	}
}
