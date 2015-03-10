package grafica;

import grafica.auxiliares.BackgroundPanel;
import grafica.auxiliares.Constantes;
import grafica.auxiliares.MyTableModel;
import grafica.controladoras.ControladoraRanking;

import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollBar;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.table.TableColumn;

import logica.exceptions.ExceptionsPersistencia;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

public class VentanaRanking {

	private JFrame frame;
	private JTable table;
	private ControladoraRanking controladoraRanking;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRanking window = new VentanaRanking();
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
	public VentanaRanking() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setTitle("¡Adivina la película! - Ranking");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 800, 400);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraRanking = new ControladoraRanking();
		
		Image backgroundImage = ImageIO.read(new File(Constantes.RUTA_BACKGROUND));
		BackgroundPanel panelContenido = new BackgroundPanel(backgroundImage);
		frame.getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelContenido.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(231, 76, 60));
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelTitulo.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(Constantes.RUTA_TITULO_RANKING));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitulo);
		
	
		String[] columnas = {"POSICION",
                "NOMBRE",
                "PUNTOS",
                "ACIERTOS",
                "ERRORES",
                "PARTIDAS"};
		
		try {
			Object[][] data = controladoraRanking.listarRanking();
			table = new JTable(data, columnas);
			table.getTableHeader().setReorderingAllowed(false);
			table.setEnabled(false);
			JScrollPane scrollPane = new JScrollPane(table);
			panelContenido.add(scrollPane, BorderLayout.CENTER);
		} catch (ExceptionsPersistencia e){
			Object[] options = {"OK"};
			JOptionPane.showOptionDialog(frame,
					e.getMessage(),
					"Ranking",
					JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,		//do not use a custom Icon
					options,	//the titles of buttons
					null);		//default button title
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

}
