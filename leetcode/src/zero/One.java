package zero;

import java.util.Arrays;

/**
 * Created by olddriver on 17-3-27.
 *
 */
public class One {
    public int[] twoSum(int[] nums, int target) {
        int[] primitive=new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            primitive[i]=nums[i];
        }
        Arrays.sort(nums);
        int first=0;
        int second=0;
        for (int i = 0; i <nums.length-1 ; i++) {
            if(i!=0&&nums[i]==nums[i-1]) continue;
            int a=Arrays.binarySearch(nums,i+1,nums.length,target-nums[i]);
            if(a>i){
                first=nums[i];
                second=nums[a];
                break;
            }
        }
        int [] res={-1,-1};
        for (int i = 0; i <nums.length ; i++) {
            if(primitive[i]==first||primitive[i]==second){
                if(res[0]==-1){
                    res[0]=i;
                }else {
                    res[1]=i;
                    return res;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
