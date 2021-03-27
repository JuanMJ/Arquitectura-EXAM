package main.java.uia.com.contabilidad.gestor;

import java.util.Map;

import main.java.uia.com.contabilidad.clientes.InfoUIA;

public class DecoradorCuentas extends Decorador {
	
	public DecoradorCuentas(IGestor gestor, String tipo)
	{
		super(gestor, tipo);
	}
	
	
	public DecoradorCuentas()
	{		
	}
	
	public void validaCuentas()
	{
		super.Print();
	}


	public Map<String, InfoUIA> getCatalogo() {	
		return this.catalogo;
	}


}
