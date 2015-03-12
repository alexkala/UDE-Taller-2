package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintStream;

import logica.IFachadaCapaLogica;
import servidor.ObjectCliente;
import logica.ValueObjetcs.*;
import logica.exceptions.ExceptionsPersistencia;



public class Ranking extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static IFachadaCapaLogica fachada;	
	/*
	public void init()
	{		
		fachada = ObjectCliente.Inicializar();

	}
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		/*
		DataJugador[] ranking = null;
		try {
			ranking = fachada.listarRanking();
		} catch (ClassNotFoundException | ExceptionsPersistencia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// indico que el resultado va en formato html
				resp.setContentType("text/html");
				
				// mando el mensaje html por el Response
				PrintWriter out = resp.getWriter();
				out.println ("<html>");
				out.println ("<body>");
				out.println ("<h1> Hola, Mundo Web! </h1>");
		/*	
		System.out.println("\nRANKING");
		DataJugador[] rankingFinal = ranking;		// listarRanking
		int i = 1;
		for (DataJugador elem: rankingFinal) {
			out.println("<p>dsa</p>"); //(i + " - " + elem.getNombre() + " - " + elem.getCodigo() + " - PUNTAJE: " + elem.getPuntajeJugador());
			i++;
		}
	*/	
		out.println ("</body>");
		out.println ("</html>");
		out.close ();
	/*
		RequestDispatcher rd;
		req.setAttribute("Ranking", ranking);
		rd = req.getRequestDispatcher("/Ranking.jsp");
		rd.forward(req, resp);	
		*/
		
	}
	
	public void destroy()
	{
		
	}
}
