package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import logica.IFachadaCapaLogica;
import logica.Jugador;
import logica.ManageString;
import logica.Partida;
import logica.Partidas;
import logica.Pelicula;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataLogin;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.*;

public class Cliente {

	public static void main(String[] args) throws ExceptionsJugadores, ExceptionsPeliculas, MalformedURLException, NotBoundException, ExceptionCodigoIncorrecto {
		try {
			IFachadaCapaLogica fachada = (IFachadaCapaLogica) Naming.lookup("//localhost:1099/cuenta"); 	// ALGO DEL SERVER 
			
			
			Jugador jugador = new Jugador("Alex","123");
			jugador.setPuntajeJugador(60);
			fachada.nuevoJugador(jugador);							// nuevoJugador
			
			jugador = new Jugador("Felipe", "456");
			jugador.setPuntajeJugador(60);
			fachada.nuevoJugador(jugador);							// nuevoJugador
			
			
			jugador = new Jugador("Gaston", "789");
			jugador.setPuntajeJugador(30);
			fachada.nuevoJugador(jugador);					// nuevoJugador

			DataJugador[] dataJugadores = fachada.listarJugadores();	// listarJugadores
			
			DataLogin log = fachada.logIn("Alex","123");
			System.out.println("Logueo correcto del Jugador: " + log.getNombre());		
			
			
			
			// muestra los jugadores
			System.out.println("\nJUGADORES");
			for (DataJugador elem: dataJugadores) {
				System.out.println(elem.getNombre() + " - " + elem.getCodigo() + " - PUNTAJE: " + elem.getPuntajeJugador());
			}
			
			// RANKING
			System.out.println("\nRANKING");
			DataJugador[] ranking = fachada.listarRanking();		// listarRanking
			int i = 1;
			for (DataJugador elem: ranking) {
				System.out.println(i + " - " + elem.getNombre() + " - " + elem.getCodigo() + " - PUNTAJE: " + elem.getPuntajeJugador());
				i++;
			}
			
			// PELICULAS
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

			
			
			//PARTIDAS
			Partidas partidas = new Partidas();
			
			//agrega partidas
			
			String textoAdivinado = ManageString.transformarTextoAdivinado(pelicula2.getTitulo());
			Partida partida1 = new Partida(1, textoAdivinado, pelicula2);
			partida1.setFinalizada(true);
			partidas.add(partida1);

			textoAdivinado = ManageString.transformarTextoAdivinado(pelicula5.getTitulo());
			Partida partida2 = new Partida(2, textoAdivinado, pelicula5);
			partida2.setFinalizada(true);
			partidas.add(partida2);

			textoAdivinado = ManageString.transformarTextoAdivinado(pelicula1.getTitulo());
			Partida partida3 = new Partida(3, textoAdivinado, pelicula1);
			partida3.setFinalizada(true);
			partidas.add(partida3);
			
			//Jugador alex = fachada.getJugadores().get("Alex");
			//alex.setPartidasJugador(partidas);
			
			Partida actual = fachada.partidaEnCurso("Alex", "123");		// partidaEnCurso
			System.out.println("\nPARTIDA ACTUAL");
			
			System.out.println(actual.getNumeroPartida() + ": " + actual.getTextoAdivinado());
			System.out.println(actual.getPeliculaPartida().getTitulo() + " - " + actual.getPeliculaPartida().getPista());
			System.out.println(actual.isFinalizada() ? "Finalizada" : "En curso");
			
			Partida nueva = new Partida();
			
			for (i = 1; i <= 2; i++) {
				System.out.println("\nPARTIDA NUEVA");
				nueva = fachada.nuevaPartida("Alex", "123");			// nuevaPartida
				if (nueva != null) {
					nueva.setFinalizada(true);
					System.out.println(nueva.getNumeroPartida() + ": " + nueva.getTextoAdivinado());
					System.out.println(nueva.getPeliculaPartida().getTitulo() + " - " + nueva.getPeliculaPartida().getPista());
					System.out.println(nueva.isFinalizada() ? "Finalizada" : "En curso");
				}
			}
			
			DataPartida[] partidasArre= fachada.listarPartidas("Alex");
						
			
				for(DataPartida elem: partidasArre)		{
					
					System.out.println ("\nNumero de partida: " + elem.getNumero());
					System.out.println ("Pelicula: " + elem.getPeliculaPartida().getTitulo());				
					System.out.println ("Puntaje de la partida: " + elem.getPuntajePartida());
					System.out.println ("Texto adivinado: " + elem.getTextoAdivinado());
					System.out.println ("Es acertada?: " + elem.isAcertada());
					System.out.println ("Esta finalizada?: " + elem.isFinalizada());
					
				}
			
				
			
		}
		catch (MalformedURLException e) {	e.printStackTrace(); }
		catch (RemoteException e) {	e.printStackTrace(); }
		catch (ExceptionsJugadores e) {e.printStackTrace(); }

	}

}

