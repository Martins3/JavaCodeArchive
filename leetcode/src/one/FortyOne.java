package one;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-22.
 */
public class FortyOne {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode fast=head.next.next;
        ListNode slow=head;
        while (fast!=null&&slow!=null&&fast.next!=null){
            if(fast==slow){
                return true;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
