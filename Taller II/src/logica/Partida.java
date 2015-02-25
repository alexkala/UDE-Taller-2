package logica;
import java.io.*;

public class Partida implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private int numeroPartida;
	private int puntajePartida;
	private boolean finalizada;
	private boolean acertada;
	private String textoAdivinado;
	private Pelicula peliculaPartida;
	
	
	// constructor	
	public Partida(int numeroPartida, int puntajePartida, boolean finalizada,
			boolean acertada, String textoAdivinado, Pelicula peliculaPartida) {
		this.numeroPartida = numeroPartida;
		this.puntajePartida = puntajePartida;
		this.finalizada = finalizada;
		this.acertada = acertada;
		this.textoAdivinado = textoAdivinado;
		this.peliculaPartida = peliculaPartida;
	}
	
	public Partida(int numeroPartida, String textoAdivinado, Pelicula peliculaPartida) {
		this.numeroPartida = numeroPartida;
		this.puntajePartida = 0;
		this.finalizada = false;
		this.acertada = false;
		this.textoAdivinado = textoAdivinado;
		this.peliculaPartida = peliculaPartida;
	}
	
	public Partida() {
		this.numeroPartida = -1;
		this.puntajePartida = 0;
		this.finalizada = false;
		this.acertada = false;
		this.textoAdivinado = null;
		this.peliculaPartida = null;
	}

	// getters & setters
	public int getNumeroPartida() {
		return numeroPartida;
	}

	public void setNumeroPartida(int numeroPartida) {
		this.numeroPartida = numeroPartida;
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
