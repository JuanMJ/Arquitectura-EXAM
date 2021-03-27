package main.java.uia.com.contabilidad.gestor;

public class DecoradorCompras extends Decorador {
	
	public DecoradorCompras(IGestor gestor, String tipo)
	{
		super(gestor, tipo);
	}
	
	public DecoradorCompras()
	{		
	}
	
	public void validaCompras()
	{
		super.Print();
	}


}
