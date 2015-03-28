package encapsulamiento;

import java.io.Serializable;
import java.util.ArrayList;



public class Frase implements Serializable{	
	private static final long serialVersionUID = 5372008368050494797L;	
	private String articulo, sustantivo,sustantivo2,sustantivo3,sustantivo4, verbo,preposicion, preposicion2,preposicion3 ,pronombre, adjetivo, adverbio;
	private ArrayList<String> frase;
	
	
	public Frase() {
		
	}
	public Frase(String articulo, String sustantivo, String verbo, String preposicion, String adjetivo,String advervio) {
		
		this.articulo = articulo;
		this.sustantivo = sustantivo;
		this.verbo = verbo;
		this.preposicion = preposicion;
		this.adjetivo = adjetivo;
		this.adverbio = advervio;
	}
	public Frase(ArrayList<String> frase) {
		this.frase = frase;
	}

	

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
//		System.out.println(f);
		return f;
	}
	
}