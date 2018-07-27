package five;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by martin on 17-4-23.
 */
public class SixtyOne {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i <nums.length ; i+=2) {
            sum+=nums[i];
        }
        return sum;
    }
}
