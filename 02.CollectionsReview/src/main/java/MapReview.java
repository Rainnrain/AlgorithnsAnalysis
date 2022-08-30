import java.util.*;

public class MapReview {
    public static void main(String[] args) {

        Map<Integer, String> studentsMap= new HashMap<>();
        studentsMap.put(1,"Jack");
        studentsMap.put(2,"Julia");

        System.out.println(findFirstNonRepeating2("javaj Developer "));
    }
    public static Character findFirstNonRepeating(String str){

       Map<Integer, Character> map= new LinkedHashMap<>();

       for(Character ch: str.toCharArray()){
           if(map.containsValue(ch)){
               map.put(+1, ch);
           }else{
               map.put(1, ch);
           }
       }

       return map.get(1);
    }

    public static Character findFirstNonRepeating2(String str){

        Map<Character, Integer> map= new TreeMap<>();
        int count;

        for(Character ch: str.toCharArray()){
            if(map.containsKey(ch)){
                count=map.get(ch);
                map.put(ch, count+1);
            }
            else map.put(ch, 1);
        }
        for(Character ch:str.toCharArray()){
            if(map.get(ch)==1) return ch;
        }
        return null;
    }
}
