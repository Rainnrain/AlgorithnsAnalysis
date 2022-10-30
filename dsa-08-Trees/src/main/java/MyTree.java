import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    TNode root;

    public MyTree(){

    }
    void insert (int value){
        TNode newNode=new TNode(value);
        if(root==null){
            root=newNode;
            return;
        }
        TNode current = root;
        while(true){
            if(value<=current.value){
                if(current.leftChild==null){
                    //if left is null insert here!
                    current.leftChild=newNode;
                    break;
                }
                current=current.leftChild;
            }else{
                if(current.rightChild==null){
                    //if right is null insert here!
                    current.rightChild=newNode;
                    break;
                }
                current=current.rightChild;
            }
        }
    }

    // preOrdered Transversal of the tree
    //ROOT-LEFT-RIGHT
    void preOrderTraversal(TNode root){
        if(root==null) return;
        System.out.print(root.value+",");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);

    }

    void inOrderTraversal(TNode root){
        if (root==null) return;
        inOrderTraversal(root.leftChild);
        System.out.print(root.value+",");
        inOrderTraversal(root.rightChild);
    }

    void postOrderTraversal(TNode root){
        if(root==null) return;
        inOrderTraversal(root.leftChild);
        inOrderTraversal(root.rightChild);
        System.out.print(root.value+",");
    }

    void levelOrderTranversal(){
        if(root==null) return;
        Queue<TNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            TNode toVisit=queue.poll(); // gets front element of the queue
            System.out.println(toVisit.value+" , ");

            if(toVisit.leftChild!=null){
                queue.add(toVisit.leftChild);
            }if(toVisit.rightChild!=null){
                queue.add(toVisit.rightChild);
            }

        }
    }
}
