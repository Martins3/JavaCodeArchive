package graph.mst;

import graph.Edge;
import graph.WeightedGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Kruskal {

    /**
     * 初始化:
     * 1. parent
     * 2. rank
     *
     * find : parent[x] = find[parent[x]]
     * union: compare the rank !
     * */
    class DisjointSet{
        private int[] points;
        private int[] rank;
        private DisjointSet(int size){
            points = new int[size];

            // every one points to itself
            for (int i = 0; i < points.length; i++) {
                points[i] = i;
            }

            rank = new int[size];
        }

        private int find(int x){
            if(points[x] == x) return x;

            points[x] = find(points[x]);
            return points[x];
        }

        private void union(int x, int y){
            int px = find(x);
            int py = find(y);

            if(px == py) return;

            if(rank[px] > rank[py]){
                points[py] = px;
            }else{
                if(rank[px] == rank[py]) rank[py] ++;
                points[px] = py;
            }
        }

        private void print(){
            for(int i: points){
                System.out.print(i + " ");
            }
            System.out.println();

            for(int i : rank){
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }
    }

    /**
     * what to init :
     *  1. Union find
     *  2. pq : sort all the edge
     * */
    private void Kruskal(WeightedGraph G){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        DisjointSet d = new DisjointSet(G.getV());

        LinkedList<Edge> container = new LinkedList<>();

        // don't add edges in the same graph

        for(LinkedList<Edge> edges : G.getAdjListArray()){
            pq.addAll(edges);
        }
        while (!pq.isEmpty()){
            Edge e = pq.poll();
            int x = e.getX();
            int y = e.getY();

            if(d.find(x) != d.find(y)){
                d.union(x, y);
                container.add(e);
            }
        }


        // print the edges

        for(Edge e : container){
            System.out.println(e.toString());
        }
    }

    private void testDisjointSet(){
        DisjointSet d = new DisjointSet(10);
        System.out.println(d.find(1));

        d.union(1, 2);
        d.print();

        d.union(5, 6);
        d.print();

        d.union(1, 5);
        d.print();

        d.find(1);
        d.print();




    }
    public static void main(String[] args) {
        Kruskal k = new Kruskal();
        WeightedGraph w = new WeightedGraph();
        w = w.makeWG("weightGraph.txt");
        k.Kruskal(w);
    }
}
