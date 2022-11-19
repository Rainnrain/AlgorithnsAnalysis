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
        if (size == items.length) throw new IllegalStateException();
        else {
            items[size++] = value;
            bubbleUp();
        }
    }

    public int remove(){
        if(size==0) throw new NoSuchElementException();
        else{
            int result=items[0];
            items[0]=items[--size];
            bubbleDown();
            return result;
        }
    }

    public void bubbleDown(){
        int index=0;
        int largerChildIndex;
        while(index<=size&& !isValidParent(index)){
            largerChildIndex=largerChildIndex(index);
            swap(index, largerChildIndex);
            index=largerChildIndex;
        }
    }

    public boolean isValidParent(int index){
        if(!hasLeftChild(index)) return true;
        else{
            boolean isValid=false;
            if(hasRightChild(index)){
                isValid=(items[index]>=items[leftChildIndex(index)]&& items[index]>=items[rightChildIndex(index)]);
            }
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
        if(!hasLeftChild(index)) return index;
        else if(!hasRightChild(index)){
            return leftChildIndex(index);
        }
        return items[leftChildIndex(index)]>items[rightChildIndex(index)]?leftChildIndex(index):rightChildIndex(index);
    }

    public void bubbleUp(){
        // calculate start point/ index
        int index= size-1;
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
}
