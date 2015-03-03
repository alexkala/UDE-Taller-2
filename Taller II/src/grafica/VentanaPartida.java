package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;



public class VentanaPartida {

	private JFrame frame;
	private JTextField textFieldIngresarCaracter;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public VentanaPartida() {
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
		
		JPanel panel_5 = new JPanel();
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
		
		JLabel lblNewLabel = new JLabel("-L -RA-----RA--R");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 34));
		
		JPanel bodyArriba = new JPanel();
		body.add(bodyArriba, BorderLayout.NORTH);
		bodyArriba.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPuntaje = new JPanel();
		bodyArriba.add(panelPuntaje, BorderLayout.NORTH);
		
		JLabel lblPuntaje = new JLabel("PUNTAJE: -2");
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
		
		JLabel lblPista = new JLabel("CIENCIA FICCI\u00D3N");
		lblPista.setBorder(new EmptyBorder(0, 10, 0, 10));
		lblPista.setForeground(Color.GRAY);
		lblPista.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPista.setHorizontalAlignment(SwingConstants.CENTER);
		panelPista.add(lblPista);
		
		JButton btnIngresar = new JButton("INGRESAR");
		JButton btnArriesgar = new JButton("ARRIESGAR");
		
		JPanel barraAbajo = new JPanel();
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
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
		
	}
}
