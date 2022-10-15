import java.util.*;

public class SunsetViews {
    public static void main(String[] args) {
        int[] buildings={3, 5, 4, 4, 3, 1, 3, 2};
        sunsetViews(buildings,"east").forEach(System.out::println);
    }
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

    ArrayList<Integer> blg=new ArrayList<Integer>();

    for (int building : buildings) {
        blg.add((Integer)building);
    }
    Stack<Integer> buildingIndexes=new Stack<>();

    if(direction.equalsIgnoreCase("East")) {
        for (int i = 0; i < blg.size(); i++) {

            if (!buildingIndexes.empty() && blg.get(buildingIndexes.peek()) <= blg.get(i)) {
                buildingIndexes.pop();
            }
            buildingIndexes.push(i);

            if (i == blg.size() - 1) break;

            else if (blg.get(i) <= blg.get(i + 1)) {
                buildingIndexes.pop();
            }
        }
    }else{
        for (int i = blg.size()-1; i >=0; i--) {
            if (!buildingIndexes.empty() && blg.get(buildingIndexes.peek()) <= blg.get(i)) {
                buildingIndexes.pop();
            }
            buildingIndexes.push(i);

            if (i ==0) break;

            else if (blg.get(i) <= blg.get(i -1)) {
                buildingIndexes.pop();
            }
        }
    }
    return new ArrayList<>(buildingIndexes);
}

public static ArrayList<Integer> sunsetViewsFatih(int[] buildings, String direction){
        Stack<Integer> stack= new Stack <>(); // stack to hold building indicies that see sunrice
    // This is for east by default
int i=0;
int step=1;
//This is for the west direction
if(direction.equalsIgnoreCase("west")){
    i=buildings.length-1;
    step=-1;
}
while(i>=0 && i< buildings.length){

        while(!stack.isEmpty() && buildings[i]>= buildings[stack.peek()]){
            stack.pop();
        }
        stack.push(i);
        i+=step;
    }

if(direction.equalsIgnoreCase("west")) Collections.reverse(stack);
    // Now I have a stack with the building indicies taht can see the sunset
    return new ArrayList<Integer>(stack);
}

}
