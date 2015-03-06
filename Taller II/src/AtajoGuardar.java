import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import logica.IFachadaCapaLogica;
import logica.ManageString;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionPartidas;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
import logica.exceptions.ExceptionsPersistencia;


public class AtajoGuardar {
	public static void main(String[] args) throws NotBoundException,
			ExceptionsJugadores, ExceptionsPeliculas,
			ExceptionCodigoIncorrecto, IOException, ExceptionPartidas,
			ClassNotFoundException, ExceptionsPersistencia {
		String url ="//" + ManageString.getProperty("ip")+ ":" + ManageString.getProperty("puerto")	+ "/" + ManageString.getProperty("nombre");		
		IFachadaCapaLogica fachada = (IFachadaCapaLogica) Naming.lookup(url); 	// ACCEDE AL SERVER 
		
		fachada.guardarCambios();
		
	}
}
