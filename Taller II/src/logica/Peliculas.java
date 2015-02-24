package logica;

import java.io.*;

import logica.Pelicula;
import logica.ValueObjetcs.DataPelicula;

import java.util.Iterator;
import java.util.TreeMap;

public class Peliculas extends TreeMap<String, Pelicula> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private TreeMap<String, Pelicula> peliculas;


public Peliculas (){
	peliculas = new TreeMap<String, Pelicula>();
}

public DataPelicula[] obtenerPeliculas()
{
	DataPelicula arregloPeliculas[] = new DataPelicula[peliculas.size()]; 
	Iterator <Pelicula> iteradorPeliculas = peliculas.values().iterator();
	int i = 0;
	while (iteradorPeliculas.hasNext())
	{ 
		Pelicula pelicula = iteradorPeliculas.next();
		arregloPeliculas[i] = new DataPelicula(pelicula.getTitulo(),pelicula.getPista());
		i++;
	}
	return arregloPeliculas;
}
































}