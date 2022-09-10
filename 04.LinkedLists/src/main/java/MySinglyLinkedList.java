package main.java;

public class MySinglyLinkedList {
    Node head;
    Node tail;
    int size;

    boolean isEmpty() {
        return head == null;
    }

    void add(int data) {
        // create a new node object from data
        Node node = new Node(data);

        if (isEmpty()) {
            tail = head = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    int indexOf(int id) {
        Node current = head;
        if (isEmpty()) return -1;
        int position = 0;
        while (current != null) {
            if (current.id == id) {
                return position;
            }
            position++;
            current = current.next;
        }
        return -1;
    }

    void addFirst(int data) {
        //write code
        Node node = new Node(data);
        Node current = head;
        if (isEmpty()) {
            tail = head = node;
            size++;
        } else {
            node.next = current;
            head = node;
            size++;
        }
    }

    void deleteById(int id) {
        //Check if empty
        if (isEmpty()) System.out.println("List is empty");
        // assign prev and current to the head
        Node previous = head;
        Node current = head;

        while (current != null) {

            if (current.id == id) {// If there is a match
                // Case 1: head position
                if (current == head) {
                    head = current.next;
                    current.next = null;
                } else if (current == tail) {
                    tail = previous;
                    previous.next = null;
                } else {
                    previous.next = current.next;
                    current.next = null;
                }
                //Case 2: tail position
                //Case 3: middle
                //after deletion
                size--;


            }
            previous = current;
            current = current.next;

        }
    }

    void printNodes() {
        Node current = head;
        while (current != null) {
            if (current.next == null) {
                System.out.print(current.id + "=> null");
            } else {
                System.out.print(current.id + "=>");

            }
            current = current.next;
        }
    }

    int getKthFromLast(int k) {
        Node current=head;
        Node secondCurrent=head;

      while(current!=null){
          secondCurrent=current;
          for (int i = 0; i <=k ; i++) {
            if(current!=null)  current=current.next;
          }
      }

        return secondCurrent.id;}

        int getKthFromLast2(int k) {
        int index=0;
        Node current=head;
        Node previous=head;

        while(current.next!=null){
            index++;
            current=current.next;
            if(index==(size-k)){
                break;
            }
        }
        return current.id;
    }

    void removeKthFromLast(int k){
        int index=0;
        Node current=head;
        Node previous=head;

        while(current.next!=null){
            index++;
            previous=current;
            current=current.next;
            if(index==(size-k)){
                break;
            }
        }
     previous.next=current.next;
        current.next=null;
    }
}
