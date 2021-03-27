package main.java.uia.com.contabilidad.gestor;

import java.util.Map;

import main.java.uia.com.contabilidad.clientes.InfoUIA;

public interface IGestor {
	
	public void Print();
	public void Lee();
	public void Busca();	
	public InfoUIA busca(String id);
	public Map<String, InfoUIA> getCatalogoMaestro();
	public void setCatalogo(Map<String, InfoUIA> p);
	public IGestor getGestor();
	public void setGestor(IGestor p);
}
