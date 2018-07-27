package six;

/**
 * Created by martin on 17-9-24.
 *
 * 错误原因
 * 1. 题目没有看完整, 看一遍题目之后然后就写
 * 2. typo, 把两个全部都是写成了 last
 * 3. typo res的初始值没有设置为0
 * 4. 程序流程思考错误
 */
public class EightySix {
    public static void main(String[] args) {
        EightySix es = new EightySix();
        int s =es.calPoints(new String[]{"1", "D", "D", "D"});
        System.out.println(s);
    }
    class ListNode{
        int num;
        ListNode next;
        ListNode last;
        ListNode(int num){
            this.num = num;
            next = null;
            last = null;
        }
    }
    public int calPoints(String[] ops) {
        ListNode head = new ListNode(0); // empty one
        ListNode p = head; // should not be init
        for(String s:ops){
            if(s.equals("C")){
                p = p.last;
                p.next = null;
            }else if(s.equals("+")){
                int t = p.num + p.last.num;
                ListNode n= new ListNode(t);
                p.next = n;
                n.last = p;
                p = n;
            }else if(s.equals("D")){
                ListNode n = new ListNode(p.num * 2);
                p.next = n;
                n.last = p;
                p = n;
            }else{
                ListNode n = new ListNode(Integer.parseInt(s));
                p.next = n;
                n.last = p;
                p = n;
            }
        }
        int res = 0;
        while (head != null){
           res += head.num;
           head = head.next;
        }
        return res;
    }
}
