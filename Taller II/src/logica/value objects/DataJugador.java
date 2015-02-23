package logica.ValueObjetcs;
import java.io.*;
import java.util.ArrayList;

import logica.Partida;

public class DataJugador implements Serializable {


	private static final long serialVersionUID = 1L;

	private String nombre;
	private String codigo;
	private int puntajeJugador;
	private int cantAciertos;
	private int cantErrores;
	private ArrayList<Partida> partidasJugador;
	
	
	public DataJugador(String nombre, String codigo, int puntajeJugador,
			int cantAciertos, int cantErrores,
			ArrayList<Partida> partidasJugador) {
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
	public ArrayList<Partida> getPartidasJugador() {
		return partidasJugador;
	}
	public void setPartidasJugador(ArrayList<Partida> partidasJugador) {
		this.partidasJugador = partidasJugador;
	}
	
}
