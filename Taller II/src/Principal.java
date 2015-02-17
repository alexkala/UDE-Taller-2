import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

import logica.FachadaCapaLogica;
import logica.Jugador;
import logica.Partida;
import logica.Pelicula;

import com.sun.xml.internal.fastinfoset.util.CharArray;

public class Principal {

	public static void main(String[] args) {
		
		
		String tituloPelicula = "RELATOS SALVAJES";
		//System.out.println("Original: " + tituloPelicula);
		tituloPelicula = tituloPelicula.replaceAll("\\s+", " "); // elimina los espacios blancos de sobra
										// entre palabras
		//System.out.println("Sin espacios extra: " + tituloPelicula);
		tituloPelicula = tituloPelicula.trim(); // elimina espacios al principio y final del string (si
						// hay)
		//System.out.println("Sin espacios al principio y final: " + tituloPelicula);
		tituloPelicula = tituloPelicula.toUpperCase(); // convierte a mayusculas
		//System.out.println("Convertido a mayusculas: " + tituloPelicula);
		
		Pelicula peliculaPartida = new Pelicula(tituloPelicula, "Producida por Pedro Almodóvar y ostenta entre sus filas al actor hoy más popular del cine local, Ricardo Darín.");
		

		String textoAdivinado;
		textoAdivinado = tituloPelicula;
		textoAdivinado = textoAdivinado.replaceAll("\\S", "-");
		
		Partida p1 = new Partida(0, 0, false, false, textoAdivinado, peliculaPartida);
		
		System.out.println("Texto adivinado: " + textoAdivinado);
		System.out.println("Pista: " + p1.getPeliculaPartida().getPista());
		
		
		String letra = new String();
		
		while (!p1.isFinalizada()) {
			System.out.println("Adivina una letra: ");
			 
			try{
			    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			    letra = bufferRead.readLine();
		 
			    System.out.println(letra);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		 
			letra = letra.toUpperCase(); // convierte la letra a mayuscula
			char letraChar = letra.charAt(0); // cambia el String con la letra a 1
												// char
			
			FachadaCapaLogica.getInstancia().ingresarCaracter("", "", p1, letraChar);
			System.out.println("Texto adivinado: " + p1.getTextoAdivinado());
			System.out.println("Puntaje: " + p1.getPuntajePartida());
		}
		
	}
}
