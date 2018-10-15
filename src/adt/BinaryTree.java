package adt;
//Código recuperado de https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
public class BinaryTree {
    public Node root;

    public BinaryTree(){
        this.root = null;
    }

    public boolean find(int id){
        Node current = root;
        while(current!=null){
            if(current.key==id){
                return true;
            }else if(current.key>id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }

    public boolean delete(int id){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while(current.key!=id){
            parent = current;
            if(current.key>id){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){

            //now we have found the minimum element in the right sub tree
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }
    public Node getSuccessor(Node deleleNodeBST){
        Node successsor =null;
        Node successsorParent =null;
        Node current = deleleNodeBST.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!= deleleNodeBST.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNodeBST.right;
        }
        return successsor;
    }
    public void insert(int id){
        Node newNodeBST = new Node(id);
        if(root==null){
            root = newNodeBST;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(id<current.key){
                current = current.left;
                if(current==null){
                    parent.left = newNodeBST;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNodeBST;
                    return;
                }
            }
        }
    }
    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.key);
            display(root.right);
        }
    }

}
