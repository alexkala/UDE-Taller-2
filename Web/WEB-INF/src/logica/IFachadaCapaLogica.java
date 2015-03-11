package logica;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataLogin;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionPartidas;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
import logica.exceptions.ExceptionsPersistencia;

public interface IFachadaCapaLogica extends Remote {
	
	public void nuevaPelicula(Pelicula pelicula) throws RemoteException, ExceptionsPeliculas;
	
	public DataPelicula[] listarPeliculas() throws RemoteException, ExceptionsPeliculas;
	
	public void nuevoJugador(Jugador j) throws RemoteException, ExceptionsJugadores;
	
	public DataJugador[] listarJugadores() throws RemoteException, ExceptionsJugadores;
	
	public DataPartida[] listarPartidas(String nombreJugador) throws RemoteException, ExceptionsJugadores;
	
	public void guardarCambios() throws RemoteException, IOException;
	
	public DataLogin logIn(String nombreJugador, String codigoJugador) throws RemoteException,ExceptionsJugadores, ExceptionCodigoIncorrecto ;
	
	public Partida nuevaPartida(String nombreJugador, String codigoJugador) throws RemoteException,ExceptionPartidas,  ExceptionsPeliculas;
	
	public Partida partidaEnCurso(String nombreJugador, String codigoJugador) throws RemoteException, ExceptionsJugadores;
	
	public Partida ingresarCaracter(String nombreJugador, String codigoJugador, char c) throws RemoteException, ExceptionsJugadores, ExceptionPartidas;
	
	public Partida arriesgarPelicula(String nombreJugador, String codigoJugador, String peliculaArriesgada) throws RemoteException, ExceptionsJugadores;
	
	public DataJugador[] listarRanking() throws RemoteException, ClassNotFoundException, IOException, ExceptionsPersistencia;

}
