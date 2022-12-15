public class BigOSingleLoop {
    public static void main(String[] args) {
        int numberOfOperations = 0;
        int n = 10;
        long startTime;
        long endTime;
        System.out.println("Input size n is = " + n);
        // Task 1 Single Loop...................

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            numberOfOperations += 1;
        }
        endTime = System.currentTimeMillis();

        System.out.println("Number of operations :" + numberOfOperations + " in " + (endTime - startTime) + " miliseconds");
        // Task 2 Nested Loops...................

        startTime = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                numberOfOperations += 1;
            }
        }
        endTime = System.currentTimeMillis();

        System.out.println("Number of operations for Nested loop :" + numberOfOperations + " in " + (endTime - startTime) + " miliseconds");

        // Task 2 End...................
// ......................................................................................................
        // Task 3 Three Nested Loops...................
        numberOfOperations = 0;
        startTime = System.currentTimeMillis();
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; i < n; k++) {
                    numberOfOperations += 1;
                }

            }
        }
            endTime = System.currentTimeMillis();
            System.out.println("Number of operations for three Nested loop :" + numberOfOperations + " in " + (endTime - startTime) + " miliseconds");

            // Task 3 End...................
// ......................................................................................................
            // Task 4 N and M Nested Loops...................
            // Task 4 End...................

            // Task 5 Logarithmic Complexity...................
            numberOfOperations = 0;
            startTime = System.currentTimeMillis();
            for (int i = 1; i < n; i *= 2) {
                numberOfOperations += 1;
            }
            endTime = System.currentTimeMillis();

            System.out.println("Number of operations with logarithmic :" + numberOfOperations + " in " + (endTime - startTime) + " miliseconds");


            // Task 5 End...................*/
        startTime = System.currentTimeMillis();
        System.out.println("Time before:"+ startTime);
        numbers();
        endTime = System.currentTimeMillis();
        System.out.println("End time: "+endTime);
        System.out.println("Total time: "+ (endTime-startTime));
        }
    public static void  numbers() {
        int[] num = {1, 2, 3, 4, 6};
        int[] num2 = {3, 4, 3, 1, 6};

        for (int i = 0; i < num.length; i++) {

            for (int j = 0; j < num2.length; j++) {
                if (num[i] + num2[j] == 0) {
                    System.out.println(num[i]+""+ num2[j]);
                }
            }
        }
    }
    }

