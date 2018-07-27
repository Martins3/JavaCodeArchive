package three;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by olddriver on 17-3-27.
 *
 */
public class EightyTwo {


    ListNode head;
    private  class ListNode {
        int val;
        ListNode next=null;
        ListNode(int x) { val = x; }
    }
    private EightyTwo(ListNode head){
        this.head=head;
    }
    public int getRandom() {
        int sum=0;
        ListNode find=head;
        while (head!=null){
            sum++;
            head=head.next;
        }
        while (find!=null){
            if(ThreadLocalRandom.current().nextInt(1,  sum+1)==1){
                return find.val;
            }else {
                sum--;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }

}
