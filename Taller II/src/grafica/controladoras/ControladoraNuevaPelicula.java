package grafica.controladoras;

import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import logica.Pelicula;
import logica.exceptions.ExceptionsPeliculas;
import servidor.ObjectCliente;

public class ControladoraNuevaPelicula {
	
	private IFachadaCapaLogica fachada;
	private grafica.VentanaLogin window;

			
		public void NuevaPelicula(String titulo,String pista) throws RemoteException, ExceptionsPeliculas{
			Pelicula p = new Pelicula(titulo, pista);
			try {
				fachada = ObjectCliente.Inicializar();
				fachada.nuevaPelicula(p);
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (ExceptionsPeliculas e) {
				e.printStackTrace();
			}
			
		}

	

}
