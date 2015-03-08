package grafica;

import grafica.controladoras.ControladoraNuevoJugador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.JPasswordField;

import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionsJugadores;



public class VentanaNuevoJugador {
	
	private grafica.controladoras.ControladoraNuevoJugador controladoraNuevoJugador;
	private JFrame frmNuevoJugador;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevoJugador window = new VentanaNuevoJugador();
					window.frmNuevoJugador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaNuevoJugador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuevoJugador = new JFrame();
		frmNuevoJugador.setResizable(false);
		frmNuevoJugador.setTitle("Adivina la pel\u00EDcula - Nuevo Jugador");
		frmNuevoJugador.setBounds(100, 100, 650, 464);
		frmNuevoJugador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraNuevoJugador= new ControladoraNuevoJugador();
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(40, 0, 40, 0));
		panel.setBackground(Color.DARK_GRAY);
		frmNuevoJugador.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("ADIVINA LA PEL\u00CDCULA");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 34));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frmNuevoJugador.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel lblCodigoDelJugador = new JLabel("Constrase\u00F1a del Jugador:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNombreDelJugador = new JLabel("Nombre del Jugador:");
		
		JButton btnConfirmar = new JButton("Aceptar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty())	{
					if(!(passwordField.getPassword().length==0)){
						String nombre = textField.getText();
						char[] array = passwordField.getPassword();
						String codigo = new String(array);
						try {				
							controladoraNuevoJugador.NuevoJugador(nombre, codigo);
							VentanaMenuAdministrador menuAdministrador = new VentanaMenuAdministrador();
							menuAdministrador.setVisible(true);
							frmNuevoJugador.setVisible(false);
							
						}catch (RemoteException | ExceptionsJugadores | NullPointerException e1) {
								e1.printStackTrace();
						}	
					}
				}
			}
		
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNuevoJugador.setVisible(false);
				VentanaMenuAdministrador menuAdministrador = new VentanaMenuAdministrador();
				menuAdministrador.setVisible(true);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setForeground(Color.WHITE);
		
		passwordField = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreDelJugador, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigoDelJugador, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap(403, Short.MAX_VALUE)
							.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDelJugador, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoDelJugador, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(79)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblNuevoJugador = new JLabel("Nuevo Jugador:");
		lblNuevoJugador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNuevoJugador, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(317, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNuevoJugador, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
	}
	
	public void setVisible (boolean visible) {
		frmNuevoJugador.setVisible(visible);
	}
	
	/*
	public void NuevoJugador(){
		if(!textField.getText().contentEquals(null)){
			if(!passwordField.getPassword().contentEquals(null)){
				DataJugador j = new DataJugador (textField.getText(),passwordField.getSelectedText());
				
			}
		}
	}*/
}
