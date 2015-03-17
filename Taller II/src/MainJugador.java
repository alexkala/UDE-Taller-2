import grafica.VentanaLogin;
import grafica.VentanaMenuAdministrador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import logica.FachadaCapaLogica;
import logica.Partida;
import logica.Pelicula;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionsPeliculas;

public class MainJugador {

	public static void main(String[] args) throws ExceptionsPeliculas, RemoteException {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
			e.printStackTrace();
		}
		
		// -----
		// LOGIN
		// -----
		VentanaLogin login;
		try {
			login = new VentanaLogin();
			login.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
