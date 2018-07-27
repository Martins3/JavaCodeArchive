package six;

import sun.plugin.javascript.navig.Link;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by martin on 17-9-24.
 * 1. 题目的含义读错. last 变成 first
 * 2. 少考察了一种情况, 单一分离的情况
 * 3. 寻找 root 的方法含有错误
 */
public class EightyFour {
    public static void main(String[] args) {
        EightyFour ef = new EightyFour();
        // [[3,5],[4,1],[1,2],[2,5]]
        int[][] data = {{3, 5}, {4, 1}, {1, 2}, {2, 5}};
        for(int i: ef.findRedundantConnection(data)){
            System.out.println(i);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {

        int[] father = new int[2000 + 1];
        for(int[] i: edges){
            if(father[i[1]] == 0) {
                father[i[1]] = i[0];
            }else {
                // 出现了两个 father, 如果father 之下含有三个child ,删除之
                int young = father[i[1]];
                int sons = 0;
                for (int[] j : edges) {
                    if (j[0] == young) {
                        sons++;
                        if (sons == 3) {
                            return new int[]{young, i[1]};
                        }
                    }
                }
                return new int[]{i[0], i[1]};
            }
        }

        // 处理三个子节点, 记录sons的个数
        LinkedList<int[]> maybe = new LinkedList<>();
        int[] sons = new int[2000 +1];
        for(int[] i:edges){
            sons[i[0]] ++;
            if(sons[i[0]] == 3){
                maybe.add(i);
            }
        }
        if(!maybe.isEmpty()){
            return maybe.getLast();
        }




        // 对于分离的节点的处理
        TreeSet<Integer> nodes = new TreeSet<>();
        for(int[] i:edges){
            nodes.add(i[0]);
            nodes.add(i[1]);
        }
        for(int[] i: edges){
            nodes.remove(i[1]);
        }

        LinkedList<int[]> head = new LinkedList<>();
        for(int n:nodes){
            LinkedList<Integer> de =  new LinkedList<>();
            for(int[] e:edges){
                // 找出子孙个数的, 子孙含有子孙的 vaild ,子孙的个数超过1的, vaild
                if(e[0] == n){
                    de.add(e[1]);
                }
            }
            boolean over = false;
            if(de.size() == 1){
                for(int[] i:edges){
                    if(i[0] == de.getFirst()){
                        over = true;
                        break;
                    }
                }
                if(!over){
                    head.add(new int[]{n, de.getFirst()});
                }
            }
        }
        if(head.size() == 2){
            //
        }



        // 处理 root 指向子节点的问题, 找到circle
        int node = 0;
        for (int i = 0; i < father.length; i++) {
            if(father[i] != 0)
                node = i;
        }
        TreeSet<Integer> instack = new TreeSet<>();
        TreeSet<Integer> incircle = new TreeSet<>();
        instack.add(node);
        while (!instack.contains(node)){
            node = father[node];
            instack.add(node);
        }
        int start = node;
        node = father[node];
        incircle.add(start);
        while (node != start){
            incircle.add(node);
            node = father[node];
        }
        for(int[] i:edges){
            if(incircle.contains(i[1])){
                maybe.add(i);
            }
        }
        if(!maybe.isEmpty()){
            return maybe.getLast();
        }
        return null;

    }
}
