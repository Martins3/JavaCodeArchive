package one;

import mytools.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by martin on 17-4-23.
 *
 */
public class Three {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new Stack<>();
        Stack<TreeNode> s=new Stack<>();
        Stack<TreeNode> theSecond=new Stack<>();
        s.push(root);
        LinkedList<List<Integer>> a=new LinkedList<>();
        LinkedList<Integer> b;
        int i=0;
        b=new LinkedList<>();
        b.add(root.val);
        a.add(b);
        while (!s.isEmpty()){
            b=new LinkedList<>();
            i++;
            while (!s.isEmpty()){
                TreeNode temp=s.pop(); // from the left to right
                if(i%2==0){
                    if(temp.left!=null){
                        theSecond.push(temp.left);
                        b.add(temp.left.val);
                    }
                    if(temp.right!=null){
                        theSecond.push(temp.right);
                        b.add(temp.right.val);
                    }
                }else {
                    if(temp.right!=null){
                        theSecond.push(temp.right);
                        b.add(temp.right.val);
                    }
                    if(temp.left!=null){
                        theSecond.push(temp.left);
                        b.add(temp.left.val);
                    }

                }
            }
            if(!theSecond.isEmpty()){
                a.add(b);
            }
            s=theSecond;
            theSecond=new Stack<>();
        }
        return a;
    }
}
