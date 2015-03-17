package grafica;

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

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaFinPartida {
	private JFrame frmAdivinaLaPelcula;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFinPartida window = new VentanaFinPartida();
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
	public VentanaFinPartida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdivinaLaPelcula = new JFrame();
		frmAdivinaLaPelcula.setTitle("Adivina la pel\u00EDcula - Fin de la partida");
		frmAdivinaLaPelcula.setBounds(100, 100, 598, 234);
		frmAdivinaLaPelcula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 35, 0, 35));
		frmAdivinaLaPelcula.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblFinPartida = new JLabel("FIN DE LA PARTIDA");
		lblFinPartida.setHorizontalAlignment(SwingConstants.LEFT);
		lblFinPartida.setForeground(Color.DARK_GRAY);
		lblFinPartida.setFont(new Font("Arial", Font.BOLD, 24));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFinPartida)
					.addContainerGap(281, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblFinPartida)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		frmAdivinaLaPelcula.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 35, 0, 35));
		panel_2.add(panel_1, BorderLayout.CENTER);
		
		JButton btnNuevaPartida = new JButton("NUEVA PARTIDA");
		btnNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNuevaPartida.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNuevaPartida.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenuJugador menuJugador = new VentanaMenuJugador();
				frmAdivinaLaPelcula.setVisible(false);
				menuJugador.setVisible(true);
			}
		});
		btnMenu.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnMenu.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JLabel lblNewLabel = new JLabel("\u00A1Has finalizado la partida! \u00BFDeseas iniciar una partida nueva o volver al men\u00FA?");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnNuevaPartida, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNuevaPartida, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(btnMenu, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNuevaPartida, btnMenu}));
	}
}
