package main.java.uia.com.contabilidad.clientes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import main.java.uia.com.contabilidad.cuentas.Cuenta;

public class Requisicion extends InfoUIA
{
	
	Double saldo = 0.0;
	Cuenta miCuenta = null;
	
	@JsonCreator
    public Requisicion(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("saldo")double p1) 
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
	
	public void valida()
	{
		this.setEstado("Valido");
	}
	
}

