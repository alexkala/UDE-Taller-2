package logica;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataLogin;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;

public interface IFachadaCapaLogica extends Remote {
	
	public String pruebaRemoto() throws RemoteException;
	
	public void nuevaPelicula(Pelicula pelicula) throws RemoteException, ExceptionsPeliculas;
	
	public DataPelicula[] listarPeliculas() throws RemoteException, ExceptionsPeliculas;
	
	public void nuevoJugador(Jugador j) throws RemoteException, ExceptionsJugadores;
	
	public DataJugador[] listarJugadores() throws RemoteException, ExceptionsJugadores;
	
	public DataPartida[] listarPartidas(String nombreJugador) throws RemoteException, ExceptionsJugadores;
	
	public void guardarCambios() throws RemoteException, IOException;
	
	public DataLogin logIn(String nombreJugador, String codigoJugador) throws RemoteException,ExceptionsJugadores, ExceptionCodigoIncorrecto ;
	
	public Partida nuevaPartida(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionsJugadores, ExceptionsPeliculas;
	
	public Partida partidaEnCurso(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionsJugadores;
	
	public void ingresarCaracter(String nombreJugador, String codigoJugador, Partida partida, char c) throws RemoteException;
	
	public void arriesgarPelicula(String nombreJugador, String codigoJugador, Partida partida, String peliculaArriesgada) throws RemoteException;
	
	public DataJugador[] listarRanking() throws RemoteException;

}
