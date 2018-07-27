package graph.basic;

import graph.Edge;
import graph.WeightedGraph;

import java.util.LinkedList;

public class LP {

    private void findLongestPath(WeightedGraph G, int s) {
        LinkedList<Integer> seq = new LinkedList<>();
        boolean[] visited = new boolean[G.getV()];

        // run the dfs for the every points
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) sort(G, i, visited, seq);
        }

        int[] disTo = new int[G.getV()];
        for (int i = 0; i < disTo.length; i++) {
            disTo[i] = Integer.MIN_VALUE;
        }


        // start from the begin until find the target
        // relax the notes by the sorting sequence !

        for(int i: seq){
            System.out.println(i);
        }
        int index = 0;
        while (s != seq.getFirst()) {
            seq.removeFirst();
            index ++;
        }

        disTo[index] = 0;
        for(int i: seq){
            // for every edge
            for(Edge e: G.getAdjListArray()[i]){
               int end = e.getY();
               if(disTo[end] < disTo[i] + e.getWeight()){
                   disTo[end] = disTo[i] + e.getWeight();
               }
            }
        }

        for (int i = 0; i < disTo.length; i++) {
            System.out.println(i + " : " + disTo[i]);
        }
    }
    private void sort(WeightedGraph G, int s, boolean[] visited, LinkedList<Integer> seq){
       visited[s] = true;
       for(Edge e : G.getAdjListArray()[s]){
          int end = e.getY();
          if(!visited[end]) sort(G, end, visited, seq);
       }
       seq.addFirst(s);
    }


    public static void main(String[] args) {
        LP lp = new LP();
        WeightedGraph g = new WeightedGraph();
        g = g.makeWG("basic/long.txt");
        lp.findLongestPath(g, 0);
    }
}
