import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import logica.FachadaCapaLogica;
import logica.Jugador;
import logica.Jugadores;
import logica.ManageString;
import logica.Partida;
import logica.Partidas;
import logica.Pelicula;
import logica.Peliculas;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataLogin;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;


public class PruebaFachada {

	public static void main(String[] args) throws ExceptionsJugadores, ExceptionsPeliculas, RemoteException, ExceptionCodigoIncorrecto {
		
		/*
		// JUGADORES
		Jugador jugador1 = new Jugador("Alex", "123");
		jugador1.setPuntajeJugador(60);
		FachadaCapaLogica.getInstancia().nuevoJugador(jugador1);							// nuevoJugador
		
		Jugador jugador = new Jugador("Gaston", "789");
		jugador.setPuntajeJugador(60);
		FachadaCapaLogica.getInstancia().nuevoJugador(jugador);							// nuevoJugador
		
		jugador = new Jugador("Felipe", "456");
		jugador.setPuntajeJugador(30);
		FachadaCapaLogica.getInstancia().nuevoJugador(jugador);							// nuevoJugador

		DataJugador[] dataJugadores = FachadaCapaLogica.getInstancia().listarJugadores();	// listarJugadores
		
		// muestra los jugadores
		System.out.println("\nJUGADORES");
		for (DataJugador elem: dataJugadores) {
			System.out.println(elem.getNombre() + " - " + elem.getCodigo() + " - PUNTAJE: " + elem.getPuntajeJugador());
		}
		
		// RANKING
		System.out.println("\nRANKING");
		DataJugador[] ranking = FachadaCapaLogica.getInstancia().listarRanking();		// listarRanking
		int i = 1;
		for (DataJugador elem: ranking) {
			System.out.println(i + " - " + elem.getNombre() + " - " + elem.getCodigo() + " - PUNTAJE: " + elem.getPuntajeJugador());
			i++;
		}

		// -----
		// LOGIN
		// -----
		System.out.println("\n\nLOGIN");
		DataLogin dataLogin = FachadaCapaLogica.getInstancia().logIn("Alex", "123");
		System.out.println(dataLogin.getNombre());
		System.out.println(dataLogin.getCodigo());

		/*
		
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
		
		// PARTIDAS
		Partida nueva = new Partida();
		
		for (i = 1; i <= 3; i++) {
			System.out.println("\nPARTIDA NUEVA");
			nueva = FachadaCapaLogica.getInstancia().nuevaPartida(jugador1.getClave(), jugador1.getCodigo());			// nuevaPartida
			if (nueva != null) {
				nueva.setFinalizada(true);
				System.out.println(nueva.getNumeroPartida() + ": " + nueva.getTextoAdivinado());
				System.out.println(nueva.getPeliculaPartida().getTitulo() + " - " + nueva.getPeliculaPartida().getPista());
				System.out.println(nueva.isFinalizada() ? "Finalizada" : "En curso");
			}
		}

		DataPartida[] partidasArre= FachadaCapaLogica.getInstancia().listarPartidas("Alex");	// listarPartidas
		System.out.println("\n---------------------\n");
		System.out.println("LISTAR PARTIDAS\n");
		for(DataPartida elem: partidasArre)		{
			System.out.println (elem.getNumero() + ": " + elem.getTextoAdivinado());
			System.out.println(elem.getPeliculaPartida().getTitulo() + " - " + elem.getPeliculaPartida().getPista());
			System.out.println(elem.isFinalizada() ? "Finalizada" : "En curso");			
		}
		
		System.out.println("\n---------------------\n");
		
		Partida actual = FachadaCapaLogica.getInstancia().nuevaPartida("Alex", "123");		// partidaEnCurso
		System.out.println("\nPARTIDA ACTUAL");
		
		System.out.println(actual.getNumeroPartida() + ": " + actual.getTextoAdivinado());
		System.out.println("PISTA: " + actual.getPeliculaPartida().getPista());
		System.out.println(actual.isFinalizada() ? "Finalizada" : "En curso");

		String letra = new String();
		char letraChar = '9';
		while (!actual.isFinalizada()) {
			System.out.println("Adivina una letra: ");
			 
			try {
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				letra = bufferRead.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			letra = letra.toUpperCase(); // convierte la letra a mayuscula
			letraChar = letra.charAt(0); // cambia el String con la letra a 1 char
			
			if (letraChar == '0') {				// arriesga la pelicula
				String peliculaArriesgada = new String();
				System.out.println("Arriesga el titulo de la pelicula: ");
				try {
				    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				    peliculaArriesgada = bufferRead.readLine();
				} catch(IOException e) {
					e.printStackTrace();
				}
				peliculaArriesgada = peliculaArriesgada.replaceAll("\\s+", " "); 
				peliculaArriesgada = peliculaArriesgada.trim();
				peliculaArriesgada = peliculaArriesgada.toUpperCase();
				FachadaCapaLogica.getInstancia().arriesgarPelicula("Alex", "123", actual, peliculaArriesgada);
								
				
			} else {
				FachadaCapaLogica.getInstancia().ingresarCaracter("Alex", "123", letraChar);
			}
			System.out.println("Texto adivinado: " + actual.getTextoAdivinado());
			System.out.println("Puntaje: " + actual.getPuntajePartida());
		}
		
		//actual = new Partida();		
		actual = FachadaCapaLogica.getInstancia().partidaEnCurso("Alex", "123");			// partidaEnCurso
		System.out.println("\nPARTIDA ACTUAL");
		System.out.println(nueva.getNumeroPartida() + ": " + actual.getTextoAdivinado());
		System.out.println("PISTA: " + actual.getPeliculaPartida().getPista());
		System.out.println(actual.isFinalizada() ? "Finalizada" : "En curso");
		
		*/

	}
	
}
