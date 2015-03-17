package grafica.controladoras;

import grafica.VentanaGuardar;
import grafica.VentanaMenuAdministrador;

import java.io.IOException;
import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import servidor.ObjectCliente;


public class ControladoraGuardar {
	private IFachadaCapaLogica fachada;
	private grafica.VentanaMenuAdministrador window;
		
	public void guardarCambios ()
	{
		fachada = ObjectCliente.Inicializar();
		
		try {
			window = new  VentanaMenuAdministrador();
			fachada.guardarCambios();		
			window.guardoOK("Se guardo correctamente.");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			window.errorAlGuardar(e.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			window.errorAlGuardar(e.getMessage());
		
		}
	}
}
