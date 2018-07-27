package zero;

import mytools.DoArray;

/**
 * Created by olddriver on 17-3-28.
 *
 */
public class SeventyFive {
    public void sortColors(int[] nums) {
       int zero=0;
       int one=0;
       int two=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            } else {
                two++;
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            if(i<zero){
                nums[i]=0;
            }else if(i<zero+one){
                nums[i]=1;
            }else {
                nums[i]=2;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums=new int[]{0,0,0,1,2,1,2,1,1,1};
        SeventyFive s=new SeventyFive();
        s.sortColors(nums);
        DoArray.printIntArray(nums);
    }
}
