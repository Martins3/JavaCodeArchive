package zero;

/**
 * Created by olddriver on 17-4-8.
 */
public class TwentySix {
    public int removeDuplicates(int[] nums) {
        int dump=0;
        for (int i = 0; i <nums.length ; i++) {
            if(i!=0&&nums[i]==nums[i-1]){
                dump++;
            }else {
                nums[i-dump]=nums[i];
            }
        }
        return nums.length-dump;
    }
}
