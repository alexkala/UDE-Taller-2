package grafica;

import grafica.controladoras.ControladoraLogin;
import grafica.controladoras.ControladoraVentanaPartida;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import logica.exceptions.ExceptionsJugadores;



public class VentanaPartida {

	private JFrame frame;
	private JTextField textFieldIngresarCaracter;
	private Partida partida;
	private ControladoraVentanaPartida controladoraVentanaPartida;
	private JTextField textFieldArriesgar;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	/*
	public VentanaPartida() {
		initialize();
	}
	*/

	public VentanaPartida(Partida actual) {
		partida = actual;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 696, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		controladoraVentanaPartida = new ControladoraVentanaPartida();
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu menuPartida = new JMenu("Partida");
		menuBar.add(menuPartida);
		
		JMenuItem menuItemPartidaNueva = new JMenuItem("Nueva partida");
		menuItemPartidaNueva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuPartida.add(menuItemPartidaNueva);
		
		JMenuItem menuItemPartidaActual = new JMenuItem("Partida actual");
		menuItemPartidaActual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuPartida.add(menuItemPartidaActual);
		
		JMenu menuRanking = new JMenu("Ranking");
		menuBar.add(menuRanking);
		
		JMenuItem menuItemRankingVer = new JMenuItem("Ver Ranking");
		menuItemRankingVer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		menuRanking.add(menuItemRankingVer);
		menuItemRankingVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRanking ventanaRanking = new VentanaRanking();
				ventanaRanking.setVisible(true);
			}
		});
		
		final JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		panel_5.add(header, BorderLayout.NORTH);
		header.setBackground(Color.DARK_GRAY);
		
		JPanel headerTitulo = new JPanel();
		headerTitulo.setBorder(new EmptyBorder(40, 0, 40, 0));
		headerTitulo.setBackground(Color.DARK_GRAY);
		header.setLayout(new BorderLayout(0, 0));
		header.add(headerTitulo, BorderLayout.NORTH);
		
		JLabel lblHeaderTitulo = new JLabel("ADIVINA LA PEL\u00CDCULA");
		lblHeaderTitulo.setFont(new Font("Arial", Font.BOLD, 34));
		lblHeaderTitulo.setForeground(Color.WHITE);
		headerTitulo.add(lblHeaderTitulo);
		
		JPanel body = new JPanel();
		panel_5.add(body, BorderLayout.CENTER);
		body.setBackground(Color.WHITE);
		body.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		body.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTextoAdivinado = new JLabel(partida.getTextoAdivinado());
		panel.add(lblTextoAdivinado);
		lblTextoAdivinado.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoAdivinado.setForeground(Color.DARK_GRAY);
		lblTextoAdivinado.setFont(new Font("Arial", Font.PLAIN, 34));
		
		
		JPanel bodyArriba = new JPanel();
		body.add(bodyArriba, BorderLayout.NORTH);
		bodyArriba.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPuntaje = new JPanel();
		bodyArriba.add(panelPuntaje, BorderLayout.NORTH);
		
		JLabel lblPuntaje = new JLabel("PUNTAJE: " + partida.getPuntajePartida());
		lblPuntaje.setBorder(new EmptyBorder(0, 10, 0, 10));
		GroupLayout gl_panelPuntaje = new GroupLayout(panelPuntaje);
		gl_panelPuntaje.setHorizontalGroup(
			gl_panelPuntaje.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPuntaje.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPuntaje, GroupLayout.PREFERRED_SIZE, 661, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panelPuntaje.setVerticalGroup(
			gl_panelPuntaje.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPuntaje.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblPuntaje, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelPuntaje.setLayout(gl_panelPuntaje);
		
		JPanel panelPista = new JPanel();
		bodyArriba.add(panelPista);
		panelPista.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelPista.setBackground(Color.WHITE);
		panelPista.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPista = new JLabel(partida.getPeliculaPartida().getPista());
		lblPista.setBorder(new EmptyBorder(0, 10, 0, 10));
		lblPista.setForeground(Color.GRAY);
		lblPista.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPista.setHorizontalAlignment(SwingConstants.CENTER);
		panelPista.add(lblPista);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String letra = textFieldIngresarCaracter.getText();
				try {
					controladoraVentanaPartida.ingresarCaracter("Alex", "123", letra);			
				} catch (ExceptionsJugadores e1) {
					e1.printStackTrace();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		JButton btnArriesgar = new JButton("ARRIESGAR");
		
		
		final JPanel barraAbajo = new JPanel();
		barraAbajo.setBorder(new EmptyBorder(0, 10, 0, 10));
		panel_5.add(barraAbajo, BorderLayout.SOUTH);
		barraAbajo.setBackground(new Color(247, 247, 247));
		
		textFieldIngresarCaracter = new JTextField();
		textFieldIngresarCaracter.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIngresarCaracter.setColumns(10);	
		
		GroupLayout gl_barraAbajo = new GroupLayout(barraAbajo);
		gl_barraAbajo.setHorizontalGroup(
			gl_barraAbajo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_barraAbajo.createSequentialGroup()
					.addGap(318)
					.addComponent(textFieldIngresarCaracter, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIngresar)
					.addGap(95)
					.addComponent(btnArriesgar)
					.addGap(32))
		);
		gl_barraAbajo.setVerticalGroup(
			gl_barraAbajo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_barraAbajo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_barraAbajo.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldIngresarCaracter, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(btnIngresar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnArriesgar, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_barraAbajo.setAutoCreateGaps(true);
		gl_barraAbajo.setAutoCreateContainerGaps(true);
		barraAbajo.setLayout(gl_barraAbajo);
		
		
		
		
		
		// Esconde la barra arriesgar
		//barraArriesgar.setVisible(false);

		
		btnArriesgar.addActionListener(new ActionListener() {				// Evento btnArriesgar
			public void actionPerformed(ActionEvent e) {
				final JPanel barraArriesgar = new JPanel();
				barraArriesgar.setBorder(new EmptyBorder(0, 10, 0, 10));
				barraArriesgar.setBackground(new Color(247, 247, 247));
				panel_5.add(barraArriesgar, BorderLayout.SOUTH);
				
				textFieldArriesgar = new JTextField();
				textFieldArriesgar.setHorizontalAlignment(SwingConstants.CENTER);
				textFieldArriesgar.setColumns(10);
				textFieldArriesgar.setHorizontalAlignment(SwingConstants.LEFT);
				textFieldArriesgar.setBorder(BorderFactory.createCompoundBorder(
						textFieldArriesgar.getBorder(), 
				        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
				
				
				JButton btnArriesgarPelicula = new JButton("ARRIESGAR");
				btnArriesgarPelicula.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String peliculaArriesgada = textFieldArriesgar.getText();
						try {
							controladoraVentanaPartida.arriesgarPelicula("Alex", "123", peliculaArriesgada);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ExceptionsJugadores e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}					
				});
				
				
				JButton btnCancelar = new JButton("CANCELAR");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						barraArriesgar.setVisible(false);
						barraAbajo.setVisible(true);
					}					
				});
				
				
				GroupLayout gl_barraArriesgar = new GroupLayout(barraArriesgar);
				gl_barraArriesgar.setHorizontalGroup(
					gl_barraArriesgar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_barraArriesgar.createSequentialGroup()
							.addContainerGap()
							.addComponent(textFieldArriesgar, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnArriesgarPelicula)
							.addGap(8)
							.addComponent(btnCancelar)
							.addGap(32))
				);
				gl_barraArriesgar.setVerticalGroup(
					gl_barraArriesgar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_barraArriesgar.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_barraArriesgar.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_barraArriesgar.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldArriesgar, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
									.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
								.addComponent(btnArriesgarPelicula, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
				);
				gl_barraArriesgar.setAutoCreateGaps(true);
				gl_barraArriesgar.setAutoCreateContainerGaps(true);
				barraArriesgar.setLayout(gl_barraArriesgar);
				barraArriesgar.setBackground(new Color(247, 247, 247));
				
				barraAbajo.setVisible(false);
				barraArriesgar.setVisible(true);
				
				
				/*
				// DIALOGO FIN DE LA PARTIDA
				Object[] options = {"NUEVA PARTIDA",
				"MENU"};
				int opcion = JOptionPane.showOptionDialog(frame,
						"¡Has finalizado la partida! ¿Qué deseas hacer a continuación?",
						"Fin de la partida",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,		//do not use a custom Icon
						options,	//the titles of buttons
						null);		//default button title
				
				/*
				switch (opcion) {
				case 0:		// OPCION: NUEVA PARTIDA
				{
					VentanaPartida partidaNueva = new VentanaPartida();
					partidaNueva.setVisible(true);
				}
				break;
				case 1:		// OPCION: MENU
				case -1:	// OPCION: SALIR (cerrar el dialogo)
				{
					VentanaMenuJugador menu = new VentanaMenuJugador();
					menu.setVisible(true);
					frame.setVisible(false);
				}
					break;
				default:
					break;
				} 
				*/
				// TERMINA DIALOGO FIN DE LA PARTIDA
			}
		});
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
		
	}
}
