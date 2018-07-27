package zero;

/**
 * Created by olddriver on 17-4-11.
 *
 */
public class Two {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        int a;
        ListNode cur=new ListNode(0); // make fortheen fake note
        ListNode res=cur;
        //use the l1 be the res;
        while (l1!=null||l2!=null){
           if(l1!=null){
               if(l2!=null){
                   a=l2.val;
                   l2=l2.next;
               }else {
                   a=0;
               }
               cur.next=l1;
               cur=cur.next;
               cur.val=cur.val+a+carry;
               if(cur.val>=10){
                   cur.val=cur.val-10;
                   carry=1;
               }else {
                   carry=0;
               }
               l1=l1.next;
           }else {
               a=0;
               cur.next=l2;
               cur=cur.next;
               cur.val=cur.val+a+carry;
               if(cur.val>=10){
                   cur.val=cur.val-10;
                   carry=1;
               }else {
                   carry=0;
               }
               l2=l2.next;
                }
        }
        if(carry!=0){
            cur.next=new ListNode(1);
        }
        return res.next;
    }
}
