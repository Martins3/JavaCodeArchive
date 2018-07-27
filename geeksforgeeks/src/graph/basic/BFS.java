package graph.basic;

import graph.Graph;

import java.util.LinkedList;

/**
 * Created by martin on 17-10-28.
 */
public class BFS {

    public static void BFS(Graph G, int s){
        boolean visited[] = new boolean[G.getV()];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
           int node = queue.poll();
           if(!visited[node]){
               System.out.println("do something on " + node);
               visited[node] = true;
               queue.addAll(G.getAdjListArray()[node]);
           }
        }
    }

    public static void main(String[] args) {
        BFS(Graph.makeDG("tiny.txt"), 0);
    }
}
