package eje1;

/*
 *Autor:LBVP
 */


import java.io.*;
import java.util.Random;

public class POST8 {


    public static void main(String[] args) {
        /*Creo un onjeto File. Recibe como parametro la ruta completa con el nombre del fichero
         * Para los usuarios de Windows la ruta seria mas o menos asi:"c:\\MiFichero.txt"*/
        File Ffichero=new File("C://Users/Shingo/Desktop/prueba.txt");
//        EcribirFichero(Ffichero,"Juan");
//        EcribirFichero(Ffichero,"Ana");
//        EcribirFichero(Ffichero,"Pedro");
//        ModificarFichero(Ffichero,"Pedro","Maria");
//        LeerFichero(Ffichero);
        EliminarRegistro(Ffichero,"Juan");
        EliminarRegistro(Ffichero,"Ana");
        LeerFichero(Ffichero);
        
        }
    public static void EcribirFichero(File Ffichero,String SCadena){
        try {
                //Si no Existe el fichero lo crea
                if(!Ffichero.exists()){
                     Ffichero.createNewFile();
                }
               //Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. Ademas   en
               //el pedazo de sentencia "FileOutputStream(Ffichero,true)", true es por si existe el fichero
               //segir añadiendo texto y no borrar lo que tenia 
                BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));
                //Escribe en el fichero la cardena que recibe la funcion. la cadena "\r\n" significa salto de linea
                Fescribe.write(SCadena + "\r\n");
                //Cierra el flujo de escritura
                Fescribe.close();
            } catch (Exception ex) {
               //Captura un posible error y le imprime en pantalla 
               System.out.println(ex.getMessage());
            }
        
    }
/*Funcion que lee el contenido de un fichero de texto
*Parametro:Ffichero. Objeto de la clase file donde se va a leer
*/    
public static  void LeerFichero(File Ffichero){
   try {
       /*Si existe el fichero*/
       if(Ffichero.exists()){
           /*Abre un flujo de lectura a el fichero*/
           BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
           String Slinea;
           System.out.println("**********Leyendo Fichero***********");
           /*Lee el fichero line a linea hasta llegar a la ultima*/
           while((Slinea=Flee.readLine())!=null) {
           /*Imprime la linea leida*/    
           System.out.println(Slinea);              
           }
           System.out.println("*********Fin Leer Fichero**********");
           /*Cierra el flujo*/
           Flee.close();
         }else{
           System.out.println("Fichero No Existe");
         }
   } catch (Exception ex) {
       /*Captura un posible error y le imprime en pantalla*/ 
        System.out.println(ex.getMessage());
   }
 }
/*Metodo que borra un fichero si existe
 *Parametro:Ffichero. Objeto de la clase file donde se va a borrar
 */    
public static  void BorrarFichero(File Ffichero){
     try {
         /*Si existe el fichero*/
         if(Ffichero.exists()){
           /*Borra el fichero*/  
           Ffichero.delete(); 
           System.out.println("Fichero Borrado con Exito");
         }
     } catch (Exception ex) {
         /*Captura un posible error y le imprime en pantalla*/ 
          System.out.println(ex.getMessage());
     }
} 
/***********************************************************
 * Modificar un fichero de texto, consiste en leer un archvo
 *y esbribir su con tenido en uno nuevo llamado X, excepto la 
 *linea a modificar que se remplaza con la linea nueva.Luego
 *se borra el fichero inicial y se renombra el nuevo fichero
 *con el nombre del archivo inicial 
 ***********************************************************
 *PARAMETROS:
 *FficheroAntiguo:Objeto File del fichero a modificar
 *Satigualinea:Linea que se busca para modificar
 *Snuevalinea:Linea con la que se va a remplazar la vieja
 ***********************************************************/
    public static  void ModificarFichero(File FficheroAntiguo,String Satigualinea,String Snuevalinea){        
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
                         EcribirFichero(FficheroNuevo,Snuevalinea);
                    }else{
                        /*Escribo la linea antigua*/
                         EcribirFichero(FficheroNuevo,Slinea);
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
        /***********************************************************
        *Eliminar un registro dentro de un fichero de texto, 
        *consiste en leer un archvo y esbribir su contenido en uno 
        *nuevo llamado X, excepto la linea a eliminar.Luego se borra 
        *el fichero inicial y se renombra el nuevo fichero con el 
        *nombre del archivo inicial 
        ***********************************************************
        *PARAMETROS:
        *FficheroAntiguo:Objeto File del fichero a eliminar el reg
        *Satigualinea:Linea que se busca para eliminar
        ***********************************************************/    
       public static  void EliminarRegistro(File FficheroAntiguo,String Satigualinea){        
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
                       EcribirFichero(FficheroNuevo,Slinea);
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
    
  }

