package com.gui;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import encapsulamiento.Frase;


public class MessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JList<Frase> lista;
	private DefaultListModel<Frase> messageListModel;
	
	public MessagePanel() {		
		messageListModel = new DefaultListModel<Frase>();
		lista = new JList<Frase>(messageListModel);
		setLayout(new BorderLayout());		
		add(new JScrollPane(lista), BorderLayout.CENTER);
	}	

	public void setData(List<Frase> db){	
		for (Frase frase:db) {
			System.out.println(frase);
			messageListModel.addElement(frase);
		}		
	}


	public void clearList(){
        messageListModel.clear();
	}









	
	
	
}
