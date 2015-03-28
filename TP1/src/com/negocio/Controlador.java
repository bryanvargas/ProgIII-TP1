package com.negocio;



import java.io.File;
import java.io.IOException;
import java.util.List;



import com.gui.FormEvent;
import com.persistencia.*;

import encapsulamiento.Frase;
public class Controlador {
	Repositorio db = new Repositorio(); 
//	GeneradorFrases generador;
	
	public List<Frase> getPalabra(){
//		return db.getPalabra();
		return db.getPalabra();
	}	
	public void addfrase(FormEvent ev) {			
			db.setTema(ev.getTema());
			db.setCantidad(ev.getCantidad());
			db.setAgresibidad(ev.getAgresibidad());	
			System.out.println(ev.getAgresibidad());
			db.generador2();
//			mostrar();
		}
	public List<Frase> mostrar(){	
		
		return db.getFrase();
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
