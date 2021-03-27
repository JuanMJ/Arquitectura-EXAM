package main.java.uia.com.contabilidad.gestor;

public class DecoradorCheques extends Decorador {
	
	public DecoradorCheques(IGestor gestor, String tipo)
	{
		super(gestor, tipo);
	}
	
	
	public DecoradorCheques()
	{		
	}
	
	public void validaCheques()
	{
		super.Print();
	}


}
