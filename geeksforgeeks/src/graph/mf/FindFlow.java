package graph.mf;

import graph.Edge;
import graph.WeightedGraph;

import java.util.LinkedList;

public class FindFlow {

    private LinkedList<Edge>[] Gf;



    /**
     * algorithm:
     * 1. the given graph should be kept
     * 2. every dfs, we will get a new residual-graph
     *      1. visited
     *      2. the edge in graph
     *      for every edge, update the Gf
     * 3. the Gf never have negative edge, for convenience, don't delete edge with no weight
     * , not all the edge can be added !
     *
     * @param G Capacity图
     * */
    public void find(WeightedGraph G, int s, int t){

        // create
        Gf = new LinkedList[G.getV()];
        for (int i = 0; i < Gf.length; i++) {
            Gf[i] = new LinkedList<>();
        }
        for(LinkedList<Edge> list : G.getAdjListArray()){
            for(Edge e: list){
                int x = e.getX();
                int y = e.getY();
                int weight = e.getWeight();
                Gf[x].add(new Edge(x, y, weight));
            }
        }

        LinkedList<Edge> path;

        boolean[] visited;


        int maximumFlow = 0;

        // run
        while (true){
            path = new LinkedList<>();
            visited = new boolean[G.getV()];

            if(!dfs(Gf, s, t, path, visited)) break;

            int flow = Integer.MAX_VALUE;
            for(Edge e: path){
                flow = Math.min(flow, e.getWeight());
                System.out.println(e.getX() + " ---> " + e.getY());
            }
            System.out.println();
            maximumFlow += flow;



            // modify the Gf
            for(Edge e: path){
                int x = e.getX();
                int y = e.getY();

                // u -> v
                for(Edge uv: Gf[x]){
                    if(uv.getY() == y) uv.setWeight(uv.getWeight() - flow);
                }

                // v -> u
                // 会有可能行, 并没有该边
                boolean exited = false;
                for(Edge vu: Gf[y]){
                    if(vu.getY() == x){
                        vu.setWeight(vu.getWeight() + flow);
                        exited = true;
                    }
                }
                if(!exited) Gf[y].add(new Edge(y, x, flow));
            }
        }

        // print the edge with for maximum flow !
        // 如何比对, 只看原图的边, 只看被消减的边
        System.out.println("the maximum is " + maximumFlow);
    }


    /**
     * 1. if we find, in the return, collect all the path and minimal flow
     * 2. if not find, return the false to end the finding !
     * */
    private boolean dfs(LinkedList<Edge>[] Gf, int s, int t,
                        LinkedList<Edge> path, boolean[] visited){
        // found the ending !
        if(s == t) return true;

        visited[s] = true;
        for(Edge e: Gf[s]){
            if(e.getWeight() > 0){
                if(!visited[e.getY()]) {
                    if (dfs(Gf, e.getY(), t, path, visited)) {
                        path.add(e); // we find by this edge !
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public LinkedList<Edge>[] getGf() {
        return Gf;
    }

    public static void main(String[] args) {
        FindFlow ff = new FindFlow();
        WeightedGraph w = new WeightedGraph();
        w = w.makeWG("./mf/flow.txt");
        ff.find(w, 0, 3);
    }
}
