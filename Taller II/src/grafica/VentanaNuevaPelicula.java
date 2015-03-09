package grafica;

import grafica.auxiliares.TextPrompt;
import grafica.controladoras.ControladoraNuevaPelicula;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.RemoteException;

import logica.exceptions.ExceptionsPeliculas;

public class VentanaNuevaPelicula {

	private JFrame frmNuevaPelicula;
	private JTextField txtTitulo;
	private JTextField textPista;
	private grafica.controladoras.ControladoraNuevaPelicula controladoraNuevaPelicula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevaPelicula window = new VentanaNuevaPelicula();
					window.frmNuevaPelicula.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaNuevaPelicula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			frmNuevaPelicula = new JFrame();
			frmNuevaPelicula.setResizable(false);
			frmNuevaPelicula.setTitle("Adivina la pel\u00EDcula - Nueva Pel\u00EDcula");
			frmNuevaPelicula.setBounds(100, 100, 627, 436);
			frmNuevaPelicula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			controladoraNuevaPelicula= new ControladoraNuevaPelicula();
			
			JPanel panel_2 = new JPanel();
			frmNuevaPelicula.getContentPane().add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_1 = new JPanel();
			panel_2.add(panel_1, BorderLayout.CENTER);
			
			JButton btnNewButton = new JButton("ACEPTAR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!txtTitulo.getText().isEmpty()){
						if(!textPista.getText().isEmpty()){							
							String titulo = txtTitulo.getText();
							String pista = textPista.getText();									
							try {
								controladoraNuevaPelicula.NuevaPelicula(titulo, pista);
								frmNuevaPelicula.setVisible(false);
								VentanaMenuAdministrador menuAdministrador = new VentanaMenuAdministrador();
								menuAdministrador.setVisible(true);
							} catch (RemoteException | ExceptionsPeliculas e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else
							errorPelicula("Debe ingresar una pista.");
					}else
						errorPelicula("Debe ingresar un titulo.");
					
				}
			});
			
			JButton btnCancelar = new JButton("CANCELAR");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmNuevaPelicula.setVisible(false);
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
			
			txtTitulo = new JTextField();
			TextPrompt tpTitulo = new TextPrompt("Título", txtTitulo);
			tpTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
			tpTitulo.setForeground( Color.LIGHT_GRAY );
			tpTitulo.changeAlpha(0.5f);
			txtTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
			txtTitulo.setHorizontalAlignment(SwingConstants.LEFT);
			txtTitulo.setBorder(BorderFactory.createCompoundBorder(
					txtTitulo.getBorder(), 
			        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
			txtTitulo.setColumns(10);
			
			textPista = new JTextField();
			TextPrompt tpPista = new TextPrompt("Pista", textPista);
			tpPista.setFont(new Font("Arial", Font.PLAIN, 13));
			tpPista.setForeground( Color.LIGHT_GRAY );
			tpPista.changeAlpha(0.5f);
			textPista.setFont(new Font("Arial", Font.PLAIN, 13));
			textPista.setHorizontalAlignment(SwingConstants.LEFT);
			textPista.setBorder(BorderFactory.createCompoundBorder(
					textPista.getBorder(), 
			        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
			textPista.setColumns(10);
			
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(40, 0, 40, 0));
			panel.setBackground(Color.DARK_GRAY);
			
			JLabel label = new JLabel("ADIVINA LA PEL\u00CDCULA");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Arial", Font.BOLD, 34));
			panel.add(label);
			
			JPanel panel_3 = new JPanel();
			panel_3.setForeground(Color.WHITE);
			panel_3.setBackground(Color.LIGHT_GRAY);
			
			JLabel lblNuevaPelicula = new JLabel("Nueva Pelicula:");
			lblNuevaPelicula.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GroupLayout gl_panel_3 = new GroupLayout(panel_3);
			gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGap(0, 644, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNuevaPelicula, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(333, Short.MAX_VALUE))
			);
			gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.TRAILING)
					.addGap(0, 47, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNuevaPelicula, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
			);
			panel_3.setLayout(gl_panel_3);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new EmptyBorder(40, 0, 40, 0));
			panel_4.setBackground(Color.DARK_GRAY);
			
			JLabel label_2 = new JLabel("ADIVINA LA PEL\u00CDCULA");
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Arial", Font.BOLD, 34));
			panel_4.add(label_2);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new EmptyBorder(40, 0, 40, 0));
			panel_5.setBackground(Color.DARK_GRAY);
			
			JLabel label_3 = new JLabel("ADIVINA LA PEL\u00CDCULA");
			label_3.setForeground(Color.WHITE);
			label_3.setFont(new Font("Arial", Font.BOLD, 34));
			panel_5.add(label_3);
			
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(318)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(1)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(20)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textPista, Alignment.LEADING)
									.addComponent(txtTitulo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(7)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textPista, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(23))
			);
			panel_1.setLayout(gl_panel_1);
			panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, btnCancelar, txtTitulo}));
	}
	public void setVisible (boolean visible) {
		frmNuevaPelicula.setVisible(visible);
	}
	
public void errorPelicula(String s){
		
		JOptionPane.showMessageDialog(null, "Error.\n" + s, "Error", JOptionPane.ERROR_MESSAGE);
		
	}

public void okPelicula(String s){
	
	JOptionPane.showMessageDialog(null, s, "Pelicula Agregada " , JOptionPane.INFORMATION_MESSAGE);
	
}
}
