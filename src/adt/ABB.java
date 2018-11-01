package adt;

public class ABB {

    public class nodoArbol {
        private ABB hd;
        private ABB hi;
        public int dato;

        private void nodoArbol(){
            hd = null;
            hi = null;
            dato = 0;
        }

        public ABB getHd() {
            return hd;
        }

        public ABB getHi() {
            return hi;
        }

        public int getDato() {
            return dato;
        }
    }

    public nodoArbol raiz;

    public void ABB(){
        nodoArbol raiz = new nodoArbol();
    }

    public boolean esVacio(){
        return (raiz == null);
    }

    public void insertar(int a){
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = a;
            nuevo.hd = new ABB();
            nuevo.hi = new ABB();
            raiz = nuevo;
        }
        else {
            if (a > raiz.dato) {
                (raiz.hd).insertar(a);
            }
            if (a < raiz.dato){
                (raiz.hi).insertar(a);
            }
        }
    }

    public ABB buscar(int a){
        ABB arbolito = null;
        if (!esVacio()) {
            if (a == raiz.dato) {
                return this;
            }
            else {
                if (a < raiz.dato) {
                    arbolito = raiz.hi.buscar(a);
                }
                else {
                    arbolito = raiz.hd.buscar(a);
                }
            }
        }
        return arbolito;
    }

    public int buscarMin() {
        ABB arbolActual = this;
        while( !arbolActual.raiz.hi.esVacio() ) {
            arbolActual = arbolActual.raiz.hi;
        }
        int devuelvo= arbolActual.raiz.dato;
        arbolActual.raiz=null;
        return devuelvo;
    }

    public boolean esHoja() {
        boolean hoja = false;
        if( (raiz.hi).esVacio() && (raiz.hd).esVacio() ) {
            hoja = true;
        }
        return hoja;
    }
}