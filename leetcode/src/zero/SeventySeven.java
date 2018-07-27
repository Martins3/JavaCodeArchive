package zero;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by martin on 17-10-4.
 * 1. 算法理解错误,不应如此搜索
 * 2. 被彻底分析过的点永远都是不应该出现的, 用于长度的变化, 修改部分的代码
 * 3. 终止含有两个条件, 用于巧合, 可以正确含有结果
 */
public class SeventySeven {
    public static void main(String[] args) {
        new SeventySeven().combine(20, 16);
    }
    private int k;
    public List<List<Integer>> container;
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> remind = new LinkedList<>();
        LinkedList<Integer> builder = new LinkedList<>();
        container = new LinkedList<>();
        this.k = k; // 初始化 k
        for (int i = 1; i <= n ; i++) {
            remind.add(i);
        }
        depthFirst(remind, builder);
        return container;
    }

    private void depthFirst(List<Integer> remind, List<Integer> builder){
        if(builder.size() == k){
            container.add(new LinkedList<>(builder));
        }else{
            if(remind.size() + builder.size() < k) return;
            while (remind.size() !=0){
                Integer i = remind.get(0);
                LinkedList<Integer> new_remind = new LinkedList<>(remind);
                new_remind.remove(i);
                builder.add(i);
                depthFirst(new_remind, builder);
                builder.remove(i);

                remind.remove(i);
            }
        }

    }
}
