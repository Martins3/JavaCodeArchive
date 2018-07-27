package one;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by olddriver on 17-4-6.
 *
 */
public class FortyFive {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res=new LinkedList<>();
        if(root==null) return res;
        TreeNode current=root;
        Stack<TreeNode> S=new Stack<>();
        S.push(current);
        while (!S.isEmpty()){
            if(current==null){
                TreeNode a=S.pop();
                current=a.right;
                if(current!=null) S.push(current);
            }else{
                current=current.left;
                if(current!=null) S.push(current);
            }
        }
        return res;
    }
}
