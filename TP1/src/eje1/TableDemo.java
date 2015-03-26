package eje1;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JTabbedPane;
import java.io.*;


public class TableDemo extends JFrame{

    public TableDemo() {

         super("Ejemplo 3");
          

        DefaultTableModel myModel = new DefaultTableModel();
        myModel.addColumn("Nombre");
        myModel.addColumn("Nombre");
        myModel.addColumn("Nombre");
        myModel.addColumn("Nombre");
        myModel.addColumn("Nombre");
       
        JTable table = new JTable(myModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 150));


         
            BufferedReader br = null;
                try{
                    br = new BufferedReader(new FileReader("C:/Users/Shingo/Desktop/myDocument.txt"));
                    String line = br.readLine();

                    for(int row = 0; row < 10 ; row++){
                        for(int column = 0; column<5 ;column++){


                                   while (line != null )
                                   {
                                     String [] rowfields = line.split("\\.+");
                                     myModel.addRow(rowfields);
                                     line = br.readLine();
                                    }
                                   
                                }
                             }

                        }
                catch(Exception e)
                  {
                            System.out.println(e.getMessage());
                  }
        

        

        JTabbedPane panelInformacion = new JTabbedPane();
        JPanel panel1 = new JPanel();
        panel1.add( new JScrollPane( table ));
        panelInformacion.addTab( "Codigo", null, panel1, "Primer panel" );
        //agregar objeto JTabbedPane al contenedor
        getContentPane().add( panelInformacion );

        setSize( 800, 600 );
        setVisible( true );
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TableDemo aplicacion = new TableDemo();
	aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

}