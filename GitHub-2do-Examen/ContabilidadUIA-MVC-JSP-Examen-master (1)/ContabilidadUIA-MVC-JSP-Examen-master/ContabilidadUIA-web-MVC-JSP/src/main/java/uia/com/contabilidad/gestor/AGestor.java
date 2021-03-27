package main.java.uia.com.contabilidad.gestor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.uia.com.contabilidad.clientes.InfoUIA;
import main.java.uia.com.contabilidad.clientes.ListaInfoUIA;

public abstract class AGestor implements IGestor{
	
	protected Map<String, InfoUIA> catalogoMaestro = null;
	
    public AGestor(String nomFile)
    {
    	ObjectMapper mapper = new ObjectMapper();
        
        ListaInfoUIA miLista = null;
        
		try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
   		 	miLista = mapper.readValue(new FileInputStream(nomFile), ListaInfoUIA.class );
            
        }
        catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (miLista != null) {
            System.out.println("----- Items List -----");

            for (InfoUIA mi : miLista.getItems()) {
                System.out.println("Type = " + mi.getClass() +  ", id = "+ mi.getId() + ", name = " + mi.getName());
            }
        }
        
        catalogoMaestro = new HashMap<String, InfoUIA>();
        
         catalogoMaestro = miLista.getItems().stream()
              .collect(Collectors.toMap(InfoUIA::getName, item -> item));
		
    }
    
    
    public Map<String, InfoUIA> getCatalogoMaestro() {
		return catalogoMaestro;
	}


	public void setCatalogo(Map<String, InfoUIA> catalogoMaestro) {
		this.catalogoMaestro = catalogoMaestro;
	}


	public void Print()
    {
    	if (catalogoMaestro != null) {
            System.out.println("----- Catalogo -----");

            for (Map.Entry<String, InfoUIA> entry : catalogoMaestro.entrySet()) {
                System.out.println(entry.getKey() + ", Cliente : " + entry.getValue());
            }
        }
    }
    
    public InfoUIA busca(String id)
    {
    	if(catalogoMaestro.containsKey(id))
    		return catalogoMaestro.get(id);
    	else
    		return null;
    }
}
