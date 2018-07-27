package one;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-21.
 *
 */
public class Sixty {
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
    public static void main(String[] args) {

    }
}
