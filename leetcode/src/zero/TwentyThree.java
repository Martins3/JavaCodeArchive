package zero;
import mytools.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Created by olddriver on 17-4-15.
 *
 */
public class TwentyThree {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode fake=new ListNode(0);
        ListNode res=fake;
        class Pair{
            ListNode l;
            int index;
            Pair(ListNode l,int index){
                this.l=l;
                this.index=index;
            }
        }
        PriorityQueue<Pair> P=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.l.val-o2.l.val;
            }
        });
        for (int i = 0; i <lists.length ; i++) {
            if(lists[i]!=null){
                P.add(new Pair(lists[i],i));
                lists[i]=lists[i].next;
            }
        }
        while (!P.isEmpty()){
            Pair top=P.poll();
            fake.next=top.l;
            fake=fake.next;
            int i=top.index;
            if(lists[i]!=null){
                P.add(new Pair(lists[i],i));
                lists[i]=lists[i].next;
            }
        }
        fake.next=null;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode[] nodes=new ListNode[3];
        for (int i = 0; i <3 ; i++) {
            nodes[i]=ListNode.creatListNode(i+1);
        }
        ListNode.printListNode(new TwentyThree().mergeKLists(nodes));
    }
}
