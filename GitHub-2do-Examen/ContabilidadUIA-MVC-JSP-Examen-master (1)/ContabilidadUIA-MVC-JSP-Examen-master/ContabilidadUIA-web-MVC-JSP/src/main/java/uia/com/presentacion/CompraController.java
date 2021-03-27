package main.java.uia.com.presentacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.uia.com.contabilidad.ContabilidadUIA;

/**
 * Servlet implementation class CompraController
 */
@WebServlet(
		urlPatterns = { 
				"/CompraController", 
		}, 
		initParams = { 
				@WebInitParam(name = "Nombre", value = "NA")
		})
public class CompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String VER_CUENTA = "/verCompras.jsp";
    private static String VER_CHEQUE = "/verCheques.jsp";
    private ContabilidadUIA dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraController() {
    	super();
        dao = new ContabilidadUIA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		// TODO Auto-generated method stub
		throws ServletException, IOException {
        	String action = request.getServletPath();

        switch (action) {
	        case "/ClienteController":
		        index(request, response);
		        break;	
	       	case "/verCompras":
		        verCompra(request, response);
		        break;
		    default:
		        break;
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void verCompra(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("verCompras.jsp");
        try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
