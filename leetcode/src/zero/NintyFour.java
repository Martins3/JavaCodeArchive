package zero;



import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by olddriver on 17-4-6.
 *  1) Create an empty stack S.
    2) Initialize current node as root
    3) Push the current node to S and set current = current->left until current is NULL
    4) If current is NULL and stack is not empty then
        fortheen) Pop the top item from stack.
        b) Print the popped item, set current = popped_item->right
        c) Go to step 3.
    5) If current is NULL and stack is empty then we are done.
 */
public class NintyFour {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res=new LinkedList<>();
        if(root==null) return res;
        TreeNode current=root;
        Stack<TreeNode> S=new Stack<>();

        S.push(current);
        while (!S.isEmpty()){
            if(current==null){
                TreeNode a=S.pop();
                res.add(a.val);
                current=a.right;
                if(current!=null) S.push(current);
            }else{
                current=current.left;
                if(current!=null) S.push(current);
            }
        }
        return res;
    }
    private NintyFour(){
        for (Integer i:inorderTraversal(null)){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        new NintyFour();
    }
}
