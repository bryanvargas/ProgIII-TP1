package com.negocio;



import java.io.File;
import java.io.IOException;

import java.util.List;


import com.gui.FormEvent;
import com.persistencia.*;
public class Controlador {
	Repositorio db = new Repositorio(); 
	GeneradorFrases generador;
	
	public List<Frase> getPalabra(){
		return db.getPalabra();
	}	
	public void addfrase(FormEvent ev) {		
			String tema = ev.getTema();
			int cantidad = ev.getCantidad();
			String agresibidad = ev.getAgresibidad();
			
			generador = new GeneradorFrases(tema, cantidad,agresibidad);			
			mostrar();
		}
	public List<Frase> mostrar(){		
		return generador.getFrase();
	}
	

	public List<Frase> getPerson(){
		return generador.getFrase();
	}
		
	
	
	public void deletePalabra(int index) {
			db.removePalabra(index);
		
	}
	
	public int getFilas(){
		return db.getRow();
	}
	public void saveToFile(File file) throws IOException{
		db.saveToFile(file);
	}
	
	public void loadFromFile(File file) throws IOException{
		db.loadFromFile(file);
	}
	
	public void guardar(){
		db.guardar();
	}
//	public void addfrase(FormEvent e, ArrayList<String> generado) {
//		// TODO Auto-generated method stub
//		
//	}




}
