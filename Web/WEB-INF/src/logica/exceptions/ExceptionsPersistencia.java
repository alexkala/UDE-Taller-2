package logica.exceptions;

import java.io.Serializable;

public class ExceptionsPersistencia extends Exception implements Serializable {
		
	private static final long serialVersionUID = 1L;

	public ExceptionsPersistencia(String msj)
	{
		super("\nNo existe archivo en la ruta:" + msj);
	}
	
	
}
