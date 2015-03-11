package grafica;


import grafica.auxiliares.Constantes;
import grafica.controladoras.ControladoraListarPeliculas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JTable;

import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;

import javax.swing.SwingConstants;

public class VentanaListarPeliculas {

	private JFrame frmAdivinaLaPelcula;
	private grafica.controladoras.ControladoraListarPeliculas controladoraListarPeliculas;
	private JTable tablePeliculas;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListarPeliculas window = new VentanaListarPeliculas();
					window.frmAdivinaLaPelcula.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaListarPeliculas() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdivinaLaPelcula = new JFrame();
		frmAdivinaLaPelcula.setTitle("¡Adivina la película! - Lista de Películas");
		frmAdivinaLaPelcula.setResizable(false);
		frmAdivinaLaPelcula.setBounds(100, 100, 697, 501);
		//frmAdivinaLaPelcula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraListarPeliculas = new ControladoraListarPeliculas();
		
		frmAdivinaLaPelcula.getContentPane().setLayout(new BorderLayout(0, 0));
	
		JPanel panelContenido = new JPanel();
		frmAdivinaLaPelcula.getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelContenido.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelTitulo.setBackground(new Color(231, 76, 60));
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel labelTitulo = new JLabel("");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setIcon(new ImageIcon(Constantes.RUTA_TITULO_PELICULAS));
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 34));
		panelTitulo.add(labelTitulo);
		

		JPanel panelTabla = new JPanel();
		panelContenido.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		tablePeliculas = new JTable();
		String columnas[] = {"TÍTULO", "PISTA"};
		modelo = new DefaultTableModel(columnas,0);
		tablePeliculas.setModel(modelo);
		modelo.fireTableDataChanged();				
		try {
			ListarPeliculas();
		} catch (ExceptionsJugadores e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExceptionsPeliculas e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//panelTabla.add(tablePeliculas.getTableHeader(),BorderLayout.PAGE_START);
		//panelTabla.add(tablePeliculas,BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(tablePeliculas);
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		tablePeliculas.getTableHeader().setReorderingAllowed(false);
		tablePeliculas.setEnabled(false);
	}

	public void setVisible(boolean b) {
		frmAdivinaLaPelcula.setVisible(b);
		// TODO Auto-generated method stub		
	}
	
public void ListarPeliculas() throws ExceptionsJugadores, ExceptionsPeliculas{
		
		try 
		{
			DataPelicula data[] = controladoraListarPeliculas.listaPeliculas();
			for(int i=0;i<data.length;i++)
			{
				Object[] nuevaFila = {data[i].getTitulo(),data[i].getPista()};
				modelo.addRow(nuevaFila);
			}
		} 
		catch (RemoteException e) { e.printStackTrace(); }
	}
}
