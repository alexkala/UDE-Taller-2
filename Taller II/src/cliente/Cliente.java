package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import logica.FachadaCapaLogica;
import logica.IFachadaCapaLogica;
import logica.Jugador;
import logica.ManageString;
import logica.Partida;
import logica.Pelicula;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.*;

public class Cliente {

	public static void main(String[] args) throws ExceptionsJugadores, ExceptionsPeliculas, MalformedURLException, NotBoundException {
		try {
			IFachadaCapaLogica fachada = (IFachadaCapaLogica) Naming.lookup("//pc00197:1099/cuenta"); 	// ALGO DEL SERVER 
			
			
			Jugador jugador = new Jugador("Alex", "123");
			jugador.setPuntajeJugador(60);
			FachadaCapaLogica.getInstancia().nuevoJugador(jugador);							// nuevoJugador
			
			jugador = new Jugador("Gaston", "789");
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
			ArrayList<Partida> partidas = new ArrayList<Partida>();
			
			// agrega partidas
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
			
			Jugador alex = FachadaCapaLogica.getInstancia().getJugadores().get("Alex");
			alex.setPartidasJugador(partidas);
			
			Partida actual = FachadaCapaLogica.getInstancia().partidaEnCurso("Alex", "123");		// partidaEnCurso
			System.out.println("\nPARTIDA ACTUAL");
			
			System.out.println(actual.getNumeroPartida() + ": " + actual.getTextoAdivinado());
			System.out.println(actual.getPeliculaPartida().getTitulo() + " - " + actual.getPeliculaPartida().getPista());
			System.out.println(actual.isFinalizada() ? "Finalizada" : "En curso");
			
			Partida nueva = new Partida();
			
			for (i = 1; i <= 2; i++) {
				System.out.println("\nPARTIDA NUEVA");
				nueva = FachadaCapaLogica.getInstancia().nuevaPartida("Alex", "123");			// nuevaPartida
				if (nueva != null) {
					nueva.setFinalizada(true);
					System.out.println(nueva.getNumeroPartida() + ": " + nueva.getTextoAdivinado());
					System.out.println(nueva.getPeliculaPartida().getTitulo() + " - " + nueva.getPeliculaPartida().getPista());
					System.out.println(nueva.isFinalizada() ? "Finalizada" : "En curso");
				}
			}
			
		}
		catch (MalformedURLException e) {	e.printStackTrace(); }
		catch (RemoteException e) {	e.printStackTrace(); }
		catch (ExceptionsJugadores e) {e.printStackTrace(); }

	}

}
