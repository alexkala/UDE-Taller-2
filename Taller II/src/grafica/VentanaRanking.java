package grafica;

import grafica.auxiliares.MyTableModel;
import grafica.controladoras.ControladoraRanking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.table.TableColumn;

import logica.exceptions.ExceptionsPersistencia;

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
	 */
	public VentanaRanking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ranking");
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 808, 572);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraRanking = new ControladoraRanking();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("RANKING");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
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
				table.setEnabled(false);
				table.setDragEnabled(true);
				JScrollPane scrollPane = new JScrollPane(table);
				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
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
