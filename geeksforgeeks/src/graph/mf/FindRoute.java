package graph.mf;

import graph.Edge;
import graph.Graph;
import graph.WeightedGraph;

import java.util.LinkedList;

public class FindRoute {

    /**
     * 要求是所有的边没有重合, 支持无向图
     * 可以很容易的举出一个例子的, 使用dfs 然后标记一个边为不可以使用的边 !
     * 设置所有的全部权重为1, 然后对于起止 maximum flow !
     * @param G directed graph without weight
     * @param s start
     * @param t end
     */
    private void findRoute(Graph G, int s, int t){
        // making a weight WG from G
        WeightedGraph wGraph = new WeightedGraph();
        wGraph = wGraph.fromNormalGraph(G);

        // find the all path
        FindFlow findFlow = new FindFlow();
        findFlow.find(wGraph, s, t);
    }

    public static void main(String[] args) {
        Graph g = Graph.makeDG("mf/route.txt");
        FindRoute fr = new FindRoute();
        fr.findRoute(g, 0, 3);
    }
}
