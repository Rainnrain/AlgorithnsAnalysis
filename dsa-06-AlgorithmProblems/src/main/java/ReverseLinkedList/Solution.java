package ReverseLinkedList;

public class Solution {
    public static void main(String[] args) {
        MySinglyLinkedList list=new MySinglyLinkedList();

        for(int i=0;i<10;i++) list.add(i);
        list.printNodes();
        System.out.println("After reverse in one pass");
        reverse(list);
        list.printNodes();
    }
     static void reverse(MySinglyLinkedList list) {
         Node prev= list.head;
         Node current= list.head.next;

         while(current!=null){
             Node nodeNext=current.next;
             current.next=prev;
             prev=current;
             current=nodeNext;
         }
         list.tail=list.head;
         list.tail.next=null;
         list.head=prev;
    }
}
