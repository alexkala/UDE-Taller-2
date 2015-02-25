package logica;
import java.io.*;

public class Jugador implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String codigo;
	private int puntajeJugador;
	private int cantAciertos;
	private int cantErrores;
	private Partidas partidasJugador;
	
	// constructor
	public Jugador(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.puntajeJugador = 0;
		this.cantAciertos = 0;
		this.cantErrores = 0;
		this.partidasJugador = null;
	}
	
	// getters & setters
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

}
