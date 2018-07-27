package zero;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by martin on 17-10-4.
 *  1. 出现了一个貌似很深邃的错误
 *  2.
 */
public class FortySeven {
    public static void main(String[] args) {
        new FortySeven().permuteUnique(new int[]{1, 1, 2, 2});
    }
    public List<List<Integer>> container;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Vector<Integer> remind = new Vector<>();
        Vector<Integer> builder = new Vector<>();
        Arrays.sort(nums);

        container = new LinkedList<>();
        for(int i:nums){
            remind.add(i);
        }
        depthFirst(remind, builder);
        return container;
    }

    private void depthFirst(List<Integer> remind, List<Integer> builder){
        if(remind.size() == 1){
            List<Integer> a = new Vector<>(builder);
            a.add(remind.get(0));
            container.add(a);
        }else{
            int pre = 0;
            for (int i = 0; i < remind.size(); i++) {
                // 重复的数值不在分析, remind 的数值在删除,但是总是可以维持之前的相对循序
                if(i == 0) pre = remind.get(0);

                // 首先检查是不是相同的数值
                if(remind.get(i) == pre && i!=0) continue;

                pre = remind.get(i);
                List<Integer> new_remind = new Vector<>(remind);
                new_remind.remove(i); // 去除第i 个元素
                builder.add(remind.get(i));
                depthFirst(new_remind, builder);
                builder.remove(builder.size() - 1); // builder
            }
        }

    }
}
