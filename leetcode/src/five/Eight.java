package five;


import mytools.TreeNode;

import java.util.*;

/**
 * Created by martin on 17-9-21.
 *
 */
public class Eight {
    public static void main(String[] args) {
        Eight e = new Eight();
        TreeNode.printTreeZigOrder(TreeNode.createExample(12));
        System.out.println("the res:");
        for(int i:e.findFrequentTreeSum(TreeNode.createExample(12))){
            System.out.print(i);
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        TreeMap<Integer, Integer> s = buildMap(root, new TreeMap<>()).m;
        int big = Integer.MIN_VALUE;
        for(int i:s.values()){
            if(i > big)
                big = i;
        }
        LinkedList<Integer> v = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : s.entrySet())
        {
           if(entry.getValue() == big){
               v.add(entry.getKey());
           }
        }

        return v.stream().mapToInt(i -> i).toArray();
    }

    class Pair{
        TreeMap<Integer, Integer> m;
        int sum;
        Pair(){
            m = null;
            sum = 0;
        }
    }

    private Pair buildMap(TreeNode root, TreeMap<Integer, Integer> m){
        if(root == null) {
            Pair p = new Pair();
            p.m = m;
            p.sum = 0;
            return p;
        }
        Pair l = buildMap(root.left, m);
        Pair r = buildMap(root.right, l.m);
        Pair res = new Pair();
        res.sum = l.sum + r.sum + root.val;
        res.m = r.m;
        if(res.m.containsKey(res.sum)){
            res.m.put(res.sum, res.m.get(res.sum) + 1);
        }else{
            res.m.put(res.sum, 1);
        }
        return res;
    }
}

