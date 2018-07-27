package graph.mst;

import graph.Edge;
import graph.WeightedGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Princeton 含有 lazy 的版本 和 eager 的版本
 */
public class Prim {

    /**
     * init:
     * 1. visited[] : the vertex has been added
     * 2. pq: find the minimal edge connecting to the outside
     * 3. Container: to contain the edge added !
     *
     * algorithm:
     * 1. once add a new point, we will add all the edge to pq
     * 2. don't add edge connected to the visited !
     * 3. ignore edge connected to the visited !
     *
     * caution:
     * 1. there seems to be huge mistake for the original idea !!!!!!
     * 2. why it can not
     *
     * */
    private void Prim(WeightedGraph G){
        boolean[] visited = new boolean[G.getV()];

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        LinkedList<Edge> container = new LinkedList<>();

        // init
        visited[0] = true;
        pq.addAll(G.getAdjListArray()[0]);

        while (!pq.isEmpty()){
            Edge e = pq.poll();
            if(!visited[e.getY()]){
                // we can add all edge from
                visited[e.getY()] = true;
                for(Edge neighbor: G.getAdjListArray()[e.getY()]){
                    // or just add the edge not connected to visited !
                    if(!visited[neighbor.getY()]){
                        pq.add(neighbor);
                    }
                }
                container.add(e);
            }
        }

        // print the edges

        for(Edge e: container){
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        Prim prim = new Prim();
        WeightedGraph w = new WeightedGraph();
        w = w.makeWG("weightGraph.txt");
        prim.Prim(w);
    }
}
