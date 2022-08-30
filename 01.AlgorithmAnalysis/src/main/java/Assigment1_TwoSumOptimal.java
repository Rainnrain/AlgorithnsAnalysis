import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Assigment1_TwoSumOptimal {
    public static void main(String[] args) {

        int[] array= new int[]{4,7,2,11};
        System.out.println(Arrays.toString(twoSumOptimalSolution(array, 9)));


    }

    public static int[] twoSumOptimalSolution(int[] array, int targetValue){
        //Space complexity of O(n) because of the hashMap
        // Complexity  of the solution is O(n)

        Map<Integer, Integer> map= new HashMap<>();
        for (int i = 0; i <array.length ; i++) {
            int potentialMatch=targetValue-array[i];
            if(map.containsKey(potentialMatch)) return new int[] {i, map.get(potentialMatch)};
            else map.put(array[i], i);
        }
        return new int[]{};
    }
}
