package ArbolB;

public class arbolB {
    private Raiz arbolito;
    private String[] paginas = new String[5];
    public arbolB(int oleada) {
        arbolito = new Raiz(tamano(oleada)/4);
    }
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
        System.out.println("este es el grado"+ resultado/5);
        return resultado/5;
    }
    public void sacarRaiz(String Texto) {
        int m = 0;
        for (int i = 0; i < Texto.length(); i++) {
            System.out.println(Texto.substring(m, i + 1));
            m++;
        }
    }
    public void insertar(int valor){
        arbolito.insertar(valor);
    }
    public void borrar(int valor){
        arbolito.eliminar(valor);
    }
    public String verPagina(int valor){
        return paginas[valor];
    }
    public Raiz getArbolito(){
        return arbolito;
    }
}

