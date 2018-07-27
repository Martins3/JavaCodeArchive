package zero;
import mytools.ListNode;
/**
 * Created by olddriver on 17-4-16.
 */
public class TwentyFour {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode fake=new ListNode(0);
        fake.next=head;
        head=fake;
        while (true){
            if(fake.next==null||fake.next.next==null){
                break;
            }else {
                ListNode n=fake.next;
                fake.next=n.next;
                n.next=n.next.next;
                fake.next.next=n;
                fake=fake.next.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
