package three;

import mytools.DoArray;

import java.util.Arrays;

/**
 * Created by olddriver on 17-4-2.
 *
 * Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk,
 and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class Fifty {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res=new int[Math.min(nums1.length,nums2.length)];
        int i=0;
        int j=0;
        int cnt=0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                i++;
                j++;
                res[cnt++]=nums1[i-1];
            }else if(nums1[i]>nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        return Arrays.copyOfRange(res,0,cnt);
    }
    private void test(){
        DoArray.printIntArray(intersect(new int[]{1,2,2,1},new int[]{1,1}));
    }
    public static void main(String[] args) {
        new Fifty().test();
    }

}
