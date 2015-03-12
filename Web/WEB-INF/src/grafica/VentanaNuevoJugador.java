
package grafica;

import grafica.auxiliares.Constantes;
import grafica.auxiliares.TextPrompt;
import grafica.controladoras.ControladoraNuevoJugador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JPasswordField;

import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionsJugadores;

import javax.swing.SwingConstants;


public class VentanaNuevoJugador {
	
	private grafica.controladoras.ControladoraNuevoJugador controladoraNuevoJugador;
	private JFrame frmNuevoJugador;
	private JTextField txtNombre;
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
		frmNuevoJugador.setTitle("¡Adivina la película! - Nuevo Jugador");
		frmNuevoJugador.setBounds(100, 100, 521, 312);
		//frmNuevoJugador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraNuevoJugador= new ControladoraNuevoJugador();
		
		JPanel panelContenido = new JPanel();
		frmNuevoJugador.getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelContenido.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setBackground(new Color(231, 76, 60));
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Constantes.RUTA_NUEVO_JUGADOR));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 34));
		panelTitulo.add(label);
		
		JPanel panelCampos = new JPanel();
		panelCampos.setBackground(new Color(44, 62, 80));
		panelCampos.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelContenido.add(panelCampos, BorderLayout.CENTER);
		
		// NOMBRE
		txtNombre = new JTextField();
		TextPrompt tpNombre = new TextPrompt("Nombre", txtNombre);
		tpNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		tpNombre.setForeground( Color.LIGHT_GRAY );
		txtNombre.setForeground(Color.DARK_GRAY);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		// PASSWORD
		passwordField = new JPasswordField();
		TextPrompt tpPasswordField = new TextPrompt("Password", passwordField);
		tpPasswordField.setFont(new Font("Arial", Font.PLAIN, 13));
		tpPasswordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 13));
		passwordField.setForeground(Color.DARK_GRAY);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		GroupLayout gl_panelCampos = new GroupLayout(panelCampos);
		gl_panelCampos.setHorizontalGroup(
			gl_panelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCampos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCampos.createParallelGroup(Alignment.TRAILING)
						.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
						.addComponent(txtNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelCampos.setVerticalGroup(
			gl_panelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCampos.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		panelCampos.setLayout(gl_panelCampos);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(new Color(44, 62, 80));
		panelBotones.setBorder(new EmptyBorder(0, 20, 15, 20));
		panelContenido.add(panelBotones, BorderLayout.SOUTH);
		
		// ACEPTAR
		JButton btnConfirmar = new JButton("Aceptar");

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtNombre.getText().isEmpty()){
					if(!(passwordField.getPassword().length==0)){
						String nombre = txtNombre.getText();
						char[] array = passwordField.getPassword();
						String codigo = new String(array);
						try {				
							controladoraNuevoJugador.NuevoJugador(nombre, codigo);
							frmNuevoJugador.setVisible(false);

						}catch (ExceptionsJugadores | NullPointerException | IOException e1) {
							e1.printStackTrace();
						}	
					}else
						errorJugador("Necesita un codigo para crear un jugador.");
				}else
					errorJugador("Necesita un nombre para crear un jugador.");
			}

		});
		
		// CANCELAR
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNuevoJugador.setVisible(false);
			}
		});
		
		GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
		gl_panelBotones.setHorizontalGroup(
			gl_panelBotones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addContainerGap(282, Short.MAX_VALUE)
					.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelBotones.setVerticalGroup(
			gl_panelBotones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelBotones.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelBotones.setLayout(gl_panelBotones);
		

		
		
	}
	
	public void setVisible (boolean visible) {
		frmNuevoJugador.setVisible(visible);
	}
	public void errorJugador(String s){
		
		JOptionPane.showMessageDialog(null,  s, "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void okJugador(String s){
		
		JOptionPane.showMessageDialog(null, s, "Jugador Agregado " , JOptionPane.INFORMATION_MESSAGE);
		
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
