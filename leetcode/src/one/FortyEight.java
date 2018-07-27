package one;

import java.util.Arrays;

/**
 * Created by olddriver on 17-3-30.
 */
public class FortyEight {
    private  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        int size=0;
        ListNode keep=head;
        while (head!=null){
            size++;
            head=head.next;
        }
        int[] data=new int[size];
        int i=0;
        head=keep;
        while (head!=null){
            data[i++]=head.val;
            head=head.next;
        }
        Arrays.sort(data);
        head=keep;
        i=0;
        while (head!=null){
            head.val=data[i];
            head=head.next;
        }
        return keep;
    }
}
