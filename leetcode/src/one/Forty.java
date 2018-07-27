package one;

import mytools.TreeNode;

import java.util.Stack;

/**
 * Created by martin on 17-4-24.
 */
public class Forty {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        Stack<TreeNode> s=new Stack<>();
        Stack<TreeNode> theSecond=new Stack<>();
        s.push(root);
        int i=0;
        while (!s.isEmpty()){
            while (!s.isEmpty()){
                TreeNode temp=s.pop(); // from the left to right
                if(temp.left!=null){
                    theSecond.push(temp.left);
                }
                if(temp.right!=null){
                    theSecond.push(temp.right);
                }
            }
            i++;
            if(theSecond.isEmpty()){
                i--;
            }
            s=theSecond;
            theSecond=new Stack<>();
        }
        return i;
    }
}
