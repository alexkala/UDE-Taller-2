package grafica;

import grafica.auxiliares.BackgroundPanel;
import grafica.controladoras.ControladoraLogin;
import grafica.controladoras.ControladoraMenuJugador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Menu;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Canvas;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Partida;
import logica.exceptions.ExceptionPartidas;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.SwingConstants;

public class VentanaMenuJugador {

	private JFrame frame;
	private ControladoraMenuJugador controladoraMenuJugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuJugador window = new VentanaMenuJugador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMenuJugador() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException  {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraMenuJugador = new ControladoraMenuJugador();
		
		
		// ---------------
		// IMAGEN DE FONDO
		// ---------------
		Image backgroundImage = ImageIO.read(new File("imagenes/background.png"));
		BackgroundPanel panel_2 = new BackgroundPanel(backgroundImage);
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.NORTH);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(new Color(231, 76, 60));
		
		// ------
		// TITULO
		// ------
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("imagenes/titulo.png"));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 34));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1, BorderLayout.CENTER);
		
		// --------------
		// BOTON REANUDAR
		// --------------
		JButton btnPartidaActual = new JButton("REANUDAR");
		
		// Activado solo si se puede reanudar una partida
		try {
			Partida actual = controladoraMenuJugador.partidaEnCurso("Alex", "123");
			if (actual.isFinalizada()) {
				btnPartidaActual.setEnabled(false);
			}			
		} catch (ExceptionsJugadores e1) {
			btnPartidaActual.setEnabled(false);
		}
		
		btnPartidaActual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Partida actual = controladoraMenuJugador.partidaEnCurso("Alex", "123");
					if (!actual.isFinalizada()) {
						VentanaPartida partida = new VentanaPartida();
						partida.setVisible(true);
						frame.setVisible(false);
					}			
				} catch (ExceptionsJugadores e1) {
					Object[] options = {"OK"};
					int opcion = JOptionPane.showOptionDialog(frame,
							"No tienes ninguna partida en curso",
							"Reanudar partida",
							JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE,
							null,		//do not use a custom Icon
							options,	//the titles of buttons
							null);		//default button title
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// -------------------
		// BOTON NUEVA PARTIDA
		// -------------------
		JButton btnNuevaPartida = new JButton("NUEVA PARTIDA");
		
		// Activado solo si se puede crear una partida nueva
		try {
			Partida actual = controladoraMenuJugador.partidaEnCurso("Alex", "123");
			if (!actual.isFinalizada()) {
				btnNuevaPartida.setEnabled(false);
			}			
		} catch (ExceptionsJugadores e1) {
			btnNuevaPartida.setEnabled(true);
		}
		
		btnNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Partida nueva = controladoraMenuJugador.nuevaPartida("Alex", "123");
					if (nueva != null) {
						VentanaPartida partida = new VentanaPartida();
						partida.setVisible(true);
						frame.setVisible(false);
					} 					
				} catch (ExceptionPartidas e1) {
					Object[] options = {"REANUDAR PARTIDA", "CANCLEAR"};
					int opcion = JOptionPane.showOptionDialog(frame,
							"Ya tienes una partida en curso. ¿Deseas reanudarla?",
							"Nueva partida",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,		//do not use a custom Icon
							options,	//the titles of buttons
							null);		//default button title
					
					switch (opcion) {
					case 0:
					{
						try {
							Partida actual = controladoraMenuJugador.partidaEnCurso("Alex", "123");
							VentanaPartida partida = new VentanaPartida();
							partida.setVisible(true);
							frame.setVisible(false);
						} catch (ExceptionsJugadores e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
					}
						break;

					}
				} catch (ExceptionsPeliculas e1) {
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(frame,
							e1.getMessage(),
							"Nueva partida",
							JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE,
							null,		//do not use a custom Icon
							options,	//the titles of buttons
							null);		//default button title
				} catch (ExceptionsJugadores e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// -------------
		// BOTON RANKING
		// -------------
		JButton btnRanking = new JButton("RANKING");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRanking ventanaRanking = new VentanaRanking();
				ventanaRanking.setVisible(true);
			}
		});
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(261)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnRanking, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNuevaPartida, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
						.addComponent(btnPartidaActual, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(261, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(97)
					.addComponent(btnPartidaActual, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNuevaPartida, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRanking, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(293, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

}
