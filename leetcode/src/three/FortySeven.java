package three;

import mytools.ListNode;

import java.util.*;

/**
 * Created by martin on 17-9-22.
 */
public class FortySeven {
    public static void main(String[] args) {
        FortySeven fs = new FortySeven();
        for(int i:fs.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2)){
            System.out.print(i + " ");
        }
    }
        public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(tree.keySet().contains(nums[i])){
                tree.put(nums[i], tree.get(nums[i]) + 1);
            }else {
                tree.put(nums[i], 1);
            }
        }

        System.out.println(Arrays.toString(tree.entrySet().toArray()));

        TreeMap<Integer, LinkedList<Integer>> fv = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(Map.Entry<Integer, Integer> vf:tree.entrySet()) {
            if (fv.containsKey(vf.getValue())) {
                fv.get(vf.getValue()).add(vf.getKey());
            } else {
                LinkedList<Integer> fs = new LinkedList<>();
                fs.add(vf.getKey());
                fv.put(vf.getValue(), fs);
            }
        }
        System.out.println(Arrays.toString(fv.entrySet().toArray()));

        int index = 0;
        LinkedList<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, LinkedList<Integer>> s: fv.entrySet()){
            if(index >= k){
                break;
            }
            index += s.getValue().size();
            res.addAll(s.getValue());
        }
        return res;
    }
}



