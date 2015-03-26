package com.gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import com.persistencia.GeneradorFrases;

public class TextPanel extends JPanel{ 
	private JTextArea textArea;
	public TextPanel() {
		textArea = new JTextArea();
//		textArea.setEditable(false);
//		textArea.setText("fdfdf");
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(String text){
		textArea.append(text);
		
	}
	
//	public void setData(GeneradorFrases db){
//		textArea.
//	}
	

	public void refresh() {
		textArea.setText("");
		
	}

	

}