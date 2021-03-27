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
public class ChequesController {

	 // Simply selects the home view to render by returning its name.
	
	private ContabilidadUIA dao = Singleton.getInstance();
	
	@RequestMapping(value = "/cheques", method = RequestMethod.GET)
	public String cargaCompras(@RequestParam String chequeName, 
		      ModelMap model)
	{
		System.out.println("Pagina Compras solicitada, locale = ");

		this.dao.getCompras(chequeName);;
		model.addAttribute("cheques", getListaClientes());
		model.addAttribute("chequeActual", this.dao.chequeId);
		model.addAttribute("compras", this.getListaCheques());
		model.addAttribute("cuentas", this.getListaCheques());
		return "verCheques";
	}


	@RequestMapping(value = "/cuentas", method = RequestMethod.GET)
	public String cargaCuentas(@RequestParam String chequeName, 
		      ModelMap model)
	{
		System.out.println("Pagina Compras solicitada, locale = ");

		this.dao.getCompras(chequeName);;
		model.addAttribute("cheques", getListaClientes());
		model.addAttribute("chequeActual", this.dao.chequeId);
		model.addAttribute("compras", this.getListaCheques());
		model.addAttribute("cuentas", this.getListaCheques());
		return "verCompras";
	}
	

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editarCliente(@RequestParam String chequeName, 
		      ModelMap model)
	{
		
		System.out.println("Pagina Compras solicitada, locale = ");

		this.dao.getCompras(chequeName);;
		model.addAttribute("cheques", getListaClientes());
		model.addAttribute("chequeActual", this.dao.chequeId);
		model.addAttribute("compras", this.getListaCheques());
		model.addAttribute("cuentas", this.getListaCheques());
		return "editar";
	}
	
	

	@ModelAttribute("listaCheques")
	   public ArrayList<ChequeJSP> getListaCheques() {
	      return this.dao.getListaProveedores();
	   }
	
	@ModelAttribute("listaCompras")
	   public ArrayList<ChequeJSP> getListaCompras() {
	      return this.dao.getListaCompras();
	   }

	@ModelAttribute("listaCuentas")
	   public ArrayList<ChequeJSP> getListaCuentas() {
	      return this.dao.getListaCuentas();
	   }
	
}
