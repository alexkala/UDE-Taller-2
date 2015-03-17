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
import logica.exceptions.ExceptionPartidas;
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
	private Monitor MonitorJugadores;
	private Monitor MonitorPeliculas;

		
	// constructor
	private FachadaCapaLogica() throws ClassNotFoundException, IOException, ExceptionsPersistencia{
		this.MonitorJugadores = new Monitor();
		this.MonitorPeliculas = new Monitor();
		
		Persistencia persistencia = new Persistencia();
		try{
			Datos data = new Datos();
			data = persistencia.Recuperar(ManageString.getProperty("rutaRespaldo"));
			this.jugadores = data.getJugadores();
			this.peliculas =  data.getPeliculas();

		}catch(ExceptionsPersistencia e)
		{
			jugadores = new Jugadores();
			peliculas = new Peliculas();
		}
		
	}

	// getters y setters
	public static FachadaCapaLogica getInstancia() throws ClassNotFoundException, IOException, ExceptionsPersistencia{
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
		MonitorPeliculas.comienzoEscritura();
		String s = pelicula.getTitulo();
		s = ManageString.corregirTexto(s);
		pelicula.setTitulo(s);
		if (peliculas.containsKey(pelicula.getClave())) {
			MonitorPeliculas.terminoEscritura();			
			throw new ExceptionsPeliculas("Error: ya existe la pelicula");
		}
		else {
			peliculas.put(pelicula.getClave(), pelicula);
			System.out.println("Pelicula agregada");
			MonitorPeliculas.terminoEscritura();
		}
	}
	// Requerimiento 2: Listar Peliculas
	public DataPelicula[] listarPeliculas() throws RemoteException {
			MonitorPeliculas.comienzoLectura();
			DataPelicula[]  result = peliculas.obtenerPeliculas();
			MonitorPeliculas.terminoLectura();
			return  result;
	}
	// Requerimiento 3: Registrar Nuevo Jugador
	public void nuevoJugador(Jugador j) throws RemoteException, ExceptionsJugadores {
		MonitorJugadores.comienzoEscritura();
		String s = j.getNombre();
		s = ManageString.corregirTexto(s);
		j.setNombre(s);
		if (jugadores.containsKey(j.getClave())) {
			MonitorJugadores.terminoEscritura();
			throw new ExceptionsJugadores("Error: ya existe  el jugador");
			
		}
		else {
			jugadores.put(j.getClave(), j);
			System.out.println("Jugador agregado");
		}
		MonitorJugadores.terminoEscritura();
	}

	//Requerimiento 4: Listar Jugadores
	public DataJugador[] listarJugadores() throws RemoteException {	
		MonitorJugadores.comienzoLectura();
		DataJugador[] result =  jugadores.obtenerJugadores();
		MonitorJugadores.terminoLectura();
		return result;
	}
	
	//Requerimiento 5: Listar Partidas De Un Jugador
	public DataPartida[] listarPartidas(String nombreJugador) throws ExceptionsJugadores {
			MonitorJugadores.comienzoEscritura();
			if(jugadores.containsKey(nombreJugador)){
				if (jugadores.get(nombreJugador).getPartidasJugador() != null){	
					Jugador jugador= jugadores.get(nombreJugador);
					DataPartida[] partidasArre= jugador.getPartidasJugador().obtenerPartidas();
					MonitorJugadores.terminoEscritura();
					return partidasArre;									
				}else{
					MonitorJugadores.terminoEscritura();
					throw new ExceptionsJugadores("Error: el jugador no tiene partidas");
				}
			}
			else{
				MonitorJugadores.terminoEscritura();
				throw new ExceptionsJugadores("Error: no existe el jugador");
			}
			
				
	}
	//Requerimiento 6: Guardar Cambios
	public void guardarCambios() throws RemoteException, IOException {
		MonitorJugadores.comienzoEscritura();
		MonitorPeliculas.comienzoEscritura();
		String path = ManageString.getProperty("rutaRespaldo");
		Persistencia db = new Persistencia();
		Datos datos = new Datos(getPeliculas(), getJugadores());
		db.Respaldar(datos, path);
		System.out.println("Se guardo correctamente.");
		MonitorJugadores.terminoEscritura();
		MonitorPeliculas.terminoEscritura();
		
	}
	

	//Requerimiento 7: Loguearse Para Jugar
	public DataLogin logIn(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionsJugadores, ExceptionCodigoIncorrecto {
		   // nombreJugador = ManageString.corregirTexto(nombreJugador);
			System.out.println(nombreJugador);
			MonitorJugadores.comienzoLectura();
			if(jugadores.containsKey(nombreJugador)) {
				Jugador jugador = jugadores.get(nombreJugador);
				String password = jugador.getCodigo();
				System.out.println("password: " + password);
				System.out.println("codigoJugador: " + codigoJugador);
					if(password.equals(codigoJugador)) {
						DataLogin login = new DataLogin(nombreJugador,codigoJugador);
						MonitorJugadores.terminoLectura();
						return login;
					}
					else {
						MonitorJugadores.terminoLectura();
						throw new ExceptionCodigoIncorrecto("Error: Codigo incorrecto");
					}
			}
			else {
				MonitorJugadores.terminoLectura();
				throw new ExceptionsJugadores("Error: no existe  el jugador con dicho nombre");
			}
	}	

	
	//Requerimiento 8: Iniciar Nueva Partida
	public Partida nuevaPartida(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionPartidas, ExceptionsPeliculas {
		//MonitorJugadores.comienzoEscritura();
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
				//MonitorJugadores.terminoEscritura();
				throw new ExceptionPartidas("Error: Ya hay una partida en curso");
			}
		} else {												// si no tiene partidas
			partidas = new Partidas();
			numeroPartida = 1;
		}
		//MonitorPeliculas.comienzoLectura();
		Pelicula peliculaPartida = peliculas.randomPelicula(partidas);			// Elije una pelicula al azar
		//MonitorPeliculas.terminoLectura();
		if (peliculaPartida != null) {								// randomPelicula pudo devolver una pelicula
			String textoAdivinado = ManageString.transformarTextoAdivinado(peliculaPartida.getTitulo());		// crea textoAdivinado a partir del titulo
			Partida nuevaPartida = new Partida(numeroPartida, textoAdivinado, peliculaPartida);
			partidas.add(nuevaPartida);
			jugador.setPartidasJugador(partidas);
			//MonitorJugadores.terminoEscritura();
			return nuevaPartida;
		}
		//MonitorJugadores.terminoEscritura();
		return null;
	}
	//Requerimiento 9: Visualizar Partida En Curso
	public Partida partidaEnCurso(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionsJugadores {		
		MonitorJugadores.comienzoLectura();
		if (jugadores.get(nombreJugador).getPartidasJugador() != null){		// El jugador tiene al menos una partida
			Jugador jugador = jugadores.get(nombreJugador);
			int indexUltimaPartida = jugador.getPartidasJugador().size() - 1;
			Partida actual = jugador.getPartidasJugador().get(indexUltimaPartida);
			MonitorJugadores.terminoLectura();
			return actual;
		}
		else {
			MonitorJugadores.terminoLectura();
			throw new ExceptionsJugadores("Error: el jugador no tiene partidas");
				
		}
	}
	
	//Requerimiento 10: Ingresar Un Caracter
	public Partida ingresarCaracter(String nombreJugador, String codigoJugador, char c) throws RemoteException, ExceptionsJugadores, ExceptionPartidas {
		Partida partida = partidaEnCurso(nombreJugador, codigoJugador);
		Jugador jugador = jugadores.get(nombreJugador);
		
		MonitorJugadores.comienzoEscritura();
		c = Character.toUpperCase(c);
		int i = 0;
		int puntajeJugador=0;
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
						puntajeJugador=1;
						//jugador.setCantAciertos(jugador.getCantAciertos() + 1);
					}
				} else { // letra erronea
					if (!puntajeSumado) { // resta 5 puntos
						System.out.println("Letra erronea!");
						puntaje = puntaje - 5;
						puntajeSumado = true;
						puntajeJugador=-5;
						//jugador.setCantErrores(jugador.getCantErrores() + 1);
					}
				}
			}
		} else {
			MonitorJugadores.terminoEscritura();
			throw new ExceptionPartidas("La letra ya fue ingresada previamente");
			
		}

		textoAdivinado = new String(textoAdivinadoChar); // convierte el texto adivinado de nuevo a String
		partida.setTextoAdivinado(textoAdivinado);
		partida.setPuntajePartida(puntaje);
		jugador.setPuntajeJugador(jugador.getPuntajeJugador() + puntajeJugador);
		
		if (textoAdivinado.equals(tituloPelicula)) {					// adivino la pelicula
			System.out.println("Película adivinada!");
			partida.setAcertada(true);
			partida.setFinalizada(true);
			
			jugador.setCantAciertos(jugador.getCantAciertos() + 1);
		}
		MonitorJugadores.terminoEscritura();
		return partida;
	}
	
	//Requerimiento 11: Arriesgar Pelicula
	public Partida arriesgarPelicula(String nombreJugador, String codigoJugador, String peliculaArriesgada) throws RemoteException, ExceptionsJugadores {
		Partida partida = partidaEnCurso(nombreJugador, codigoJugador);
		int puntaje=0;
		MonitorJugadores.comienzoEscritura();
		Jugador jugador = jugadores.get(nombreJugador);

		MonitorPeliculas.comienzoLectura();
		String tituloPelicula = partida.getPeliculaPartida().getTitulo();
		MonitorPeliculas.terminoLectura();

		String textoAdivinado = partida.getTextoAdivinado();
	
		ManageString.corregirTexto(peliculaArriesgada);
		
		if (peliculaArriesgada.equals(tituloPelicula)) {					// pelicula adivinada
			if (ManageString.faltaUnaLetra(textoAdivinado, tituloPelicula)) {			// falta solo 1 letra (suma 1)
				System.out.println("Falta una letra");
				partida.setPuntajePartida(partida.getPuntajePartida() + 1);
				puntaje=1;
			} else {														// falta mas de 1 letra (suma 50)
				System.out.println("Falta mas de una letra");
				partida.setPuntajePartida(partida.getPuntajePartida() + 50);
				puntaje=50;
			}
			partida.setAcertada(true);
			partida.setTextoAdivinado(tituloPelicula);
			jugador.setCantAciertos(jugador.getCantAciertos() + 1);
			System.out.println("Película adivinada! :)");

		} else {													// pelicula errada
			partida.setPuntajePartida(partida.getPuntajePartida() - 50);
			partida.setAcertada(false);
			jugador.setCantErrores(jugador.getCantErrores() + 1);
			puntaje=-50;
			System.out.println("Película errada! :(");
		}

		partida.setFinalizada(true);
		jugador.setPuntajeJugador(jugador.getPuntajeJugador() + puntaje);
		MonitorJugadores.terminoEscritura();
		return partida;
	}
	//Requerimiento 12: Ranking General
	public DataJugador[] listarRanking() throws ClassNotFoundException, IOException, ExceptionsPersistencia {
			MonitorJugadores.comienzoLectura();
			/*
			Jugadores ranking = new Jugadores();
			Persistencia db = new Persistencia();
			Datos d = db.Recuperar(ManageString.getProperty("rutaRespaldo"));
			ranking = d.getJugadores();
			*/
			
			DataJugador[] dataRanking = jugadores.obtenerJugadores();
			Arrays.sort(dataRanking);
			
			MonitorJugadores.terminoLectura();
			return dataRanking;
	}
}

