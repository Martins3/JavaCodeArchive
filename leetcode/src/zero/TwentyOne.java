package zero;

/**
 * Created by olddriver on 17-3-29.
 *
 */
public class TwentyOne {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode l;
        if(l1.val<l2.val){
            l=l1;
            l1=l1.next;
        }else {
            l=l2;
            l2=l2.next;
        }
        ListNode res=l;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                l.next=l1;
                l=l.next;
                l1=l1.next;
            }else {
                l.next=l2;
                l=l.next;
                l2=l2.next;
            }
        }
        if(l2==null){
            l.next=l1;
            return res;
        }
        l.next=l2;
        return res;
    }
    private void test(){
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        a.next=b;
        b.next=c;

        ListNode x=new ListNode(4);
        ListNode y=new ListNode(5);
        ListNode z=new ListNode(6);
        x.next=y;
        y.next=z;
        ListNode res=mergeTwoLists(a,x);
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
    }
    public static void main(String[] args) {
        new TwentyOne().test();
    }
}
