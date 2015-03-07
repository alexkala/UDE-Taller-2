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
		frame.setTitle("Ranking");
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
		/*
		table_1 = new JTable();
		table_1.setEnabled(false);
		table_1.setDragEnabled(true);
		panel_1.add(table_1);
		*/
		//JScrollPane scrollPane = new JScrollPane();
		//frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	
		String[] columnas = {"POSICION",
                "NOMBRE",
                "PUNTOS",
                "ACIERTOS",
                "ERRORES",
                "PARTIDAS"};
		
		try {
			Object[][] data = controladoraRanking.listarRanking();
			if (data != null) {
				table = new JTable(data, columnas);
				table.getTableHeader().setReorderingAllowed(false);
				table.setEnabled(false);
				JScrollPane scrollPane = new JScrollPane(table);
				panelContenido.add(scrollPane, BorderLayout.CENTER);
			} else {
				
				Object[] options = {"NUEVA PARTIDA",
				"MENU"};
				int opcion = JOptionPane.showOptionDialog(frame,
						"NO NULL",
						"Fin de la partida",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,		//do not use a custom Icon
						options,	//the titles of buttons
						null);		//default button title
			}
			
			//table = new JTable(data, columnas);
			//JScrollPane scrollPane2 = new JScrollPane(table);
			//table.setFillsViewportHeight(true);
			//frame.getContentPane().add(scrollPane2, BorderLayout.CENTER);
			/*
			JPanel panel_1 = new JPanel();
			frame.getContentPane().add(panel_1, BorderLayout.CENTER);
			*/
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

		
		
		/*
		TableColumn column = null;
		for (int i = 0; i < 6; i++) {
		    switch (i) {
			case 0:
			{
				column = table.getColumnModel().getColumn(i);
				column.setPreferredWidth(50);
			}
				break;

			default:
			{
				column = table.getColumnModel().getColumn(i);
				column.setPreferredWidth(100);
			}
				break;
		    }	
		}
		*/
		

	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

}
