import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetReview {

    public static void main(String[] args) {

        Set<Student> set = new LinkedHashSet<>();

        set.add(new Student(1, "Mark"));
        set.add(new Student(4, "Lorraine"));
        set.add(new Student(2, "Brad"));
        set.add(new Student(3, "Heather"));
        set.add(new Student(4, "Lorraine"));

        System.out.println(set.add(new Student(1, "Mark")));

        System.out.println(set);
        String str= "Javva Developer";
        System.out.println(firstRepeatingChar(str));
        System.out.println(firstRepeatingChar2(str));
    }

    public static Character firstRepeatingChar(String str) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (set.add("" + str.charAt(i))) {
                continue;
            } else {
                return str.charAt(i);
            }
        }
        return null;
    }

    public static Character firstRepeatingChar2(String str) {
        //Complexity of the code itself is O(n)
        Set<Character> chars= new HashSet<>(); // In here there is a space complexity of O(n)

        for(Character ch:str.toCharArray()) if(!chars.add(ch)) return ch;

        return null;
    }
}