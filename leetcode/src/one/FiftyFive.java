package one;

import three.Fifty;

import java.util.Arrays;

/**
 * Created by olddriver on 17-4-3.
 * index points to null
 */
public class FiftyFive {
    class MinStack {
        int []a;
        int index;
        int size;
        public MinStack() {
            size=1;
            index=0;
            a=new int[size];

        }

        public void push(int x) {
            if(index==size){
                size=size*2;
                int[] aa=new int[size];
                System.arraycopy(a,0,aa,0,size/2);
                aa[index]=x;
                index++;
                a=aa;
            }else {
                a[index]=x;
                index++;
            }
        }

        public void pop() {
            if(index==0) throw new RuntimeException("stack is empty");
            index--;
        }

        public int top() {
            if(index==0) throw new RuntimeException("stack is empty");
            return a[index-1];
        }

        public int getMin() {
            if(index==0) throw new RuntimeException("stack is empty");
            int s=Integer.MAX_VALUE;
            for (int i = 0; i <index ; i++) {
                s=Math.min(a[i],s);
            }
            return s;
        }
    }
    private FiftyFive(){


          MinStack obj = new MinStack();
          obj.push(12);
          obj.push(13);
            obj.push(12);
            obj.push(13);

        obj.pop();
        obj.getMin();
        obj.pop();
        obj.getMin();
        obj.pop();
        obj.getMin();

    }
    public static void main(String[] args) {
        new FiftyFive();
    }
}
