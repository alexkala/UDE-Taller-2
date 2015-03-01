import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;





import logica.IFachadaCapaLogica;
import logica.Jugador;
import logica.ManageString;
import logica.Partida;
import logica.Pelicula;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataLogin;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionPartidas;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
import logica.exceptions.ExceptionsPersistencia;


public class PruebaCliente2 {

	public static void main(String[] args) throws NotBoundException, ExceptionsJugadores, ExceptionsPeliculas, ExceptionCodigoIncorrecto, IOException, ExceptionPartidas, ClassNotFoundException, ExceptionsPersistencia {

		String url ="//" + ManageString.getProperty("ip")+ ":" + ManageString.getProperty("puerto")	+ "/" + ManageString.getProperty("nombre");		
		IFachadaCapaLogica fachada = (IFachadaCapaLogica) Naming.lookup(url); 	// ACCEDE AL SERVER 
		
		// ---------
		// JUGADORES
		// ---------
		Jugador jugador = new Jugador("Juan", "987");
		jugador.setPuntajeJugador(60);
		fachada.nuevoJugador(jugador);							// nuevoJugador

		jugador = new Jugador("Pedro", "654");
		jugador.setPuntajeJugador(60);
		fachada.nuevoJugador(jugador);							// nuevoJugador

		jugador = new Jugador("Alberto", "321");
		jugador.setPuntajeJugador(30);
		fachada.nuevoJugador(jugador);							// nuevoJugador

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
		
		// -----
		// LOGIN
		// -----
		
		System.out.println("\n\nLOGIN");
		DataLogin dataLogin = fachada.logIn("Pedro", "654");
		System.out.println(dataLogin.getNombre());
		System.out.println(dataLogin.getCodigo());
		
		// ---------
		// PELICULAS
		// ---------
		Pelicula pelicula1 = new Pelicula("Titanes del pacifico", "Ciencia Ficcion");
		Pelicula pelicula2 = new Pelicula("LA CARRETERA", "Drama");
		Pelicula pelicula3 = new Pelicula("EL JUICIO DE CASEY ANTHONY ", "Drama");

		fachada.nuevaPelicula(pelicula1);							// nuevaPelicula
		fachada.nuevaPelicula(pelicula2);							// nuevaPelicula
		fachada.nuevaPelicula(pelicula3);							// nuevaPelicula

		DataPelicula[] dataPeliculas = fachada.listarPeliculas();	// listarPeliculas
		
		// muestra las peliculas
		System.out.println("\nPELICULAS");
		for (DataPelicula elem : dataPeliculas) {
			System.out.println(elem.getTitulo() + " - " + elem.getPista());
		}
		
		
		// --------
		// PARTIDAS
		// --------
		//Partida nueva = new Partida();		
		Partida nueva = fachada.nuevaPartida(dataLogin.getNombre(), dataLogin.getCodigo());			// nuevaPartida
		System.out.println("\nPARTIDA NUEVA");
		System.out.println(nueva.getNumeroPartida() + ": " + nueva.getTextoAdivinado());
		System.out.println("PISTA: " + nueva.getPeliculaPartida().getPista());
		System.out.println(nueva.isFinalizada() ? "Finalizada" : "En curso");
		
		DataPartida[] dataPartidas = fachada.listarPartidas(dataLogin.getNombre());
		System.out.println("\n\nPARTIDAS ALEX\n");
		for (DataPartida elem: dataPartidas) {
			System.out.println("\nPARTIDA " + elem.getNumero());
			System.out.println("TEXTO ADIVINADO: " + elem.getTextoAdivinado());
			System.out.println("PISTA: " + elem.getPeliculaPartida().getPista());
			System.out.println("PUNTAJE: " + elem.getPuntajePartida());
			System.out.println(elem.isFinalizada() ? "Finalizada" : "En curso");
		}
		
		
		String letra = new String();
		char letraChar = '9';
		while (!nueva.isFinalizada()) {
			System.out.println("Adivina una letra (0 para arriesgar): ");
			 
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
				nueva = fachada.arriesgarPelicula(dataLogin.getNombre(), dataLogin.getCodigo(), peliculaArriesgada);
								
				
			} else {
				nueva = fachada.ingresarCaracter(dataLogin.getNombre(), dataLogin.getCodigo(), letraChar);
			}
			System.out.println("Texto adivinado: " + nueva.getTextoAdivinado());
			System.out.println("Puntaje: " + nueva.getPuntajePartida());
		}
		
		Partida actual = new Partida();		
		actual = fachada.partidaEnCurso(dataLogin.getNombre(), dataLogin.getCodigo());			// partidaEnCurso
		System.out.println("\nPARTIDA ACTUAL");
		System.out.println(actual.getNumeroPartida() + ": " + actual.getTextoAdivinado());
		System.out.println("PISTA: " + nueva.getPeliculaPartida().getPista());
		System.out.println(actual.isFinalizada() ? "Finalizada" : "En curso");

		dataJugadores = fachada.listarJugadores();	// listarJugadores

		// muestra los jugadores
		System.out.println("\nJUGADORES");
		for (DataJugador elem: dataJugadores) {
			System.out.println(elem.getNombre() + " - " + elem.getCodigo() + " - PUNTAJE: " + elem.getPuntajeJugador());
		}
		
		fachada.guardarCambios();

		// -------
		// RANKING
		// -------
		System.out.println("\nRANKING");
		DataJugador[] rankingFinal = fachada.listarRanking();		// listarRanking
		i = 1;
		for (DataJugador elem: rankingFinal) {
			System.out.println(i + " - " + elem.getNombre() + " - " + elem.getCodigo() + " - PUNTAJE: " + elem.getPuntajeJugador());
			i++;
		}
		
		
	}
}
