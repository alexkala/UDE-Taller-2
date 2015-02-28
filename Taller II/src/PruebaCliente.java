import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import logica.FachadaCapaLogica;
import logica.IFachadaCapaLogica;
import logica.Jugador;
import logica.Partida;
import logica.Pelicula;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;


public class PruebaCliente {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, ExceptionsJugadores, ExceptionsPeliculas {
		IFachadaCapaLogica fachada = (IFachadaCapaLogica) Naming.lookup("//localhost:1099/cuenta"); 	// ALGO DEL SERVER 
		System.out.println(fachada.pruebaRemoto());	
		
		// ---------
		// JUGADORES
		// ---------
		Jugador jugador = new Jugador("Alex", "123");
		jugador.setPuntajeJugador(60);
		fachada.nuevoJugador(jugador);							// nuevoJugador
/*
		jugador = new Jugador("Gaston", "789");
		jugador.setPuntajeJugador(60);
		fachada.nuevoJugador(jugador);							// nuevoJugador

		jugador = new Jugador("Felipe", "456");
		jugador.setPuntajeJugador(30);
		fachada.nuevoJugador(jugador);							// nuevoJugador
*/
		DataJugador[] dataJugadores = fachada.listarJugadores();	// listarJugadores

		// muestra los jugadores
		System.out.println("\nJUGADORES");
		for (DataJugador elem: dataJugadores) {
			System.out.println(elem.getNombre() + " - " + elem.getCodigo() + " - PUNTAJE: " + elem.getPuntajeJugador());
		}
		
		// -------
		// RANKING
		// -------
		System.out.println("\nRANKING");
		DataJugador[] ranking = fachada.listarRanking();		// listarRanking
		int i = 1;
		for (DataJugador elem: ranking) {
			System.out.println(i + " - " + elem.getNombre() + " - " + elem.getCodigo() + " - PUNTAJE: " + elem.getPuntajeJugador());
			i++;
		}
		
		
		// ---------
		// PELICULAS
		// ---------
		Pelicula pelicula1 = new Pelicula("El francotirador", "Accion");
		Pelicula pelicula2 = new Pelicula("Birdman", "Humor negro");
		Pelicula pelicula3 = new Pelicula("Selma", "Drama");
		Pelicula pelicula4 = new Pelicula("La   teoria del todo  ", "Romance - Biografia");
		Pelicula pelicula5 = new Pelicula("Momentos de una vida", "Drama");

		fachada.nuevaPelicula(pelicula1);							// nuevaPelicula
		fachada.nuevaPelicula(pelicula2);							// nuevaPelicula
		fachada.nuevaPelicula(pelicula3);							// nuevaPelicula
		fachada.nuevaPelicula(pelicula4);							// nuevaPelicula
		fachada.nuevaPelicula(pelicula5);							// nuevaPelicula

		DataPelicula[] dataPeliculas = fachada.listarPeliculas();	// listarPeliculas
		
		// muestra las peliculas
		System.out.println("\nPELICULAS");
		for (DataPelicula elem : dataPeliculas) {
			System.out.println(elem.getTitulo() + " - " + elem.getPista());
		}
		
		
		// --------
		// PARTIDAS
		// --------
		Partida nueva = new Partida();		
		nueva = fachada.nuevaPartida("Alex", "123");			// nuevaPartida
		System.out.println("\nPARTIDA NUEVA");
		System.out.println(nueva.getNumeroPartida() + ": " + nueva.getTextoAdivinado());
		System.out.println("PISTA: " + nueva.getPeliculaPartida().getPista());
		System.out.println(nueva.isFinalizada() ? "Finalizada" : "En curso");
		
		
		
		
		String letra = new String();
		char letraChar = '9';
		while (letraChar != '1') {
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
				fachada.arriesgarPelicula("Alex", "123", fachada.partidaEnCurso("Alex", "123"), peliculaArriesgada);
								
				
			} else {
				fachada.ingresarCaracter("Alex", "123", fachada.partidaEnCurso("Alex", "123"), letraChar);
			}
			System.out.println("Texto adivinado: " + nueva.getTextoAdivinado());
			System.out.println("Puntaje: " + nueva.getPuntajePartida());
		}
		
		Partida actual = new Partida();		
		actual = fachada.partidaEnCurso("Alex", "123");			// partidaEnCurso
		System.out.println("\nPARTIDA ACTUAL");
		System.out.println(nueva.getNumeroPartida() + ": " + nueva.getTextoAdivinado());
		System.out.println("PISTA: " + nueva.getPeliculaPartida().getPista());
		System.out.println(nueva.isFinalizada() ? "Finalizada" : "En curso");
		
		
		
		
		
		
		
		
		
		/*
		for (i = 1; i <= 3; i++) {
			System.out.println("\nPARTIDA NUEVA");
			nueva = fachada.nuevaPartida("Alex", "123");			// nuevaPartida
			if (nueva != null) {
				nueva.setFinalizada(true);
				System.out.println(nueva.getNumeroPartida() + ": " + nueva.getTextoAdivinado());
				System.out.println(nueva.getPeliculaPartida().getTitulo() + " - " + nueva.getPeliculaPartida().getPista());
				System.out.println(nueva.isFinalizada() ? "Finalizada" : "En curso");
			}
		}
		*/
	}
}
