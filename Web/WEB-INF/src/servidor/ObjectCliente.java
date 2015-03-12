package servidor;

import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import javax.swing.JOptionPane;
import logica.IFachadaCapaLogica;
import logica.ManageString;

public class ObjectCliente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public static IFachadaCapaLogica Inicializar(){
		IFachadaCapaLogica fachada = null;
		try
		{
					
			String url ="//" + ManageString.getProperty("ip")+ ":" + ManageString.getProperty("puerto")	+ "/" + ManageString.getProperty("nombre");		
			fachada = (IFachadaCapaLogica) Naming.lookup(url); 	// ACCEDE AL SERVER 
	
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Error.\nArchivo de configuracion no encontrado.\n"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}
		return fachada;
		
	}

}
