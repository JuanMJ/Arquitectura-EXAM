package main.java.uia.com.contabilidad.proveedores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import main.java.uia.com.contabilidad.clientes.InfoUIA;
import main.java.uia.com.contabilidad.cuentas.Cuenta;
import main.java.uia.com.presentacion.ClienteJSP;

public class Proveedor extends InfoUIA
{
	
	Double saldo = 0.0;
	Cuenta miCuenta = null;
	private ArrayList<ClienteJSP> listaJSP = null;
	
	@JsonCreator
    public Proveedor(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("saldo")double p1) 
	{
        super(id, name);
        super.type =  this. getClass(). getSimpleName();        
        this.saldo = p1;
    }

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void validaCobranza() 
	{
			getItems().forEach(t->
	 				{
	 					t.validaCobranza();
		 			}
	 				);
		
	}
	
	public ArrayList<ClienteJSP> getLista() 
	{
		ClienteJSP cliente = null;
		
		if(listaJSP != null)
		{
			((List<ClienteJSP>) listaJSP).clear();
		}
		else
			listaJSP = new ArrayList<ClienteJSP>();
		
		if (this.items != null) 
		{
        
			System.out.println("----- Lista -----");
			
            items.forEach(t->{
    			if(t.getClienteJSP() != null)
    				((List<ClienteJSP>) listaJSP).add(t.getClienteJSP());
            });
		}
		return listaJSP;
	}

	public ArrayList<ClienteJSP> getListaCuentas() 
	{
		ClienteJSP cliente = null;
		
		if(listaJSP != null)
		{		
			listaJSP = new ArrayList<ClienteJSP>();
		}
		
		if (this.items != null) 
		{        
			System.out.println("----- Lista -----");
			
            items.forEach(t->{
    			if(t.getItems() != null)
    			{
    				t.getItems().forEach(p->
    				{
    					((List<ClienteJSP>) listaJSP).add(p.getClienteJSP());
    				});
    			}
    		});
		}
		return listaJSP;
	}

}
