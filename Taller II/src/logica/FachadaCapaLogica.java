package logica;

import java.util.TreeMap;

public class FachadaCapaLogica {
	private static FachadaCapaLogica instancia;
	private TreeMap<String, Jugador> jugadores;
	private TreeMap<String, Pelicula> peliculas;

	// constructor
	private FachadaCapaLogica() {
		jugadores = new TreeMap<String, Jugador>();
		peliculas = new TreeMap<String, Pelicula>();
	}

	// getters y setters
	public static FachadaCapaLogica getInstancia() {
		if (instancia == null) {
			instancia = new FachadaCapaLogica();
		}
		return instancia;
	}

	public TreeMap<String, Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(TreeMap<String, Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public TreeMap<String, Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(TreeMap<String, Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	// metodos de los requerimientos
	public void nuevaPelicula(Pelicula p) {
		String s = p.getTitulo();
		s.replaceAll("\\s+", " ");	// elimina los espacios blancos de sobra entre palabras
		s.trim();					// elimina espacios al principio y final del string (si hay)
		s.toUpperCase();			// convierte a mayusculas
		if (peliculas.containsKey(p.getClave())) {
			// error ya existe la pelicula
		}
		else {
			peliculas.put(p.getClave(), p);
			//pelicula agregada
		}
	}

	public DataPelicula[] listarPelicualas() {

	}

	public void nuevoJugador(Jugador j) {
		if (jugadores.containsKey(j.getClave())) {
			// error ya existe el jugador
		}
		else {
			jugadores.put(j.getClave(), j);
			//jugador agregado
		}
	}

	
	public DataJugador[] listarJugadores(String nombreJugador) {
	
	}
	
	public DataPartida[] listarPartidas() {
	
	}
	

	public void guardarCambios() {

	}

	public void logIn(String nombreJugador, String codigoJugador) {

	}

	public void nuevaPartida(String nombreJugador, String codigoJugador) {

	}

	public Partida partidaEnCurso(String nombreJugador, String codigoJugador) {
		
	}

	public void ingresarCaracter(String nombreJugador, String codigoJugador, Partida p, char c) {

	}

	public void arriesgarPelicula(String nombreJugador, String codigoJugador, Partida p) {

	}

	public DataJugador[] listarRanking() {

	}

}
