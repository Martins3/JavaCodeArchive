package mytools;

import java.util.Stack;

/**
 * Created by olddriver on 17-4-22.
 *
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode createExample(int length){
        // the first one was left out
        if(length<1) try {
            throw new Exception("node should be more than 1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        TreeNode[] numbers=new TreeNode[length+1];
        for (int i = 1; i <numbers.length ; i++) {
            numbers[i]=new TreeNode(i);
        }
        // 使用heap 的格式
        for (int i = 1; i <numbers.length ; i++) {
            if(2*i<=length){
                numbers[i].left=numbers[2*i];
            }else {
                numbers[i].left=null;
            }

            if(2*i+1<=length){
                numbers[i].right=numbers[2*i+1];
            }else {
                numbers[i].right=null;
            }
        }
        return numbers[1];
    }

    public static TreeNode createExample(int[] numbers){
        // be implemented soon
        return null;
    }
    public static void printTreeZigOrder(TreeNode root){
        if(root==null){
            System.out.println(" the tree is empty!");
            return;
        }

        Stack<TreeNode> s=new Stack<>();
        Stack<TreeNode> theSecond=new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            while (!s.isEmpty()){
                TreeNode temp=s.pop(); // from the left to right
                if(temp.left!=null){
                    theSecond.push(temp.left);
                }
                if(temp.right!=null){
                    theSecond.push(temp.right);
                }
                System.out.print(temp.val+" ");
            }
            System.out.println();
            s=theSecond;
            theSecond=new Stack<>();
        }
    }

    // test this funcitons
    public static void main(String[] args) {
        TreeNode a=TreeNode.createExample(10);
        TreeNode.printTreeZigOrder(a);
    }


}

