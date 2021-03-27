package main.java.uia.com.contabilidad.clientes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import main.java.uia.com.contabilidad.cheques.Cheque;
import main.java.uia.com.contabilidad.cheques.NotaDebito;
import main.java.uia.com.contabilidad.clientes.Cliente;
import main.java.uia.com.contabilidad.cuentas.Cuenta;
import main.java.uia.com.contabilidad.proveedores.Proveedor;
import main.java.uia.com.presentacion.ClienteJSP;


@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = Proveedor.class, name = "proveedor"),
	    @Type(value = Cliente.class, name = "cliente"),
	    @Type(value = Compra.class, name = "compra"),
	    @Type(value = Requisicion.class, name = "requisicion"),
	    @Type(value = Cuenta.class, name = "cuenta"),
	    @Type(value = Cheque.class, name = "cheque"),
	    @Type(value = NotaDebito.class, name = "notadebito"),
	    })

public abstract class InfoUIA implements IInfoUIA{

	private int id;
	public String name;
	private String estado;
	protected String type;
	protected List<InfoUIA> items;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public InfoUIA(int id, String name)
	{
		this.id=id;
		this.name = name;
	}
	
	public InfoUIA() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<InfoUIA> getItems() {
		return items;
	}

	public void setItems(List<InfoUIA> items) {
		this.items =  items;
	}

	public void validaCobranza()
	{
		this.getItems().forEach(t->
			{
				t.validaCobranza();
			}
			);
	}
	
	public void Print()
	{
		System.out.println("Nombre:\t"+this.getName());
		System.out.println("Id:\t"+this.getId());
		System.out.println("Estado:\t"+this.getEstado());
		
	}

	public ClienteJSP getClienteJSP() {
		ClienteJSP item = new ClienteJSP(this.getName(), this.getId(), this.getEstado());
		return item;
	}
	
}
