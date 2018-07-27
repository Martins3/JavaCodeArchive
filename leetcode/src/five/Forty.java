package five;

/**
 * Created by olddriver on 17-4-3.
 *
 */
public class Forty {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        // 首先检查是不是最后
        int len = nums.length;
        if(nums[len - 1] != nums[len - 2]){
            if(nums[len - 2] == nums[len - 3]){
                return nums[len- 1];
            }
        }

        int left = 0;
        int right = nums.length / 2;
        int middle = (left + right) / 2; // 需要保证middle 总是一个偶数, 访问的时候 * 2
        // 变成一个查找 第一个出现的错位的
        while (left <= right){
            break;
        }
        return 0;
    }
    private Forty(){
        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,3,4,5,5}));
    }

    public static void main(String[] args) {
        new Forty();
    }
}
