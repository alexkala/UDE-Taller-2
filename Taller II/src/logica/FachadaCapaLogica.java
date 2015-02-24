package logica;

import java.util.Iterator;
import java.util.TreeMap;

import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataLogin;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;

public class FachadaCapaLogica {
	private static FachadaCapaLogica instancia;
	private Jugadores jugadores;
	private Peliculas peliculas;
	
	// constructor
	private FachadaCapaLogica() {
		jugadores = new Jugadores();
		peliculas = new Peliculas();
	}

	// getters y setters
	public static FachadaCapaLogica getInstancia() {
		if (instancia == null) {
			instancia = new FachadaCapaLogica();
		}
		return instancia;
	}

	public Jugadores getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugadores jugadores) {
		this.jugadores = jugadores;
	}

	public Peliculas getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Peliculas peliculas) {
		this.peliculas = peliculas;
	}

	// metodos de los requerimientos
	public void nuevaPelicula(Pelicula pelicula) throws ExceptionsPeliculas {
		String s = pelicula.getTitulo();
		s = corregirTexto(s);
		pelicula.setTitulo(s);
		if (peliculas.containsKey(pelicula.getClave())) {
			System.out.println("");
			 throw new ExceptionsPeliculas("Error: ya existe la pelicula");
		}
		else {
			peliculas.put(pelicula.getClave(), pelicula);
			System.out.println("Pelicula agregada");
			// Error: pelicula agregada Gaston
		}
	}

	public DataPelicula[] listarPeliculas() {
	
		return  peliculas.obtenerPeliculas();
	}

	public void nuevoJugador(Jugador j) throws ExceptionsJugadores {
		if (jugadores.containsKey(j.getClave())) {
			throw new ExceptionsJugadores("Error: ya existe la el jugador");
			
		}
		else {
			jugadores.put(j.getClave(), j);
			System.out.println("Jugador agregado");
		}
	}

	
	public DataJugador[] listarJugadores() {
				
		return jugadores.obtenerJugadores();
	}
	
	public DataPartida[] listarPartidas() {
		//Felipe
	}
	

	public void guardarCambios(String path) {
		//Gaston

	}

	public DataLogin logIn(String nombreJugador, String codigoJugador) {
		//Felipe
	}

	public Partida nuevaPartida(String nombreJugador, String codigoJugador) {
		//Alex
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
			//Alex
	}
	
	// Metodos auxiliares (privados)Felipe
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



