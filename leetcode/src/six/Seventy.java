package six;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by martin on 17-10-4.
 * 1. 很显然, 没有保证一件事情, 含有多个数值的情况如何处理
 * 2.
 */
public class Seventy {
    public int maximumSwap(int num) {
        // 保证高位在高处即可
        // index 高, 权高
        int[] array_num = toArray(num);
        int[] best_num = array_num.clone();
        Arrays.sort(best_num);

        for (int i = best_num.length - 1; i >=0 ; i--) {
            if(best_num[i] != array_num[i]){
                for (int j = 0; j < i; j++) {
                    if(array_num[j] == best_num[i]){
                        int t = array_num[j];
                        array_num[j] = array_num[i];
                        array_num[i] = t;
                        break;
                    }
                }
                break;
            }
        }
        return toNumber(array_num);
    }

    private static int[] toArray(int a){
        Vector<Integer> v = new Vector<>();
        while (a != 0){
            v.add(a % 10);
            a = a / 10;
        }
        int[] k = new int[v.size()];
        for (int i = 0; i < v.size(); i++) {
            k[i] = v.get(i);
        }
        return k;
    }

    private static int toNumber(int[] a){
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res += a[i] * (int)Math.pow(10, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int a = new Seventy().maximumSwap(12233);
        System.out.println(a);
    }


}
