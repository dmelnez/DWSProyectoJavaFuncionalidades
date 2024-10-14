package servicios;

import java.io.File;
import java.io.FileWriter;

public class FicheroImplementacion implements FicheroInterfaz {

	public void ficheroLog(String mensajeLog) {
		
		String rutaFichero = "C:\\Users\\dmelnez\\Desktop\\Eclipse Proyectos\\edu.redSocialMoteros\\FicheroLog.txt";
		
		File fichero = new File(rutaFichero);
		
		try (FileWriter escribirFich = new FileWriter(fichero, true))
		{
			escribirFich.write(mensajeLog + "\n");
			escribirFich.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
