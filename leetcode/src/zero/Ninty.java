package zero;

import java.util.*;

/**
 * Created by martin on 17-10-3.
 * 1. 对于深度copy 和 浅层的 copy 的理解错误
 */
public class Ninty {
    public static void main(String[] args) {
        new Ninty().subsetsWithDup(new int[]{1, 2, 2});
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 计算的所有的元素的个数, 对于最开始的版本实现, 之后实现版本递增
        TreeMap<Integer, Integer> source = new TreeMap<>();
        for(int i: nums){
            if(source.containsKey(i)){
                source.put(i, source.get(i) + 1);
            }else {
                source.put(i, 1);
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        if(nums.length == 0)
            return res;

        for(Map.Entry<Integer, Integer> entry:source.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            List<List<Integer>> new_res = new LinkedList<>();

            for(List<Integer> list: res){ // 一个添加, 其他逐渐添加
                new_res.add(list); //
                for (int i = 1; i <= value; i++) {
                    LinkedList<Integer> copy_list = new LinkedList<>(list);

                    for (int j = 0; j < i; j++) { // 添加 i 个元素
                        copy_list.add(key);
                    }
                    new_res.add(copy_list);
                }
            }
            res = new_res;
        }


        return res;
    }
}
