import org.w3c.dom.ls.LSOutput;

import java.util.PriorityQueue;

public class HeapLC {

    int[] items;
    int size;

    public HeapLC(int capacity) {
        this.items = new int[capacity];
        this.size = 0;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,3,1,2,4,5,5,6};


        findItemKth(nums, 4);
        System.out.println( findKthLargest(nums, 4));
        System.out.println(findKthLargestItem(nums, 4));

    }

    public static void findItemKth(int[] arr, int k) {

        int index = 0;
        HeapLC heap = new HeapLC(arr.length);

        while (index < arr.length-1) {

            heap.items[heap.size++] = arr[index];

            if (heap.items[index] > heap.items[arr[(index - 1) / 2]]) {
                int temp = heap.items[index];
                heap.items[index] = heap.items[(index - 1) / 2];
                heap.items[(index - 1) / 2] = temp;
            }
            index++;

        }
        int i = 0;
        while (i < k) {
            heap.items[0] = heap.items[heap.size--];

            while (index <= heap.size && !((heap.items[index] >= heap.items[index * 2 + 1] &&
                    heap.items[index] >= heap.items[index * 2 + 2]) || index * 2 + 1 <= heap.size)) {

                int largerChildIndex;

                largerChildIndex = heap.items[index * 2 + 1] > heap.items[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2;
                int temp = heap.items[index];
                heap.items[index] = heap.items[largerChildIndex];
                heap.items[largerChildIndex] = temp;

                index = largerChildIndex;


            }

            i++;
        }
        System.out.println(heap.items[0]);
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.offer(nums[i]);
            } else if (pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }


    public static int findKthLargestItem(int[] nums, int k) {
       MyHeap heap= new MyHeap(nums.length);

        for (int i = 0; i < nums.length; i++) {
                heap.insert(nums[i]);
        }
        for (int i = 1; i < k; i++) {
            heap.remove();
        }
        return heap.peek();
    }
}



