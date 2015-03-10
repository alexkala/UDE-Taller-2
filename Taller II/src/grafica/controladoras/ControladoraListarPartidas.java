package grafica.controladoras;

import java.rmi.RemoteException;

import logica.IFachadaCapaLogica;
import logica.ValueObjetcs.DataJugador;
import logica.ValueObjetcs.DataPartida;
import logica.exceptions.ExceptionsJugadores;
import servidor.ObjectCliente;

public class ControladoraListarPartidas {
	
	private IFachadaCapaLogica fachada;
	private grafica.VentanaLogin window;
	
	public String[] opcionesCombobox() throws ExceptionsJugadores {
		try {
			fachada = ObjectCliente.Inicializar();
			DataJugador[] datajugadores = fachada.listarJugadores();
			String[] jugadores = new String[datajugadores.length];
			for (int i = 0; i < datajugadores.length; i++) {
				jugadores[i] = datajugadores[i].getNombre();
			}
			return jugadores;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object[][] listarPartidas(String nombreJugador) throws RemoteException, ExceptionsJugadores {
		DataPartida[] dataPartidas = fachada.listarPartidas(nombreJugador);
		Object[][] data = new Object[dataPartidas.length][6];
			int i = 0;
			for (DataPartida elem: dataPartidas) {
				data[i][0] = new Integer(elem.getNumero());			// NUMERO DE PARTIDA
				data[i][1] = new String(elem.getPeliculaPartida().getTitulo());	// PELICULA
				data[i][2] = new String(elem.getTextoAdivinado());				// TEXTO ADIVINADO
				if (elem.isAcertada()) {										// ACERTADA
					data[i][3] = new String("Si");					
				} else {
					data[i][3] = new String("No");
				}
				if (elem.isFinalizada()) {										// FINALIZADA
					data[i][4] = new String("Si");					
				} else {
					data[i][4] = new String("No");
				}
				data[i][5] = new Integer(elem.getPuntajePartida());				// PUNTAJE
				i++;
			}
			return data;
	}
}
