package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JProgressBar;

import grafica.controladoras.ControladoraGuardar;

public class VentanaGuardar {

	private JFrame frmGuardar;
	private ControladoraGuardar ControladoraGuardarI;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public VentanaGuardar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuardar = new JFrame();
		frmGuardar.setTitle("Guardar");
		frmGuardar.setResizable(false);
		frmGuardar.setBounds(100, 100, 422, 349);
		frmGuardar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuardar.getContentPane().setBackground(Color.WHITE);
		frmGuardar.getContentPane().setLayout(new BorderLayout(0, 0));
		
		ControladoraGuardarI = new ControladoraGuardar();
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		frmGuardar.getContentPane().add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		panel_5.add(header, BorderLayout.NORTH);
		header.setBackground(Color.DARK_GRAY);
		
		JPanel headerTitulo = new JPanel();
		headerTitulo.setBorder(new EmptyBorder(40, 0, 40, 0));
		headerTitulo.setBackground(Color.DARK_GRAY);
		header.setLayout(new BorderLayout(0, 0));
		header.add(headerTitulo, BorderLayout.SOUTH);
		
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
		
		JProgressBar progressBar = new JProgressBar();
		panel.add(progressBar, BorderLayout.CENTER);
		
		JPanel bodyArriba = new JPanel();
		body.add(bodyArriba, BorderLayout.NORTH);
		bodyArriba.setLayout(new BorderLayout(0, 0));
		
		JPanel barraAbajo = new JPanel();
		barraAbajo.setBorder(new EmptyBorder(0, 10, 0, 10));
		panel_5.add(barraAbajo, BorderLayout.SOUTH);
		barraAbajo.setBackground(new Color(247, 247, 247));
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				ControladoraGuardarI.guardarCambios();		
			}
		});
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGuardar.setVisible(false);
				VentanaMenuAdministrador menuAdministrador = new VentanaMenuAdministrador();
				menuAdministrador.setVisible(true);
			}
		});
		
		GroupLayout gl_barraAbajo = new GroupLayout(barraAbajo);
		gl_barraAbajo.setHorizontalGroup(
			gl_barraAbajo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_barraAbajo.createSequentialGroup()
					.addGap(64)
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(84)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_barraAbajo.setVerticalGroup(
			gl_barraAbajo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_barraAbajo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_barraAbajo.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_barraAbajo.setAutoCreateGaps(true);
		gl_barraAbajo.setAutoCreateContainerGaps(true);
		barraAbajo.setLayout(gl_barraAbajo);
	}

	public void setVisible(boolean visible) {
		frmGuardar.setVisible(visible);
		
	}
	
	public void ioMensaje(){
		
		JOptionPane.showMessageDialog(null, "Error.\n Entro al intenar guardar datos.\n", "Error", JOptionPane.ERROR_MESSAGE);
	}
	public void guardadoOK(){
		
		JOptionPane.showMessageDialog(null, "Guardado OK", "", JOptionPane.INFORMATION_MESSAGE);
	}
	
	}
