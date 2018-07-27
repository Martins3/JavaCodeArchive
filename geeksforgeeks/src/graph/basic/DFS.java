package graph.basic;

import graph.Graph;

import java.util.Stack;

public class DFS {
    // init
    public static void dfsStack(Graph g, int s){
        boolean[] visited = new boolean[g.getV()];

        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]) {
                System.out.println("we do something to " + node);
                visited[node] = true;
                stack.addAll(g.getAdjListArray()[node]);
            }
        }
    }




    public static void main(String[] args) {
        Graph g = Graph.makeDG("tiny.txt");
        dfsStack(g, 0);
    }
}
