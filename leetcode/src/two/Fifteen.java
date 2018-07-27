package two;

import java.util.Arrays;

/**
 * Created by martin on 17-9-22.
 */
public class Fifteen {
    int local;
    public int findKthLargest(int[] nums, int k) {
        local = k;
        int[] sub = slice(nums);
        while (local != 1){
            sub = slice(sub);
        }
        return findMax(nums) ;
    }

    private static int[] slice(int[] nums){
        // 使用元素div, 左边的元素全部小鱼等于div, ....
        // 修改local 和 返回数组
        // 需要支持返回值只有一个数值的时候
        int div = nums[0];
        int i = 1;
        int j = nums.length;
        while (i <= j){
            while (nums[i] < div){
                i++;
            }

            while (nums[j] > div){
                j--;
            }
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }

        return null;
    }


    private int findMax(int[] nums){
        int max = nums[0];
        for(int i:nums){
            if(i > max){
                max = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        int[] b = Arrays.copyOfRange(a, 0, 2);
        a[0] = 10000000;
        for(int i:b){
            System.out.print(i + " ");
        }
    }
}
