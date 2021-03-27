package main.java.uia.com.contabilidad.gestor;

import java.util.ArrayList;

import main.java.uia.com.contabilidad.clientes.InfoUIA;
import main.java.uia.com.presentacion.ClienteJSP;

public class DecoradorProveedores extends Decorador {
	
	public DecoradorProveedores(IGestor gestor, String tipo)
	{
		super(gestor, tipo);
	}
	
	
	public DecoradorProveedores()
	{		
	}
	
	public void validaProveedores()
	{
		super.Print();
	}

	public ArrayList<ClienteJSP> getLista()
	{
		return super.getLista();
	}
}
