package three;

import mytools.DoArray;
import one.FortySeven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by olddriver on 17-4-1.
 *
 */
public class FortyNine {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res=new int[nums1.length+nums2.length];
        int count=0;
        for (int i = 0; i <nums1.length ; i++) {
            if(Arrays.binarySearch(nums2,nums1[i])>=0){
                if(i==0||nums1[i]!=nums1[i-1]){
                    res[count++]=nums1[i];
                }
            }
        }
        return Arrays.copyOfRange(res,0,count);
    }

    private void test(){
        int[] a=intersection(new int[]{4,7,9,7,6,7},new int[]{5,0,0,6,1,6,2,2,4});
        DoArray.printIntArray(a);
    }
    public static void main(String[] args) {
        new FortyNine().test();
    }
}
