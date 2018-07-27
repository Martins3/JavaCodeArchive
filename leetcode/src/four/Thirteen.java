package four;

import java.util.LinkedList;

/**
 * Created by martin on 17-9-21.
 */
public class Thirteen {
    public static void main(String[] args) {
        Thirteen a = new Thirteen();
        System.out.println(a.numberOfArithmeticSlices(new int[]{1, 2, 3}));
    }
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length <=2)
            return 0;
        LinkedList<Integer> a = new LinkedList<>();

        int previous = A[1];
        int gap = A[1] - A[0];
        int last = 2;
        boolean flag = true;
        for (int i = 2; i < A.length; i++) {
            int this_gap = A[i] - previous;
            previous = A[i];
            if(this_gap == gap) {
                last++;
                flag = true;
            }else{
                if(last >= 3)
                    a.add(last);
                last = 2;
                gap = this_gap;
                flag = false;
            }
        }
        if(flag && last >= 3)
            a.add(last);
        int res = 0;
        for(Integer i : a){
            res += cal(i);
        }
        return res;
    }

    private static int cal(int i){
        return (i - 1) * (i - 2) / 2;
    }
}
