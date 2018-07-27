package graph.sp;

import graph.Edge;
import graph.WeightedGraph;

import java.util.LinkedList;

public class BellmanFord {

    /**
     * what to init:
     *  1. disTo
     *  2. parent
     * */
    private void SP(WeightedGraph G, int s){
        int[] disTo = new int[G.getV()];
        int[] parent = new int[G.getV()];

        for (int i = 0; i < disTo.length; i++) {
           disTo[i] = Integer.MAX_VALUE;
        }
        disTo[s] = 0;

        for (int i = 0; i < parent.length; i++) {
           parent[s] = -1;
        }


        for (int i = 0; i < G.getV() - 1; i++) {
            // for every edge
            for(LinkedList<Edge> list: G.getAdjListArray()){
                for(Edge e: list){
                   int x = e.getX();
                   int y = e.getY();

                   if(disTo[y] > disTo[x] + e.getWeight()){
                       parent[y] = x;
                       disTo[y] = disTo[x] + e.getWeight();
                   }
                }
            }
        }


        // print all the path and distance
        for (int i = 0; i < parent.length; i++) {
            // not connected
            if(disTo[i] < 0){
                System.out.println(i + " : " + "INF");
            }else{
                int distance = disTo[i];
                while (i != s){
                    System.out.print(i + " -> ");
                    i = parent[i];
                }
                System.out.println(i + " : " + distance);
            }
        }
    }
}
