package zero;
import mytools.ListNode;

/**
 * Created by olddriver on 17-4-19.
 *
 */
public class EightyThree {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode f=head;
        ListNode res=head;
        head=head.next;
        while (head!=null){
         if(head.val==f.val){
             head=head.next;
             f.next=head;
         }else {
             head=head.next;
             f=f.next;
         }
        }
        return res;
    }
}
