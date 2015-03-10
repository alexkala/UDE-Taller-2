package grafica.controladoras;

import grafica.VentanaGuardar;

import java.io.IOException;
import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import servidor.ObjectCliente;


public class ControladoraGuardar {
	private IFachadaCapaLogica fachada;
	private grafica.VentanaGuardar window;
		
	public void guardarCambios ()
	{
		fachada = ObjectCliente.Inicializar();
		try {
			//window = new  VentanaGuardar();
			fachada.guardarCambios();
			//window.guardadoOK();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//window.ioMensaje();
		}
	}
}
