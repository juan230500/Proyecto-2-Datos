package ArbolB;

import juego.Dragon;

import javax.swing.*;

public class arbolB {
    private String stringOleada;
    private Raiz arbolito;
    private JLabel raiz = new JLabel();
    private JLabel pagina1 = new JLabel();
    private JLabel pagina2 = new JLabel();
    private JLabel pagina3 = new JLabel();
    private JLabel pagina4 = new JLabel();
    public arbolB(String oleada, int tamanoOleada) {
    stringOleada=oleada;
    arbolito=new Raiz(tamanoOleada);
    }
    public void insertarElemento(int elemento){
        arbolito.insertar(elemento);

    }

    public void llenar(Dragon Dragones[]){
        int numeroElemento=0;
        while(Dragones.length>numeroElemento){
            String nombreSinLetras=Dragones[numeroElemento].getNombre().substring(1);
            int numEntero = Integer.parseInt(nombreSinLetras);
            arbolito.insertar(numEntero);
            numeroElemento+=1;
        }
    }
    public void eliminar(Dragon DragonEliminado){

        String nombreSinLetras=DragonEliminado.getNombre().substring(1);
        int numEntero = Integer.parseInt(nombreSinLetras);
        arbolito.eliminar(numEntero);

    }
    public String dameInfromacion(int elemento){
        return arbolito.dameInfo(elemento,this.stringOleada);
    }
    public void establecerInfoLables(Raiz raiz1){
        raiz.setText(raiz1.dameInfo(0,stringOleada));
        pagina1.setText(raiz1.dameInfo(1,stringOleada));
        pagina2.setText(raiz1.dameInfo(2,stringOleada));
        pagina3.setText(raiz1.dameInfo(3,stringOleada));
        pagina4.setText(raiz1.dameInfo(4,stringOleada));
    }

}


