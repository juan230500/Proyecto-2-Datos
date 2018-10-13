package adt;
//Código recuperado de https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
public class Binary_tree {
    public Node_BST root;

    public Binary_tree(){
        this.root = null;
    }

    public boolean find(int id){
        Node_BST current = root;
        while(current!=null){
            if(current.data==id){
                return true;
            }else if(current.data>id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }
    public boolean delete(int id){
        Node_BST parent = root;
        Node_BST current = root;
        boolean isLeftChild = false;
        while(current.data!=id){
            parent = current;
            if(current.data>id){
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
            Node_BST successor	 = getSuccessor(current);
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
    public Node_BST getSuccessor(Node_BST deleleNodeBST){
        Node_BST successsor =null;
        Node_BST successsorParent =null;
        Node_BST current = deleleNodeBST.right;
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
        Node_BST newNodeBST = new Node_BST(id);
        if(root==null){
            root = newNodeBST;
            return;
        }
        Node_BST current = root;
        Node_BST parent = null;
        while(true){
            parent = current;
            if(id<current.data){
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
    public void display(Node_BST root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

}

class Node_BST {
    int data;
    Node_BST left;
    Node_BST right;
    public Node_BST(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
