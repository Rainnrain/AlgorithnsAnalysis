package main.java;

public class SingleLinkeListApp {

    public static void main(String[] args) {
        MySinglyLinkedList myList= new MySinglyLinkedList();
        System.out.println(myList.isEmpty());


        for (int i = 0; i <5 ; i++) {
            myList.add(i);
        }
//        myList.printNodes();
//        myList.deleteById(7);
//        System.out.println();
//        System.out.println( myList.indexOf(8));
//        myList.printNodes();
       myList.addFirst(123);
        myList.printNodes();
        System.out.println();
    //    System.out.println(myList.getKthFromLast(5));
     //   myList.removeKthFromLast(5);
        myList.printNodes();
        System.out.println();
        System.out.println(myList.getKthFromLastFATIH(4));
       myList.removeKthFromLast2(3);
        myList.printNodes();

    }
}
