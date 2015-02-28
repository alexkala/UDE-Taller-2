import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import logica.Jugador;
import logica.ManageString;
import logica.Partida;
import logica.Pelicula;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataLogin;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
/*
 Este main se utiliza para probar que la capa de persistencia, recupere correctamente los datos
 Privamente se debera haber ejecutado el main PruebaCliente.java, para que guarde los datos de las peliculas y los jugadores.
 */
public class PruebaPersistencia {

	public static void main(String[] args) throws NotBoundException, ExceptionsJugadores, ExceptionsPeliculas, ExceptionCodigoIncorrecto, IOException {
		String url ="//" + ManageString.getProperty("ip")+ ":" + ManageString.getProperty("puerto")	+ "/" + ManageString.getProperty("nombre");		
		IFachadaCapaLogica fachada = (IFachadaCapaLogica) Naming.lookup(url); 	// ACCEDE AL SERVER 
		 
	
		DataPelicula[] dataPeliculas = fachada.listarPeliculas();
		// Muestra las peliculas
		System.out.println("\nPELICULAS");
		for (DataPelicula elem : dataPeliculas) {
				System.out.println(elem.getTitulo() + " - " + elem.getPista());
		}
		
		DataJugador[] dataJugadores = fachada.listarJugadores();
		// Muestra las peliculas
		System.out.println("\nJUGADORES");
		for (DataJugador elem : dataJugadores) {
			System.out.println(elem.getNombre() + " - " + elem.getPuntajeJugador());
		}

						
		
	}

}
