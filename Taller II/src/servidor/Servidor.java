package servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import logica.FachadaCapaLogica;

public class Servidor {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			// instancio mi Objeto Remoto y lo publico
			FachadaCapaLogica.getInstancia();
			System.out.println ("Antes de publicarlo");
			Naming.rebind("//pc00197:1099/cuenta", FachadaCapaLogica.getInstancia());		// ALGO DEL SERVER
					System.out.println ("Luego de publicarlo");
		}
		catch (RemoteException e) {	e.printStackTrace(); }
		catch (MalformedURLException e)	{ e.printStackTrace(); }
	}
}
