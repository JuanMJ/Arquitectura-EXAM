package main.java.uia.com.presentacion;

public class ClienteJSP {
	private int id;
	private String name;
	private String estado;
	protected String type;
	
	
	public ClienteJSP()
	{}
	
	public ClienteJSP(String name2, int id2, String estado2) {
		this.id= id2;
		this.name =name2;
		this.estado = estado2;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
