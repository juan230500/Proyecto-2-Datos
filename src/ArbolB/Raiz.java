package ArbolB;

import juego.Dragon;

import java.util.ArrayList;
/**
 * La clase  Raiz sirve para crear un arbol B
 * Esta clase fue sacada del repositorio https://github.com/maestro252/Arbol-B
 * @version 1.0
 * @since    3 Dec 2013
 */

public class Raiz
{
    public static int grado;
    public Nodo primerNodo;
    public static boolean esRaiz;
    public static int nivel ;
    public static int imprimir ;
    public static String arbol ;
    public String oleada;
    public void llenar(Dragon Dragones[]){
        int numeroElemento=0;
        oleada=Character.toString(Dragones[0].getNombre().charAt(0));
        while(Dragones.length>numeroElemento){
            String nombreSinLetras=Dragones[numeroElemento].getNombre().substring(1);
            int numEntero = Integer.parseInt(nombreSinLetras);
            //System.out.println(Dragones.length);
            insertar(numEntero);
            numeroElemento+=1;

        }
        //System.out.println("Termine de llenar");
    }
    /**
     * Este metodo se utliza para calcular un grado adecuado al arbol para que
     * no tenga mas de cuatro paginas  ademas de la raiz el arbol
     * @param oleada  el Tamano de la oleada que va a entrar en el arbolB
     * @return int el valor del grado correcto del arbol
     */
    public int tamano(int oleada) {
        int resultado = 0;
        int numero=0;
        boolean flag=true;
        while(flag) {
            if ((oleada + numero) % 5 == 0) {
                flag=false;

            }
            numero+=1;
        }
        resultado = (oleada + numero);
        //System.out.println("este es el grado"+ resultado/5);
        return resultado/5;
    }
    /**
     * Este metodo se utliza para  serializar el texto quitandole_todo lo que no es necesario
     * @param Texto1 este  es el texto  que envia recorrido
     * @param oleada este es el Caracter identificador de la oleada
     * @return String el valor que retorna es el texto serializado
     */
    public String serializarTexto(String Texto1,String oleada){
        String hijo="";
        //System.out.println("debugiando por aqui "+Texto1);
        String Texto=(Texto1.replace("]","x"));
        Texto=(Texto.replace("[","x"));
        Texto=Texto.replaceAll("\\s","");
        //System.out.println("debugiando por aqui 2"+Texto);
        String informacionRecolectada="";
        boolean encontreNumero=false;
        boolean ecnontreX=false;
        int numeroDearrobas=0;
        for (int i = 0; i < Texto.length(); i++) {
            if(Texto.charAt(i)=='x'){
                ecnontreX=true;
                encontreNumero=false;
            }
            if (Texto.charAt(i)!='x'&&ecnontreX){
                hijo+="@";
                hijo+=oleada;
                numeroDearrobas+=1;
            }

            if (Texto.charAt(i)!='x'){
                encontreNumero=true;
                ecnontreX=false;
            }
            if(encontreNumero){
                hijo+=Texto.charAt(i);
            }
        }
        //System.out.println(Texto);
        hijo=(hijo.replace("x",""));
        hijo=(hijo.replace("@","@"+"\n"));
        hijo=(hijo.replace(",",","+"\n"+oleada));
        return hijo+"@";
    }
    /**
     * Este metodo se utliza para   seccionar las paginas por el simbolo @
     * y lograr saber cual es cual
     * @param Texto este  es el texto  que envia recorrido
     * @param elemento este es el Caracter identificador de la oleada
     * @return String el valor que retorna es el valor de una pagina es especifico o la raiz
     */
    public String giveArrayHijos(String Texto,int elemento){
        int numerodeValor=0;
        int numeroArrobaEncontrado=0;
        String contenidoPagina="";
        String[] paginas = new String[5];

        for (int i = 0; i < Texto.length(); i++) {

            if(Texto.charAt(i)=='@'){
                numeroArrobaEncontrado+=1;
            }
            if (numeroArrobaEncontrado>elemento&&numeroArrobaEncontrado<elemento+2){
                contenidoPagina+=Texto.charAt(i);
            }
        }
        contenidoPagina=contenidoPagina.replace("@","");
        return contenidoPagina;
    }
    /**
     * Este metodo se utiliza para recorrer el arbol B
     * y sacar toda la informacion  meterlo en un String
     * @return String El retorna el valor del string que contiene toda la informacion del arbol.
     */
    public String Recorrido(){
        String raiz = "[ ";
        for(int i = 0; i < this.primerNodo.valores.length && this.primerNodo.valores[i] != 0; i++){
            raiz += this.primerNodo.valores[i] + ", ";
        }
        raiz += " ]\n";
        raiz += this.llamarRecorrer();
        //System.out.println("este es el recorrido"+raiz);
        return raiz;
    }
    /**
     * Este metodo se utiliza para tener la infromacion deseada del arbol
     * sin nada extra como algun caracter extra o algo por el estilo
     * ademas de eso se puede escoger que deseo que me devuelva sea la raiz o una de las paginas
     * @return String El retorna el valor  del elemento  a escoger sea la raiz o  una pagina.
     */
    public String  dameInfo(int opcion,String oleada){
        String Texto1=this.serializarTexto(this.Recorrido(),oleada);
        String Info=this.giveArrayHijos(Texto1,opcion);
        if(Info.length()==0){
            return "";
        }
        else{
            //System.out.println("este es el largo"+Info.length());
            Info=Info.substring(1,Info.length()-1);
            return  Info;
        }
    }
    /**
     * Este metodo es el constructor para crear objetos de la clase raiz
     * @param grado este parametro es la cantidad de elemento que ingresaran al arbol
     */
    public Raiz(int grado) {
        nivel = 1;
        imprimir = 1;
        arbol = "";
        grado=tamano(grado);
        this.grado = grado;
        primerNodo = new Nodo ();
        Lista llevarIngresos = new Lista();
        esRaiz = true;
    }
    /**
     * Este metodo se utiliza para insertar algo en el arbol b
     * @param valor este dato es el que va a ser ingresado en el arbol b
     */
    public void insertar (int valor) {
        if (primerNodo.tengoHijos==false) {
            int j = 0;
            for (int i = 0; i<primerNodo.valores.length; i++) {
                if (primerNodo.valores[i] == 0) {
                    primerNodo.valores[i] = valor;
                    Lista.ingresados.add(valor);
                    j = i;
                    ordenar(primerNodo.valores,6);
                    break;
                }
            }
            if (j == 2*grado) {
                split(primerNodo);
            }
        } else {
            setTengoHijos(primerNodo);
            ingresarEnHijos(primerNodo, valor);

        }
    }
    /**
     * Este metodo se utiliza para insertar algo en el arbol b
     * @param arr este dato es los elementos del arbol
     * @param longitud es el tamano del arbol
     */
    public void ordenar(int arr[], int longitud){
        longitud = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                longitud++;
            }else{
                break;
            }
        }
        for(int ord = 0; ord < longitud; ord++){
            for(int ord1 = 0; ord1 < longitud - 1 ; ord1++){
                if(arr[ord1] > arr[ord1 + 1]){
                    int tmp = arr[ord1];
                    arr[ord1] = arr[ord1+1];
                    arr[ord1+1] = tmp;

                }
            }
        }
    }
    /**
     * Este metodo se utiliza para insertar algo en el arbol b
     * @param nodo este dato es  un nodo es especifico parfa setearle sus referencias
     *
     */
    public void setTengoHijos (Nodo nodo) {
        if (nodo == primerNodo) {
            if (primerNodo.nodo[0]!= null) {
                primerNodo.tengoHijos = true;
            }
        }
        for (int i = 0; i<nodo.nodo.length; i++) {
            if (nodo.nodo[i] != null) {
                nodo.tengoHijos = true;
                setTengoHijos(nodo.nodo[i]);
            }
        }
    }
    /**
     * Este metodo se utiliza para insertar algo en el arbol b
     * @param conHijos  este es para generar la referecia  de hijos a los nodos del arbol
     *
     */
    public void ingresarEnHijos(Nodo conHijos, int valor) {
        boolean entro = false;
        if(conHijos != null && !conHijos.tengoHijos){
            ubicarValorEnArreglo(conHijos, valor);
            entro = true;
        }
        for(int i = 0; conHijos != null && i < 2*grado + 1  && !entro; i++){
            if(valor < conHijos.valores[i] || conHijos.valores[i] == 0){
                entro = true;
                ingresarEnHijos(conHijos.nodo[i], valor);
                i = 2*grado;
            }
        }
    }
    /**
     * Este metodo se utiliza para  averiguar el valoir que contiene un nodo con el
     * valor ingresado
     * @param nodoA este es un nodo que ingresara  para verificarlo
     * @param valor este es el valor que se comparara  con lo que contiene el nodo
     */
    public void ubicarValorEnArreglo(Nodo nodoA, int valor){
        int cont = 0;
        while(cont <= 2*grado){
            if (nodoA.valores[cont]==0) {
                nodoA.valores[cont]=valor;
                ordenar(nodoA.valores, 5);
                Lista.ingresados.add(valor);
                if (cont == 2*grado) {
                    split(nodoA);
                }
                break;
            }
            cont++;
        }
    }
    /**
     * Este metodo se utiliza  Para ordenar un nodo en el arbol deseado
     * @param aOrdenar
     */
    public void ordenarNodos(Nodo aOrdenar){
        int i,j;
        i = 0;
        Nodo tmp;

        while(i < 2 * grado + 3 && aOrdenar.nodo[i] != null){
            j = 0;
            while(j < 2 * grado +2  && aOrdenar.nodo[j] != null && aOrdenar.nodo[j+1] != null){
                if(aOrdenar.nodo[j].valores[0] > aOrdenar.nodo[j+1].valores[0] ){
                    tmp = aOrdenar.nodo[j];
                    aOrdenar.nodo[j] = aOrdenar.nodo[j+1];
                    aOrdenar.nodo[j+1] = tmp;
                }
                j++;
            }
            i++;
        }
    }
    public void split (Nodo nodo) {

        Nodo hijoIzq = new Nodo();
        Nodo hijoDer = new Nodo();

        //split general
        if (nodo.nodo[0]!=null) { //si tiene hijos antes de hacer el split entonces
            for (int i = 0; i <grado+1; i++) { // los separa los hijos del nodo en hijoIzq e hijoDer
                hijoIzq.nodo[i] = nodo.nodo[i];
                hijoIzq.nodo[i].padre = hijoIzq;
                nodo.nodo[i] = null;
                hijoDer.nodo[i] = nodo.nodo[grado+1+i];
                hijoDer.nodo[i].padre = hijoDer;
                nodo.nodo[grado+1+i] = null;
            }
        }

        for (int i =0; i<grado; i++){ //guarda los valores en hijoIzq e hijoDer
            hijoIzq.valores[i] = nodo.valores[i];
            nodo.valores[i] = 0;
            hijoDer.valores[i] = nodo.valores[grado+1+i];
            nodo.valores[grado+1+i] = 0;
        }
        nodo.valores[0] = nodo.valores[grado];
        nodo.valores[grado] = 0; //queda en nodo solo el valor que "subio"

        nodo.nodo[0] = hijoIzq; //asigna a nodo el nuevo hijo izquierdo (hijoIzq)
        nodo.nodo[0].padre = nodo; // se hizo en primer ciclo
        nodo.nodo[1] = hijoDer; // asigna a nodo el nuevo hijo derecho (hijoDer)
        nodo.nodo[1].padre = nodo; // se hizo en el primer ciclo
        setTengoHijos(primerNodo);
        ordenarNodos(nodo);


        if (nodo.padre!=null) { // luego del split y asignar los hijos (hijoIzq, hijoDer), subir el valor al padre
            boolean subido = false;
            for (int i = 0; i<nodo.padre.valores.length && subido==false; i++) {
                if (nodo.padre.valores[i] == 0) {
                    nodo.padre.valores[i] = nodo.valores[0];
                    subido = true;
                    nodo.valores[0] = 0;
                    ordenar(nodo.padre.valores, 5);
                }
            }
            int posHijos = 0;
            for (int i = 0; i<2*grado+3 ; i++) {
                if (nodo.padre.nodo[i]!=null) {
                    posHijos++;
                } else {
                    break;
                }
            }
            nodo.padre.nodo[posHijos] = nodo.nodo[0];
            nodo.padre.nodo[posHijos+1] = nodo.nodo[1];
            nodo.padre.nodo[posHijos].padre = nodo.padre;
            nodo.padre.nodo[posHijos+1].padre = nodo.padre;
            int aqui = 0;
            for (int i =0; i<2*grado+3 && nodo.padre.nodo[i]!=null; i++) {
                if (nodo.padre.nodo[i].valores[0] == nodo.valores[0]) {
                    aqui = i;
                    break;
                }
            }
            Nodo papa = nodo.padre;
            nodo = null;
            int j = aqui;
            while (j<2*grado+2 && papa.nodo[j]!=null && papa.nodo[j+1]!=null) {
                papa.nodo[j] = papa.nodo[j+1];
                j++;
            }
            papa.nodo[j] = null;
            ordenar(papa.valores,5);
            ordenarNodos(papa);
            if (papa.valores[2*grado]!=0) {
                split(papa);
            }
        }
    }

    public String recorrer(Nodo nodo) {
        arbol += "\n";
        for (int i =0; i<2*grado+1; i++) {
            if (nodo.nodo[i] != null) {
                if (i == 0) {
                    nivel++;
                    imprimir = 1;
                } else {
                    imprimir ++;
                }
                recorrer(nodo.nodo[i]);
            }
            arbol += "[ ";
            for (int j = 0; nodo.nodo[i]!=null && j<nodo.nodo[i].valores.length; j++) {
                if (nodo.nodo[i].valores[j] != 0) {
                    arbol += nodo.nodo[i].valores[j] + ", ";
                }
            }
            arbol += " ]";
        }
        if (arbol.length() > (2*grado+3)*4) {
            //System.out.println (arbol);
            return arbol;
        }
        return arbol;
    }
    public String llamarRecorrer() {
        String mostrar = recorrer(primerNodo);
        nivel = 1;
        imprimir = 1;
        return arbol;
    }


}