package adt;

public class Cola {
    private Node_Linked first;
    private Node_Linked last;

    public Cola(){
        this.first=null;
        this.last=null;
    }

    public void enqueue(Object Data){
        Node_Linked tmp=new Node_Linked(Data);
        if (first==null){
            this.first=tmp;
            this.last=tmp;
        }
        else{
            this.last.setNext(tmp);
            this.last=tmp;
        }
    }

    public Object dequeue(){
        if (first!=null){
            Object Data=this.first.getData();
            this.first=this.first.getNext();
            return Data;
        }
        else{
            return null;
        }
    }

    public void display(){
        Node_Linked tmp=this.first;
        while(tmp!=null){
            System.out.print(tmp.getData()+"-");
            tmp=tmp.getNext();
        }
    }
}
