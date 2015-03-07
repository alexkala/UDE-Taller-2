package grafica.controladoras;

import grafica.BufferSesion;

import java.io.IOException;
import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import logica.ManageString;
import logica.Partida;
import logica.ValueObjetcs.DataLogin;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionPartidas;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
import servidor.ObjectCliente;

public class ControladoraVentanaPartida {
	private IFachadaCapaLogica fachada;
	private grafica.VentanaLogin window;
	
	public boolean ingresarCaracter(String nombreJugador, String codigoJugador, String letra) throws ExceptionsJugadores, RemoteException, ExceptionPartidas {
		fachada = ObjectCliente.Inicializar();
		String textoAdivinado = new String(fachada.partidaEnCurso(nombreJugador, codigoJugador).getTextoAdivinado());
		letra = letra.toUpperCase(); // convierte la letra a mayuscula
		char letraChar = letra.charAt(0); // cambia el String con la letra a 1 char
		Partida partida = fachada.ingresarCaracter(nombreJugador, codigoJugador, letraChar);
		return !textoAdivinado.equals(partida.getTextoAdivinado());
	}
	
	public boolean arriesgarPelicula(String nombreJugador, String codigoJugador, String peliculaArriesgada) throws RemoteException, ExceptionsJugadores {
		fachada = ObjectCliente.Inicializar();
		peliculaArriesgada = ManageString.corregirTexto(peliculaArriesgada);
		Partida partida = fachada.arriesgarPelicula(nombreJugador, codigoJugador, peliculaArriesgada);
		if (partida.isAcertada()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public Partida partidaEnCurso(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionsJugadores {
		fachada = ObjectCliente.Inicializar();
		return fachada.partidaEnCurso(nombreJugador, codigoJugador);
	}
	
	public Partida nuevaPartida(String nombreJugador, String codigoJugador) throws ExceptionsJugadores, ExceptionPartidas, ExceptionsPeliculas, RemoteException {
			fachada = ObjectCliente.Inicializar();
			Partida nueva = fachada.nuevaPartida(nombreJugador, codigoJugador);
			return nueva;
	}

}
