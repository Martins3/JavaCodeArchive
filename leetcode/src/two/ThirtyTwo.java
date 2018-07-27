package two;

import java.util.Stack;

/**
 * Created by olddriver on 17-4-6.
 */
public class ThirtyTwo   {
    class MyQueue {
        Stack<Integer> mainS;
        Stack<Integer> subS;
        /** Initialize your data structure here. */
        public MyQueue() {
            mainS=new Stack<>();
            subS=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!mainS.isEmpty()){
                subS.push(mainS.pop());
            }
            subS.push(x);
            while (!subS.isEmpty()){
                mainS.push(subS.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return mainS.pop();
        }

        /** Get the front element. */
        public int peek() {
            return  mainS.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mainS.isEmpty();
        }
    }

}
