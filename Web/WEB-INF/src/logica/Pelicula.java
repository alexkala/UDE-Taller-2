package logica;
import java.io.*;

public class Pelicula implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String pista;
	
	public Pelicula(String titulo, String pista) {
		this.titulo = titulo;
		this.pista = pista;
	}
	
	// getters & setters
	public String getClave() {
		return titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getPista() {
		return pista;
	}
	public void setPista(String pista) {
		this.pista = pista;
	}
	
	
	
	
	
	
	//prueba comentario commit
	
}
