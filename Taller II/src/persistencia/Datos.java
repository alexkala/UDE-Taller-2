package persistencia;
import java.io.*;

import logica.*;

public class Datos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Peliculas peliculas;
	private Jugadores jugadores; 
	
	public Datos(Peliculas _peliculas, Jugadores _jugadores){
		this.peliculas = _peliculas;
		this.jugadores = _jugadores;
	}
	
	public Datos (){
		peliculas = new Peliculas();
		jugadores = new Jugadores();
	}

	public Peliculas getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Peliculas peliculas) {
		this.peliculas = peliculas;
	}

	public Jugadores getJugadores() {
		return jugadores;
	}//getjogador

	public void setJugadores(Jugadores jugadores) {
		this.jugadores = jugadores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}










}
