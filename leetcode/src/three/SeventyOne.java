package three;

/**
 * Created by olddriver on 17-3-25.
 * overflow and negative
 */
public class SeventyOne {
    public int getSum(int a, int b) {
        int sum=a;
        if(b>0){
            for (int i = 0; i <b ; i++) {
                sum++;
            }
        }else {
            sum--;
            for (int i = 0; i <-(b+1) ; i++) {
                sum--;
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        SeventyOne t=new SeventyOne();
        System.out.println(t.getSum(-10,-12));
        System.out.println(t.getSum(2147483647,-2147483648));
        System.out.println(2147483647);
        System.out.println(-2147483648);
    }
}
