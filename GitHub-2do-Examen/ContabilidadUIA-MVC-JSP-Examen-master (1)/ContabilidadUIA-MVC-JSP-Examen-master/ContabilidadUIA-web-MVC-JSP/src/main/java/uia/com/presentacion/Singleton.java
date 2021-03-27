package main.java.uia.com.presentacion;

import main.java.uia.com.contabilidad.ContabilidadUIA;

public class Singleton {

		public static ContabilidadUIA singleton= new ContabilidadUIA();

	   /* A private Constructor prevents any other
	    * class from instantiating.
	    */
	   public Singleton() { }

	   /* Static 'instance' method */
	   public static ContabilidadUIA getInstance( ) {
	      return singleton;
	   }

	   public static ContabilidadUIA getSingleton() {
		return singleton;
	}

	public static void setSingleton(ContabilidadUIA singleton) {
		Singleton.singleton = singleton;
	}

	
	}