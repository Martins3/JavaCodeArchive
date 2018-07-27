package zero;
import mytools.ListNode;

/**
 * Created by olddriver on 17-4-16.
 *
 */
public class SixtyOne {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode findlen=head;
        int len=0;
        while (findlen!=null){
            findlen=findlen.next;
            len++;
        }
        if(len==0)return null;
        k=k%len;
        k=len-k;
        if(k==len) return head;
        ListNode follow=head;
        ListNode frontier=head;
        while (k!=1){
            frontier=frontier.next;
            k--;
        }
        while (follow.next!=null){
            follow=follow.next;
        }
        follow.next=head;
        ListNode res=frontier.next;
        frontier.next=null;
        return res;
    }

    public static void main(String[] args) {
        ListNode a=ListNode.creatListNode(10);
        ListNode.printListNode(new SixtyOne().rotateRight(a,2));
    }
}
