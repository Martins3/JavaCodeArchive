package zero;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-21.
 */
public class EightySix {
    public ListNode partition(ListNode head, int x) {
        if(head==null)return null;
        ListNode lessH=null;
        ListNode less=null;
        ListNode eBigger=null;
        ListNode eBiggerH=null;
        while (head!=null){
            if(head.val<x){
                if(lessH==null){
                    lessH=head;
                    less=head;
                }else {
                    less.next=head;
                    less=less.next;
                }
            }else {
                if(eBiggerH==null){
                    eBiggerH=head;
                    eBigger=head;
                }else{
                    eBigger.next=head;
                    eBigger=eBigger.next;
                }
            }
            head=head.next;
        }
        if(eBigger!=null) {
            eBigger.next = null;
        }
        if(less!=null){
            less.next=eBiggerH;
        }else {
            lessH=eBiggerH;
        }

        return lessH;
    }
}
