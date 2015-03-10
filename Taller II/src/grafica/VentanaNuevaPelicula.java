package grafica;

import grafica.auxiliares.Constantes;
import grafica.auxiliares.TextPrompt;
import grafica.controladoras.ControladoraNuevaPelicula;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
			frmNuevaPelicula.setTitle("¡Adivina la película! - Nueva Pel\u00EDcula");
			frmNuevaPelicula.setBounds(100, 100, 627, 327);
			//frmNuevaPelicula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			controladoraNuevaPelicula= new ControladoraNuevaPelicula();
			
			JPanel panelContenido = new JPanel();
			frmNuevaPelicula.getContentPane().add(panelContenido, BorderLayout.CENTER);
			panelContenido.setLayout(new BorderLayout(0, 0));
			
			JPanel panelTitulo = new JPanel();
			panelTitulo.setBackground(new Color(231, 76, 60));
			panelTitulo.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelContenido.add(panelTitulo, BorderLayout.NORTH);
			panelTitulo.setLayout(new BorderLayout(0, 0));
			

			JLabel lblNuevaPelicula = new JLabel("");
			lblNuevaPelicula.setIcon(new ImageIcon(Constantes.RUTA_NUEVA_PELICULA));
			lblNuevaPelicula.setHorizontalAlignment(SwingConstants.CENTER);
			panelTitulo.add(lblNuevaPelicula, BorderLayout.CENTER);
			lblNuevaPelicula.setForeground(Color.WHITE);
			lblNuevaPelicula.setFont(new Font("Arial", Font.BOLD, 34));

			JPanel panelCampos = new JPanel();
			panelCampos.setBackground(new Color(44, 62, 80));
			panelCampos.setBorder(new EmptyBorder(20, 20, 20, 20));
			panelContenido.add(panelCampos, BorderLayout.CENTER);

			
			
			txtTitulo = new JTextField();
			TextPrompt tpTitulo = new TextPrompt("Título", txtTitulo);
			tpTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
			tpTitulo.setForeground( Color.LIGHT_GRAY );
			tpTitulo.changeAlpha(0.5f);
			txtTitulo.setFont(new Font("Arial", Font.PLAIN, 13));
			txtTitulo.setHorizontalAlignment(SwingConstants.LEFT);
			txtTitulo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
			txtTitulo.setColumns(10);

			
			textPista = new JTextField();
			TextPrompt tpPista = new TextPrompt("Pista", textPista);
			tpPista.setFont(new Font("Arial", Font.PLAIN, 13));
			tpPista.setForeground( Color.LIGHT_GRAY );
			tpPista.changeAlpha(0.5f);
			textPista.setFont(new Font("Arial", Font.PLAIN, 13));
			textPista.setHorizontalAlignment(SwingConstants.LEFT);
			textPista.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
			textPista.setColumns(10);
			
			GroupLayout gl_panelCampos = new GroupLayout(panelCampos);
			gl_panelCampos.setHorizontalGroup(
				gl_panelCampos.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_panelCampos.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelCampos.createParallelGroup(Alignment.LEADING)
							.addComponent(textPista, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
							.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)))
			);
			gl_panelCampos.setVerticalGroup(
				gl_panelCampos.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelCampos.createSequentialGroup()
						.addContainerGap()
						.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(textPista, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(65, Short.MAX_VALUE))
			);
			panelCampos.setLayout(gl_panelCampos);
			
			JPanel panelBotones = new JPanel();
			panelBotones.setBackground(new Color(44, 62, 80));
			panelBotones.setBorder(new EmptyBorder(0, 20, 10, 20));
			panelContenido.add(panelBotones, BorderLayout.SOUTH);
			
			JButton btnAceptar = new JButton("ACEPTAR");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!txtTitulo.getText().isEmpty()){
						if(!textPista.getText().isEmpty()){							
							String titulo = txtTitulo.getText();
							String pista = textPista.getText();									
							try {
								controladoraNuevaPelicula.NuevaPelicula(titulo, pista);
								frmNuevaPelicula.setVisible(false);
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
				}
			});
			
			GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
			gl_panelBotones.setHorizontalGroup(
				gl_panelBotones.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelBotones.createSequentialGroup()
						.addContainerGap(397, Short.MAX_VALUE)
						.addComponent(btnAceptar)
						.addGap(10)
						.addComponent(btnCancelar)
						.addContainerGap())
			);
			gl_panelBotones.setVerticalGroup(
				gl_panelBotones.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_panelBotones.createSequentialGroup()
						.addGroup(gl_panelBotones.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panelBotones.setLayout(gl_panelBotones);
			
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
