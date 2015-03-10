package grafica;

import grafica.auxiliares.BackgroundPanel;
import grafica.auxiliares.Constantes;
import grafica.controladoras.ControladoraListarPartidas;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import logica.exceptions.ExceptionsJugadores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

public class VentanaListarPartidas {

	private JFrame frame;
	private JTable table;
	private ControladoraListarPartidas controladoraListarPartidas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListarPartidas window = new VentanaListarPartidas();
					window.frame.setVisible(true);
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
	public VentanaListarPartidas() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 700);
		frame.setTitle("¡Adivina la película! - Lista de Partidas");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraListarPartidas = new ControladoraListarPartidas();
		
		

		final JPanel panelContenido = new JPanel();
		frame.getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel panelArriba = new JPanel();
		panelContenido.add(panelArriba, BorderLayout.NORTH);
		panelArriba.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(231, 76, 60));
		panelArriba.add(panelTitulo);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTituloPartidas = new JLabel("");
		lblTituloPartidas.setIcon(new ImageIcon(Constantes.RUTA_TITULO_PARTIDAS));
		lblTituloPartidas.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(lblTituloPartidas);
		
		final JPanel panelCuerpo = new JPanel();
		panelContenido.add(panelCuerpo, BorderLayout.CENTER);
		panelCuerpo.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDropdown = new JPanel();
		panelDropdown.setBackground(new Color(192, 57, 43));
		panelDropdown.setBorder(new EmptyBorder(0, 20, 0, 20));
		panelCuerpo.add(panelDropdown, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Elije el jugador");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// COMBOBOX
		String[] comboJugadores;
		try {
			comboJugadores = controladoraListarPartidas.opcionesCombobox();
		} catch (ExceptionsJugadores e) {
			comboJugadores = null;
		}
		final JComboBox comboBox = new JComboBox(comboJugadores);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 13));

		// TABLA
		Image backgroundImage = ImageIO.read(new File(Constantes.RUTA_BACKGROUND));
		
		final BackgroundPanel panelTabla = new BackgroundPanel(backgroundImage);
		panelCuerpo.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		// BOTON
		JButton btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreJugador = (String) comboBox.getSelectedItem();
				System.out.println(nombreJugador);
				
				// TABLA
				String[] columnas = {"NUMERO",
		                "PELÍCULA",
		                "TEXTO ADIVINADO",
		                "ACERTADA",
		                "FINALIZADA",
		                "PUNTAJE"};
				Object[][] data = null;
				table = new JTable(data, columnas);
				try {
					panelTabla.removeAll();
					data = controladoraListarPartidas.listarPartidas(nombreJugador);
					table = new JTable(data, columnas);
					table.getTableHeader().setReorderingAllowed(false);
					table.setEnabled(false);
					JScrollPane scrollPane = new JScrollPane(table);
					panelTabla.add(scrollPane, BorderLayout.CENTER);
					panelContenido.updateUI();
				} catch (ExceptionsJugadores sinPartidas) {
					panelTabla.removeAll();
					JLabel lblSinPartidas = new JLabel("No hay partidas creadas.");
					lblSinPartidas.setBorder(new EmptyBorder(20, 0, 20, 0));
					lblSinPartidas.setFont(new Font("Arial", Font.PLAIN, 13));
					lblSinPartidas.setHorizontalAlignment(SwingConstants.CENTER);
					panelTabla.add(lblSinPartidas, BorderLayout.CENTER);
					panelContenido.updateUI();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		
		
		
		
		
		GroupLayout gl_panelDropdown = new GroupLayout(panelDropdown);
		gl_panelDropdown.setHorizontalGroup(
			gl_panelDropdown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDropdown.createSequentialGroup()
					.addGap(2)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
					.addComponent(btnMostrar, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelDropdown.setVerticalGroup(
			gl_panelDropdown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDropdown.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelDropdown.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(btnMostrar, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelDropdown.setLayout(gl_panelDropdown);
		
		
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
