
import java.util.ArrayList;
import java.util.TreeMap;
import java.io.*;

import logica.*;
import logica.ValueObjetcs.DataPelicula;
import persistencia.*;


public class MainPersistencia {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{

			Pelicula pelicula1= new Pelicula("Tarzan","Hombre de la selva");
			Pelicula pelicula2= new Pelicula("Mulan","Guerrera China");
			Pelicula pelicula3= new Pelicula("Red","Espias retirados");
			Pelicula pelicula4= new Pelicula("Toy Story","Juguetes");
			
			Partida p1 = new Partida(0, 0, false, false, "r", pelicula1);
			Partida p2 = new Partida(0, 0, false, false, "a", pelicula2);
			Partida p3 = new Partida(0, 0, false, false, "e", pelicula3);
			Partida p4 = new Partida(0, 0, false, false, "t", pelicula4);
			
			
			Jugador jugador1= new Jugador("Pepe","123");
			Jugador jugador2= new Jugador("Juan","456");
			Jugador jugador3= new Jugador("Luis","789");
			Jugador jugador4= new Jugador("Dani","000");
			
			FachadaCapaLogica.getInstancia().nuevoJugador(jugador1);
			
			
			TreeMap<String,Pelicula>  peliculas =  new TreeMap<String,Pelicula>();
			TreeMap<String,Pelicula>  peliculasGuardadas =  new TreeMap<String,Pelicula>();
			TreeMap<String,Jugador>  jugadores =  new TreeMap<String,Jugador>();
		
			peliculas.put(pelicula1.getClave(), pelicula1);
			
			
			
			
			/*jugadores.insert(jugador1);
			jugadores.insert(jugador2);
			jugadores.insert(jugador3);
			jugadores.insert(jugador4);
			
*/			
			Persistencia p = new Persistencia();
			//p.Respaldar(jugadores, peliculas);
			System.out.println("\nhola");
			Datos d = new Datos();
			
			d = p.Recuperar();
			FachadaCapaLogica.getInstancia().setJugadores(d.getJugadores());
			System.out.println("\nchau");
			
			
			
			/*
			String tituloPelicula = "Relatos  salvajes";		
			Pelicula peliculaPartida = new Pelicula(tituloPelicula, "Producida por Pedro Almodóvar y ostenta entre sus filas al actor hoy más popular del cine local, Ricardo Darín.");
			FachadaCapaLogica.getInstancia().nuevaPelicula(peliculaPartida);
			
			DataPelicula[] peliculasArre = FachadaCapaLogica.getInstancia().listarPeliculas();
			for(DataPelicula elem: peliculasArre)
			{
				
				System.out.println (elem.getTitulo());
			}
			
			
		    
			*/
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
