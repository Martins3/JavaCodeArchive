package six;

/**
 * Created by martin on 17-9-20.
 */
public class SeventyFour {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return 1;
        }
        int res = 1;
        int max = res;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                res ++;
                max = Math.max(res, max);
            }else {
                res = 1;
            }

        }
        return max;
    }
}
