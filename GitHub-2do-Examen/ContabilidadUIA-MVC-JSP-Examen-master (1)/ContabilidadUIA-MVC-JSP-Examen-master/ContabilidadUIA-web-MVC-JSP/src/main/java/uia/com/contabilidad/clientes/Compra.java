package main.java.uia.com.contabilidad.clientes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import main.java.uia.com.contabilidad.cuentas.Cuenta;

public class Compra extends InfoUIA
{
	
	Double saldo = 0.0;
	Cuenta miCuenta = null;
	
	@JsonCreator
    public Compra(@JsonProperty("id")int id, @JsonProperty("name")String name, @JsonProperty("saldo")double p1) 
	{
        super(id, name);
        this.saldo = p1;
        super.setType(this.getClass().getTypeName());
    }

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}

