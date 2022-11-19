import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    TNode root;

    public MyTree() {

    }

    void insert(int value) {
        TNode newNode = new TNode(value);
        if (root == null) {
            root = newNode;
            return;
        }
        TNode current = root;
        while (true) {
            if (value <= current.value) {
                if (current.leftChild == null) {
                    //if left is null insert here!
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    //if right is null insert here!
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    // preOrdered Transversal of the tree
    //ROOT-LEFT-RIGHT
    void preOrderTraversal(TNode root) {
        if (root == null) return;
        System.out.print(root.value + ",");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);

    }

    void inOrderTraversal(TNode root) {
        if (root == null) return;
        inOrderTraversal(root.leftChild);
        System.out.print(root.value + ",");
        inOrderTraversal(root.rightChild);
    }

    void postOrderTraversal(TNode root) {
        if (root == null) return;
        inOrderTraversal(root.leftChild);
        inOrderTraversal(root.rightChild);
        System.out.print(root.value + ",");
    }

    void levelOrderTranversal() {
        if (root == null) return;
        Queue<TNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TNode toVisit = queue.poll(); // gets front element of the queue
            System.out.println(toVisit.value + " , ");

            if (toVisit.leftChild != null) {
                queue.add(toVisit.leftChild);
            }
            if (toVisit.rightChild != null) {
                queue.add(toVisit.rightChild);
            }

        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        TNode current = root;
        while (current != null) {
            if (value < current.value) current = current.leftChild;
            else if (value > current.value) current = current.rightChild;
            else return true;
        }
        return false;
    }

    public boolean isLeaf(TNode node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public void printLeaves(TNode root) {
        if (root == null) return;

        if (isLeaf(root)) System.out.print(root.value + ", ");
        printLeaves(root.leftChild);
        printLeaves(root.rightChild);

    }

    public int countLeaves(TNode root) {
        if (root == null) return 0;
        if (isLeaf(root)) return 1;
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int findSumOfLeaves(TNode root) {
        if (root == null) return 0;
        if (isLeaf(root)) return root.value;

        return findSumOfLeaves(root.leftChild) + findSumOfLeaves(root.rightChild);
    }


    public int height(TNode root) {
        if (root == null) return -1;

        if (isLeaf(root)) return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));

    }


    public int sumOfDepth(TNode root) {
        int sum = 0;
        int count=0;

        if (root == null) return 0;
        Queue<TNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TNode toVisit = queue.poll(); // gets front element of the queue
            sum++;

            if (toVisit.leftChild != null) {
                queue.add(toVisit.leftChild);
                sum += 1 ;
            }
            if (toVisit.rightChild != null) {
                queue.add(toVisit.rightChild);
                sum += 1  ;
            }

        }
        return sum;
    }

    public int calculateNodeDepthsSums(){
        return nodeDepthSums(root, 0);
    }
    public int nodeDepthSums(TNode node, int a){
        if(node==null) return 0;
        return a+nodeDepthSums(node.leftChild, a+1) + nodeDepthSums(node.rightChild, a+1);
    }

    public int calculateNodeSums(){
        return nodeSums(root, root.value);
    }
    public int nodeSums(TNode node, int sum){
        if(node==null) return 0;
        return sum+nodeSums(node.leftChild, node.value) + nodeDepthSums(node.rightChild, node.value);
    }


    public int rangeSum(TNode node, int low, int high){
        int sum=0;
        if(node==null) return 0;
        if(root.value>=low && root.value<=high) {
            sum+= node.value;
        return sum + rangeSum(node.leftChild,  low,  high)+ rangeSum(node.rightChild, low, high);
    }
        return sum+ rangeSum(node.leftChild,  low,  high)+ rangeSum(node.rightChild, low, high);
    }
}
