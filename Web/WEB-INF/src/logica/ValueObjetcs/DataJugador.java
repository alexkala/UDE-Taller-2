package logica.ValueObjetcs;
import java.io.*;
import java.util.ArrayList;

import logica.Jugador;
import logica.Partida;
import logica.Partidas;

public class DataJugador implements Serializable, Comparable<DataJugador> {


	private static final long serialVersionUID = 1L;

	private String nombre;
	private String codigo;
	private int puntajeJugador;
	private int cantAciertos;
	private int cantErrores;
	private Partidas partidasJugador;
	
	public DataJugador(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	public DataJugador(String nombre, String codigo, int puntajeJugador,
			int cantAciertos, int cantErrores,
			Partidas partidasJugador) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.puntajeJugador = puntajeJugador;
		this.cantAciertos = cantAciertos;
		this.cantErrores = cantErrores;
		this.partidasJugador = partidasJugador;
	}
	
	
	public String getClave() {
		return nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getPuntajeJugador() {
		return puntajeJugador;
	}
	public void setPuntajeJugador(int puntajeJugador) {
		this.puntajeJugador = puntajeJugador;
	}
	public int getCantAciertos() {
		return cantAciertos;
	}
	public void setCantAciertos(int cantAciertos) {
		this.cantAciertos = cantAciertos;
	}
	public int getCantErrores() {
		return cantErrores;
	}
	public void setCantErrores(int cantErrores) {
		this.cantErrores = cantErrores;
	}
	public Partidas getPartidasJugador() {
		return partidasJugador;
	}
	public void setPartidasJugador(Partidas partidasJugador) {
		this.partidasJugador = partidasJugador;
	}
	
	public int compareTo(DataJugador j) {
		int compararPuntaje = ((DataJugador) j).getPuntajeJugador(); 
		 
		//ascending order
		//return this.puntajeJugador - compararPuntaje;
 
		//descending order
		return compararPuntaje - this.puntajeJugador;
 
	}
}
