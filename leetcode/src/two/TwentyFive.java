package two;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by olddriver on 17-4-3.
 */
public class TwentyFive {
     class MyStack {
         private Queue<Integer> queue = new LinkedList<>();

         public void push(int x) {
             queue.add(x);
             for (int i=1; i<queue.size(); i++)
                 queue.add(queue.remove());
         }

         public void pop() {
             queue.remove();
         }

         public int top() {
             return queue.peek();
         }

         public boolean empty() {
             return queue.isEmpty();
         }
     }
    private TwentyFive(){

    }
    public static void main(String[] args) {
        new TwentyFive();
    }
}
