package grafica.controladoras;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;

import grafica.VentanaGuardar;
import logica.IFachadaCapaLogica;
import servidor.ObjectCliente;

public class ControladoraGuardar {
	private IFachadaCapaLogica fachada;
	private grafica.VentanaGuardar window;
		
	public void guardarCambios ()
	{
		fachada = ObjectCliente.Inicializar();
		try {
			
			fachada.guardarCambios();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
