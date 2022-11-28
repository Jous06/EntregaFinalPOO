/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
public class ModificarFichero {
    public static void EscribirFichero(File Ffichero,String SCadena){
  try {
          //Si no Existe el fichero lo crea
           if(!Ffichero.exists()){
               Ffichero.createNewFile();
           }
          /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. 
           *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)",
           *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/
          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));
          /*Escribe en el fichero la cadena que recibe la función. 
           *el string "\r\n" significa salto de linea*/
          Fescribe.write(SCadena + "\r\n");
          //Cierra el flujo de escritura
          Fescribe.close();
       } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
          System.out.println(ex.getMessage());
       } 
}
    
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

    
public static  void ModificarFichero(String Satigualinea,String Snuevalinea){
    
        File FficheroAntiguo=new File("C:\\Users\\Josué Duque\\Documents\\NetBeansProjects\\TrabajoFinal\\prueba.txt");
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
                        EscribirFichero(FficheroNuevo,Snuevalinea);
                    }else{
                        /*Escribo la linea antigua*/
                         EscribirFichero(FficheroNuevo,Slinea);
                    }             
                }
                /*Obtengo el nombre del fichero inicial*/
                String SnomAntiguo=FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del 
                *fichero inicial*/
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
    
    public static void main(String[] args) {
        
    }
    
}

