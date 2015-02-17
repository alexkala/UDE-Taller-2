import com.sun.xml.internal.fastinfoset.util.CharArray;

public class Principal {

	public static void main(String[] args) {
		String s = "yo";
		System.out.println("Original: " + s);
		s = s.replaceAll("\\s+", " "); // elimina los espacios blancos de sobra
										// entre palabras
		System.out.println("Sin espacios extra: " + s);
		s = s.trim(); // elimina espacios al principio y final del string (si
						// hay)
		System.out.println("Sin espacios al principio y final: " + s);
		s = s.toUpperCase(); // convierte a mayusculas
		System.out.println("Convertido a mayusculas: " + s);

		String textoAdivinado;
		textoAdivinado = s;
		textoAdivinado = textoAdivinado.replaceAll("\\S", "-");
		System.out.println("Texto adivinado: " + textoAdivinado);

		int puntaje = 0;

		String letra = "y"; // letra ingresada
		letra = letra.toUpperCase(); // convierte la letra a mayuscula
		char letraChar = letra.charAt(0); // cambia el String con la letra a 1
											// char

		System.out.println("Letra ingresada: " + letra);

		// buscar letra
		int i = 0;
		boolean puntajeSumado = false;
		char[] textoAdivinadoChar = textoAdivinado.toCharArray();
		if (textoAdivinado.indexOf(letraChar) == -1) { // verifica que la letra
														// no haya sido
														// adivinada previamente
			while (i != -1) {
				i = s.indexOf(letra, i); // busca la posicion de la letra
											// ingresada
				if (i != -1) { // letra correcta
					textoAdivinadoChar[i] = letraChar; // reemplaza la
														// ocurrencia de la
														// letra ingresada
					i++;
					if (!puntajeSumado) { // suma 1 punto
						puntaje = puntaje + 1;
						puntajeSumado = true;
					}
				} else { // letra erronea
					if (!puntajeSumado) { // resta 5 puntos
						System.out.println("Letra erronea!");
						puntaje = puntaje - 5;
						puntajeSumado = true;
					}
				}
			}
		} else {
			System.out.println("La letra ya fue ingresada previamente");
		}

		textoAdivinado = new String(textoAdivinadoChar); // convierte el texto
															// adivinado de
															// nuevo a String
		System.out.println("Texto adivinado: " + textoAdivinado);
		System.out.println("Puntaje: " + puntaje);
		
		if (textoAdivinado.equals(s)) {					// adivino la pelicula
			System.out.println("Película adivinada!");
			// partida.acertada = true;
			// partida.finalizada = true;
		}

		// ///////////////////////////////////////////
		// TODO LO MISMO PARA PROBAR OTRA LETRA
		// ///////////////////////////////////////////

		letra = "o"; // letra ingresada
		letra = letra.toUpperCase(); // convierte la letra a mayuscula
		letraChar = letra.charAt(0); // cambia el String con la letra a 1 char

		System.out.println("Letra ingresada: " + letra);

		// buscar letra
		i = 0;
		puntajeSumado = false;
		textoAdivinadoChar = textoAdivinado.toCharArray();
		if (textoAdivinado.indexOf(letraChar) == -1) { // verifica que la letra
														// no haya sido
														// adivinada previamente
			while (i != -1) {
				i = s.indexOf(letra, i); // busca la posicion de la letra
											// ingresada
				if (i != -1) { // letra correcta
					textoAdivinadoChar[i] = letraChar; // reemplaza la
														// ocurrencia de la
														// letra ingresada
					i++;
					if (!puntajeSumado) { // suma 1 punto
						puntaje = puntaje + 1;
						puntajeSumado = true;
					}
				} else { // letra erronea
					if (!puntajeSumado) { // resta 5 puntos
						System.out.println("Letra erronea!");
						puntaje = puntaje - 5;
						puntajeSumado = true;
					}
				}
			}
		} else {
			System.out.println("La letra ya fue ingresada previamente");
		}

		textoAdivinado = new String(textoAdivinadoChar); // convierte el texto
															// adivinado de
															// nuevo a String
		System.out.println("Texto adivinado: " + textoAdivinado);
		System.out.println("Puntaje: " + puntaje);
		
		if (textoAdivinado.equals(s)) {					// adivino la pelicula
			System.out.println("Película adivinada!");
			// partida.acertada = true;
			// partida.finalizada = true;
		}
	}
}
