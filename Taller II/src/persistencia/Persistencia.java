package persistencia;

import java.io.*;

import logica.*;

import java.util.Properties;

import logica.exceptions.ExceptionsPersistencia;




public class Persistencia {
	
	private Datos datos;

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}
	
	public Persistencia(){

		datos= new Datos();
		
	}

	public String getRuta()throws IOException{
		
		try{
		
		Properties p = new Properties();
		String f = "config/app.properties";
		p.load (new FileInputStream (f));
		return p.getProperty("rutaRespaldo");
		}	
		catch(IOException e)
			{ throw e; }
					
	}	
	
	public void Respaldar (Jugadores jugadores,Peliculas peliculas)throws IOException{
		datos.setJuga(jugadores);
		datos.setPeli(peliculas);
		
		try
		{
			FileOutputStream fos = null;
			File file;
			
			String r = getRuta();
			System.out.print(r);
		
			
			file = new File(getRuta());
			fos = new FileOutputStream(file);
			
			if (!file.exists()) {
			     file.createNewFile();
			  }
			//FileOutputStream f = new FileOutputStream(getRuta());
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(datos);
			o.close();
			fos.close();
		}
		catch(IOException e){ throw e; }
		
	}
	

	public Datos Recuperar() throws IOException, ExceptionsPersistencia, ClassNotFoundException
	{
		try
		{
			FileInputStream fis = null;
			File file;
			file = new File(getRuta());
			
			boolean ex =  file.exists();
			
			System.out.print(ex);
			
			if(file.exists())
			{
			fis = new FileInputStream(file);
			//FileInputStream f = new FileInputStream(getRuta());
			ObjectInputStream o = new ObjectInputStream(fis);
			datos = (Datos) o.readObject();
			
			o.close();
			fis.close();
			
			
			}
			else
			{	
				
			//throw new ExceptionsPersistencia("dsa");	
			
			}
			
			return datos;
			
		}
			
			catch(IOException e){ throw e; }
			catch(ClassNotFoundException e){ throw e; }
	}				
			
}




	