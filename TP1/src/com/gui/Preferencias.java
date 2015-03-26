package com.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class Preferencias extends JDialog {
	private JButton okButton;
	private JButton cancelButton;
	private JSpinner portSpinner;
	private SpinnerNumberModel spinnerModel;
	private JTextField userField;
	private JPasswordField passField;
	private JComboBox comboLAF;
	private JLabel prefer;
	
	private PrefsListener prefsListener;
	
	public	Preferencias(JFrame parent){
		super(parent, "Preferences", false);
		
		okButton= new JButton("OK");
		cancelButton = new JButton("CANCEL");
		comboLAF = new JComboBox(cargarLAFsDisponibles());
		prefer = new JLabel("Apariencia");
		
//		comboLAF.setBounds(50, 60, 40, 40);
		spinnerModel = new SpinnerNumberModel(3306,0,9999,1);
		portSpinner = new JSpinner(spinnerModel);
//		getContentPane().setBackground(Color.GREEN);
		userField  = new JTextField(10);
		passField = new JPasswordField(10);
		
//		seteat la forma es que se escribe el pasword  de "*" a "&"
		passField.setEchoChar('&');
		
		layoutControls();
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				accionesAplicar();
				if(prefsListener !=null){
					prefsListener.preferencesSet(accionesAplicar());
				}
				setVisible(false);
				
			}
		});
		
		
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
			
		});
		
		
		
		setSize(305,230);
		setLocationRelativeTo(parent);
	}
	
	 private int accionesAplicar(){
		 	  //Ya vimos para qué es...
		 	  LookAndFeelInfo[] infoLAF;
		 	  //Esto también...
		 	  infoLAF = UIManager.getInstalledLookAndFeels();
		 	  //Aquí guardamos el índice de selección del combo:
		 	  int seleccion = comboLAF.getSelectedIndex();
//		 	   String sd =  infoLAF[seleccion].getName();
		 	  try {
		 	   //Aquí aplicamos el L&F usando la selección del combo:
		 	   UIManager.setLookAndFeel(infoLAF[seleccion].getClassName());
		 	   //Aquí pedimos actualizar la GUI con el nuevo L&F:
		 	   SwingUtilities.updateComponentTreeUI(Preferencias.this);


		 	  }
		 	  catch (Exception e) {
		 	   e.printStackTrace();
		 	  }
		 	  return seleccion;
		 	 }
	private Object[] cargarLAFsDisponibles() {
		LookAndFeelInfo[] info;
		Object[] nombresLAF;
		
		info = UIManager.getInstalledLookAndFeels();
		nombresLAF = new Object[info.length];
		
		for (int i = 0; i < info.length; i++) {
			nombresLAF[i] = info[i].getName();
		}
		return nombresLAF;

	}

	private void layoutControls(){
		setLayout(null);
		JPanel controlsPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		controlsPanel.setLayout(null);
		buttonsPanel.setLayout(null);
		
		int space = 15;
		Border spaceBorder = BorderFactory.createEmptyBorder(space,space,0,space);
		Border titleBorder = BorderFactory.createTitledBorder("Apariencias");
		
		
//		controlsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		controlsPanel.setBorder(titleBorder);
		controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder,titleBorder));
		
//		buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		buttonsPanel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED));

		comboLAF.setBounds(140, 35, 105, 20);
		controlsPanel.add(comboLAF);
		prefer.setBounds(50, 35, 70, 20);
		controlsPanel.add(prefer);
		
		okButton.setBounds(110, 0, 70, 20);
		buttonsPanel.add(okButton);
		
		cancelButton.setBounds(115+70, 0, 90, 20);
		buttonsPanel.add(cancelButton);

		controlsPanel.setBounds(0, 0, 300, 160);
		buttonsPanel.setBounds(0, 170, 300, 30);
		add(controlsPanel);
		add(buttonsPanel);

		
	}

	public void setDefaults(String user){
		userField.setText(user);
	
	}
	public void setPrefsListener(PrefsListener prefsListener) {
		this.prefsListener = prefsListener;
		
	}


}