package zero;

/**
 * Created by martin on 17-9-26.
 * 1. 使用 abs没有考察 负数
 * 2. 查看题目理解错误
 * 3. 对于细分的情况没有考察清除的
 * 4.
 */
public class TwentyNine {
    public static void main(String[] args) {
        TwentyNine tn = new TwentyNine();
        System.out.println(tn.divide(12, 4));
        System.out.println(tn.divide(-2147483648,-2));
    }
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;

        if(dividend == Integer.MIN_VALUE){
            if(divisor == -1)
                return Integer.MAX_VALUE;

            if(divisor ==  1)
                return Integer.MIN_VALUE;

            if(divisor == Integer.MIN_VALUE)
                return 1;

            if(divisor == Integer.MAX_VALUE)
                return -1;

            if(divisor < 0)
                return  (int)(Math.exp(Math.log(Integer.MAX_VALUE + 1.0) - Math.log(Math.abs(divisor))));
            else
                return - (int)(Math.exp(Math.log(Integer.MAX_VALUE + 1.0) - Math.log(Math.abs(divisor))));
        }

        if(divisor == Integer.MIN_VALUE){
            return 0;
        }

        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0){
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
            return (int)(Math.exp(Math.log(dividend) - Math.log(divisor)));
        }

        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0){
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
            return - (int)(Math.exp(Math.log(dividend) - Math.log(divisor)));
        }

        return 0;
    }
}
