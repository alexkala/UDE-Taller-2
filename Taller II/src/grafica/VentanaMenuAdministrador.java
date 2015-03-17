package grafica;

import grafica.auxiliares.BackgroundPanel;
import grafica.auxiliares.Constantes;
import grafica.controladoras.ControladoraGuardar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import logica.exceptions.ExceptionsJugadores;

public class VentanaMenuAdministrador {

	private JFrame frmMenuAdministrador;
	private ControladoraGuardar controladoraGuardar;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuAdministrador window = new VentanaMenuAdministrador();
					window.frmMenuAdministrador.setVisible(true);
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
	public VentanaMenuAdministrador() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */

	private void initialize() throws IOException {
		frmMenuAdministrador = new JFrame();
		frmMenuAdministrador.setTitle("¡Adivina la película! - Menu Administrador");
		frmMenuAdministrador.setResizable(false);
		frmMenuAdministrador.setBounds(100, 100, 800, 700);

		frmMenuAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraGuardar = new ControladoraGuardar();
		
		JMenuBar menuBar = new JMenuBar();
		frmMenuAdministrador.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladoraGuardar.guardarCambios();
				/*
				VentanaGuardar guardar = new VentanaGuardar();
				guardar.setVisible(true);
				frmMenuAdministrador.setVisible(false);
				*/
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		

		Image backgroundImage = ImageIO.read(new File(Constantes.RUTA_BACKGROUND));
		BackgroundPanel panelContenido = new BackgroundPanel(backgroundImage);
		frmMenuAdministrador.getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		frmMenuAdministrador.getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		
		JPanel panelArriba = new JPanel();
		panelContenido.add(panelArriba, BorderLayout.NORTH);
		panelArriba.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(231, 76, 60));
		panelArriba.add(panelTitulo);
		panelTitulo.setBorder(new EmptyBorder(15, 20, 15, 20));
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(Constantes.RUTA_TITULO));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 34));
		panelTitulo.add(lblTitulo);
		
		JPanel panelMenu = new JPanel();
		panelContenido.add(panelMenu, BorderLayout.CENTER);
		
		// --------------
		// NUEVA PELICULA
		// --------------
		JButton btnNuevaPelicula = new JButton("NUEVA PEL\u00CDCULA");
		btnNuevaPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaNuevaPelicula nuevaPelicula = new VentanaNuevaPelicula();
				nuevaPelicula.setVisible(true);
				//frmMenuAdministrador.setVisible(false);
			}
		});
		
		// -------------
		// NUEVO JUGADOR
		// -------------
		JButton btnNuevoJugador = new JButton("NUEVO JUGADOR");
		btnNuevoJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaNuevoJugador nuevoJugador = new VentanaNuevoJugador();
				nuevoJugador.setVisible(true);
				//frmMenuAdministrador.setVisible(false);
			}
		});
		
		// -------------
		// VER PELICULAS
		// -------------		
		JButton btnMostrarPelculas = new JButton("VER PEL\u00CDCULAS");
		btnMostrarPelculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListarPeliculas listaPeliculas = new VentanaListarPeliculas();
				listaPeliculas.setVisible(true);
				//frmMenuAdministrador.setVisible(false);
			}
		});
		
		// -------------
		// VER JUGADORES
		// -------------
		JButton btnMostrarJugadores = new JButton("VER JUGADORES");
		btnMostrarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListarJugadores listaJugadores = null;
				listaJugadores = new VentanaListarJugadores();
				listaJugadores.setVisible(true);
				//frmMenuAdministrador.setVisible(false);
			}
		});
		
		// ------------
		// VER PARTIDAS
		// ------------
		JButton btnVerPartidas = new JButton("VER PARTIDAS");
		btnVerPartidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListarPartidas listarPartidas;
				try {
					listarPartidas = new VentanaListarPartidas();
					listarPartidas.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// -------
		// RANKING
		// -------
		JButton btnRanking = new JButton("RANKING");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRanking ventanaRanking;
				try {
					ventanaRanking = new VentanaRanking();
					ventanaRanking.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addGap(296)
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnMostrarPelculas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNuevoJugador, 0, 0, Short.MAX_VALUE)
						.addComponent(btnMostrarJugadores, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVerPartidas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRanking, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNuevaPelicula, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(295, Short.MAX_VALUE))
		);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addGap(67)
					.addComponent(btnNuevaPelicula, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNuevoJugador, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMostrarPelculas, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMostrarJugadores, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnVerPartidas, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRanking, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		panelMenu.setLayout(gl_panelMenu);

		
		
	}

	public void setVisible(boolean b) {
		frmMenuAdministrador.setVisible(b);
	}
	
	public void errorAlGuardar(String s){
		JOptionPane.showMessageDialog(null,  s, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void guardoOK(String s){
		JOptionPane.showMessageDialog(null, s, "Guardado Exitoso!" , JOptionPane.INFORMATION_MESSAGE);
	}
}
