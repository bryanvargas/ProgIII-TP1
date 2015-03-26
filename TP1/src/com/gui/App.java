package com.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class App {
	public static void main(String[] args) {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			 SwingUtilities.invokeLater(new Runnable() {				
				public void run() {
					new MainFrame();
				}
			});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lo sentimos, se cayo"+e.getMessage());
		}
	}
}


//https://darkbyteblog.wordpress.com/2011/07/23/java-textpad-demo/

//https://darkbyteblog.wordpress.com/2011/07/05/java-crear-un-editor-de-texto/
