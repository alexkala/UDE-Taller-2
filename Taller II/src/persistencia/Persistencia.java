package persistencia;

import java.io.*;

import logica.*;

import java.util.Properties;
import java.util.TreeMap;

import logica.exceptions.ExceptionsPersistencia;

public class Persistencia {

	private Datos datos;

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	public Persistencia() {

		datos = new Datos();

	}

	public String getRuta() throws IOException {

		try {

			Properties p = new Properties();
			String f = "config/app.properties";
			p.load(new FileInputStream(f));
			return p.getProperty("rutaRespaldo");
		} catch (IOException e) {
			throw e;
		}

	}

	public void Respaldar(Datos datos, String path) throws IOException {
		try {
			FileOutputStream fos = null;
			File file;

			file = new File(path);
			fos = new FileOutputStream(file);

			if (!file.exists()) {
				file.createNewFile();
			}
			// FileOutputStream f = new FileOutputStream(getRuta());
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(datos);
			o.close();
			fos.close();
		} catch (IOException e) {
			throw e;
		}

	}

	public Datos Recuperar(String path) throws IOException, ExceptionsPersistencia,
			ClassNotFoundException {
		try {
			FileInputStream fis = null;
			File file = new File(path);

			if (file.exists()) {
				fis = new FileInputStream(file);
				// FileInputStream f = new FileInputStream(getRuta());
				ObjectInputStream o = new ObjectInputStream(fis);
				datos = (Datos) o.readObject();
				o.close();
				fis.close();

			} else {

				 throw new ExceptionsPersistencia(path);

			}
			return datos;
		}

		catch (IOException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		}
	}

}
