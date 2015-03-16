package servidor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import logica.FachadaCapaLogica;
import logica.ManageString;
import logica.exceptions.ExceptionsPersistencia;

public class Servidor {
	public static void main(String[] args) throws ClassNotFoundException, IOException, ExceptionsPersistencia {
		try {
			LocateRegistry.createRegistry(Integer.parseInt((ManageString.getProperty("puerto"))));
			// instancio mi Objeto Remoto y lo publico
			FachadaCapaLogica.getInstancia();
			System.out.println ("Antes de publicarlo");
			String url ="//" + ManageString.getProperty("ip")+ ":" + ManageString.getProperty("puerto")	+ "/" + ManageString.getProperty("nombre");		
			Naming.rebind(url, FachadaCapaLogica.getInstancia());		// LEVANTA EL SERVER
			System.out.println ("Luego de publicarlo");
		}
		catch (RemoteException e) {	e.printStackTrace(); }
		catch (MalformedURLException e)	{ e.printStackTrace(); }
	}
}
