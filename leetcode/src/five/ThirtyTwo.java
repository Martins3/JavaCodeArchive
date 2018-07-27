package five;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by martin on 17-9-30.
 * 1. 没有对于数据进行预处理
 * 2. 只要出现了数组的 index 的变化之后,一定是需要查看的有没有可能越界的
 * 3. 对于 0 的分析的问题是, 如果 0 是连续如何
 */
public class ThirtyTwo {
    public static void main(String[] args) {
        int a = new ThirtyTwo().findPairs(new int[]{1, 1, 1, 1, 1}, 0);
        System.out.println(a);
    }
    public int findPairs(int[] nums, int k) {
        if(nums.length <= 1)
            return 0;

        Arrays.sort(nums);
        Vector<Integer> diff = new Vector<>();
        int zeros = 0;

        // 对于 0 的单独处理
        int precedent = nums[0];
        boolean valid_zero = true;
        for (int j = 1; j < nums.length; j++) {
            int i = nums[j] - precedent;
            precedent = nums[j];


            if(i == 0){
                if(valid_zero) {
                    zeros++;
                    valid_zero = false;
                }

            }else {
                valid_zero = true;
                diff.add(i);
            }
        }
        if(k == 0) return zeros;



        // 转化为 连续数值 相加为 k
        // 不可以包含 0 + 2 以及 2 + 0 的情况
        int a = 0;
        int b = 0;
        int sum = diff.get(0);
        int pairs = 0;
        while (a < diff.size() && b < diff.size()){
            if(sum > k){
                sum -= diff.get(a);
                a ++;
                if(a > b){
                    b ++;
                    if(b == diff.size())
                        break;
                    sum += diff.get(b);
                }
            }else if(sum == k){
                a ++;
                b ++;
                pairs ++;
                if(b == diff.size())
                    return pairs;
                else
                    sum = diff.get(b) - diff.get(a - 1) + sum;
            }else if(sum < k){
                b ++;
                if(b == diff.size()){
                    break;
                }
                sum += diff.get(b);
            }
        }

    return pairs;
    }
}
