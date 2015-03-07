package grafica;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class PruebaVentanaLogin {

	public static void main(String[] args) {
		

		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		VentanaLogin ventana;
		try {
			ventana = new VentanaLogin();
			ventana.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		VentanaMenuJugador jugador = new VentanaMenuJugador();
		jugador.setVisible(true);
		 */
	}

}
