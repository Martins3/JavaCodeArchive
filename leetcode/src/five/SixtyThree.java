package five;

import mytools.TreeNode;

/**
 * Created by martin on 17-4-23.
 */
public class SixtyThree {
    class Pair{
        int sum;
        int tilt;
        private Pair(int sum,int tilt){
            this.sum=sum;
            this.tilt=tilt;
        }
    }
    private Pair findSum(TreeNode root){
        if(root==null) return new Pair(0,0);
        Pair l=findSum(root.left);
        Pair r=findSum(root.right);
        int tilt=Math.abs(l.sum-r.sum)+l.tilt+r.tilt;
        int sum=l.sum+r.sum+root.val;
        return new Pair(sum,tilt);
    }
    public int findTilt(TreeNode root) {
        Pair p=findSum(root);
        return p.tilt;
    }

    public static void main(String[] args) {

    }
}
