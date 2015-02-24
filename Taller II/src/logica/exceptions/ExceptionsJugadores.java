package logica.exceptions;

import java.io.Serializable;

public class ExceptionsJugadores extends Exception implements Serializable {
		
	private static final long serialVersionUID = 1L;

	public ExceptionsJugadores(String msj)
	{
		super(msj);
	}
	
	
}
