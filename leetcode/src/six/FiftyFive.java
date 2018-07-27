package six;

import mytools.TreeNode;
import three.Fifty;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by martin on 17-9-27.
 * 1. while 循环的之前没有添加函数的元素进去
 * 2. 分析的时候使用的为 从1 开始, 之后的代码没有修改
 * 3. 结束的时候不是 nums 等于 0 的
 */
public class FiftyFive {
    public static void main(String[] args) {
        FiftyFive ff = new FiftyFive();
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.left.right = new TreeNode(3);

        ff.printTree(a);

    }

    public List<List<String>> printTree(TreeNode root) {
        int depth = height(root);
        Vector<Vector<TreeNode>> triangle = new Vector<>();
        Vector<TreeNode> a = new Vector<>();
        a.add(root);
        triangle.add(a);

        for (int i = 1; i < depth; i++) {
            Vector<TreeNode> b = new Vector<>();
            for(TreeNode node: a){
                if(node == null){
                    b.add(null);
                    b.add(null);
                }else{
                    b.add(node.left);
                    b.add(node.right);
                }
            }
            triangle.add(b);
            a = b;
        }



        LinkedList<List<String>> res = new LinkedList<>();
        for (int i = 1; i <= depth ; i++) {
            LinkedList<String> layer = new LinkedList<>();
            int s = depth - i;
            int pos = pow(s) - 1;
            int gap = pow(s + 1);

            int index = 0;
            int index_2 = 0;
            int nums = pow(depth) - 1;
            while (nums!=0){
                nums --;
                if(index == pos){
                    pos = pos + gap ;
                    index ++;
                    TreeNode tn = triangle.get(i - 1).get(index_2);
                    if(tn == null){
                        layer.add("");
                    }else {
                        layer.add("" + tn.val);
                    }
                    index_2 ++;
                }else {
                    index++;
                    layer.add("");
                }
            }
            res.add(layer);
        }
        return res;

    }

    private static int pow(int x){
        return (int)Math.pow(2, x);
    }


    private static int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }


}
