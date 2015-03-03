package grafica;
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
		
		VentanaLogin ventana = new VentanaLogin();
		ventana.setVisible(true);
	}

}
