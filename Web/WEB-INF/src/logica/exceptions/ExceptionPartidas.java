package logica.exceptions;

import java.io.Serializable;

public class ExceptionPartidas  extends Exception implements Serializable {
	private static final long serialVersionUID = 1L;

	public ExceptionPartidas(String msj)
	{
		super(msj);
	}
}
