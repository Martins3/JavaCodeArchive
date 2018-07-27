package three;

import java.util.List;

/**
 * Created by olddriver on 17-3-27.
 *
 */

public class ThirtyEight {
    ListNode head;
    public class ListNode {
        int val;
        ListNode next=null;
        ListNode(int x) { val = x; }
    }

    private void creatListNode(int length){
        ListNode head=new ListNode(length);
        this.head=head;
        for (int i = length-1; i >0 ; i--) {
            head.next=new ListNode(i);
            head=head.next;
        }
    }

    public void printLIstNode(){
        while (head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode first=head;
        if(first==null) return null;
        ListNode second=head.next;
        ListNode tail=head.next;
        if(tail!=null){
            while (true){
                head.next=tail.next;
                if(head.next==null) break;
                head=head.next;
                tail.next=head.next;
                if(tail.next==null) break;
                tail=tail.next;
            }
        }
        head.next=second;
        return first;
    }
    public static void main(String[] args) {
        ThirtyEight t=new ThirtyEight();
        t.creatListNode(10);
        ListNode h=t.oddEvenList(t.head);
        t.printLIstNode();

        t.creatListNode(11);
        ListNode hh=t.oddEvenList(t.head);
        t.printLIstNode();

    }
}
