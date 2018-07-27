package two;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-21.
 *
 if(head==null) return null;
 if(head.next==null) return head;
 ListNode h=head;
 head=head.next;
 h.next=null;
 ListNode temp=head;
 while (temp!=null){
 temp=temp.next;
 head.next=h;
 h=head;
 head=temp;
 }
 */
public class ThirtyFour {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode h=head;
        head=head.next;
        h.next=null;
        ListNode temp=head;
        while (temp!=null){
            temp=temp.next;
            head.next=h;
            h=head;
            head=temp;
        }

        return h;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;

        ListNode len=head;
        int l=0;
        while (len!=null){
            len=len.next;
            l++;
        }
        int flag=l%2;
        l=l/2;
        ListNode begins=head;
        while (l!=1){
            l--;
            begins=begins.next;
        }
        ListNode temp=begins;
        if(flag==1){
            begins=begins.next.next;
        }else {
            begins=begins.next;
        }
        temp.next=null;
        head=reverseList(head);
        while (head!=null){
            if(head.val==begins.val){
                return false;
            }
            head=head.next;
            begins=begins.next;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
