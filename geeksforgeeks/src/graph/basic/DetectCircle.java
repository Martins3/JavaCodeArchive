package graph.basic;

import graph.Graph;

import java.util.Stack;

public class DetectCircle {
    /**
     * we assume the Graph G is a connected G
     * and the input of the Graph is standard Graph
     *
     * we also print the circle
     *
     * find the circle can be implement by dfs and bfs
     *
     * 递归的访问: 只要访问的时候, 发现的含有
     * */
    private boolean findCircle(Graph G){
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        boolean[] visited = new boolean[G.getV()];
        while (!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){

            }
        }
        return  false;
    }

    /**
     * find the circle in undirected graph
     *
     * is there any difference in pre-order and post-order different !
     *
     * undirected problem: we should avoid the parent, easy !
     * */
    private boolean findCircleUndirecteGraph(Graph G){
        int s = 0;
        boolean[] visited = new boolean[G.getV()];
        return helpB(G, s, visited);
    }

    private boolean helpB(Graph G, int s, boolean[] visited){
        return false;
    }
}
