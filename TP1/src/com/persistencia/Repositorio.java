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
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Repositorio {
private List<Frase> frase;	
private List<GeneradorFrases> oracion;
//static ArrayList rosterList = new ArrayList();
	public Repositorio() {
		this.frase = new LinkedList<Frase>();        
		creatArr();
	}
	
	public void addPalabra(GeneradorFrases frase){
		this.oracion.add(frase);
	}
	
	public void removePalabra(int index){
		frase.remove(index);
	}
	
	public List<Frase> getPalabra(){
		return Collections.unmodifiableList(frase);
	}
	
	public int getRow(){
		return frase.size();
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
	        frase.add(new Frase(rowfields[0],rowfields[1],rowfields[2],rowfields[3]));
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
		
		Frase[] persons = frase.toArray(new Frase[frase.size()]);
		
		oos.writeObject(persons);
		oos.close();
	}
	
	public void loadFromFile(File file) throws IOException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			Frase[] persons = (Frase[])ois.readObject();
			frase.clear();
			frase.addAll(Arrays.asList(persons));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ois.close();
	}

	public void guardar() {
		// TODO Auto-generated method stub
		
	}

}
