package main.java.uia.com.contabilidad.mvc.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import main.java.uia.com.contabilidad.ContabilidadUIA;
import main.java.uia.com.contabilidad.mvc.model.User;
import main.java.uia.com.presentacion.ClienteJSP;
import main.java.uia.com.presentacion.Singleton;


@Configuration
@EnableWebMvc
@Controller
public class HomeController {

	private ContabilidadUIA dao = Singleton.getInstance();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		
		model.addAttribute("cheques", getListaCheques());

		return "verCheques";
	}


	@ModelAttribute("listaCheques")
	   public ArrayList<ChequeJSP> getListaCheques() {
	      return this.dao.getListaProveedores();
	   }

	
}
