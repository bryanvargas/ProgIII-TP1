package com.gui;


import java.awt.event.ActionListener;
import java.util.EventObject;

public class FormEvent extends EventObject {
	private String tema;
	private int cantidad;
	private String agresibidad;
	
	public FormEvent(Object source) {
		super(source);		
	}

	
	public FormEvent(Object source, String tema, int cantidad, String agresibidad) {
		super(source);
		this.tema = tema;
		this.cantidad= cantidad; 
		this.agresibidad = agresibidad;	
	}



	



	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getAgresibidad() {
		return agresibidad;
	}

	public void setAgresibidad(String agresibidad) {
		this.agresibidad = agresibidad;
	}
	
}
