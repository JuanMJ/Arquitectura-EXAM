package main.java.uia.com.contabilidad.mvc.controller;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import main.java.uia.com.contabilidad.ContabilidadUIA;
import main.java.uia.com.presentacion.ClienteJSP;
import main.java.uia.com.presentacion.Singleton;



@Controller
public class ClientesController {

	 // Simply selects the home view to render by returning its name.
	
	private ContabilidadUIA dao = Singleton.getInstance();
	
	@RequestMapping(value = "/compras", method = RequestMethod.GET)
	public String cargaCompras(@RequestParam String clienteName, 
		      ModelMap model)
	{
		System.out.println("Pagina Compras solicitada, locale = ");

		this.dao.getCompras(clienteName);;
		model.addAttribute("clientes", getListaClientes());
		model.addAttribute("clienteActual", this.dao.clienteId);
		model.addAttribute("compras", this.getListaCompras());
		model.addAttribute("cuentas", this.getListaCuentas());
		return "verCompras";
	}


	@RequestMapping(value = "/cuentas", method = RequestMethod.GET)
	public String cargaCuentas(@RequestParam String clienteName, 
		      ModelMap model)
	{
		System.out.println("Pagina Compras solicitada, locale = ");

		this.dao.getCompras(clienteName);;
		model.addAttribute("clientes", getListaClientes());
		model.addAttribute("clienteActual", this.dao.clienteId);
		model.addAttribute("compras", this.getListaCompras());
		model.addAttribute("cuentas", this.getListaCuentas());
		return "verCompras";
	}
	

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editarCliente(@RequestParam String clienteName, 
		      ModelMap model)
	{
		
		System.out.println("Pagina Compras solicitada, locale = ");

		this.dao.getCompras(clienteName);;
		model.addAttribute("clientes", getListaClientes());
		model.addAttribute("clienteActual", this.dao.clienteId);
		model.addAttribute("compras", this.getListaCompras());
		model.addAttribute("cuentas", this.getListaCuentas());
		return "editar";
	}
	
	

	@ModelAttribute("listaCLientes")
	   public ArrayList<ClienteJSP> getListaClientes() {
	      return this.dao.getListaProveedores();
	   }
	
	@ModelAttribute("listaCompras")
	   public ArrayList<ClienteJSP> getListaCompras() {
	      return this.dao.getListaCompras();
	   }

	@ModelAttribute("listaCuentas")
	   public ArrayList<ClienteJSP> getListaCuentas() {
	      return this.dao.getListaCuentas();
	   }
	
}
