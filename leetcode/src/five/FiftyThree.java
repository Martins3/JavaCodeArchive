package five;

/**
 * Created by martin on 17-4-25.
 *
 */
public class FiftyThree {
    public String optimalDivision(int[] nums) {
        if(nums.length==1){
            return Integer.toString(nums[0]);
        }else if(nums.length==2){
            StringBuilder res=new StringBuilder(Integer.toString(nums[0]));
            res.append("/");
            res.append(Integer.toString(nums[1]));
            return res.toString();
        }

        StringBuilder res=new StringBuilder(Integer.toString(nums[0]));
        res.append("/(");
        for (int i = 1; i <nums.length ; i++) {
            res.append(Integer.toString(nums[i]));
            if(i<nums.length-1){
                res.append("/");
            }
        }
        res.append(")");
        return res.toString();
    }
}
