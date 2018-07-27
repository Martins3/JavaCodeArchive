package three;

/**
 * Created by martin on 17-10-4.
 */
public class FiftySeven {
    public static void main(String[] args) {
        new FiftySeven().countNumbersWithUniqueDigits(2);
    }
    public int countNumbersWithUniqueDigits(int n) {
        // 总共含有的数值为 10 **  n
        if(n == 0) return 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += countConfined(i);
        }
        return res;
    }

    private static int countConfined(int n){
        if(n == 1) return 10;
        int res = 0;
        // 含有 0 的
        res += (n - 1) * combination(9, n - 1);
        // 不含有 0 的
        res += combination(9, n);
        return res;
    }

    private static int combination(int n, int k){ // n 数字的个数, k 表示位置
        int res = 1;
        int i = 0;
        while (k != 0){
            res *= n - i;
            k --;
            i ++;
        }
        return res;
    }
}
