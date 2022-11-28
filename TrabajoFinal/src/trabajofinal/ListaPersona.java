package trabajofinal; 
import java.util.*;
import java.io.*;
public class ListaPersona {
    public static ArrayList leerArchivo() {
		File file = new File("C:\\Users\\Josué Duque\\Documents\\NetBeansProjects\\TrabajoFinal\\prueba.txt");
		ArrayList listaPersonas= new ArrayList<>();	
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);				
				delimitar.useDelimiter("\\s*,\\s*");
				Persona e= new Persona();
				e.setCedula(delimitar.next());
				e.setNombre(delimitar.next());
				e.setApellido(delimitar.next());
				listaPersonas.add(e);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
                }
		return listaPersonas;     
	}
    public static void añadirArchivo(ArrayList lista) {
		FileWriter flwriter = null;
                try {
                    flwriter = new FileWriter("C:\\Users\\Josué Duque\\Documents\\NetBeansProjects\\TrabajoFinal\\prueba.txt", true);
                    BufferedWriter bfwriter = new BufferedWriter(flwriter);
                    Persona persona;
                    for (int i=0; i<lista.size();i++) {
                        persona=(Persona) lista.get(i);
                        bfwriter.write(persona.getCedula() + "," + persona.getNombre() + "," + persona.getApellido() + "\n");
                    }
                    bfwriter.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    } 
                    finally {
                        if (flwriter != null) {
                            try {
                                flwriter.close();
                            } 
                            catch (IOException e) {
                                e.printStackTrace();
			}
                    }
		}
	}	
}
