package logica.exceptions;

import java.io.Serializable;

public class ExceptionCodigoIncorrecto extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ExceptionCodigoIncorrecto (String msj){
	
		super(msj);
	}
	 

}
