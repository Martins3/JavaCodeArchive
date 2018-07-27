package zero;

import java.util.Arrays;

/**
 * Created by martin on 17-10-3.
 * 1. 很坑啊, 这是什么操作, 居然是修改数组,很坑
 * 2. 居然返回值也是需要的
 */
public class Eighty {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2)
            return nums.length;



        boolean same = nums[0] == nums[1];
        int last = nums[1];
        int index = 1;
        int res = 2;
        for (int i = 2; i < nums.length; i++) {
            // 需要维护的两个数值, fortheen b

            if(same){
                if(nums[i] != last){
                    same = false;
                    nums[++ index] = nums[i];
                    res ++;
                }
            }else {
                if(nums[i] == last){
                    same = true;
                }
                nums[++ index] = nums[i];
                res ++;
            }
            last = nums[i];
        }
        return res;
    }
}
