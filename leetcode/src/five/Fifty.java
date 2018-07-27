package five;

import mytools.TreeNode;

import java.util.*;

/**
 * Created by martin on 17-4-23.
 */
public class Fifty {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new LinkedList<>();
        Stack<TreeNode> s=new Stack<>();
        Stack<TreeNode> theSecond=new Stack<>();
        PriorityQueue<Integer> p;
        LinkedList<Integer> res=new LinkedList<>();
        s.push(root);
        res.add(root.val);
        while (!s.isEmpty()){
            p=new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                // this is the first time ,i understannd the mious means what!
                public int compare(Integer o1, Integer o2) {
                    if(o1>o2){
                        return -1;
                    }else {
                        return 1;
                    }

                }
            });
            while (!s.isEmpty()){
                TreeNode temp=s.pop(); // from the left to right
                if(temp.left!=null){
                    theSecond.push(temp.left);
                    p.add(temp.left.val);
                }
                if(temp.right!=null){
                    theSecond.push(temp.right);
                    p.add(temp.right.val);
                }
            }
            if(!p.isEmpty()) res.add(p.peek());
            s=theSecond;
            theSecond=new Stack<>();
        }
        return res;
    }
}
