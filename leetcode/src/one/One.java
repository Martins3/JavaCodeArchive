package one;

import mytools.TreeNode;


/**
 * Created by martin on 17-4-24.
 *
 */
public class One {
    private boolean sym(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        return left.val==right.val&&sym(left.left,right.right)&&sym(left.right,right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root==null||sym(root.left,root.right);
    }
}
