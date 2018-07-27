package five;

import mytools.TreeNode;

/**
 * Created by martin on 17-5-7.
 */
public class SeventyTwo {

    private boolean findNewS(TreeNode s, TreeNode t){
        if(s==null) return false;
        boolean kk;
        if(s.val==t.val){
            kk=compareTree(s,t);
            if(kk) {
                return true;
            }else {
                kk = findNewS(s.right,t);
                if(kk) return true;
                kk = findNewS(s.left,t);
                if(kk) return true;
            }
        }else {
            kk = findNewS(s.right,t);
            if(kk) return true;
            kk = findNewS(s.left,t);
            if(kk) return true;
        }
        return false;
    }
    private boolean compareTree(TreeNode s,TreeNode t){
        if(s==null&&t==null) return true;
        if(s!=null&&t!=null) {
            if (s.val != t.val) return false;
            return compareTree(s.left, t.left) && compareTree(s.right, t.right);
        }else{
            return false;
        }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {

        return  findNewS(s,t);
    }
    public static void main(String[] args) {

    }
}
