package grafica.controladoras;

import java.io.IOException;
import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import logica.ValueObjetcs.DataLogin;
import logica.exceptions.ExceptionCodigoIncorrecto;
import logica.exceptions.ExceptionsJugadores;
import servidor.ObjectCliente;

public class ControladoraLogin {
	
		private IFachadaCapaLogica fachada;
		private grafica.VentanaLogin window;
		
		public DataLogin login(String nombreJugador, String codigoJugador) throws ExceptionsJugadores, ExceptionCodigoIncorrecto {
			try {
				fachada = ObjectCliente.Inicializar();
				DataLogin dataLogin = fachada.logIn(nombreJugador, codigoJugador);
				return dataLogin;
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

}
