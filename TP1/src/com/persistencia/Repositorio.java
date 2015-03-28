package com.persistencia;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.gui.TablePanel;

import encapsulamiento.Frase;

public class Repositorio {
private List<Frase> ListaPalabras;	
private List<Frase> frase;

private int cantidad;
private String tema;
private String agresibidad;
private TablePanel tablaPanel;
	public Repositorio() {		
		this.ListaPalabras = new LinkedList<Frase>();  	
		tablaPanel = new TablePanel();
		tablaPanel.setData(this.getPalabra());
		frase = new ArrayList<Frase>();
		creatArr();
	}
	
	public void removePalabra(int index){
		ListaPalabras.remove(index);
	}
	
	public List<Frase> getPalabra(){
		return Collections.unmodifiableList(ListaPalabras);
	}
	
	public int getRow(){
		return ListaPalabras.size();
	}	


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		
		this.cantidad = cantidad;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getAgresibidad() {
		return agresibidad;
	}

	public void setAgresibidad(String agresibidad) {
		this.agresibidad = agresibidad;
	}

	private  void creatArr()
	  {
	     BufferedReader br = null;	      
	     try
	    {
	      br = new BufferedReader(new FileReader("C:/Users/Shingo/Desktop/segundaLista.txt"));
//	      br = new BufferedReader(new FileReader("C:/Users/Shingo/Desktop/myDocument.txt"));
	      String line = br.readLine();
	      Random rnd = new Random();
	      int a = 0;
	      while (line != null )
	      {
	    	  a= rnd.nextInt(4);
	        String [] rowfields = line.split("\\.");
	        
	        ListaPalabras.add(new Frase(rowfields[0],rowfields[1],rowfields[2],rowfields[3],rowfields[4],rowfields[5]));
	        line = br.readLine();
	       }	      
	    }
	    catch (FileNotFoundException e){	    
	      e.printStackTrace();
	    }
	    catch (IOException e){
	      e.printStackTrace();
	    }
	     
	     
	}

	public void saveToFile(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Frase[] persons = ListaPalabras.toArray(new Frase[ListaPalabras.size()]);
		
		oos.writeObject(persons);
		oos.close();
	}
	
	public void loadFromFile(File file) throws IOException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			Frase[] persons = (Frase[])ois.readObject();
			ListaPalabras.clear();
			ListaPalabras.addAll(Arrays.asList(persons));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ois.close();
	}

	public void guardar() {
		// TODO Auto-generated method stub
		
	}
	

	
	
	public void generador2(){	
		frase.clear();
		for (int j = 0; j < getCantidad(); j++) {				 			  
			ArrayList<String> miFrase = new ArrayList<String>();
			miFrase.add(palabra(0));System.out.println("hola mundo");
			miFrase.add(palabra(1));
			miFrase.add(palabra(2));
			miFrase.add(palabra(3));
			miFrase.add(palabra(0));
			miFrase.add(palabra(1));
			System.out.println("hola");
			addFrase(new Frase(miFrase));		 
		}
		
	}
	public void addListaPalabras(Frase palabra){
		ListaPalabras.add(palabra);
	}
	public String palabra(int columna){
		String palabra = "";		
		palabra = tablaPanel.columna(new Random().nextInt(6),columna);
		return palabra;
	}
	public List<Frase> getFrase() {
		return frase;
	}

	public void setFrase(List<Frase> frase) {
		this.frase = frase;
	}
	public void addFrase(Frase palabra){
		frase.add(palabra);
	}



}
