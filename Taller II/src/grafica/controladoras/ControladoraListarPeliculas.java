package grafica.controladoras;

import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
import servidor.ObjectCliente;

public class ControladoraListarPeliculas {
	
	private IFachadaCapaLogica fachada;
	private grafica.VentanaListarPeliculas v;
	
	
	public DataPelicula[] listaPeliculas()  throws RemoteException, ExceptionsJugadores, ExceptionsPeliculas {
		try {
			fachada = ObjectCliente.Inicializar();
			DataPelicula[] dataPelicula = fachada.listarPeliculas();
			return dataPelicula;
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return null;
	}	

}
