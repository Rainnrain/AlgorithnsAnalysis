package MergeTwoSortedLL;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode tempHead= new ListNode();
        ListNode prev= tempHead;
        ListNode current=list2;
        ListNode current1=list1;

        while( current!=null && current1!=null){
            if(current.val<=current1.val){
                prev.next=current;
                current=current.next;
            }else{
                prev.next=current1;
                current1=current1.next;
            }
            prev=prev.next;
        }
        // check if any are left over
        if(current1==null) prev.next=current1;
        else prev.next=current;
        return tempHead.next; // this excludes the dummy head we made

    }
}
