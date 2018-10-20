package adt;

import juego.Dragon;

//https://www.geeksforgeeks.org/avl-tree-set-2-deletion/
public class AVLTree
{

    private Node root;

    /**
     * Devuelve la altura de cierto nodo
     * @param N nodo a consultar altura
     * @return la altura comoun entero
     */
    private int height(Node N)
    {
        if (N == null)
            return 0;
        return N.height;
    }

    /**
     * Devuelve el máximo entre dós números
     * @param a primer numero
     * @param b segundo numero
     * @return el mayor de ambos
     */
    private int max(int a, int b)
    {
        return (a > b) ? a : b;
    }


    /**
     * Una rotación simple a la derecha
     * @param y el nodo donde comienza la rotación
     * @return Lanueva raíz despues de rotar
     */
    private Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }


    /**
     * Una rotación simple a la izquierda
     * @param x el nodo donde comienza la rotación
     * @return Lanueva raíz despues de rotar
     */
    private Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    /**
     * Devuelve el factor de balnceo de cierto nodo
     * @param N nodo a consultar
     * @return el balance como la diferencia de las alturas izquierda y derecha
     */
    private int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    /**
     * Sobrecarga para facilitar método recursivo
     * @param key dragon a insertar
     */
    public void insert(Dragon key) {
        this.root=insert(this.root, key);
    }

    /**
     * Método recursivo de inserción, al inicio busca la posicion correcta para insertar
     * como en un ABB pero luego retrocede de forma recursiva para actualizar las alturas
     * y portanto verificar los factores de balanceo y de no cumplirse realiza las rotaciones necesarias
     * @param node el nodo actual
     * @param key el dragon a insertar
     * @return un nodo modificado para comunicarse entre recursiones
     */
    private Node insert(Node node, Dragon key)
    {
        /* 1. Perform the normal BST rotation */
        if (node == null){
            return (new Node(key));
        }

        if (key.getEdad() < node.key.getEdad())
            node.left = insert(node.left, key);
        else if (key.getEdad() > node.key.getEdad())
            node.right = insert(node.right, key);
        else // Equal keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

        /* 3. Get the balance factor of this ancestor
        node to check whether this node became
        Wunbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key.getEdad() < node.left.key.getEdad())
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key.getEdad() > node.right.key.getEdad())
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key.getEdad() > node.left.key.getEdad())
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key.getEdad() < node.right.key.getEdad())
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }


    //***Delete y minValue no se usa porque simplemente se insertan solo los dragones a ordenar sin el eliminado

    /**
     * Sobrecarga para facilitar el uso del preorden recursivo
     */
    public void preOrder() {
        System.out.print("AVL en preorden: ");
        preOrder(this.root,this.root);
        System.out.println();
    }

    /**
     * Imprime el arbol en recorriendolo en preorden y mostrando las edades de sus nodos
     * que son el criterio de ordenamiento del AVL
     * En parentesis coloca la edad del padre del nodo para orientarse mejor
     */
    private void preOrder(Node node, Node padre)
    {
        if (node != null)
        {
            System.out.print(node.key.getEdad() +"("+padre.key.getEdad()+")"+" ");
            preOrder(node.left,node);
            preOrder(node.right,node);
        }
    }

    public Node getRoot() {
        return root;
    }
}