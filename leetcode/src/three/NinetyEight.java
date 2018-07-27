package three;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by olddriver on 17-3-27.
 */
public class NinetyEight {
    class Solution {
        int[] nums;
        public Solution(int[] nums) {
            this.nums=nums;
        }

        public int pick(int target) {
            int sum=0;
            for (int i = 0; i <nums.length ; i++) {
                if(target==nums[i]) sum++;
            }
            for (int i = 0; i <nums.length ; i++) {
                if(nums[i]==target){
                    if(ThreadLocalRandom.current().nextInt(1,  sum+1)==1){
                        return i;
                    }else {
                        sum--;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,3};
        NinetyEight n=new NinetyEight();
        NinetyEight.Solution solution =n.new Solution(nums);
        System.out.println(solution.pick(3));
    }
}
