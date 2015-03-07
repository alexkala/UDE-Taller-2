package grafica;

import java.io.IOException;

import logica.FachadaCapaLogica;
import logica.Jugadores;
import logica.ManageString;
import logica.Monitor;
import logica.Peliculas;
import logica.exceptions.ExceptionsPersistencia;
import persistencia.Datos;
import persistencia.Persistencia;

public class BufferSesion {

	private static BufferSesion instancia;
	private String nombreJugador;
	private String codigoJugador;
			
	// constructor
	private BufferSesion() {
		this.nombreJugador = new String();
		this.codigoJugador = new String();
	}

	// getters y setters
	public static BufferSesion getInstancia() {
		if (instancia == null) {
			instancia = new BufferSesion();
		}
		return instancia;
	}


	public String getNombreJugador() {
		return nombreJugador;
	}


	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}


	public String getCodigoJugador() {
		return codigoJugador;
	}


	public void setCodigoJugador(String codigoJugador) {
		this.codigoJugador = codigoJugador;
	}
}
