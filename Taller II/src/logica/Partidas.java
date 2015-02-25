package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import logica.ValueObjetcs.DataPartida;

public class Partidas extends ArrayList<Partida> implements Serializable {

	private static final long serialVersionUID = 1L;
		
	public Partidas (){
		super();
	}
	
	public DataPartida[] obtenerPartidas(){
		DataPartida arregloPartidas[] = new DataPartida[this.size()]; 
		Iterator <Partida> iteradorPartidas = this.iterator();
		int i = 0;
		while (iteradorPartidas.hasNext())
		{ 
			Partida partida= iteradorPartidas.next();
			arregloPartidas[i] = new DataPartida(partida.getNumeroPartida(),partida.getPuntajePartida(),partida.isFinalizada(),partida.isAcertada(),partida.getTextoAdivinado(),partida.getPeliculaPartida());
			i++;
		}
		return arregloPartidas;

	}
}
	
	
