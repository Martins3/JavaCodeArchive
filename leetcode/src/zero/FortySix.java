package zero;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by martin on 17-10-4.
 * 无法接受反复的合并, 反复添加
 *  java 传入的是引用, 所以数据结果如何处理的, 由于数据结构的内容也是对象, 所以传入的结果也是引用
 *  接口使用错误, 含有两套规则, 使用 int 和 Integer 的结果不同
 */
public class FortySix {
    public static void main(String[] args) {
        new FortySix().permute(new int[]{1, 2, 4, 3});
    }
    public List<List<Integer>> container;
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> remind = new LinkedList<>();
        LinkedList<Integer> builder = new LinkedList<>();
        container = new LinkedList<>();
        for(Integer i:nums){
            remind.add(i);
        }
        depthFirst(remind, builder);
        return container;
    }

    private void depthFirst(List<Integer> remind, List<Integer> builder){
        if(remind.size() == 1){
            List<Integer> a = new LinkedList<>(builder);
            a.add(remind.get(0));
            container.add(a);
        }else{
            for(Integer i : remind){
                LinkedList<Integer> new_remind = new LinkedList<>(remind);
                new_remind.remove(i);
                builder.add(i);
                depthFirst(new_remind, builder);
                builder.remove(i);
            }
        }

    }
}
