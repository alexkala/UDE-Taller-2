package grafica.controladoras;

import grafica.auxiliares.MyTableModel;
import grafica.auxiliares.TablaRanking;
//import grafica.auxiliares.table;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import logica.IFachadaCapaLogica;
import logica.Partida;
import logica.ValueObjetcs.DataJugador;
import logica.exceptions.ExceptionPartidas;
import logica.exceptions.ExceptionsJugadores;
import logica.exceptions.ExceptionsPeliculas;
import logica.exceptions.ExceptionsPersistencia;
import servidor.ObjectCliente;


public class ControladoraRanking {
	private IFachadaCapaLogica fachada;
	private grafica.VentanaRanking window;
	
	
	
	public Object[][] listarRanking() throws ClassNotFoundException, IOException, ExceptionsPersistencia {
		try {
			fachada = ObjectCliente.Inicializar();
			DataJugador[] dataJugadores = fachada.listarRanking();
			Object[][] data = new Object[dataJugadores.length][6];
				int i = 0;
				for (DataJugador elem: dataJugadores) {
					data[i][0] = new Integer(i + 1);			// POSICION
					data[i][1] = new String(elem.getNombre());	// NOMBRE
					data[i][2] = new Integer(elem.getPuntajeJugador());				// PUNTOS
					data[i][3] = new Integer(elem.getCantAciertos());				// ACIERTOS
					data[i][4] = new Integer(elem.getCantErrores());				// ERRORES
					if (elem.getPartidasJugador() != null) {
						data[i][5] = new Integer(elem.getPartidasJugador().size());				// PARTIDAS
					} else {
						data[i][5] = new Integer(0);				// PARTIDAS
					}
					i++;
					
				}
				return data;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Partida nuevaPartida(String nombreJugador, String codigoJugador) throws ExceptionsJugadores, ExceptionPartidas, ExceptionsPeliculas {
		try {
			fachada = ObjectCliente.Inicializar();
			Partida nueva = fachada.nuevaPartida(nombreJugador, codigoJugador);
			return nueva;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public DataJugador[] listarRanking(String nombreJugador, String codigoJugador) throws ExceptionsJugadores, ClassNotFoundException, IOException, ExceptionsPersistencia {
		try {
			fachada = ObjectCliente.Inicializar();
			return fachada.listarRanking();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
