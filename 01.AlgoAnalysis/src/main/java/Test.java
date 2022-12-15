import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        System.out.println("Time before:" + startTime);

        endTime = System.currentTimeMillis();
        System.out.println("End time: " + endTime);
        System.out.println("Total time: " + (endTime - startTime) + " miliseconds");

        int[] array = new int[]{4, 7, 2, 11};

        System.out.println(Arrays.toString(twoSumSolution1(array, 9)));
    }

    public static int[] twoSumSolution1(int[] array, int targetValue) {


        for (int i = 0; i < array.length; i++) {

            for (int j = 1; j < array.length; j++) {
                if (i != j) {
                    if (array[i] + array[j] == targetValue) {
                        return new int[]{i, j};
                    }
                }
            }
        }
            return new int[]{};
        }

}