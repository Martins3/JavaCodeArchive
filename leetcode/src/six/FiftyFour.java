package six;

import mytools.TreeNode;

import java.util.Arrays;

/**
 * Created by martin on 17-9-26.
 * 1. i == 1 应该是 i == 0
 */
public class FiftyFour {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int i = findMax(nums);
        TreeNode root = new TreeNode(nums[i]);
        if(i == 0){
            root.left = null;
        }else{
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, i));
        }

        if(i == nums.length - 1){
            root.right = null;
        }else{
            root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, i + 1, nums.length));
        }
        return  root;
    }

    private static int findMax(int[] nums){
        int max = nums[0];
        int res = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(max < nums[i]){
                max = nums[i];
                res = i;
            }
        }
        return res;
    }
}
