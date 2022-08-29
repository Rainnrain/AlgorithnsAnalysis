import java.util.ArrayList;

public class Assigment2 {
    public static void main(String[] args) {

        ArrayList <int[]> busStops= new ArrayList<>();
        busStops.add(new int[] {10,0}); //First stop
        busStops.add(new int[] {3,5});
        busStops.add(new int[] {2,5});//Last stop

    }
    public static int countPassengers(ArrayList<int[]> stops) {
        //Code here!
        int result = 0;
        for(int i = 0; i < stops.size();i++) {
            result += stops.get(i)[0];
            result -= stops.get(i)[1];
        }
        return result;
    }

    public static int countPassengers1(ArrayList<int[]> stops) {
        return stops.stream()
                .mapToInt(x -> x[0] - x[1])
                .sum();
    }
}
