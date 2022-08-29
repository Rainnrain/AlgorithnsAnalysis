import java.util.*;

public class ArrayListReview {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(123, "Lorraine"));
        students.add(new Student(124, "Leyla"));
        students.add(new Student(125, "Sema"));
        students.add(new Student(126, "Ramazan"));

        System.out.println("Printing with legacy for-loop.............");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        System.out.println("printing with interator....................");

        Iterator<Student> it = students.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("printing a backward iteration................");


        while (((ListIterator<?>) it).hasPrevious()) {
            System.out.println(((ListIterator<?>) it).previous());
        }

        System.out.println("Printing with for_each loop ......................");

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println(" Printing with lambda function loop.........................");

        students.forEach(student -> System.out.println(student));

        System.out.println("Sorting with the comparator interface by Descending ID");
        Collections.sort(students, new sortByIdDesc());
        students.forEach(student -> System.out.println(student));

        System.out.println("Sorting with the comparator interface by Descending NAME");

        Collections.sort(students, new sortByNameDesc());
        students.forEach(student -> System.out.println(student));
    }

    static class sortByIdDesc implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    static class sortByNameDesc implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.name.compareToIgnoreCase(o1.name);
        }
    }
}