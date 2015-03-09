package grafica;

import grafica.controladoras.ControladoraListarJugadores;

import java.awt.EventQueue;

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
		frmListarJugadores.setTitle("Adivina la pel\u00EDcula -Lista de Jugadores");
		frmListarJugadores.setResizable(false);
		frmListarJugadores.setBounds(100, 100, 688, 507);
		frmListarJugadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controladoraListarJugadores= new ControladoraListarJugadores();
			
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblListaJugadores = new JLabel("Lista de Jugadores:");
		lblListaJugadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton button = new JButton("Mostrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String columnas[] = {"Nombre","Codigo","Puntos","CantAciertos","CantErrores"};
					modelo = new DefaultTableModel(columnas,0);
					tableJugadores.setModel(modelo);
					modelo.fireTableDataChanged();
					
					
					ListarJugadores();
				} catch (ExceptionsJugadores e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmListarJugadores.setVisible(false);
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
					.addGap(5)
					.addComponent(lblListaJugadores, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(211, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnVolver)
						.addComponent(lblListaJugadores, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(40, 0, 40, 0));
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel label = new JLabel("ADIVINA LA PEL\u00CDCULA");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 34));
		panel.add(label);
		GroupLayout groupLayout = new GroupLayout(frmListarJugadores.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
				
		
		frmListarJugadores.getContentPane().setLayout(groupLayout);
		
		tableJugadores = new JTable();
		
		
		panel_2.setLayout(new BorderLayout());
		panel_2.add(tableJugadores.getTableHeader(),BorderLayout.PAGE_START);
		panel_2.add(tableJugadores,BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(tableJugadores);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		tableJugadores.getTableHeader().setReorderingAllowed(false);
		tableJugadores.setEnabled(false);
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
