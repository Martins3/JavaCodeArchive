package one;

/**
 * Created by olddriver on 17-4-11.
 *
 */
public class TwentyOne {
    public int maxProfit(int[] prices) {
        for (int i = prices.length-1; i >=0 ; i--) {
           prices[i]=prices[i]-prices[i-1];
        }
        int max=0;
        int now=0;
        for (int i = 0; i <prices.length ; i++) {
            now=now+prices[i];
            if(now<0){
                now=0;
            }
            max=Math.max(max,now);
        }
        return max;
    }
}
