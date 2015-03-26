package com.gui;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class FormPanel extends JPanel{
	private JLabel $temaFrase_jl, $cantidadFrase_jl, $nivelAgresiv_jl,
				   $complexGramatical_jl,$agresiv_jl;
	private JComboBox $listaTema_jcb, $cantFrases_jcb;
	private JSpinner $cantFrases_js;
	private SpinnerNumberModel $spinnerModelo_snm;
	private JSlider $nivelAgresibidad_s;
	private JList ageList;
	private JButton generar_btn;
	private JRadioButton bajoRadio;
	private JRadioButton medioRadio;
	private JRadioButton altoRadio;
	private ButtonGroup agresibidadGroup;
	private FormListener formListener;
	 static final int FPS_INIT = 5; 
	  int frameNumber = 0;
	    int delay;
	    Timer timer;
	    boolean frozen = false;
	
	public FormPanel() {
		setLayout(null);
		Dimension dim = getPreferredSize();
		dim.width = 257;	
		setPreferredSize(dim);
		setMinimumSize(dim);
//		inicializarComponentes();
	

//	private void inicializarComponentes() {
		$temaFrase_jl = new JLabel("Seleccione Tema");
		$temaFrase_jl.setBounds(20,40, 120, 25);
		add($temaFrase_jl);
		
		$listaTema_jcb = new JComboBox();
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		modelo.addElement("Amor");
		modelo.addElement("Amistad");
		modelo.addElement("Tristeza");
		modelo.addElement("Alegria");
		modelo.addElement("Dolor");
		modelo.addElement("Odio");
		$listaTema_jcb.setModel(modelo);
		$listaTema_jcb.setSelectedItem(0);
		$listaTema_jcb.setEditable(true);
		$listaTema_jcb.setBounds(120, 40, 85, 25);
		add($listaTema_jcb);
		
		$cantidadFrase_jl = new JLabel("Cantidad: ");
		$cantidadFrase_jl.setBounds(20, 80, 120, 25);
		add($cantidadFrase_jl);
		$cantFrases_jcb = new JComboBox();
		for(int f=1;f<=50;f++) {
			$cantFrases_jcb.addItem(String.valueOf(f));
        }
		$cantFrases_jcb.setMaximumRowCount(5);
		$cantFrases_jcb.setBounds(120, 80, 85, 25);
		add($cantFrases_jcb);
		
		//Set Up slider
		
		$nivelAgresibidad_s = new JSlider(JSlider.VERTICAL, 0, 10, FPS_INIT);
//		$nivelAgresiv_jl.setSize(20, 20);
		$nivelAgresibidad_s.addChangeListener(new SliderListener());
		$nivelAgresibidad_s.setMajorTickSpacing(1);
		$nivelAgresibidad_s.setMinorTickSpacing(1);
		$nivelAgresibidad_s.setPaintTicks(true);
		
		// turns on labels at major tick marks
		// requires spacing for major ticks to be non-zero
		$nivelAgresibidad_s.setPaintLabels(true);
		$nivelAgresibidad_s.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		$nivelAgresibidad_s.setMinimum(1);
		

		
		ageList = new JList();
		DefaultListModel ageModel = new DefaultListModel();
		
		ageModel.addElement(new AgeCategory(0,"Baja"));
		ageModel.addElement(new AgeCategory(1,"Medio"));
		ageModel.addElement(new AgeCategory(2,"Alta"));
		ageList.setModel(ageModel);
		
		ageList.setPreferredSize(new Dimension(110,66));
		ageList.setBorder(BorderFactory.createEtchedBorder());		
		ageList.setSelectedIndex(2);
		ageList.setBounds(120, 230, 88, 65);
		add(ageList);
		
		$nivelAgresiv_jl = new JLabel("Agresividad");
		$nivelAgresiv_jl.setBounds(20, 230, 80, 30);
		add($nivelAgresiv_jl);
		
		
		
		$agresiv_jl = new JLabel("Agresibidad");
		$agresiv_jl.setBounds(20, 110, 100, 50);
		add($agresiv_jl);
		bajoRadio = new JRadioButton("bajo");
		medioRadio = new JRadioButton("medio"); 
		altoRadio = new JRadioButton("alto"); 
		
		bajoRadio.setActionCommand("bajo");
		medioRadio.setActionCommand("medio");
		altoRadio.setActionCommand("alto");
		
		bajoRadio.setBounds(120, 110, 100, 50);
		add(bajoRadio);
		medioRadio.setBounds(120, 140, 100, 50);
		add(medioRadio);
		altoRadio.setBounds(120, 170, 100, 50);
		add(altoRadio);
		
		agresibidadGroup = new ButtonGroup();
		
		medioRadio.setSelected(true);
		
		//Set up genter Radios
		agresibidadGroup.add(bajoRadio);
		agresibidadGroup.add(medioRadio);
		agresibidadGroup.add(altoRadio);
		
	
		
		
   

		generar_btn = new JButton("Generar frase");
		generar_btn.setBounds(70, 350, 120, 30);
		generar_btn.setMnemonic(KeyEvent.VK_O);
		add(generar_btn);
		
		
		
//		$cantidadFrase_jl = new JLabel("");
		$spinnerModelo_snm = new SpinnerNumberModel(0,0,9999,1);
		$cantFrases_js = new JSpinner($spinnerModelo_snm);
		
		
		
		
		
		generar_btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
				String tema = (String)$listaTema_jcb.getSelectedItem();	
				String nivel = (String) $cantFrases_jcb.getSelectedItem();
				int nivelInteger = Integer.parseInt(nivel);
				
				String agresibidad = agresibidadGroup.getSelection().getActionCommand();				
//				System.out.println(tema+ "  " +nivel+"  "+ agresibidad);			
				
				FormEvent ev = new FormEvent(this, tema, nivelInteger, agresibidad);
				
				if (formListener != null) {
					formListener.formEventOccurred(ev);
					
				}
				
			}
		});
		
		
		
		
		
		
		Border innerBorder = BorderFactory.createTitledBorder("Generador de Frases");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);		
//		setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
	setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generador de Frases", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14), new java.awt.Color(000,000 , 000)));
		
		layoutComponents();
//	}
}
	private void layoutComponents() {	
	}
	
    /** Listens to the slider. */
    class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
	    JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        int fps = (int)((JSlider)e.getSource()).getValue();
	        if (fps == 0) {
		    if (!frozen) stopAnimation();
	        } else {
                    delay = 1000 / fps;
//                    timer.setDelay(delay);
		    if (frozen) startAnimation();
	        }
	    }
        }
    } 
    public void startAnimation() {
        //Start (or restart) animating!
        timer.start();
	frozen = false;
    }

    public void stopAnimation() {
        //Stop the animating thread.
        timer.stop();
	frozen = true;
    }
    
    class AgeCategory{
    	private String text;
    	private int id;
    	public AgeCategory(int id, String text){
    		this.id = id;
    		this.text = text;
    	}
    	
    	@Override
    	public String toString() {	
    		return this.text;
    	}

    	public int getId() {
    		return id;
    	}
    	
    	
    }
    
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
		
	} 
//	



	
	
	
}
