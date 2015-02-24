package logica;

import java.io.*;
import java.util.Iterator;
import java.util.TreeMap;

import logica.Jugador;
import logica.ValueObjetcs.DataJugador;

public class Jugadores extends TreeMap<String, Jugador> implements Serializable {

	private static final long serialVersionUID = 1L;
	private TreeMap<String, Jugador> jugadores;
	
	public Jugadores (){
		
		jugadores= new TreeMap<String, Jugador>();
	}

	public DataJugador[] obtenerJugadores()
	{
		DataJugador arregloJugadores[] = new DataJugador[jugadores.size()]; 
		Iterator <Jugador> iteradorJugadores = jugadores.values().iterator();
		int i = 0;
		while (iteradorJugadores.hasNext())
		{ 
			Jugador jugador = iteradorJugadores.next();
			arregloJugadores[i] = new DataJugador(jugador.getNombre(), jugador.getCodigo(), jugador.getPuntajeJugador(), jugador.getCantAciertos(), jugador.getCantErrores(), jugador.getPartidasJugador());
			i++;
		}
		return arregloJugadores;
	}


}