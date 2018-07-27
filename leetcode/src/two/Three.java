package two;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-21.
 */
public class Three {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fake=new ListNode(0);
        fake.next=head;
        head=fake;
        while (head.next!=null){
            if(head.next.val==val){
                head.next=head.next.next;
            }else {
                head=head.next;
            }

        }
        return fake.next;
    }
}
