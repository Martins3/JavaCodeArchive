package mytools;

/**
 * Created by olddriver on 17-3-23.
 * printIntArray is so stupied!
 */
public class DoArray {

    public static void printIntArray(int[] arr){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    private static int binaryDecreseSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right){
            if(nums[mid] < target){
                right = mid - 1;
                mid = (left + right) / 2;

            }else if(nums[mid] > target){
                left = mid + 1;
                mid = (left + right) / 2;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
