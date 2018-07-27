package two;

/**
 * Created by martin on 17-9-30.
 */
public class EightyThree {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }

        // 没有 0

        // 全部是 0

        int index = 0; // 写入数值的位置
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[index] = nums[i];
                index ++;
            }
        }

        for(; index < nums.length; index ++){
            nums[index] = 0;
        }
    }
}
