package grafica;

import grafica.auxiliares.TextPrompt;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JScrollBar;

import java.awt.Rectangle;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Color;

public class VentanaNuevaPelicula {

	private JFrame frmAdivinaLaPelcula;
	private JTextField txtTitulo;
	private JTextField textPista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevaPelicula window = new VentanaNuevaPelicula();
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
	public VentanaNuevaPelicula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			frmAdivinaLaPelcula = new JFrame();
			frmAdivinaLaPelcula.setTitle("Adivina la pel\u00EDcula - Nueva Pel\u00EDcula");
			frmAdivinaLaPelcula.setBounds(100, 100, 598, 269);
			frmAdivinaLaPelcula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(0, 35, 0, 35));
			frmAdivinaLaPelcula.getContentPane().add(panel, BorderLayout.NORTH);
			
			JLabel lblNuevaPelcula = new JLabel("NUEVA PEL\u00CDCULA");
			lblNuevaPelcula.setHorizontalAlignment(SwingConstants.LEFT);
			lblNuevaPelcula.setForeground(Color.DARK_GRAY);
			lblNuevaPelcula.setFont(new Font("Arial", Font.BOLD, 24));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNuevaPelcula)
						.addContainerGap(292, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(19)
						.addComponent(lblNuevaPelcula)
						.addContainerGap(18, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
			
			JPanel panel_2 = new JPanel();
			frmAdivinaLaPelcula.getContentPane().add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JPanel panel_1 = new JPanel();
			panel_2.add(panel_1, BorderLayout.CENTER);
			
			JButton btnNewButton = new JButton("ACEPTAR");
			
			JButton btnCancelar = new JButton("CANCELAR");
			
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
			
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(43)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
							.addComponent(textPista))
						.addContainerGap(45, Short.MAX_VALUE))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textPista, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addComponent(btnCancelar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(23, Short.MAX_VALUE))
			);
			panel_1.setLayout(gl_panel_1);
			panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, btnCancelar, txtTitulo}));
	}
}
