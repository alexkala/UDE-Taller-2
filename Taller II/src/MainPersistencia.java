import logica.FachadaCapaLogica;
import java.io.*;

import logica.*;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;



public class MainPersistencia {


	public static void main(String[] args) throws ExceptionsJugadores, ExceptionsPeliculas, IOException {
		// TODO Auto-generated method stub
		
		/*
		String path = ManageString.getRuta();
		Persistencia db = new Persistencia();
		Datos d = new Datos();
		try {
			d=db.Recuperar(path);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionsPersistencia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FachadaCapaLogica.getInstancia().setJugadores(d.getJugadores());
		FachadaCapaLogica.getInstancia().setPeliculas(d.getPeliculas());
		
	
		DataPelicula[] dataPeliculas2 = FachadaCapaLogica.getInstancia().listarPeliculas();	// listarPeliculas
		 
		// muestra las peliculas
		System.out.println("\nPELICULAS");
		for (DataPelicula elem : dataPeliculas2) {
			System.out.println(elem.getTitulo() + " - " + elem.getPista());
		}
		*/
		// JUGADORES
		Jugador jugador = new Jugador("Alex", "123");	
		FachadaCapaLogica.getInstancia().nuevoJugador(jugador);							// nuevoJugador

		jugador = new Jugador("Gaston", "789");
		FachadaCapaLogica.getInstancia().nuevoJugador(jugador);							// nuevoJugador

		jugador = new Jugador("Felipe", "456");
		FachadaCapaLogica.getInstancia().nuevoJugador(jugador);			
		// nuevoJugador

		DataJugador[] dataJugadores = FachadaCapaLogica.getInstancia().listarJugadores();	// listarJugadores

		// muestra los jugadores
		for (DataJugador elem: dataJugadores) {
			System.out.println(elem.getNombre() + " - " + elem.getCodigo());
		}

		// PELICULAS
		Pelicula pelicula1 = new Pelicula("El francotirador", "Accion");
		Pelicula pelicula2 = new Pelicula("Birdman", "Humor negro");
		Pelicula pelicula3 = new Pelicula("Selma", "Drama");
		Pelicula pelicula4 = new Pelicula("La   teoria del todo  ", "Romance - Biografia");
		Pelicula pelicula5 = new Pelicula("Momentos de una vida", "Drama");

		FachadaCapaLogica.getInstancia().nuevaPelicula(pelicula1);							// nuevaPelicula
		FachadaCapaLogica.getInstancia().nuevaPelicula(pelicula2);							// nuevaPelicula
		FachadaCapaLogica.getInstancia().nuevaPelicula(pelicula3);							// nuevaPelicula
		FachadaCapaLogica.getInstancia().nuevaPelicula(pelicula4);							// nuevaPelicula
		FachadaCapaLogica.getInstancia().nuevaPelicula(pelicula5);							// nuevaPelicula

		DataPelicula[] dataPeliculas = FachadaCapaLogica.getInstancia().listarPeliculas();	// listarPeliculas

		// muestra las peliculas
		System.out.println("\nPELICULAS");
		for (DataPelicula elem : dataPeliculas) {
			System.out.println(elem.getTitulo() + " - " + elem.getPista());
		}
		
		
		//Guardar en archivo
		FachadaCapaLogica.getInstancia().guardarCambios();

	}

}
