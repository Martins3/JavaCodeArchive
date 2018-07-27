package five;

import mytools.TreeNode;

import java.util.Stack;

/**
 * Created by martgin on 17-4-23.
 * 突然发现中序遍历 就是  一个正常的顺序
 */
public class ThirtyEight {

    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> S=new Stack<>();
        TreeNode cur=root;
        S.push(cur);
        int sum=0;
        while (!S.isEmpty()){
            if(cur==null){
                TreeNode temp=S.pop();
                int t=sum;
                sum+=temp.val;
                temp.val+=t;
                cur=temp.left;
                if(cur!=null){
                    S.push(cur);
                }
            }else {
                cur=cur.right;
                if(cur!=null){
                    S.push(cur);
                }
            }
        }

        return root;

    }
}
