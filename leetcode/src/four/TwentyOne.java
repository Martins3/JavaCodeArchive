package four;

/**
 * Created by olddriver on 17-3-25.
 * Given fortheen non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < Math.pow(2,31).
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 */
public class TwentyOne {
    public int findMaximumXOR(int[] nums) {
        int sum=nums[0];
        int oldsum;
        int x=nums[0];
        int y=nums[1];
        int a=x>=(x^y)?x:(x^y);
        int b=x<=(x^y)?x:(x^y);
        for (int i = 1; i <nums.length ; i++) {
            oldsum=sum;
            sum=sum^nums[0];
            if(sum-oldsum>a){
                b=a;
                a=sum-oldsum;
            }else if(a>=sum-oldsum&&b<(sum-oldsum)){
                b=sum-oldsum;
            }
        }
        return a+b;
    }
    private static void testXor(){
        System.out.println(1^2);
    }
    public static void main(String[] args) {
        TwentyOne t=new TwentyOne();
        int[] test={3, 10, 5, 25, 2, 8};
        System.out.println(t.findMaximumXOR(test));
    }
}
