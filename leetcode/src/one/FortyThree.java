package one;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-21.
 *
 */
public class FortyThree {
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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        // find the length
        int len=0;
        ListNode l=head;
        while (l!=null){
            l=l.next;
            len++;
        }
        len=len%2+len/2;
        ListNode toBeReverse=head;
        while (len!=1){
            len--;
            toBeReverse=toBeReverse.next;
        }
        ListNode second=toBeReverse.next;
        toBeReverse.next=null;
        second=reverseList(second);
        ListNode fake=new ListNode(1);
        ListNode res=fake;
        while (second!=null){
            fake.next=head;
            fake=fake.next;
            head=head.next;

            fake.next=second;
            fake=fake.next;
            second=second.next;
        }
        fake.next=head;
        head=res;
    }
}
