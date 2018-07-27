package one;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-22.
 *
 */
public class FortyTwo {
    public ListNode hasCycle(ListNode head) {

        ListNode fast=head.next.next;
        ListNode slow=head;
        while (fast!=null&&slow!=null&&fast.next!=null){
            if(fast==slow){
                return fast;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return null;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        int lena=0;
        int lenb=0;
        while (a!=null){
            a=a.next;
            lena++;
        }
        while (b!=null){
            b=b.next;
            lenb++;
        }
        ListNode temp;// by exchange the head ,make the lena is samll one
        if(lena>lenb){
            temp=headA;
            headA=headB;
            headB=temp;
        }
        // so headB should go earlier
        lenb=Math.abs(lena-lenb);
        while (lenb!=0){
            lenb--;
            headB=headB.next;
        }
        while (headA!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode inCycle=hasCycle(head);
        if(inCycle==null) return null;
        ListNode beforeCycle=head;
        while (true){
            if(beforeCycle.next==inCycle){
                break;
            }
            beforeCycle=beforeCycle.next;
        }
        // we should find out that if before cycle is in the cycle ,if that, we return the inCycle now
        boolean flag=false;
        ListNode a=inCycle.next;
        while (true){
            if(a==inCycle){
                break;
            }
            if(a==beforeCycle){
                flag=true;
            }
            a=a.next;
        }
        if(!flag){
            return inCycle;
        }
        beforeCycle.next=null; // now we modify it and we should cure it soon!
        ListNode fast=inCycle;
        ListNode res=getIntersectionNode(head,inCycle);
        beforeCycle.next=fast;
        return res;
    }
    private  void test(){
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=b;
        ListNode s=detectCycle(a);
        System.out.println(s.val);
    }

    public static void main(String[] args) {
        new FortyTwo().test();
    }
}
