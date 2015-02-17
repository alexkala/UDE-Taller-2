public class Principal {

	public static void main(String[] args) {
		String s = "  Hola   Mundo  ! ";
		System.out.println(s);
		s = s.replaceAll("\\s+", " ");	// elimina los espacios blancos de sobra entre palabras
		System.out.println("Sin espacios extra: " + s);
		s = s.trim();					// elimina espacios al principio y final del string (si hay)
		System.out.println("Sin espacios al principio y final: " + s);
		s = s.toUpperCase();			// convierte a mayusculas
		System.out.println("Convertido a mayusculas: " + s);

	}
}
