package eje1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Random;

import javax.swing.JOptionPane;

public class ManejoArchivos {

	public static void main(String[] args) {

		File fichero = new File("C://Users/Shingo/Desktop/prueba.txt");
		escribirFichero(fichero, "Juan");
		escribirFichero(fichero, "Josue");
		modificarFichero(fichero, "Juan", "Pedro");
		leerFichero(fichero);
		eliminarRegistro(fichero, "Josue");
//		leerFichero(fichero);
	}

	private static void eliminarRegistro(File FficheroAntiguo,String Satigualinea) {
		 /*Obtengo un numero aleatorio*/
        Random numaleatorio= new Random(3816L); 
        /*Creo un nombre para el nuevo fichero apartir del
         *numero aleatorio*/
        String SnombFichNuev=FficheroAntiguo.getParent()+"/auxiliar"+String.valueOf(Math.abs(numaleatorio.nextInt()))+".txt";
        /*Crea un objeto File para el fichero nuevo*/
        File FficheroNuevo=new File(SnombFichNuev);
        try {
            /*Si existe el fichero inical*/
            if(FficheroAntiguo.exists()){
                /*Abro un flujo de lectura*/
                BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                /*Recorro el fichero de texto linea a linea*/
                while((Slinea=Flee.readLine())!=null) { 
                     /*Si la linea obtenida es distinta al la bucada
                     *para eliminarr*/
                    if (!Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
                       /*la escribo en el fichero nuevo*/ 
                    	escribirFichero(FficheroNuevo,Slinea);
                    }else{
                        /*Si es igual simplemete no hago nada*/
                    }             
                }
                /*Obtengo el nombre del fichero inicial*/
                String SnomAntiguo=FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del fichero inicial*/
                FficheroNuevo.renameTo(FficheroAntiguo);
                /*Cierro el flujo de lectura*/
                Flee.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
    } 


	private static void BorrarFichero(File fichero) {
		try {
			if (!fichero.exists()) {
				fichero.delete();
				JOptionPane.showMessageDialog(null, "Fichero Borrado ");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

	}

	private static void leerFichero(File fichero) {
		try {
			if (!fichero.exists()) {
				BufferedReader leer = new BufferedReader(new FileReader(fichero));
				String linea;
				while((linea = leer.readLine())!=null){
					System.out.println(linea);
				}
				 System.out.println("*********Fin Leer Fichero**********");
		           /*Cierra el flujo*/
		           leer.close();
			}else{
				System.out.println("Fichero No Existe");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

	}

	private static void modificarFichero(File FficheroAntiguo,String Satigualinea,String Snuevalinea) {
		 /*Obtengo un numero aleatorio*/
        Random numaleatorio= new Random(3816L); 
        /*Creo un nombre para el nuevo fichero apartir del
         *numero aleatorio*/
        String SnombFichNuev=FficheroAntiguo.getParent()+"/auxiliar"+String.valueOf(Math.abs(numaleatorio.nextInt()))+".txt";
        /*Crea un objeto File para el fichero nuevo*/
        File FficheroNuevo=new File(SnombFichNuev);
        try {
            /*Si existe el fichero inical*/
            if(FficheroAntiguo.exists()){
                /*Abro un flujo de lectura*/
                BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                /*Recorro el fichero de texto linea a linea*/
                while((Slinea=Flee.readLine())!=null) { 
                    /*Si la lia obtenida es igual al la bucada
                     *para modificar*/
                    if (Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
                        /*Escribo la nueva linea en vez de la que tenia*/
                    	escribirFichero(FficheroNuevo,Snuevalinea);
                    }else{
                        /*Escribo la linea antigua*/
                    	escribirFichero(FficheroNuevo,Slinea);
                    }             
                }
                /*Obtengo el nombre del fichero inicial*/
                String SnomAntiguo=FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del fichero inicial*/
                FficheroNuevo.renameTo(FficheroAntiguo);
                /*Cierro el flujo de lectura*/
                Flee.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }

	}

	private static void escribirFichero(File fichero, String cadena) {
		try {
			if (!fichero.exists()) {
				fichero.createNewFile();
			}
			BufferedWriter escribir = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(fichero, true),
							"utf-8"));
			escribir.write(cadena + "\r\n");
			escribir.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

	}
}
