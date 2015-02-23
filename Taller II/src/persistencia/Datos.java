package persistencia;
import java.io.*;
import logica.*;

public class Datos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Peliculas peli;
	private Jugadores juga;
	
	public Datos(Peliculas peli, Jugadores juga){
		this.peli=peli;
		this.juga=juga;
	}
	public Datos (){
		peli= new Peliculas();
		juga= new Jugadores();
	}

	public Peliculas getPeli() {
		return peli;
	}

	public void setPeli(Peliculas peli) {
		this.peli = peli;
	}

	public Jugadores getJuga() {
		return juga;
	}

	public void setJuga(Jugadores juga) {
		this.juga = juga;
	}












}
