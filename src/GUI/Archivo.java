package GUI;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Archivo{
    private FileReader archivo;
    public Archivo(){
    }
    public void leer(String Direccion) throws IOException {
        archivo=new FileReader(Direccion);
        BufferedReader bf=new BufferedReader(archivo);
        String temp="";
        String bfRead;
        while ((bfRead=bf.readLine())!=null){
            temp=temp+bfRead;

        }
        bf.close();
        System.out.println(temp);
    }

    public static void main(String[] parametros) throws IOException, InterruptedException {
        Archivo myArchivo=new Archivo() ;
        myArchivo.leer("/home/reds/Documentos/archivo.txt");
        Thread.sleep(10000);
        myArchivo.leer("/home/reds/Documentos/archivo.txt");

    }
}