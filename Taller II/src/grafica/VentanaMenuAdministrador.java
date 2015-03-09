package grafica;

import java.awt.EventQueue;

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
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

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
	 */
	public VentanaMenuAdministrador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuAdministrador = new JFrame();
		frmMenuAdministrador.setTitle("Menu Administrador");
		frmMenuAdministrador.setResizable(false);
		frmMenuAdministrador.setBounds(100, 100, 732, 557);
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
		
		JPanel panel_2 = new JPanel();
		frmMenuAdministrador.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.NORTH);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		JLabel lblNewLabel = new JLabel("ADIVINA LA PEL\u00CDCULA");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1, BorderLayout.CENTER);
		
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
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(222)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnRanking, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVerPartidas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
						.addComponent(btnMostrarJugadores, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
						.addComponent(btnMostrarPelculas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
						.addComponent(btnNuevoJugador, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(222, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(57, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNuevoJugador, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMostrarPelculas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMostrarJugadores, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnVerPartidas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRanking, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(77))
		);
		panel_1.setLayout(gl_panel_1);
	}

	public void setVisible(boolean b) {
		frmMenuAdministrador.setVisible(b);
		// TODO Auto-generated method stub
		
	}
}
