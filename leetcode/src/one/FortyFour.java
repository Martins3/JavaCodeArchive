package one;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by olddriver on 17-4-6.
 *
 */
public class FortyFour {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res=new LinkedList<>();
        if(root==null) return res;
        TreeNode current=root;
        Stack<TreeNode> S=new Stack<>();
        S.push(current);
        while(!S.isEmpty()){
            if(current==null){
                TreeNode t=S.pop();
                current=t.right;
                if(current!=null) S.push(current);
            }else {
                res.add(current.val);
                current=current.left;
                if(current!=null) S.push(current);
            }
        }
        return res;
    }
}
