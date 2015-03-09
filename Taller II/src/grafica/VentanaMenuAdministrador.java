package grafica;

import grafica.auxiliares.BackgroundPanel;
import grafica.auxiliares.Constantes;

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
import java.awt.Color;


import logica.exceptions.ExceptionsJugadores;

public class VentanaMenuAdministrador {

	private JFrame frmMenuAdministrador;

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


		frmMenuAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMenuAdministrador.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGuardar guardar = new VentanaGuardar();
				guardar.setVisible(true);
				frmMenuAdministrador.setVisible(false);
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		

		//Image backgroundImage = ImageIO.read(new File(Constantes.RUTA_BACKGROUND));
		//BackgroundPanel panelContenido = new BackgroundPanel(backgroundImage);
		//frmMenuAdministrador.getContentPane().add(panelContenido, BorderLayout.CENTER);
		//panelContenido.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		frmMenuAdministrador.getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		
		JPanel panelArriba = new JPanel();
		//panelContenido.add(panelArriba, BorderLayout.NORTH);
		panelArriba.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(231, 76, 60));
		panelArriba.add(panelTitulo);
		panelTitulo.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(Constantes.RUTA_TITULO));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 34));
		panelTitulo.add(lblTitulo);
		
		JPanel panelMenu = new JPanel();
		//panelContenido.add(panelMenu, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("NUEVA PEL\u00CDCULA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaNuevaPelicula nuevaPelicula = new VentanaNuevaPelicula();
				nuevaPelicula.setVisible(true);
				frmMenuAdministrador.setVisible(false);
			}
		});
		
		JButton btnNuevoJugador = new JButton("NUEVO JUGADOR");
		btnNuevoJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaNuevoJugador nuevoJugador = new VentanaNuevoJugador();
				nuevoJugador.setVisible(true);
				frmMenuAdministrador.setVisible(false);
			}
		});
		
		JButton btnMostrarPelculas = new JButton("VER PEL\u00CDCULAS");
		btnMostrarPelculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListarPeliculas listaPeliculas = new VentanaListarPeliculas();
				listaPeliculas.setVisible(true);
				frmMenuAdministrador.setVisible(false);
			}
		});
		
		JButton btnMostrarJugadores = new JButton("VER JUGADORES");
		btnMostrarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListarJugadores listaJugadores = null;
				listaJugadores = new VentanaListarJugadores();
				listaJugadores.setVisible(true);
				frmMenuAdministrador.setVisible(false);
			}
		});
		
		JButton btnVerPartidas = new JButton("VER PARTIDAS");
		
		JButton btnRanking = new JButton("RANKING");

		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRanking ventanaRanking;
				try {
					ventanaRanking = new VentanaRanking();
					ventanaRanking.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void setVisible(boolean b) {
		frmMenuAdministrador.setVisible(b);
	}
}
