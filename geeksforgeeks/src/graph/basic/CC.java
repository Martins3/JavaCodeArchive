package graph.basic;

import graph.Graph;

import java.util.LinkedList;
import java.util.Stack;

public class CC {
    /**
     * 1. 对于某一个点进行 DFS, 得到完成顺序的Stack, 开始的节点放置到最上面
     * 2. 计算转置图
     * 3. 使用完成的Stack进行 DFS
     *
     * 解释:
     * 使用 转置图保证只要是在
     * 使用Stack保证一定是没有 没有错误的增加
     *
     * 为什么不可以按照谁结束的早, 然后让谁开始访问 => there is counterpart
     * 为什么使用反向的时候没有问题: 在前面结束, 那么必定没有
     */
    private void twoDFS(Graph G){
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[G.getV()];

        for (int i = 0; i < G.getV(); i++) {
            if(!visited[i]){
                dfs(G, stack, visited, i);
            }
        }

        LinkedList<Integer>[] antiGraph = new LinkedList[G.getV()];
        for (int i = 0; i < antiGraph.length; i++) {
            antiGraph[i] = new LinkedList<>();
        }
        for (int i = 0; i < G.getAdjListArray().length; i++) {
            for(int j: G.getAdjListArray()[i]){
                antiGraph[j].add(i);
            }
        }

        boolean[] counted = new boolean[G.getV()];
        int res = 0;
        while (!stack.isEmpty()){
            int s = stack.pop();
            if(!counted[s]){
                res ++;
                dfsAfter(antiGraph, counted, s);
            }
        }
        System.out.println(res);
    }


    private void dfs(Graph G, Stack<Integer> stack, boolean[] visited, int s){
        visited[s] = true;

        for(int neighbor: G.getAdjListArray()[s]){
            if(!visited[neighbor]){
                dfs(G, stack, visited, neighbor);
            }
        }
        stack.push(s);
    }

    private void dfsAfter(LinkedList<Integer>[] G, boolean[] visited, int s){
        visited[s] = true;
        for(int neighbor: G[s]){
            if(!visited[neighbor]){
                dfsAfter(G, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = Graph.makeDG("test.txt");
        CC cc = new CC();
        cc.twoDFS(g);
    }
}
