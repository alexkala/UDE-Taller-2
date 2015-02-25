import logica.Jugador;
import logica.Jugadores;
import logica.Partida;
import logica.Partidas;
import logica.Pelicula;
import logica.Peliculas;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataPelicula;
import logica.ManageString;

public class PruebaDiccionarios {

	public static void main(String[] args) {
		// JUGADORES
		Jugador jugador1 = new Jugador("Alex", "123");
		Jugador jugador2 = new Jugador("Felipe", "456");
		Jugador jugador3 = new Jugador("Gaston", "789");

		Jugadores jugadores = new Jugadores();

		jugadores.put(jugador2.getClave(), jugador2);
		jugadores.put(jugador3.getClave(), jugador3);
		jugadores.put(jugador1.getClave(), jugador1);

		DataJugador[] dataJugadores = jugadores.obtenerJugadores();
		System.out.println("JUGADORES");
		for (DataJugador elem : dataJugadores) {
			System.out.println(elem.getNombre() + " - " + elem.getCodigo());
		}

		// PELICULAS
		Pelicula pelicula1 = new Pelicula("El francotirador", "Accion");
		Pelicula pelicula2 = new Pelicula("Birdman", "Humor negro");
		Pelicula pelicula3 = new Pelicula("Selma", "Drama");
		Pelicula pelicula4 = new Pelicula("La teoria del todo",
				"Romance - Biografia");
		Pelicula pelicula5 = new Pelicula("Momentos de una vida", "Drama");

		Peliculas peliculas = new Peliculas();

		peliculas.put(pelicula1.getClave(), pelicula1);
		peliculas.put(pelicula2.getClave(), pelicula2);
		peliculas.put(pelicula3.getClave(), pelicula3);
		peliculas.put(pelicula4.getClave(), pelicula4);
		peliculas.put(pelicula5.getClave(), pelicula5);

		DataPelicula[] dataPeliculas = peliculas.obtenerPeliculas();
		System.out.println("\nPELICULAS");
		for (DataPelicula elem : dataPeliculas) {
			System.out.println(elem.getTitulo() + " - " + elem.getPista());
		}
		
		// PARTIDAS
		Partidas partidas = new Partidas();
		
		String textoAdivinado = ManageString.transformarTextoAdivinado(pelicula2.getTitulo());
		Partida partida1 = new Partida(0, textoAdivinado, pelicula2);
		partidas.add(partida1);
		
		textoAdivinado = ManageString.transformarTextoAdivinado(pelicula5.getTitulo());
		Partida partida2 = new Partida(0, textoAdivinado, pelicula5);
		partidas.add(partida2);
		
		textoAdivinado = ManageString.transformarTextoAdivinado(pelicula1.getTitulo());
		Partida partida3 = new Partida(0, textoAdivinado, pelicula1);
		partidas.add(partida3);
		
		Pelicula peliculaNueva = peliculas.randomPelicula(partidas);
		System.out.println("\nPELICULA NUEVA: " + peliculaNueva.getTitulo() + " - " + peliculaNueva.getPista());
		

	}
}
