package five;

import two.Six;

/**
 * Created by martin on 17-9-20.
 * 变量的状态
 */
public class Sixty {
    public static void main(String[] args) {
        Sixty s = new Sixty();
        int k = s.subarraySum(new int[]{-1, -1, 1}, 0);
        System.out.println(k);
    }
    public int subarraySum(int[] nums, int k){


        return 0;
    }
    public int OnlyPositiveSubarraySum(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        int a = 0;
        int b = 0;
        int sum = nums[0];
        int res = 0;
        while (b < nums.length){
            if(sum == k){
                res ++;
                a ++;
                b ++;
                if(b == nums.length)
                    return res;
                sum = sum + nums[b] - nums[a - 1];
            }else if(sum < k) {
                b ++;
                if(b == nums.length)
                    return res;
                sum += nums[b];
            }else {
                a ++;
                if(a > b){
                    b ++;
                    if(b == nums.length)
                        return res;
                    sum = nums[a];
                }else{
                    sum -= nums[a - 1];
                }
            }
        }
        return res;
    }
}
