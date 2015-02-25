package logica.exceptions;

import java.io.Serializable;

public class ExceptionsPeliculas extends Exception implements Serializable {
		
	private static final long serialVersionUID = 1L;

	public ExceptionsPeliculas(String msj)
	{
		super(msj);
	}
	
}
