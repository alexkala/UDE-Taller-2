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
		s = corregirTexto(s);
		p.setTitulo(s);
		if (peliculas.containsKey(p.getClave())) {
			System.out.println("Error: ya existe la pelicula");
			// Error: ya existe la pelicula
		}
		else {
			peliculas.put(p.getClave(), p);
			System.out.println("Pelicula agregada");
			// Error: pelicula agregada
		}
	}

	public DataPelicula[] listarPelicualas() {

	}

	public void nuevoJugador(Jugador j) {
		if (jugadores.containsKey(j.getClave())) {
			// Error: ya existe el jugador
		}
		else {
			jugadores.put(j.getClave(), j);
			// Error: jugador agregado
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

	public Partida nuevaPartida(String nombreJugador, String codigoJugador) {

	}

	// PRECONDICION: tiene que haber al menos una partida
	public Partida partidaEnCurso(String nombreJugador, String codigoJugador) {		
		Jugador jugador = jugadores.get(nombreJugador);
		int indexUltimaPartida = jugador.getPartidasJugador().lastIndexOf(jugador);
		Partida actual = jugador.getPartidasJugador().get(indexUltimaPartida);
		return actual;
	}

	
	public void ingresarCaracter(String nombreJugador, String codigoJugador, Partida partida, char c) {
		
		int i = 0;
		int puntaje = partida.getPuntajePartida();
		boolean puntajeSumado = false;
		String textoAdivinado = partida.getTextoAdivinado();
		String tituloPelicula = partida.getPeliculaPartida().getTitulo();
		char[] textoAdivinadoChar = textoAdivinado.toCharArray();
		
		System.out.println("Letra: " + c);
		if (textoAdivinado.indexOf(c) == -1) { // verifica que la letra
														// no haya sido
														// adivinada previamente
			while (i != -1) {
				i = tituloPelicula.indexOf(c, i); // busca la posicion de la letra
											// ingresada
				if (i != -1) { // letra correcta
					textoAdivinadoChar[i] = c; // reemplaza la
														// ocurrencia de la
														// letra ingresada
					i++;
					if (!puntajeSumado) { // suma 1 punto
						puntaje = puntaje + 1;
						puntajeSumado = true;
					}
				} else { // letra erronea
					if (!puntajeSumado) { // resta 5 puntos
						System.out.println("Letra erronea!");
						puntaje = puntaje - 5;
						puntajeSumado = true;
					}
				}
			}
		} else {
			System.out.println("La letra ya fue ingresada previamente");
		}

		textoAdivinado = new String(textoAdivinadoChar); // convierte el texto
															// adivinado de
															// nuevo a String
		partida.setTextoAdivinado(textoAdivinado);
		partida.setPuntajePartida(puntaje);
		
		if (textoAdivinado.equals(tituloPelicula)) {					// adivino la pelicula
			System.out.println("Película adivinada!");
			// Error: pelicula adivinada
			partida.setAcertada(true);
			partida.setFinalizada(true);
		}
	}
	
	public void arriesgarPelicula(String nombreJugador, String codigoJugador, Partida partida, String peliculaArriesgada) {
		String tituloPelicula = partida.getPeliculaPartida().getTitulo();
		String textoAdivinado = partida.getTextoAdivinado();
		corregirTexto(peliculaArriesgada);
		
		if (peliculaArriesgada.equals(tituloPelicula)) {					// pelicula adivinada
			if (faltaUnaLetra(textoAdivinado, tituloPelicula)) {			// falta solo 1 letra (suma 1)
				System.out.println("Falta una letra");
				partida.setPuntajePartida(partida.getPuntajePartida() + 1);
			} else {														// falta mas de 1 letra (suma 50)
				System.out.println("Falta mas de una letra");
				partida.setPuntajePartida(partida.getPuntajePartida() + 50);
			}
			partida.setAcertada(true);
			partida.setTextoAdivinado(tituloPelicula);
			System.out.println("Película adivinada! :)");
			// Error: pelicula adivinada
		} else {													// pelicula errada
			partida.setPuntajePartida(partida.getPuntajePartida() - 50);
			partida.setAcertada(false);
			System.out.println("Película errada! :(");
			// Error: pelicula errada
		}
		partida.setFinalizada(true);
	}

	public DataJugador[] listarRanking() {

	}
	
	// Metodos auxiliares (privados)
	private String corregirTexto(String texto) {
		texto = texto.replaceAll("\\s+", " "); 	// elimina los espacios blancos de sobra entre palabras
		texto = texto.trim(); 					// elimina espacios al principio y final del string (si hay)
		texto = texto.toUpperCase(); 			// convierte a mayusculas
		return texto;
	}

	private boolean faltaUnaLetra(String textoAdivinado, String tituloPelicula) {
		int index = textoAdivinado.indexOf("-");
		char letraUnica = tituloPelicula.charAt(index);
		
		while (index != -1) {
			index = textoAdivinado.indexOf("-", index);
			if (index != -1) {
				if (letraUnica != tituloPelicula.charAt(index)) {
					return false;					
				} else {
					index++;
				}
			}
		}
		return true;
	}

}



