package graph.basic;

import graph.Graph;
import graph.WeightedGraph;

import java.util.LinkedList;

public class Topological {


    private void topologicalSort(Graph G){
        LinkedList<Integer> res = new LinkedList<>();

        boolean[] visited = new boolean[G.getV()];

        for (int i = 0; i < G.getV(); i++) {
           if(!visited[i]){
                dfs(G, visited, res, i);
           }
        }

        // print the res !
        for(int i: res){
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    /**
     * special dfs here:
     * 1.
     * */
    private void dfs(Graph G, boolean[] visited, LinkedList<Integer> res, int s){
        visited[s] = true;

        for(int neighbor: G.getAdjListArray()[s]){
            if(!visited[neighbor]){
                dfs(G, visited, res, neighbor);
            }
        }
        res.add(s);
    }

    public static void main(String[] args) {
        Topological t = new Topological();
        t.topologicalSort(Graph.makeDG("weightGraph.txt"));
    }
}
