package logica;
import java.io.*;

public class Partida implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private int numero;
	private int puntajePartida;
	private boolean finalizada;
	private boolean acertada;
	private String textoAdivinado;
	private Pelicula peliculaPartida;
	
	
	// constructor	
	public Partida(int numero, int puntajePartida, boolean finalizada,
			boolean acertada, String textoAdivinado, Pelicula peliculaPartida) {
		this.numero = numero;
		this.puntajePartida = puntajePartida;
		this.finalizada = finalizada;
		this.acertada = acertada;
		this.textoAdivinado = textoAdivinado;
		this.peliculaPartida = peliculaPartida;
	}
	
	// getters & setters
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPuntajePartida() {
		return puntajePartida;
	}
	public void setPuntajePartida(int puntajePartida) {
		this.puntajePartida = puntajePartida;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	public boolean isAcertada() {
		return acertada;
	}
	public void setAcertada(boolean acertada) {
		this.acertada = acertada;
	}
	public String getTextoAdivinado() {
		return textoAdivinado;
	}
	public void setTextoAdivinado(String textoAdivinado) {
		this.textoAdivinado = textoAdivinado;
	}
	public Pelicula getPeliculaPartida() {
		return peliculaPartida;
	}
	public void setPeliculaPartida(Pelicula peliculaPartida) {
		this.peliculaPartida = peliculaPartida;
	}
	
	
}
