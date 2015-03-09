package grafica.controladoras;

import java.rmi.RemoteException;

import servidor.ObjectCliente;
import logica.IFachadaCapaLogica;
import logica.ValueObjetcs.DataJugador;
import logica.exceptions.ExceptionsJugadores;

public class ControladoraListarJugadores {
	
	private IFachadaCapaLogica fachada;
	private grafica.VentanaListarJugadores window;
	
	
	public DataJugador[] listaJugadores()  throws RemoteException, ExceptionsJugadores {
		try {
			fachada = ObjectCliente.Inicializar();
			DataJugador[] dataJugador = fachada.listarJugadores();
			return dataJugador;
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}

