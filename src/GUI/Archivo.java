package GUI;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Archivo{
    private FileReader archivo;
    public Archivo(String Direccion){
        try {
            archivo=new FileReader(Direccion);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void leer() throws IOException {
        BufferedReader bf=new BufferedReader(archivo);
        String temp="";
        String bfRead;
        while ((bfRead=bf.readLine())!=null){
            temp=temp+bfRead;

        }
        System.out.println(temp);
    }

    public static void main(String[] parametros) throws IOException {
        Archivo myArchivo=new Archivo("/home/reds/Documentos/archivo.txt") ;
        myArchivo.leer();

    }
}