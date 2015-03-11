package valueObjects;

public class DataMensaje 
{
	private String autor;
	private String mensaje;
	
	public DataMensaje() 
	{
	}

	public DataMensaje(String autor, String mensaje) 
	{
		this.autor = autor;
		this.mensaje = mensaje;
	}

	public String getAutor() 
	{
		return autor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setAutor(String autor) 
	{
		this.autor = autor;
	}

	public void setMensaje(String mensaje) 
	{
		this.mensaje = mensaje;
	}	
}
