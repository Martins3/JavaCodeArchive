package four;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by martin on 17-9-29.
 */
public class NintyFour {

    // 向下递归
    TreeMap<Integer, Integer> Af;
    TreeMap<Integer, Integer> Bf;
    int[] A;
    int[] B;


    public static void main(String[] args) {
        NintyFour nf = new NintyFour();
        nf.findTargetSumWays(new int[]{1, 2, 3}, 6);
    }
    public int findTargetSumWays(int[] nums, int S) {
        // 由于数目不超过20, 所以对于的数组进行拆分
        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            if(nums[0] == S){
                return 1;
            }else {
                return 0;
            }
        }

        int len = nums.length;
        A = Arrays.copyOfRange(nums, 0, len / 2);
        B = Arrays.copyOfRange(nums, len / 2, len);

        // 复杂度分析 => 2 * 10 * 10 + 1000 * 1000
        Af = new TreeMap<>();
        Bf = new TreeMap<>();
        calA(0);



    return 0;

    }

    private void calA(int index){
        if(index == A.length){
            return;
        }
        int i = A[index];



        // 除非可以该数值 删除
    }




}
