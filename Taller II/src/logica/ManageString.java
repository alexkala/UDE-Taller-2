package logica;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ManageString {

	// Metodos auxiliares (privados)Felipe
		public String corregirTexto(String texto) {
			texto = texto.replaceAll("\\s+", " "); 	// elimina los espacios blancos de sobra entre palabras
			texto = texto.trim(); 					// elimina espacios al principio y final del string (si hay)
			texto = texto.toUpperCase(); 			// convierte a mayusculas
			return texto;
		}

		public boolean faltaUnaLetra(String textoAdivinado, String tituloPelicula) {
			int index = textoAdivinado.indexOf("-");
			char letraUnica = tituloPelicula.charAt(index);
			
			while (index != -1) {
				index = textoAdivinado.indexOf("-", index);
				if (index != -1) {
					if (letraUnica != tituloPelicula.charAt(index)) {
						return false;					
					} else {
						index++;
					}
				}
			}
			return true;
		}
		
		//Metodo para obtener la ruta de propierties
		public String getRuta() throws IOException {
			try {
				Properties p = new Properties();
				String f = "config/app.properties";
				p.load(new FileInputStream(f));
				return p.getProperty("rutaRespaldo");
			} catch (IOException e) {
				throw e;
			}

		}
}
