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
}
