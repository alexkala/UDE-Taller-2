import logica.*;
import logica.ValueObjetcs.DataPartida;
import logica.ValueObjetcs.DataPelicula;

public class Prueba {

	public static void main(String[] args) {
		

		Pelicula pelicula1= new Pelicula("Tarzan","Hombre de la selva");
		Pelicula pelicula2= new Pelicula("Mulan","Guerrera China");
		Pelicula pelicula3= new Pelicula("Red","Espias retirados");
		Pelicula pelicula4= new Pelicula("Toy Story","Juguetes");
		
		Partida p1 = new Partida(0, 0, false, false, "r", pelicula1);
		Partida p2 = new Partida(0, 0, false, false, "a", pelicula2);
		Partida p3 = new Partida(0, 0, false, false, "e", pelicula3);
		Partida p4 = new Partida(0, 0, false, false, "t", pelicula4);
		
		Peliculas pelis= new Peliculas();
		pelis.put(pelicula1.getClave(),pelicula1);
		pelis.put(pelicula2.getClave(),pelicula2);
		pelis.put(pelicula3.getClave(),pelicula3);
		pelis.put(pelicula4.getClave(),pelicula4);
		
		Partidas games= new Partidas();
		games.add(p1);
		games.add(p2);
		games.add(p3);
		games.add(p4);
		
		//DataPelicula[] peliculasArre = FachadaCapaLogica.getInstancia().listarPeliculas();
		DataPartida[] partidasArre= games.obtenerPartidas();
		
		
		for(DataPartida elem: partidasArre)		{
			
			System.out.println (elem.getTextoAdivinado());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
