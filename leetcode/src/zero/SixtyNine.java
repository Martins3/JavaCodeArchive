package zero;

/**
 * Created by martin on 17-9-20.
 */
public class SixtyNine {
    public static void main(String[] args) {
        SixtyNine s = new SixtyNine();
        System.out.println(s.mySqrt(2147483647));

    }
    public int mySqrt(int x) {
        if(x ==0)
            return 0;
        if(x >= 46340 * 46340)
            return 46340;
        float s = 1;
        float s1 = 2;
        while (Math.abs(s - s1) >= 0.0001){
            s = s1;
            s1 = (s + x /s) / 2;
        }
        int res = Math.round(s1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(res * res);

        if(res * res <= x){
            System.out.println("x: "+ x + " res: " + res);
            System.out.println(x - res * res);
            return res;
        }
        System.out.println("revise");
        System.out.println(x - (res - 1)*(res - 1));
        return res - 1;
    }
}
