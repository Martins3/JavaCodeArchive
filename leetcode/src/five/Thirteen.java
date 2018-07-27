package five;

import mytools.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by martin on 17-4-23.
 *
 */
public class Thirteen {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> s=new LinkedBlockingQueue<>();
        Queue<TreeNode> theSecond=new LinkedBlockingQueue<>();
        s.add(root);
        TreeNode res;
        while (!s.isEmpty()){
            res=s.peek();
            while (!s.isEmpty()){
                TreeNode temp=s.poll(); // from the left to right

                if(temp.left!=null){
                    theSecond.add(temp.left);
                }
                if(temp.right!=null){
                    theSecond.add(temp.right);
                }
            }
            if(theSecond.isEmpty()){ // means the the s is the last row
               return res.val;
            }
            s=theSecond;
            theSecond=new LinkedBlockingQueue<>();
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
