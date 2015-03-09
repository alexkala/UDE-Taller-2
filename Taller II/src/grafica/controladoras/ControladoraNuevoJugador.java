package grafica.controladoras;

import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import servidor.ObjectCliente;
import grafica.VentanaNuevoJugador;
import logica.IFachadaCapaLogica;
import logica.Jugador;
import logica.exceptions.ExceptionsJugadores;

public class ControladoraNuevoJugador {
	
	private IFachadaCapaLogica fachada;
	private grafica.VentanaNuevoJugador v;
	
	public void NuevoJugador(String nombre, String codigo) throws RemoteException, ExceptionsJugadores{
		Jugador j = new Jugador(nombre, codigo);
		try {
			fachada = ObjectCliente.Inicializar();
			fachada.nuevoJugador(j);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ExceptionsJugadores e) {
			e.printStackTrace();
		}
		
	}
}