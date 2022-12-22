public class InsertionSort {
    
    public static int[] insertionSort(int [] array){
        for (int i = 1; i <array.length ; i++) {
            int toBeInserted=array[i];
            int j=i-1; // this is the predecessor
            // starting shifting operation
            while(j>=0 && toBeInserted<array[j]){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=toBeInserted;
        }
        return array;
    }
}
