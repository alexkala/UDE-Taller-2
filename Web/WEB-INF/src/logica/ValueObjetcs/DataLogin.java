package logica.ValueObjetcs;

import java.io.Serializable;

import logica.Jugador;


public class DataLogin extends DataJugador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String codigo;
	
	public DataLogin(String _nombre, String _codigo) {
		super(_nombre, _codigo);
	}	

}
