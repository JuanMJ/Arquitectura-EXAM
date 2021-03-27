package main.java.uia.com.presentacion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.uia.com.contabilidad.ContabilidadUIA;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(
		urlPatterns = { 
				"/ClienteController", 
				"/verCompras", 
				"/verCuentas", 
				"/verCheques", 
				"/Actualiza", 
				"/Borra"
		}, 
		initParams = { 
				@WebInitParam(name = "Nombre", value = "NA")
		})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String VER_COMPRA = "/verCompras.jsp";
    private static String VER_CUENTA = "/verCuentas.jsp";
    private static String VER_CHEQUE = "/verCheques.jsp";
    private ContabilidadUIA dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
    	super();
    	Singleton singletonInstance = new Singleton();	
    	this.dao = singletonInstance.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		// TODO Auto-generated method stub
		 throws ServletException, IOException {
		        String forward="";
		        String action = request.getParameter("action");
		 
		        if (action.equalsIgnoreCase("verCheque")){
		            String clienteId = request.getParameter("clienteName");
		            dao.borraCliente(clienteId);
		            forward = VER_CHEQUE;
		            request.setAttribute("clientes", dao.getAllClientes());    
		        } 
		        else if (action.equalsIgnoreCase("verCompras"))
		        {
		            forward = VER_COMPRA;
		            String clienteId = request.getParameter("clienteName");
		            ArrayList<ClienteJSP> compras = dao.getCompras(clienteId);
		            request.setAttribute("cliente", clienteId);
		            request.setAttribute("listaCompras", compras);
		        } 
		        else if (action.equalsIgnoreCase("verCuentas"))
		        {
		            forward = VER_CUENTA;
		            String clienteId = request.getParameter("clienteName");
		            request.setAttribute("cliente", clienteId);
		            request.setAttribute("listaCompras", dao.getCompras(clienteId));
		            ArrayList<ClienteJSP> cuentas = dao.getCuentas(clienteId);
		            request.setAttribute("listaCuentas", cuentas);
		        } 
		        else if (action.equalsIgnoreCase("verCheques"))
		        {
		            forward = VER_CHEQUE;
		            String clienteId = request.getParameter("clienteName");
		            ArrayList<ClienteJSP> cheques = dao.getCheques(clienteId);
		            request.setAttribute("cliente", clienteId);
		            request.setAttribute("listaCheques", cheques);
		        } 
		        else if (action.equalsIgnoreCase("listCliente")){
		            forward = VER_CHEQUE;
		            request.setAttribute("clientes", dao.getAllClientes());
		        } else {
		            forward = VER_COMPRA;
		        }
		 
		        RequestDispatcher view = request.getRequestDispatcher(forward);
		        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
