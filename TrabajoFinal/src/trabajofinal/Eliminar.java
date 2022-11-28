/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;
import java.util.*;
import java.io.*;
public class Eliminar {
    public static void Eliminarlinea(String linea){
            try {

        File inFile = new File("C:\\Users\\Josué Duque\\Documents\\NetBeansProjects\\TrabajoFinal\\prueba.txt");

        if (!inFile.isFile()) {

            System.out.println("no hay file");

            return;

        }

        //Construct the new file that will later be renamed to the original filename.

        File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Josué Duque\\Documents\\NetBeansProjects\\TrabajoFinal\\prueba.txt"));

        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;

        //Read from the original file and write to the new

        //unless content matches data to be removed.

        while ((line = br.readLine()) != null) {

            if (!line.trim().equals(linea)) {

                pw.println(line);

                pw.flush();

            }

        }

        pw.close();

        br.close();


        //Delete the original file

        if (!inFile.delete()) {

            System.out.println("Could not delete file");

            return;

        }
        //Rename the new file to the filename the original file had.

        if (!tempFile.renameTo(inFile)){

            System.out.println("Could not rename file");
        }

    } catch (FileNotFoundException ex) {

        ex.printStackTrace();

    } catch (IOException ex) {

        ex.printStackTrace();

    }

}

}
    

