package one;

import java.util.Vector;

/**
 * Created by martin on 17-10-4.
 */


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class Sixteen {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;


        Vector<TreeLinkNode> s = new Vector<>();
        s.add(root);
        s.add(null);
        while (true){
            // 修改 s 的指向关系
            TreeLinkNode pre = s.get(0);

            if(pre == null) break; // 完美tree , 直接报废
            Vector<TreeLinkNode> down_s = new Vector<>();

            for (int i = 1; i < s.size(); i++) {
                pre.next = s.get(i);
                pre = s.get(i);
            }

            for (TreeLinkNode tree:s){
                if(tree != null){

                    down_s.add(tree.left);
                    down_s.add(tree.right);
                }else{
                    down_s.add(null);
                }
            }
            s = down_s;
        }
    }
}
