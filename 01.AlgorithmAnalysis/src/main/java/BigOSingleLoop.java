public class BigOSingleLoop {
    public static void main(String[] args) {
        int numberOfOperations=0;
        int n=10;
        long startTime;
        long endTime;
        System.out.println("Input size n is = "+ n);
        // Task 1 Single Loop...................

        startTime=System.currentTimeMillis();
        for(int i=0; i<n; i++){
            numberOfOperations+=1;
        }
        endTime=System.currentTimeMillis();

        System.out.println("Number of operations :"+ numberOfOperations+ " in "+ (endTime-startTime) +" miliseconds");
        // Task 2 Nested Loops...................

        startTime=System.currentTimeMillis();
        for(int j=0;j<n;j++) {
            for (int i = 0; i < n; i++) {
                numberOfOperations += 1;
            }
        }
        endTime=System.currentTimeMillis();

        System.out.println("Number of operations for Nested loop :"+ numberOfOperations+ " in "+ (endTime-startTime) +" miliseconds");

        // Task 2 End...................
// ......................................................................................................
        // Task 3 Three Nested Loops...................

        // Task 3 End...................
// ......................................................................................................
        // Task 4 N and M Nested Loops...................
        // Task 4 End...................

        // Task 5 Logarithmic Complexity...................
        numberOfOperations=10;
        startTime=System.currentTimeMillis();
        for(int i=0; i<n; i*=2){
            numberOfOperations+=1;
        }
        endTime=System.currentTimeMillis();

        System.out.println("Number of operations with logarithmic :"+ numberOfOperations+ " in "+ (endTime-startTime) +" miliseconds");




        // Task 5 End...................*/
    }
}
