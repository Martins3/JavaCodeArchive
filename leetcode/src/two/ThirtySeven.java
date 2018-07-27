package two;

/**
 * Created by olddriver on 17-3-25.
 *
 */


public class ThirtySeven {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        while (node.next.next!=null){
            node.val=node.next.val;
            node=node.next;
        }
        node.val=node.next.val;
        node.next=null;
    }

}
