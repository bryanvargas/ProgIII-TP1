package com.gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



import com.persistencia.GeneradorFrases;
import com.persistencia.Frase;

public class MessagePanel extends JPanel {
	private JList lista;
//	private GeneradorFrases mensajes;
	private DefaultListModel messageListModel;
	
	public MessagePanel() {
		
		messageListModel = new DefaultListModel();
		lista = new JList(messageListModel);
//		mensajes = new GeneradorFrases();
		setLayout(new BorderLayout());
		
		add(new JScrollPane(lista), BorderLayout.CENTER);

	}
	
//	public void mostrarMensajes(){
//		messageListModel.removeAllElements();
//		for (Palabra frase:mensajes) {
//			messageListModel.addElement(frase);
//			
//			System.out.println(frase.toString());
//		}
//		lista.setModel(messageListModel);
//	}
	
	public void setData(List<Frase> db){
		messageListModel.removeAllElements();
		for (Frase frase:db) {
			messageListModel.addElement(frase);
			
//			System.out.println(frase.toString());
		}
//		messageListModel.setData(db);
	}
//
//	public void setData(List<Frase> mostrar) {
//		// TODO Auto-generated method stub
//		
//	}






	
	
	
}
