package GUI;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Logger {
    String ruta = "D:/Users/Andrey/Desktop/filename.txt";
    public Logger(String Info){
        try {
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Info);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void muestraContenido(String ruta) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }
}