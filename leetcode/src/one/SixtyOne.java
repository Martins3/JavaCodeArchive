package one;

/**
 * Created by martin on 17-10-4.
 * 应该是不可能实现二叉搜索的
 * 虽然含有很多的峰, 但是实际上可以实现二分查找, 因为保证了两边的最低
 */
public class SixtyOne {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (nums[1] < nums[0]) return 0;
            } else if (i == len - 1){
                if (nums[len - 1] > nums[len - 2]) return len - 1;
            }else{
                if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
            }
        }
        return 0;
    }
}
