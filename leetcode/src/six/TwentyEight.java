package six;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

/**
 * Created by martin on 17-6-28.
 */
public class TwentyEight {
    public static void main(String[] args) {
        System.out.println(new TwentyEight().maximumProduct(new int[]{-1, -2, -3}));
    }

    public int maximumProduct(int[] nums) {
        if (nums.length < 3){
            return 0;
        }
        int[] n = new int[2];
        int[] p = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (t > 0) {
                if (t > p[0]) {
                    p[2] = p[1];
                    p[1] = p[0];
                    p[0] = t;
                } else if (t > p[1]) {
                    p[2] = p[1];
                    p[1] = t;
                } else if (t > p[2]) {
                    p[2] = t;
                }
            } else {
                if (t < n[2]) {
                    n[0] = n[1];
                    n[1] = n[2];
                    n[2] = t;
                } else if (t < n[1]) {
                    n[0] = n[1];
                    n[1] = t;
                }else if(t < n[0]){
                    n[0] = t;
                }
            }
        }
        int k = n[0] * n[1];
        int pp = p[0] * p[1] * p[2];

        // there is no positive
        if(p[0] == 0){
            return n[0] * n[1] * n[2];
        }

        // only one pos
        if(p[1] == 0){
            return k * p[0];
        }

     return 0;
    }
}
