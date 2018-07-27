package zero;
import mytools.ListNode;
/**
 * Created by olddriver on 17-4-19.
 *
 */
public class EightyTwo {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode fake = new ListNode(head.val-1);
        fake.next=head;
        head=fake;
        ListNode l=fake;
        ListNode r=l.next;
        while (r!=null){
          if(r.val==l.val){
              l=r;
              r=r.next;
          }else {
              if(r.next==null){
                  fake.next=r;
                  fake=fake.next;
                  r=null;
              }else {
                  if(r.next.val==r.val){
                      l=r;
                      r=r.next;
                  }else {
                      fake.next=r;
                      fake=fake.next;
                      l=r;
                      r=r.next;
                  }
              }
          }
        }
        fake.next=null;
        return head.next;
    }

}
