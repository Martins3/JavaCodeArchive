package mytools;

/**
 * Created by olddriver on 17-4-15.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val=val;
    }
    public static void printListNode(ListNode head){
        if(head==null){
            System.out.println("null");
            return;
        }
        while (head.next!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println(head.val);
    }
    public static ListNode creatListNode(int length){
        ListNode res;
        ListNode head=new ListNode(length);
        res=head;
        for (int i = length-1; i >0 ; i--) {
            head.next=new ListNode(i);
            head=head.next;
        }
        return res;
    }
}
