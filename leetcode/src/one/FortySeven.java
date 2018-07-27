package one;

import java.util.List;

/**
 * Created by olddriver on 17-3-30.
 *
 */
public class FortySeven {
    private  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode A=new ListNode(Integer.MIN_VALUE);
        //add one node to A before satrt
        // we shoulde keep the tail is null
        A.next=head;
        head=head.next;
        A.next.next=null;
        while (head!=null){
            ListNode ins=head;
            head=head.next;
            ins.next=null;


            ListNode preComp=A;
            ListNode comp=A.next;

            while (comp!=null) {
                if (comp.val < ins.val) {
                    //continue move
                    if(comp.next==null){
                        comp.next=ins;
                        break;
                    }
                    preComp=comp;
                    comp = comp.next;
                } else {
                    //insert and break
                    preComp.next=ins;
                    ins.next=comp;
                    break;
                }

            }

        }
        return A.next;
    }
    private void test(){
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        a.next=c;
        c.next=b;
        ListNode res=insertionSortList(a);
        int falg=1;
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
            if(falg==100){
                break;
            }
            falg++;
        }

    }
    public static void main(String[] args) {
        new FortySeven().test();
    }
}
