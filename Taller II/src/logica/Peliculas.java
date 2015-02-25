package logica;

import java.io.*;

import logica.Pelicula;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class Peliculas extends TreeMap<String, Pelicula> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public Peliculas(Peliculas otro) {
		super(otro);
	}
	
	public Peliculas() {
		super();
	}


	public DataPelicula[] obtenerPeliculas() {
		DataPelicula arregloPeliculas[] = new DataPelicula[this.size()];
		Iterator<Pelicula> iteradorPeliculas = this.values().iterator();
		int i = 0;
		while (iteradorPeliculas.hasNext()) {
			Pelicula pelicula = iteradorPeliculas.next();
			arregloPeliculas[i] = new DataPelicula(pelicula.getTitulo(),
					pelicula.getPista());
			i++;
		}
		return arregloPeliculas;
	}
	
	public Pelicula randomPelicula(ArrayList<Partida> partidas) {
		
		//DataPelicula[] dataPeliculasDisponibles = peliculasDisponibles.obtenerPeliculas();
		if (partidas.size() != this.size()) { 				// Quedan peliculas sin adivinar
			Peliculas peliculasDisponibles = new Peliculas(this);				// Crea una copia de las peliculas
			Iterator<Partida> iterador = partidas.iterator();
			while (iterador.hasNext()) { 						// Deja solo las peliculas disponibles
				Partida p = iterador.next();
				peliculasDisponibles.remove(p.getPeliculaPartida().getClave());
			}
			
			DataPelicula[] dataPeliculas = peliculasDisponibles.obtenerPeliculas();
			
			Random rand = new Random();
			int max = peliculasDisponibles.size();			// iguala max al tamaño del arreglo de dataPeliculasDisponibles
			int randomNum = rand.nextInt(max);				// random entre 0 (incluido) y max (excluido)

			String tituloPelicula = dataPeliculas[randomNum].getTitulo();
			return this.get(tituloPelicula);
		} else {
			System.out.print("\nError: en este momento no hay mas peliculas para adivinar.");
			// Error: en este momento no hay peliculas para adivinar.
		}
		return null;
	}
	

}