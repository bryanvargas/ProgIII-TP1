//package com.persistencia;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Random;
//import com.gui.TablePanel;
//
//public class GeneradorFrases  {
//	private List<Frase> frase;
//	private int cantidad;
//	private String tema;
//	private String agresibidad;
//	private TablePanel tablaPanel;
//	private Repositorio db = new Repositorio();
//
//
//	public GeneradorFrases() {	
//
//	}
//	public GeneradorFrases(String tema2, int cantidad2, String agresibidad2) {
//		tablaPanel = new TablePanel();
//		tablaPanel.setData(db.getPalabra());
//		frase = new ArrayList<Frase>();
//		this.tema = tema2;
//		this.cantidad = cantidad2;
//		this.agresibidad = agresibidad2;
////		System.out.println(tablaPanel.getRow());
////		agregar();
//		generador2();
//	}
//	
//	public void generador(){				  
////        sentence = article[rand()];
////        char c = sentence.charAt(0);
////        sentence = sentence.replace( c, Character.toUpperCase(c) );
////        sentence += SPACE + noun[rand()] + SPACE;
////        sentence += (verb[rand()] + SPACE + preposition[rand()]);
////        sentence += (SPACE + article[rand()] + SPACE + noun[rand()]);
////        sentence += PERIOD;
////        System.out.println(sentence);
////        sentence = "";
//	
////		TreeMap<Integer, ArrayList<String>> a = new TreeMap<Integer, ArrayList<String>>();
////			System.out.println(palabra(1));
//			String elemento ="";
//			  Random rnd = new Random();
//			  int fila= 0;
//		  for (int j = 0; j < getCantidad(); j++) {			
//			  String[] frases = new String[4];
//			  for (int i = 0; i < 4; i++) {	
//				  fila= rnd.nextInt(6);				  
//				elemento= tablaPanel.columna(fila, i);
//				frases[i]=elemento;		
//			}
////			  addFrase(new Frase(frases[0], frases[1], frases[2], frases[3]));			 
//		}
//
//    }
//	
//	public void generador2(){			
//		for (int j = 0; j < getCantidad(); j++) {				 			  
//			ArrayList<String> miFrase = new ArrayList<String>();
//			miFrase.add(palabra(0));
//			miFrase.add(palabra(1));
//			miFrase.add(palabra(2));
//			miFrase.add(palabra(3));
//			miFrase.add(palabra(0));
//			miFrase.add(palabra(1));			
//			addFrase(new Frase(miFrase));		 
//		}
//		
//	}
//	
//	public String palabra(int columna){
//		String palabra = "";		
//		palabra = tablaPanel.columna(new Random().nextInt(6),columna);
//		return palabra;
//	}
//	 
//
//	
//
//	public List<Frase> getFrase() {
//		return frase;
//	}
//
//	public void setFrase(List<Frase> frase) {
//		this.frase = frase;
//	}
//
//public void addFrase(Frase palabra){
//		frase.add(palabra);
//	}
//	
////	public void addAListaDeFrases(int id, ArrayList<Frase> lista){
////		lasFrases.put(id, lista);
////	}
//
////	@Override
////	public Iterator<Frase> iterator() {		
////		return new MessageIterator(frase);
////	}
//
//	public int getCantidad() {
//		return cantidad;
//	}
//
//	public void setCantidad(int cantidad) {
//		this.cantidad = cantidad;
//	}
//
//	public String getTema() {
//		return tema;
//	}
//
//	public void setTema(String tema) {
//		this.tema = tema;
//	}
//
//	public String getAgresibidad() {
//		return agresibidad;
//	}
//
//	public void setAgresibidad(String agresibidad) {
//		this.agresibidad = agresibidad;
//	}
//	
//	
//	
//}
//
////class MessageIterator implements Iterator{
////	private Iterator<Frase> iterator;
////	public MessageIterator(List<Frase> mensajes){
////		iterator = mensajes.iterator();
////	}
////	@Override
////	public boolean hasNext() {		
////		return iterator.hasNext();
////	}
////	@Override
////	public Object next() {		
////		return iterator.next();	
////	}
////	@Override
////	public void remove(){
////		iterator.remove();
////	}
////	
//
