package com.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;


import java.util.prefs.Preferences;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.negocio.Controlador;


public class MainFrame extends JFrame {	

	private static final long serialVersionUID = -4400693783804967080L;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Toolbar toolbar;
	private Preferencias prefsDialog;
	private TextPanel textPanel;
	private JSplitPane splitPane;
	private JTabbedPane tabPane;
	private TablePanel tablePanel;
	private MessagePanel messagePanel;
	Controlador controlador;
	private Preferences prefs;
	
	public MainFrame() {
//		super("Hello World");
		try {
			
//			JFrame.setDefaultLookAndFeelDecorated(true);
//			JDialog.setDefaultLookAndFeelDecorated(true);
//		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		    UIManager.setLookAndFeel(obtenerLAF());
		} catch (Exception e) {
			// TODO: handle exception
		}
		setTitle("Helo Wolrd");
		
		setIconImage(new ImageIcon(getClass().getResource("/images/w.png")).getImage());
	
		setJMenuBar(createMenuBar());
//		setJMenuBar(createMenuBar());
		setLayout(new BorderLayout());
		formPanel = new FormPanel();
		textPanel = new TextPanel();
		tabPane = new JTabbedPane();
		tablePanel = new TablePanel();
		controlador  = new Controlador();
		messagePanel = new MessagePanel();
		tablePanel.setData(controlador.getPalabra());
		prefsDialog = new Preferencias(this);
		prefs = Preferences.userRoot().node("db");
//		messagePanel.setData(controlador.mostrar());
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,formPanel,tabPane);
		
		splitPane.setOneTouchExpandable(true);
		
		tabPane.addTab("Frases", messagePanel);
		tabPane.addTab("Palabra Database", tablePanel);
		tabPane.addTab("Notas", textPanel);

		
		
		formPanel.setFormListener(new FormListener() {			
			public void formEventOccurred(FormEvent e) {
				messagePanel.clearList();
//				 String name = e.getTema();
//				 int occupation = e.getCantidad();
//				 int occupation = e.getCantidad();				
//				 String ageCat = e.getAgresibidad();				
//				 textPanel.appendText(name + ": " +occupation+ ": "+ ageCat+
//				 ", " + "\n");
//				 textPanel.appendText(name + ": " +occupation+ ": "+ ageCat+
//						 ", " + "\n");				 
//				 System.out.println(tablePanel.columna(2, 3));
				 controlador.addfrase(e);
			
				 messagePanel.setData(controlador.mostrar());
//					controlador.addPerson(e);
				 
			}
		});
		
		tabPane.addChangeListener(new ChangeListener() {	
			public void stateChanged(ChangeEvent e) {
				int tablaIndex = tabPane.getSelectedIndex();
				if (tablaIndex==1) {
					textPanel.refresh();
				}
//				System.out.println(tablaIndex);			
			}
		});
		
		
		
		
		
//		formPanel.setVisible(false);
		formPanel.setVisible(true);
		
		
		
		prefsDialog.setPrefsListener(new PrefsListener(){
//			public void preferencesSet(String user) {
//				prefs.put("user", user);
//				System.out.println(user);
//				
//			}

			@Override
			public void preferencesSet(int i) {
				prefs.putInt("user", i);
				System.out.println(i);
				accionesAplicar(i);
				
			}
			
		});
		String user = prefs.get("user", "");
		prefsDialog.setDefaults(user);
		
		toolbar.setToolbarListener(new ToolbarListener() {			
			public void refreshEventOccured() {
				System.out.println("inprimir");				
			}
			public void saveEventOccured() {
//				System.out.println("guardar");	
				controlador.guardar();	
				
			}
			public void prefEventOcurred() {
//				System.out.println("Preferecnias");
				prefsDialog.setVisible(true);
//				accionesAplicar();
				
			}
		});

		
		
		
//		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.PAGE_START);
		// add(textPanel, BorderLayout.CENTER);
		add(splitPane, BorderLayout.CENTER);
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		setMinimumSize(new Dimension(675, 580));
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	protected void accionesAplicar(int d) {
		LookAndFeelInfo[] info;
		info = UIManager.getInstalledLookAndFeels();
		
		try {
			UIManager.setLookAndFeel(info[d].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}

	private String obtenerLAF() {
		
		return UIManager.getInstalledLookAndFeels()[3].getClassName();
	}

	private JMenuBar createMenuBar() {
		toolbar = new Toolbar();
		
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");

		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		JMenuItem prefsItem = new JMenuItem("Preferences...");
		

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");

		// JMenuItem showFormItem = new JMenuItem("Person Form");
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		windowMenu.add(prefsItem);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
	
		

		showFormItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();
				if (menuItem.isSelected()) {
					splitPane.setDividerLocation((int)formPanel.getMinimumSize().getWidth());
				}
				formPanel.setVisible(menuItem.isSelected());
			}
		});

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		// fileMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
		// ActionEvent.SHIFT_MASK));
		
		importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I ,
				ActionEvent.CTRL_MASK));
		
		

		importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controlador.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.refresh();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"Could not load data from file", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					// System.out.println(fileChooser.getSelectedFile());
				}

			}
		});

		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controlador.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// System.out.println(fileChooser.getSelectedFile());
				}

			}
		});

		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// String $text = JOptionPane.showInputDialog(MainFrame.this,
				// "Enter your user name"
				// ,
				// "Enter User Name",JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
				// System.out.println($text);

				int $action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Do you really want to exit the appication?",
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

				if ($action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}

			}
		});
		return menuBar;

	}
}
