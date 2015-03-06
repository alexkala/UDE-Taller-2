package grafica;

import grafica.auxiliares.BackgroundPanel;
import grafica.controladoras.ControladoraLogin;
import grafica.controladoras.ControladoraMenuJugador;
import grafica.controladoras.ControladoraVentanaPartida;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import logica.Partida;
import logica.exceptions.ExceptionPartidas;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;

import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;



public class VentanaPartida {

	private JFrame frame;
	private JTextField textFieldIngresarCaracter;
	//private Partida partida;
	private ControladoraVentanaPartida controladoraVentanaPartida;
	private JTextField textFieldArriesgar;
	private JTextField textFieldArriesgarPelicula;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 * @throws IOException 
	 */
	/*
	public VentanaPartida() {
		initialize();
	}
	*/

	public VentanaPartida() throws IOException {
		try {
			initialize();
		} catch (ExceptionsJugadores e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws ExceptionsJugadores 
	 */
	private void initialize() throws IOException, ExceptionsJugadores {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		controladoraVentanaPartida = new ControladoraVentanaPartida();
		Partida partida = controladoraVentanaPartida.partidaEnCurso("Alex", "123");
		
		
		// --------
		// MENU BAR
		// --------
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu menuRanking = new JMenu("Juego");
		menuBar.add(menuRanking);
		
		// MENUITEM RANKING
		JMenuItem menuItemRankingVer = new JMenuItem("Ranking");
		menuItemRankingVer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		menuRanking.add(menuItemRankingVer);
		
		menuItemRankingVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRanking ventanaRanking = new VentanaRanking();
				ventanaRanking.setVisible(true);
			}
		});
		
		// MENUITEM MENU
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		menuRanking.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenuJugador ventanaMenu = new VentanaMenuJugador();
				ventanaMenu.setVisible(true);
				frame.setVisible(false);
			}
		});

		// ---------------
		// PANEL CONTENIDO
		// ---------------
		final JPanel panelContenido = new JPanel();
		panelContenido.setBackground(Color.WHITE);
		frame.getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));

		
		// ------------
		// PANEL HEADER
		// ------------
		JPanel header = new JPanel();
		panelContenido.add(header, BorderLayout.NORTH);
		header.setBackground(Color.DARK_GRAY);
		
	
		
		JPanel headerTitulo = new JPanel();
		headerTitulo.setBackground(new Color(231, 76, 60));
		header.setLayout(new BorderLayout(0, 0));
		header.add(headerTitulo, BorderLayout.NORTH);
			
		JLabel lblHeaderTitulo = new JLabel("");
		lblHeaderTitulo.setIcon(new ImageIcon("imagenes/titulo.png"));
		lblHeaderTitulo.setFont(new Font("Arial", Font.BOLD, 34));
		lblHeaderTitulo.setForeground(Color.WHITE);
		headerTitulo.add(lblHeaderTitulo);
	
		// ----------
		// PANEL BODY
		// ----------
		JPanel body = new JPanel();
		panelContenido.add(body, BorderLayout.CENTER);
		body.setBackground(Color.WHITE);
		body.setLayout(new BorderLayout(0, 0));
		
		
		
		final JPanel panelTextoAdivinado = new JPanel();
		panelTextoAdivinado.setBackground(new Color(236, 240, 241));
		body.add(panelTextoAdivinado, BorderLayout.CENTER);
		panelTextoAdivinado.setLayout(new BorderLayout(0, 0));
		
		final JLabel lblTextoAdivinado = new JLabel(partida.getTextoAdivinado());
		lblTextoAdivinado.setBackground(new Color(236, 240, 241));
		panelTextoAdivinado.add(lblTextoAdivinado);
		lblTextoAdivinado.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoAdivinado.setForeground(Color.DARK_GRAY);
		lblTextoAdivinado.setFont(new Font("Arial", Font.PLAIN, 34));
		
		
		JPanel bodyArriba = new JPanel();
		body.add(bodyArriba, BorderLayout.NORTH);
		bodyArriba.setLayout(new BorderLayout(0, 0));
		
		// ----------
		// PANEL PUNTAJE
		// ----------
		JPanel panelPuntaje = new JPanel();
		panelPuntaje.setBorder(new EmptyBorder(10, 20, 10, 20));
		panelPuntaje.setBackground(new Color(192, 57, 43));
		bodyArriba.add(panelPuntaje, BorderLayout.NORTH);
		panelPuntaje.setLayout(new BorderLayout(0, 0));
		
		final JLabel lblPuntaje = new JLabel("PUNTAJE: " + partida.getPuntajePartida());
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(new Font("Arial", Font.PLAIN, 13));
		panelPuntaje.add(lblPuntaje);
		
		
		// -----------
		// PANEL PISTA
		// -----------
		JPanel panelPista = new JPanel();
		bodyArriba.add(panelPista);
		panelPista.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelPista.setBackground(new Color(236, 240, 241));
		panelPista.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPista = new JLabel(partida.getPeliculaPartida().getPista());
		lblPista.setBorder(new EmptyBorder(0, 10, 0, 10));
		lblPista.setForeground(Color.GRAY);
		lblPista.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPista.setHorizontalAlignment(SwingConstants.CENTER);
		panelPista.add(lblPista);
		
		// -------------
		// PANEL MENSAJE
		// -------------
		final JPanel panelMensaje = new JPanel();
		panelMensaje.setBorder(new EmptyBorder(7, 0, 7, 0));
		body.add(panelMensaje, BorderLayout.SOUTH);
		panelMensaje.setBackground(new Color(52, 73, 94));
		panelMensaje.setLayout(new BorderLayout(0, 0));
		
		final JLabel lblLetraCorrecta = new JLabel("Adivina una letra.");
		lblLetraCorrecta.setHorizontalAlignment(SwingConstants.CENTER);
		panelMensaje.add(lblLetraCorrecta);
		lblLetraCorrecta.setForeground(Color.WHITE);
		lblLetraCorrecta.setFont(new Font("Arial", Font.PLAIN, 13));
		
		
		
		final JPanel barraAbajo = new JPanel();
		barraAbajo.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelContenido.add(barraAbajo, BorderLayout.SOUTH);
		barraAbajo.setBackground(new Color(44, 65, 80));
		barraAbajo.setLayout(new CardLayout(0, 0));
		
		
		// -----------------------
		// PANEL INGRESAR CARACTER
		// -----------------------	
		JPanel panelIngresarCaracter = new JPanel();
		panelIngresarCaracter.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelIngresarCaracter.setBackground(new Color(44, 65, 80));
		barraAbajo.add(panelIngresarCaracter, "INGRESAR_CARACTER");
		
		textFieldIngresarCaracter = new JTextField();
		textFieldIngresarCaracter.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIngresarCaracter.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFieldIngresarCaracter.setColumns(10);
		
		// -----------------------
		// BOTON INGRESAR CARACTER
		// -----------------------
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldIngresarCaracter.getText().trim().isEmpty()) {
					String letra = textFieldIngresarCaracter.getText();
					try {
						boolean letraCorrecta = controladoraVentanaPartida.ingresarCaracter("Alex", "123", letra);
						Partida partidaActual = controladoraVentanaPartida.partidaEnCurso("Alex", "123");
						lblTextoAdivinado.setText(partidaActual.getTextoAdivinado());
						lblPuntaje.setText("PUNTAJE: " + partidaActual.getPuntajePartida());
						if (letraCorrecta) {
							lblLetraCorrecta.setText("¡Letra correcta!");	
						} else {
							lblLetraCorrecta.setText("¡Letra incorrecta!");
						}
						textFieldIngresarCaracter.setText(null);
						panelContenido.updateUI();
						// si adivino la pelicula
						if (partidaActual.isFinalizada()) {
							Object[] options = {"NUEVA PARTIDA", "MENU"};
							int opcion = JOptionPane.showOptionDialog(frame,
									"FIN DE LA PARTIDA\n\n" +
									"PELÍCULA: " + partidaActual.getPeliculaPartida().getTitulo() + "\n" + 
									"PUNTAJE: " + partidaActual.getPuntajePartida() + "\n\n" +
											"Has finalizado la partida. ¿Deseas empezar una nueva pertida?",
									"¡Película adivinada!",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE,
									null,		//do not use a custom Icon
									options,	//the titles of buttons
									null);		//default button title
							
							switch (opcion) {
							case 0:
							{
								try {
									Partida partidaNueva = controladoraVentanaPartida.nuevaPartida("Alex", "123");
									if (partidaNueva != null) {
										VentanaPartida ventanaPartida = new VentanaPartida();
										frame.setVisible(false);
										ventanaPartida.setVisible(true);
									} 	
								} catch (ExceptionPartidas e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ExceptionsPeliculas e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
												
							}
							break;
							case 1:
							case -1:
							{
								VentanaMenuJugador menu = new VentanaMenuJugador();
								frame.setVisible(false);
								menu.setVisible(true);
							}
							break;
							}
							
						}
					} catch (ExceptionsJugadores e1) {
						e1.printStackTrace();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ExceptionPartidas e2) {
						lblLetraCorrecta.setText("¡Letra repetida!");
						textFieldIngresarCaracter.setText(null);
					}
				} else {
					lblLetraCorrecta.setText("Adivina una letra.");
				}
				
			}
		});
		
		
		// -------------------------------
		// BOTON ARRIESGAR PELICULA AFUERA
		// -------------------------------
		JButton btnArriesgar = new JButton("ARRIESGAR");
		btnArriesgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestra la barra de arriesgar pelicula
				textFieldIngresarCaracter.setText(null);
				CardLayout barra = (CardLayout)(barraAbajo.getLayout());
				barra.show(barraAbajo, "ARRIESGAR_PELICULA");
			}
		});
		
		
		GroupLayout gl_panelIngresarCaracter = new GroupLayout(panelIngresarCaracter);
		gl_panelIngresarCaracter.setHorizontalGroup(
			gl_panelIngresarCaracter.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelIngresarCaracter.createSequentialGroup()
					.addContainerGap(348, Short.MAX_VALUE)
					.addComponent(textFieldIngresarCaracter, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnIngresar)
					.addGap(151)
					.addComponent(btnArriesgar))
		);
		gl_panelIngresarCaracter.setVerticalGroup(
			gl_panelIngresarCaracter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelIngresarCaracter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelIngresarCaracter.createParallelGroup(Alignment.LEADING)
						.addComponent(btnArriesgar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelIngresarCaracter.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnIngresar, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
							.addComponent(textFieldIngresarCaracter, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panelIngresarCaracter.setLayout(gl_panelIngresarCaracter);
		
		// Muestra la barra de ingresar caracter
		CardLayout barra = (CardLayout)(barraAbajo.getLayout());
	    barra.show(barraAbajo, "INGRESAR_CARACTER");
		
		// ------------------------
		// PANEL ARRIESGAR PELICULA
		// ------------------------
		JPanel panelArriesgarPelicula = new JPanel();
		panelArriesgarPelicula.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelArriesgarPelicula.setBackground(new Color(44, 65, 80));
		barraAbajo.add(panelArriesgarPelicula, "ARRIESGAR_PELICULA");
		
		textFieldArriesgarPelicula = new JTextField();
		textFieldArriesgarPelicula.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldArriesgarPelicula.setColumns(10);
		textFieldArriesgarPelicula.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		// ------------------------
		// BOTON ARRIESGAR PELICULA
		// ------------------------
		JButton btnArriesgar_1 = new JButton("ARRIESGAR");
		btnArriesgar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String peliculaArriesgada = textFieldArriesgarPelicula.getText();
				try {
					boolean adivinada = controladoraVentanaPartida.arriesgarPelicula("Alex", "123", peliculaArriesgada);
					Partida partidaActual = controladoraVentanaPartida.partidaEnCurso("Alex", "123");
					lblTextoAdivinado.setText(partidaActual.getTextoAdivinado());
					lblPuntaje.setText("PUNTAJE: " + partidaActual.getPuntajePartida());
					textFieldArriesgarPelicula.setText(null);
					
					String titulo;
					if (adivinada) {
						titulo = new String("¡Película adivinada!");
					} else {
						titulo = new String("¡Película errada!");
					}
					lblLetraCorrecta.setText(titulo);
					Object[] options = {"NUEVA PARTIDA", "MENU"};
					int opcion = JOptionPane.showOptionDialog(frame,
							"FIN DE LA PARTIDA\n\n" +
							"PELÍCULA: " + partidaActual.getPeliculaPartida().getTitulo() + "\n" + 
							"PUNTAJE: " + partidaActual.getPuntajePartida() + "\n\n" +
									"Has finalizado la partida. ¿Deseas empezar una nueva pertida?",
							titulo,
							JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE,
							null,		//do not use a custom Icon
							options,	//the titles of buttons
							null);		//default button title
					
					switch (opcion) {
					case 0:
					{
						try {
							Partida partidaNueva = controladoraVentanaPartida.nuevaPartida("Alex", "123");
							if (partidaNueva != null) {
								VentanaPartida ventanaPartida = new VentanaPartida();
								frame.setVisible(false);
								ventanaPartida.setVisible(true);
							} 	
						} catch (ExceptionPartidas e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ExceptionsPeliculas e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
										
					}
					break;
					case 1:
					case -1:
					{
						VentanaMenuJugador menu = new VentanaMenuJugador();
						frame.setVisible(false);
						menu.setVisible(true);
					}
					break;
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExceptionsJugadores e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}					
		});
		
		JButton btnCancelar_1 = new JButton("CANCELAR");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Muestra la barra de ingresar caracter
				textFieldArriesgarPelicula.setText(null);
				CardLayout barra = (CardLayout)(barraAbajo.getLayout());
			    barra.show(barraAbajo, "INGRESAR_CARACTER");
			}					
		});
		
		GroupLayout gl_panelArriesgarPelicula = new GroupLayout(panelArriesgarPelicula);
		gl_panelArriesgarPelicula.setHorizontalGroup(
			gl_panelArriesgarPelicula.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelArriesgarPelicula.createSequentialGroup()
					.addComponent(textFieldArriesgarPelicula, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnArriesgar_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar_1))
		);
		gl_panelArriesgarPelicula.setVerticalGroup(
			gl_panelArriesgarPelicula.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelArriesgarPelicula.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelArriesgarPelicula.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnArriesgar_1, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(textFieldArriesgarPelicula, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelArriesgarPelicula.setLayout(gl_panelArriesgarPelicula);
		

		
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
		
	}
}
