package adt;

public class Node_Linked {
    private Object data;
    private Node_Linked next;


    public Node_Linked(Object Data){
        this.next=null;
        this.data=Data;
    }

    public Object getData(){
        return this.data;
    }

    public void setData(Object data){
        this.data=data;
    }


    public Node_Linked getNext(){
        return this.next;
    }

    public void setNext(Node_Linked nodeLinked){
        this.next= nodeLinked;
    }

}