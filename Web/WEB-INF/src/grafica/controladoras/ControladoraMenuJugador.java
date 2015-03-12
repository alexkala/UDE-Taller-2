package grafica.controladoras;

import java.io.IOException;
import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import logica.Partida;
import logica.ValueObjetcs.DataJugador;
import logica.exceptions.ExceptionPartidas;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
import logica.exceptions.ExceptionsPersistencia;
import servidor.ObjectCliente;

public class ControladoraMenuJugador {
	
	private IFachadaCapaLogica fachada;
	private grafica.VentanaMenuJugador window;
	
	public Partida partidaEnCurso(String nombreJugador, String codigoJugador) throws ExceptionsJugadores {
		try {
			fachada = ObjectCliente.Inicializar();
			Partida actual = fachada.partidaEnCurso(nombreJugador, codigoJugador);
			return actual;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Partida nuevaPartida(String nombreJugador, String codigoJugador) throws ExceptionsJugadores, ExceptionPartidas, ExceptionsPeliculas {
		try {
			fachada = ObjectCliente.Inicializar();
			Partida nueva = fachada.nuevaPartida(nombreJugador, codigoJugador);
			return nueva;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public DataJugador[] listarRanking(String nombreJugador, String codigoJugador) throws ExceptionsJugadores, ClassNotFoundException, IOException, ExceptionsPersistencia {
		try {
			fachada = ObjectCliente.Inicializar();
			return fachada.listarRanking();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
