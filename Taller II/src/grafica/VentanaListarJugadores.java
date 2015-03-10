package grafica;

import grafica.auxiliares.Constantes;
import grafica.controladoras.ControladoraListarJugadores;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import logica.ValueObjetcs.DataJugador;
import logica.exceptions.ExceptionsJugadores;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.SwingConstants;


public class VentanaListarJugadores {

	private JFrame frmListarJugadores;
	private grafica.controladoras.ControladoraListarJugadores controladoraListarJugadores;
	private JTable tableJugadores;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListarJugadores window = new VentanaListarJugadores();
					window.frmListarJugadores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaListarJugadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListarJugadores = new JFrame();
		frmListarJugadores.setTitle("¡Adivina la película! - Lista de Jugadores");
		frmListarJugadores.setResizable(false);
		frmListarJugadores.setBounds(100, 100, 688, 507);
		//frmListarJugadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraListarJugadores= new ControladoraListarJugadores();
		frmListarJugadores.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelContenido = new JPanel();
		frmListarJugadores.getContentPane().add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelContenido.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelTitulo.setBackground(new Color(231, 76, 60));
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel labelTitulo = new JLabel("");
		labelTitulo.setIcon(new ImageIcon(Constantes.RUTA_TITULO_JUGADORES));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 34));
		panelTitulo.add(labelTitulo, BorderLayout.CENTER);
		
		JPanel panelTabla = new JPanel();
		panelContenido.add(panelTabla, BorderLayout.CENTER);
		
		tableJugadores = new JTable();
		
		panelTabla.setLayout(new BorderLayout());
		//panelTabla.add(tableJugadores.getTableHeader(),BorderLayout.PAGE_START);
		//panelTabla.add(tableJugadores,BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(tableJugadores);
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		tableJugadores.getTableHeader().setReorderingAllowed(false);
		tableJugadores.setEnabled(false);
		
		String columnas[] = {"NOMBRE", "CÓDIGO", "PUNTAJE", "ACIERTOS", "ERRORES"};
		modelo = new DefaultTableModel(columnas,0);
		tableJugadores.setModel(modelo);
		modelo.fireTableDataChanged();
		
		
		try {
			ListarJugadores();
		} catch (ExceptionsJugadores e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setVisible(boolean b) {
		frmListarJugadores.setVisible(b);		
		
	}
	
	public void ListarJugadores() throws ExceptionsJugadores{
		
		try 
		{
			DataJugador data[] = controladoraListarJugadores.listaJugadores();
			for(int i=0;i<data.length;i++)
			{
				Object[] nuevaFila = {(data[i].getNombre()),(data[i].getCodigo()),Integer.toString(data[i].getPuntajeJugador()),Integer.toString(data[i].getCantAciertos()),Integer.toString(data[i].getCantErrores())};
				modelo.addRow(nuevaFila);
			}
		} 
		catch (RemoteException e) { e.printStackTrace(); }
	}
	
	}
