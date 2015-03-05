package grafica.controladoras;

import java.io.IOException;
import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import logica.ManageString;
import logica.Partida;
import logica.ValueObjetcs.DataLogin;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionsJugadores;
import servidor.ObjectCliente;

public class ControladoraVentanaPartida {
	private IFachadaCapaLogica fachada;
	private grafica.VentanaLogin window;
	
	public Partida ingresarCaracter(String nombreJugador, String codigoJugador, String letra) throws ExceptionsJugadores, RemoteException {
		fachada = ObjectCliente.Inicializar();
		letra = letra.toUpperCase(); // convierte la letra a mayuscula
		char letraChar = letra.charAt(0); // cambia el String con la letra a 1 char
		Partida partida = fachada.ingresarCaracter(nombreJugador, codigoJugador, letraChar);
		return partida;
	}
	
	public Partida arriesgarPelicula(String nombreJugador, String codigoJugador, String peliculaArriesgada) throws RemoteException, ExceptionsJugadores {
		fachada = ObjectCliente.Inicializar();
		peliculaArriesgada = ManageString.corregirTexto(peliculaArriesgada);
		Partida partida = fachada.arriesgarPelicula(nombreJugador, codigoJugador, peliculaArriesgada);
		return partida;
	}

}
