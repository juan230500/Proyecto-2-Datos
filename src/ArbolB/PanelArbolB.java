package ArbolB;

import javax.swing.*;

public class PanelArbolB extends JFrame {
    JPanel panel1=new JPanel();
private String raiz;
private String pag1="";
private String pag2="";
private String pag3="";
private String pag4="";
private Raiz ArbolB;
private JTextArea areaTexto=null;

public String raizEnPartes(int valor){
    String numero="";
    int comaEncontrada=0;
    for (int i = 0; i < raiz.length(); i++) {
        numero+=raiz.charAt(i);
        if (raiz.charAt(i)==','&&comaEncontrada==valor){

            return numero;
        }
        if (raiz.charAt(i)==','&&comaEncontrada<valor){

            numero="";
            comaEncontrada+=1;
        }
    }
    return "";
}
public void establecerPaginas(){
    if (raizEnPartes(1).replaceAll(",","").equals("")){
       pag3="";
       pag4="";
    }
    if (raizEnPartes(2).replaceAll(",","").equals("")){
        pag4="";
    }
}
public String decieQueInfoMuestro() {
    if (pag4.equals("") && pag3.equals("") && pag2.equals("") && pag1.equals("")) {
        String info = "ARBOLB CON LOS NOMBRES DE DRAGONES" +
                "\n" + "Raiz             Branches                      Paginas\n" +
                "\n" + raiz;
        return info;
    } else if (!pag4.equals("") && !pag3.equals("") && !pag2.equals("") && !pag1.equals("")) {
        String info = "ARBOLB CON LOS NOMBRES DE DRAGONES" +
                "\n" + "Raiz             Branches                      Paginas\n" +
                "\n" +
                "\n" + "  ______________________________ " + pag1 + "\n" + raizEnPartes(0) +
                "\n" + "  ______________________________ " + pag2 + raizEnPartes(1) +
                "\n" + "  ______________________________ " + pag3 + raizEnPartes(2) +
                "\n" + "  ______________________________ " + pag4;
        return info;
    } else if (pag4.equals("") && !pag3.equals("") && !pag2.equals("") && !pag1.equals("")) {
        String info = "ARBOLB CON LOS NOMBRES DE DRAGONES" +
                "\n" + "Raiz             Branches                      Paginas\n" +
                "\n" +
                "\n" + "  ______________________________ " + pag1 + "\n" + raizEnPartes(0) +
                "\n" + "  ______________________________ " + pag2 + raizEnPartes(1) +
                "\n" + "  ______________________________ " + pag3 + raizEnPartes(2);
        return info;
    } else if (pag4.equals("") && pag3.equals("") && !pag2.equals("") && !pag1.equals("")) {
        String info = "ARBOLB CON LOS NOMBRES DE DRAGONES" +
                "\n" + "Raiz             Branches                      Paginas\n" +
                "\n" +
                "\n" + "  ______________________________ " + pag1 + "\n" + raizEnPartes(0) +
                "\n" + "  ______________________________ " + pag2 + raizEnPartes(1);
        return info;
    }
    return "";

}
    public void eliminar(String eliminar){
        String nombreSinLetras=eliminar.substring(1);
        int numEntero = Integer.parseInt(nombreSinLetras);
        ArbolB.eliminar(numEntero);

       // dibujarArbolB();
    }
    public void dibujarArbolB(String Oleada){
        raiz =(ArbolB.dameInfo(0,Oleada));
        pag1=(ArbolB.dameInfo(1,Oleada)).replaceAll("\\s","");
        pag2=(ArbolB.dameInfo(2,Oleada)).replaceAll("\\s","");
        pag3=(ArbolB.dameInfo(3,Oleada)).replaceAll("\\s","");
        pag4=(ArbolB.dameInfo(4,Oleada)).replaceAll("\\s","");
        establecerPaginas();
        setBounds(200,350,400,768-400);
        areaTexto=new JTextArea();
        areaTexto.setText(decieQueInfoMuestro());
        JScrollPane scroll=new JScrollPane(areaTexto);
        this.add(scroll);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public PanelArbolB(Raiz raiz1) {
        ArbolB=raiz1;

    }
}
