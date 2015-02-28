package logica;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataLogin;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
import logica.exceptions.ExceptionsPersistencia;
import persistencia.*;
import logica.ManageString;

public class FachadaCapaLogica extends UnicastRemoteObject implements IFachadaCapaLogica {
	
	private static final long serialVersionUID = 1L;
	private static FachadaCapaLogica instancia;
	private Jugadores jugadores;
	private Peliculas peliculas;
		
	// constructor
	private FachadaCapaLogica() throws RemoteException{
		jugadores = new Jugadores();
		peliculas = new Peliculas();
	}

	// getters y setters
	public static FachadaCapaLogica getInstancia() throws RemoteException{
		if (instancia == null) {
			instancia = new FachadaCapaLogica();
		}
		return instancia;
	}

	public Jugadores getJugadores() throws RemoteException {
		return jugadores;
	}

	public void setJugadores(Jugadores jugadores) throws RemoteException {
		this.jugadores = jugadores;
	}

	public Peliculas getPeliculas() throws RemoteException {
		return peliculas;
	}

	public void setPeliculas(Peliculas peliculas) throws RemoteException {
		this.peliculas = peliculas;
	}

	// metodos de los requerimientos:
	
	// Requerimientos Administrador:
	
	// Requerimiento 1: Registrar Nueva Pelicula
	public void nuevaPelicula(Pelicula pelicula) throws RemoteException, ExceptionsPeliculas {
		String s = pelicula.getTitulo();
		s = ManageString.corregirTexto(s);
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
	// Requerimiento 2: Listar Peliculas
	public DataPelicula[] listarPeliculas() throws RemoteException {
	
		return  peliculas.obtenerPeliculas();
	}
	// Requerimiento 3: Registrar Nuevo Jugador
	public void nuevoJugador(Jugador j) throws RemoteException, ExceptionsJugadores {
		if (jugadores.containsKey(j.getClave())) {
			throw new ExceptionsJugadores("Error: ya existe  el jugador");
			
		}
		else {
			jugadores.put(j.getClave(), j);
			System.out.println("Jugador agregado");
		}
	}

	//Requerimiento 4: Listar Jugadores
	public DataJugador[] listarJugadores() throws RemoteException {		
		return jugadores.obtenerJugadores();
	}
	
	//Requerimiento 5: Listar Partidas De Un Jugador
	public DataPartida[] listarPartidas(String nombreJugador) throws ExceptionsJugadores {
		
			if(jugadores.containsKey(nombreJugador)){
				if (jugadores.get(nombreJugador).getPartidasJugador() != null){	
					Jugador jugador= jugadores.get(nombreJugador);
					DataPartida[] partidasArre= jugador.getPartidasJugador().obtenerPartidas();
					return partidasArre;									
				}else
					throw new ExceptionsJugadores("Error: el jugador no tiene partidas");
			}
			else
				throw new ExceptionsJugadores("Error: no existe el jugador");
				
	}
	//Requerimiento 6: Guardar Cambios
	public void guardarCambios() throws RemoteException, IOException {
		String path = ManageString.getRuta();
		Persistencia db = new Persistencia();
		Datos datos = new Datos(getPeliculas(), getJugadores());
		db.Respaldar(datos, path);
	}
	

	//Requerimiento 7: Loguearse Para Jugar
	public DataLogin logIn(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionsJugadores, ExceptionCodigoIncorrecto {
			
			if(jugadores.containsKey(nombreJugador)){
				Jugador jugador= jugadores.get(nombreJugador);
				String password = jugador.getCodigo();
					if(password==codigoJugador){
						DataLogin login= new DataLogin(nombreJugador,codigoJugador);
						return login;
					}
					else
						throw new ExceptionCodigoIncorrecto("Error: Codigo incorrecto");
			}
			else
				throw new ExceptionsJugadores("Error: no existe  el jugador con dicho nombre");
	}	

	
	//Requerimiento 8: Iniciar Nueva Partida
	public Partida nuevaPartida(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionsJugadores, ExceptionsPeliculas {
		
		System.out.println("\n\n--------------- \n" + nombreJugador);
		System.out.println(jugadores == null);
		Jugador jugador = jugadores.get(nombreJugador);
		System.out.println(jugador == null);
		Partidas partidas = jugador.getPartidasJugador();
		System.out.println(jugador.getPartidasJugador() == null);
		int numeroPartida;
		if (partidas != null) {																			// si tiene partidas
			int indexUltimaPartida = jugador.getPartidasJugador().size() - 1;
			Partida actual = jugador.getPartidasJugador().get(indexUltimaPartida);
			if (actual.isFinalizada()) {												// Jugador tiene una partida sin finalizar
				numeroPartida = partidas.size() + 1;
			} else {
				throw new ExceptionsJugadores("Error: Ya hay una partida en curso");
				// Error: Ya hay una partida en curso
			}
		} else {												// si no tiene partidas
			partidas = new Partidas();
			numeroPartida = 1;
		}
		Pelicula peliculaPartida = peliculas.randomPelicula(partidas);			// Elije una pelicula al azar
		if (peliculaPartida != null) {								// randomPelicula pudo devolver una pelicula
			String textoAdivinado = ManageString.transformarTextoAdivinado(peliculaPartida.getTitulo());		// crea textoAdivinado a partir del titulo
			Partida nuevaPartida = new Partida(numeroPartida, textoAdivinado, peliculaPartida);
			partidas.add(nuevaPartida);
			jugador.setPartidasJugador(partidas);
			return nuevaPartida;
		}
		return null;
	}
	//Requerimiento 9: Visualizar Partida En Curso
	public Partida partidaEnCurso(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionsJugadores {		
		if (jugadores.get(nombreJugador).getPartidasJugador() != null){		// El jugador tiene al menos una partida
			Jugador jugador = jugadores.get(nombreJugador);
			int indexUltimaPartida = jugador.getPartidasJugador().size() - 1;
			Partida actual = jugador.getPartidasJugador().get(indexUltimaPartida);
			return actual;
		}
		else {
			throw new ExceptionsJugadores("Error: el jugador no tiene partidas");
				
		}
	}
	
	//Requerimiento 10: Ingresar Un Caracter
	public void ingresarCaracter(String nombreJugador, String codigoJugador, Partida partida, char c) throws RemoteException {
		c = Character.toUpperCase(c);
		int i = 0;
		int puntaje = partida.getPuntajePartida();
		boolean puntajeSumado = false;
		String textoAdivinado = partida.getTextoAdivinado();
		String tituloPelicula = partida.getPeliculaPartida().getTitulo();
		char[] textoAdivinadoChar = textoAdivinado.toCharArray();
		
		System.out.println("Letra: " + c);
		if (textoAdivinado.indexOf(c) == -1) { // verifica que la letra no haya sido adivinada previamente
			while (i != -1) {
				i = tituloPelicula.indexOf(c, i); // busca la posicion de la letra ingresada
				if (i != -1) { // letra correcta
					textoAdivinadoChar[i] = c; // reemplaza la ocurrencia de la letra ingresada
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

		textoAdivinado = new String(textoAdivinadoChar); // convierte el texto adivinado de nuevo a String
		partida.setTextoAdivinado(textoAdivinado);
		partida.setPuntajePartida(puntaje);
		
		if (textoAdivinado.equals(tituloPelicula)) {					// adivino la pelicula
			System.out.println("Película adivinada!");
			// Error: pelicula adivinada
			partida.setAcertada(true);
			partida.setFinalizada(true);
		}
	}
	
	//Requerimiento 11: Arriesgar Pelicula
	public void arriesgarPelicula(String nombreJugador, String codigoJugador, Partida partida, String peliculaArriesgada) throws RemoteException {
		String tituloPelicula = partida.getPeliculaPartida().getTitulo();
		String textoAdivinado = partida.getTextoAdivinado();
	
		ManageString.corregirTexto(peliculaArriesgada);
		
		if (peliculaArriesgada.equals(tituloPelicula)) {					// pelicula adivinada
			if (ManageString.faltaUnaLetra(textoAdivinado, tituloPelicula)) {			// falta solo 1 letra (suma 1)
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
	//Requerimiento 12: Ranking General
	public DataJugador[] listarRanking() throws RemoteException {
			Jugadores ranking = new Jugadores(jugadores);
			DataJugador[] dataRanking = ranking.obtenerJugadores();
			Arrays.sort(dataRanking);
			return dataRanking;
	}

	public String pruebaRemoto() throws RemoteException {
		return "HOLA MUNDO REMOTO";
	}
}

