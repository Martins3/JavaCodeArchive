package one;

import mytools.TreeNode;


/**
 * Created by martin on 17-4-27.
 * 假设功能正确 ，然后当前的步骤正确就是可以了
 */
public class Fourteen {
    private TreeNode preorder(TreeNode root){
        if(root==null) return null;
        TreeNode a=preorder(root.left);
        if(a==null) a=root;


        TreeNode b=preorder(root.right);
        a.left=root.right;
        root.right=null;
        if(b==null)b=root;
        return b;
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        preorder(root);
    }
}
