package br.unifor.ads.pinii.arquiteturapin.entity;

import java.util.*;

public class Mesas {
	
	String NumeroMesa;
	String id;
	
	public Mesas(String numeroMesa, String id) {
		super();
		NumeroMesa = numeroMesa;
		this.id = id;
	}

	public String getNumeroMesa() {
		return NumeroMesa;
	}

	public void setNumeroMesa(String numeroMesa) {
		NumeroMesa = numeroMesa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	

}
