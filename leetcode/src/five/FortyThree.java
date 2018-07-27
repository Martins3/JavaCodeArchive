package five;

import mytools.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by martin on 17-4-23.
 */
public class FortyThree {
    class Pair{
        int dia;
        int lfoot;
        private Pair(int dia,int lfoot){
            this.dia=dia;
            this.lfoot=lfoot;
        }
    }

    private Pair count(TreeNode root){
        if(root==null) return new Pair(0,0);
        Pair l=count(root.left);
        Pair r=count(root.right);
        int dia=l.lfoot+r.lfoot+1;
        dia=Math.max(dia,l.dia);
        dia=Math.max(dia,r.dia); //find out the biggest of three number

        int lfoot=Math.max(l.lfoot,r.lfoot)+1;
        return new Pair(dia,lfoot);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair s=count(root);
        if(root==null) return 0;
        return s.dia;
    }
    public static void main(String[] args) {

    }
}
