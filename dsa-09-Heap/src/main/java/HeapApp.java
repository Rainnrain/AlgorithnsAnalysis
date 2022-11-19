public class HeapApp {

    public static void main(String[] args) {

        MyHeap heap=new MyHeap(10);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(5);
        heap.insert(6);
        heap.insert(4);
        heap.printHeap();
        heap.remove();
        heap.printHeap();
        heap.insert(130);
        heap.printHeap();
        heap.kThLargest(5);
    }
}
