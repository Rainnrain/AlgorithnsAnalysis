import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyHeap {
    int[] items;
    int size;

    public MyHeap(int capacity) {
        this.items = new int[capacity];
        this.size = 0;
    }

    public int peek() {
        if (size == 0) throw new NoSuchElementException();
        return items[0];
    }

    public void insert(int value) {
        if (size == items.length) throw new IllegalStateException(); // at max size cannot add any more
        else {
            items[size++] = value;
            bubbleUp();
        }
    }

    public int remove(){
        if(size==0) throw new NoSuchElementException();
        else{
            int result=items[0]; // always remove the root
            items[0]=items[--size]; // reassign last element to top
            bubbleDown();
            return result;
        }
    }

    public void bubbleDown(){
        int index=0;
        int largerChildIndex;
        while(index<=size&& !isValidParent(index)){// breaks if index is larger than size and if parent val is larger than child
                                                    // or if no left child
            largerChildIndex=largerChildIndex(index);
            swap(index, largerChildIndex);
            index=largerChildIndex;
        }
    }

    public boolean isValidParent(int index){
        if(!hasLeftChild(index)) return true; // returns true if doesn't have left child
        else{
            boolean isValid=false;
            if(hasRightChild(index)){
                isValid=(items[index]>=items[leftChildIndex(index)]&& items[index]>=items[rightChildIndex(index)]);
            } // returns true if array parent value is greater than both the left and right array child
            return isValid;
        }
    }

    public boolean hasLeftChild(int index){
        return leftChildIndex(index)<=size;
    }
    public boolean hasRightChild(int index){
        return rightChildIndex(index)<=size;
    }
    public int leftChildIndex(int index){
        return index*2+1;
    }
    public int rightChildIndex(int index){
        return index*2+2;
    }
    public int largerChildIndex(int index){
        if(!hasLeftChild(index)) return index; // returns index if no left child
        else if(!hasRightChild(index)){ // if there is no right child return left child index
            return leftChildIndex(index);
        }
        return items[leftChildIndex(index)]>items[rightChildIndex(index)]?leftChildIndex(index):rightChildIndex(index);
        // returns either the right or left child index depending on what's higher in value.
    }

    public void bubbleUp(){

        int index= size-1; // gets index of added value
        //while index >0 && parent is less than child continue...
        // 1. swap child and parent
        // 2. Switch to the next index

        while(index>0 && items[index]>items[parentsIndex(index)]){
            //swap, and assign index w/ the parent index
            swap(index, parentsIndex(index));
            index=parentsIndex(index);
        }
    }

    public int parentsIndex(int index){
        return (index-1)/2;
    }

    public void swap(int index, int parentIndex){

        int temp=items[index];
        items[index]=items[parentIndex];
        items[parentIndex]=temp;
    }

    public void printHeap(){

        for (int i=0; i<size; i++){
            System.out.print(items[i]+", ");
        }
        System.out.println();
    }


    public void kThLargest(int k){

     if( size<=k) return;

        System.out.println("The "+ k +" largest value is: "+items[k-1]);
    }
}
