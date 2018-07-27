package zero;

import mytools.ListNode;

/**
 * Created by olddriver on 17-4-22.
 */
public class NintyTwo {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;

        ListNode fake=new ListNode(1);
        fake.next=head;
        head=fake;
        int i=0;
        ListNode rhead=head;
        ListNode rtail=head;
        ListNode firstPart=head;
        ListNode temp;
        while (head!=null){
            if(i<m-1){
                head=head.next;
            }else if(i==m-1){
                firstPart=head;
                head=head.next;
            } else if(i==m){// 初始化
                temp=head;
                head=head.next;
                rtail=temp;
                rhead=temp;
            }else if(i<n){ //
                temp=head;
                head=head.next;
                temp.next=rhead;
                rhead=temp;


            }else if(i==n){
                temp=head;
                head=head.next;
                temp.next=rhead;
                rhead=temp;

                firstPart.next=rhead;
                rtail.next=head;
                break;
            }
            i++;
        }
        return fake.next;
    }

    public static void main(String[] args) {

    }
}
