package grafica.controladoras;

import grafica.VentanaNuevaPelicula;
import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import logica.Pelicula;
import logica.exceptions.ExceptionsPeliculas;
import servidor.ObjectCliente;

public class ControladoraNuevaPelicula {
	
	private IFachadaCapaLogica fachada;
	private grafica.VentanaNuevaPelicula v;

			
		public void NuevaPelicula(String titulo,String pista) throws RemoteException, ExceptionsPeliculas{
			v = new VentanaNuevaPelicula();
			Pelicula p = new Pelicula(titulo, pista);
			try {
				fachada = ObjectCliente.Inicializar();
				fachada.nuevaPelicula(p);
				v.okPelicula("Ingreso la Pelicula correctamente");
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (ExceptionsPeliculas e) {
				v.errorPelicula(e.getMessage());
			}
			
		}
}
