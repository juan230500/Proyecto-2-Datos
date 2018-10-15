package adt;

public class LinkedList{
    private Node_Linked head;
    private int size;

    public Node_Linked getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public LinkedList(){
        this.head= null;
        this.size=0;
    }

    public boolean isEmpty(){
        return this.head==null;
    }

    public int size(){
        return this.size;
    }


    public void insertFirst(Object data){
        Node_Linked newNodeLinked = new Node_Linked(data);
        newNodeLinked.setNext(this.head);
        this.head= newNodeLinked;
        this.size++;
    }


    public Node_Linked deleteFirst(){
        if(this.head != null){
            this.head= this.head.getNext();
            this.size--;
        }
        return null;
    }

    public void displayList(){
        Node_Linked current= this.head;
        while(current != null){
            System.out.println(current.getData());
            current=current.getNext();
        }
    }


    public Node_Linked find(Object searchValue){
        Node_Linked current= this.head;
        while(current != null){
            if (current.getData().equals(searchValue)){
                return current;
            }
            else{
                current=null;
            }
        }
        return null;
    }


    public Node_Linked delete(Object searchValue){
        Node_Linked current= this.head;
        Node_Linked previous= this.head;
        while (current != null){
            if (current.getData().equals(searchValue)){
                if (current.equals(this.head)){
                    this.head = this.head.getNext();
                }
                else{
                    previous.setNext(current.getNext());
                }
                this.size--;
                return current;
            }
            else{
                previous= current;
                current=current.getNext();
            }
        }
        return null;
    }

    public void insertLast(Object data){
        if (this.head==null) {
            Node_Linked nuevo = new Node_Linked(data);
            this.head = nuevo;

        }
        else {
            Node_Linked head = this.head;
            Node_Linked current_last = head;
            while (head!=null){
                current_last = head;
                head = head.getNext();
            }
            Node_Linked nuevo = new Node_Linked(data);
            current_last.setNext(nuevo);
        }
        this.size++;
    }


    public Object recorrer(int i){
        Node_Linked current = this.head;
        while(i > 0){
            current = current.getNext();
            i -= 1;
        }
        return current.getData();
    }
}
