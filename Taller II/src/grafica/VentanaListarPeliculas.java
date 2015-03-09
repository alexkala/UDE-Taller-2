package grafica;

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
		frmAdivinaLaPelcula.setTitle("Adivina la pel\u00EDcula - Lista de Peliculas");
		frmAdivinaLaPelcula.setResizable(false);
		frmAdivinaLaPelcula.setBounds(100, 100, 697, 501);
		frmAdivinaLaPelcula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraListarPeliculas = new ControladoraListarPeliculas();
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(40, 0, 40, 0));
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel label = new JLabel("ADIVINA LA PEL\u00CDCULA");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 34));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblListaDePeliculas = new JLabel("Lista de Peliculas:");
		lblListaDePeliculas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String columnas[] = {"Titulo","Pista"};
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
			}
		});
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdivinaLaPelcula.setVisible(false);
				VentanaMenuAdministrador menuAdministrador = null;
				try {
					menuAdministrador = new VentanaMenuAdministrador();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				menuAdministrador.setVisible(true);
				
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListaDePeliculas, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMostrar)
					.addGap(78)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(151, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListaDePeliculas, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(btnMostrar)
						.addComponent(button))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmAdivinaLaPelcula.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(99, Short.MAX_VALUE))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		tablePeliculas = new JTable();
		panel_2.add(tablePeliculas, BorderLayout.CENTER);
		frmAdivinaLaPelcula.getContentPane().setLayout(groupLayout);
		
		panel_2.add(tablePeliculas.getTableHeader(),BorderLayout.PAGE_START);
		panel_2.add(tablePeliculas,BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(tablePeliculas);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
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
