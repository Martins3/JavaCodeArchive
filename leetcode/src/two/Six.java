package two;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-21.
 */
public class Six {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode h=head;
        head=head.next;
        h.next=null;
        ListNode temp=head;
        while (temp!=null){
            temp=temp.next;
            head.next=h;
            h=head;
            head=temp;
        }

        return h;
    }
    public static void main(String[] args) {

    }
}
