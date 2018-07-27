package one;
import mytools.TreeNode;

import java.util.Stack;

/**
 * Created by olddriver on 17-4-22.
 *
 */
public class Twelve {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        Stack<TreeNode> S=new Stack<>();
        TreeNode cur=root;
        int sumup=0;
        // every time psuh add it ,pop subtract it;


        // can we declare this ?
        S.push(cur);
        sumup+=cur.val;
        while (!S.isEmpty()){
            if(cur==null){
                TreeNode a=S.pop();
                sumup-=a.val;
                cur=a.right;
                if(cur!=null){
                    S.push(cur);
                    sumup+=cur.val;
                }else {
                    if(a.left==null&&sum==sumup){
                        return true;
                    }
                }
            }else{
                cur=cur.left;
                if(cur!=null){
                    S.push(cur);
                    sumup+=cur.val;
                }else {
                    TreeNode temp=S.peek();
                    if(temp.right==null&&sum==sumup){
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
