package zero;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-15.
 *
 Note:
 Given n will always be valid.
 Try to do this in one pass.

 // find the length
 ListNode l=head;
 int len=0;
 while (l!=null){
 l=l.next;
 len++;
 }
 // for the len-n node ,change it's next
 ListNode fake=new ListNode(0);
 fake.next=head;
 head=fake;
 int index=len-n;
 while (index!=0){
 index--;
 head=head.next;
 }
 head.next=head.next.next;
 return fake.next;

 */

public class Nineteen {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode target;
        ListNode frontier;
        ListNode fake=new ListNode(0);
        fake.next=head;
        target=fake;
        frontier=fake;
        while (n!=-1){
            n--;
            frontier=frontier.next;
        }
        while (frontier!=null){
            frontier=frontier.next;
            target=target.next;
        }
        target.next=target.next.next;
        return fake.next;
    }

    public static void main(String[] args) {
        ListNode a =new Nineteen().removeNthFromEnd(ListNode.creatListNode(1),1);
        ListNode.printListNode(a);
    }
}
