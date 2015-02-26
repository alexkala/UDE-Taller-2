package logica;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataLogin;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;

public interface IFachadaCapaLogica extends Remote {
	/*
	public void nuevaPelicula(Pelicula pelicula) throws RemoteException, ExceptionsPeliculas;
	
	public DataPelicula[] listarPeliculas() throws RemoteException, ExceptionsPeliculas;
	
	public void nuevoJugador(Jugador j) throws RemoteException, ExceptionsJugadores;
	
	public DataJugador[] listarJugadores() throws RemoteException, ExceptionsJugadores;
	
	public DataPartida[] listarPartidas() throws RemoteException;
	
	public void guardarCambios() throws RemoteException, IOException;
	
	public DataLogin logIn(String nombreJugador, String codigoJugador) throws RemoteException;
	
	public Partida nuevaPartida(String nombreJugador, String codigoJugador) throws RemoteException;
	
	public Partida partidaEnCurso(String nombreJugador, String codigoJugador) throws RemoteException;
	
	public void ingresarCaracter(String nombreJugador, String codigoJugador, Partida partida, char c) throws RemoteException;
	
	public void arriesgarPelicula(String nombreJugador, String codigoJugador, Partida partida, String peliculaArriesgada) throws RemoteException;
	
	public DataJugador[] listarRanking() throws RemoteException;
*/
}
