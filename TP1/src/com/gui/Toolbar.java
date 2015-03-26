package com.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar implements ActionListener{
	private JButton saveButton;
	private JButton refreshButton;
	private JButton preferenciasButton;
	private ToolbarListener textListener;
	public Toolbar() {
		
		
//		
//		Dimension dim = getPreferredSize();
//		dim.width = 300;
//		dim.height = 35;
//		setPreferredSize(dim);
		
		setBorder(BorderFactory.createEtchedBorder());
		setFloatable(false);
		saveButton = new JButton();
		saveButton.setIcon(createIcon("/images/l.png"));
		saveButton.setToolTipText("Save");
		
		
		refreshButton = new JButton();
		
		saveButton.addActionListener(this);
		refreshButton.addActionListener(this);
		refreshButton.setIcon(createIcon("/images/k.png"));
		refreshButton.setToolTipText("Imprimir");
		
		preferenciasButton = new JButton();
		preferenciasButton.setIcon(createIcon("/images/j.png"));
		preferenciasButton.setToolTipText("Preferencias");
		preferenciasButton.addActionListener(this);
		
		
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		add(saveButton);
//		addSeparator();
		add(refreshButton);
		addSeparator(new Dimension(500,0));
		add(preferenciasButton);
	}
	
	private ImageIcon createIcon(String path){
		URL url = getClass().getResource(path);
		if(url == null){
			System.err.println("Unable to load image: "+ path);
		}
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}


	
	public void setToolbarListener(ToolbarListener listener){
		this.textListener = listener;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("A button has been clicked");
		JButton clicked = (JButton)e.getSource();
		if(clicked == saveButton){
//			textPanel.appendText("Hello Pelotudo\n");
			if (textListener != null) {
				textListener.saveEventOccured();
			}
		}else if (clicked == refreshButton){
//			textPanel.appendText("Godbye pelotudo\n");
			if (textListener != null) {
				textListener.refreshEventOccured();
			}
		}else if (clicked == preferenciasButton){
//			textPanel.appendText("Godbye pelotudo\n");
			if (textListener != null) {
				textListener.prefEventOcurred();
			}
		}
		
	}
}
