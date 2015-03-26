package com.persistencia;

import java.io.Serializable;
import java.util.ArrayList;



public class Frase implements Serializable{

	
	private static final long serialVersionUID = 5372008368050494797L;
	private static int count  = 0;
	private String articulo, sustantivo, verbo,preposicion, pronombre;
	private ArrayList<String> frase;
	
	
	public Frase() {
		
	}
	public Frase(String articulo, String sustantivo, String verbo, String preposicion) {
		
		this.articulo = articulo;
		this.sustantivo = sustantivo;
		this.verbo = verbo;
		this.preposicion = preposicion;
	}
	public Frase(ArrayList<String> frase) {
		this.frase = frase;
	}

	
//	public Frase(ArrayList<String> arrayList) {
//		// TODO Auto-generated constructor stub
//	}
	////**************/////////////
	public String getSustantivo() {
		return sustantivo;
	}
	public void setSustantivo(String sustantivo) {
		this.sustantivo = sustantivo;
	}
	public String getVerbo() {
		return verbo;
	}
	public void setVerbo(String verbo) {
		this.verbo = verbo;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getPreposicion() {
		return preposicion;
	}
	public void setAdjetivo(String adjetivo) {
		this.preposicion = adjetivo;
	}
//	@Override
//	public String toString() {
//		return articulo + " "+ sustantivo+ " " + verbo + " " + preposicion;
//	}
	public ArrayList<String> getFrase() {
		return frase;
	}
	public void setFrase(ArrayList<String> frase) {
		this.frase = frase;
	}
	@Override
	public String toString() {
		String f ="";
		for (String elem : frase) {
			f += elem + " ";
		}
		System.out.println(f);
		return f;
	}
	
}