package graph.sp;


import graph.Edge;
import graph.WeightedGraph;

import java.util.PriorityQueue;

public class Dijkstra {
    /**
     * 需要的数据的结构
     * 1. 标记是否已经锁死
     * 2. 所有的节点都是需要到达的制定的位置
     * 3. 标记自己的父节点是什么东西
     * 4. 优先队列
     *
     * careful:
     * 1. when the point come out from the pq, maybe already visited !
     * 2. don't add visited points
     * 3. don't add points you can not relax
     *
     * 打印出来所有的边:
     * */
    public void Dijkstra(WeightedGraph G, int s){
        boolean[] visited = new boolean[G.getV()];

        int[] disTo = new int[G.getV()];

        int[] parent = new int[G.getV()];

        // init
        for (int i = 0; i < disTo.length; i++) {
           disTo[i] = Integer.MAX_VALUE;
        }
        disTo[s] = 0;

        for (int i = 0; i < parent.length; i++) {
           parent[i] = -1;
        }
        parent[s] = s;

        class Point implements Comparable<Point>{
            private int vertex;
            private int disTo;
            Point(int vertex, int disTo){
                this.vertex = vertex;
                this.disTo = disTo;
            }

            @Override
            public int compareTo(Point o) {
                return this.disTo - o.disTo;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(s, disTo[s]));


        while (!pq.isEmpty()){
            Point p = pq.poll();
            if(!visited[p.vertex]){
                visited[p.vertex] = true;
                for(Edge e: G.getAdjListArray()[p.vertex]){
                    // A 被标记的点其实的不会被收缩
                    if(!visited[e.getY()]){
                       // B
                       if(disTo[e.getY()] > disTo[e.getX()] + e.getWeight()){
                           // change the weight
                           disTo[e.getY()] = disTo[e.getX()] + e.getWeight();
                           // add new points to the pq
                           pq.add(new Point(e.getY(), disTo[e.getY()]));
                           // change the parent
                           parent[e.getY()] = e.getX();
                       }
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
