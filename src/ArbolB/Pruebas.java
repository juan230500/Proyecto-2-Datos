package ArbolB;

import java.util.Scanner;

public class Pruebas {
    public static void main (String [ ] args) {
Raiz arbol1=new Raiz(1);
        String entradaTeclado = "";
while(!entradaTeclado.equals("Exit")){

    System.out.println ("Por favor introduzca una cadena por teclado:");



    Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

    entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
if (entradaTeclado.equals("Poner")){
    arbol1.insertar(4);
    arbol1.buscar(4);
}
if(entradaTeclado.equals("Arbol")){
    System.out.println(arbol1.llamarRecorrer());
}
    System.out.println ("Entrada recibida por teclado es: \"" + entradaTeclado +"\"");
}
        System.out.println ("se acabo la prueba");



    }
}
