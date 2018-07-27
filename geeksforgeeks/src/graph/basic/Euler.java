package graph.basic;

import graph.Graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 需要添加的部分: all the edge 恰好经过一次
 *
 * question:
 * 1. 处理图形是否 需要一定为 undirected graph !
 *
 Choose any starting vertex v, and follow a trail of edges from that vertex until returning to v.
 It is not possible to get stuck at any vertex other than v,
 because the even degree of all vertices ensures that,
 when the trail enters another vertex w there must be an unused edge leaving w.
 The tour formed in this way is a closed tour, but may not cover all the vertices and edges of the initial graph.

 As long as there exists a vertex u that belongs to the current tour but that has adjacent edges not part of the tour,
 start another trail from u, following unused edges until returning to u, and join the tour formed in this way to the previous tour.

 对于有向图:
    1. 首先必须是强连通
    2. 出入度相同

 */
public class Euler {


    /**
     * 查找path 和 查找 circle 没有什么区别
     * 为了实现的的方便的, 现在假定处理的图形为有方向的
     *
     * 算法:
     * 1. 只要当前的节点还有出来的边的, dfs
     * 2. 如果当前节点GG了, 那么
     */
    private void findPath(Graph G){
        // init
        int vertex = 0; // 当前到达的位置

        Stack<Integer> path = new Stack<>(); // 当前使用路径

        LinkedList<Integer> circuit = new LinkedList<>(); // 保存结果

        // run
        LinkedList<Integer>[] edges = G.getAdjListArray();
        path.push(vertex);
        while (!path.isEmpty()){
            if(!edges[vertex].isEmpty()){
                int next = edges[vertex].poll();

                path.push(vertex);
                vertex = next;
            }else{

                circuit.push(vertex);
                vertex = path.pop();
            }
        }

        for(int i: circuit){
            System.out.print(i + " ");
        }
        System.out.println();
    }



    /**
     * 有向图的判断几乎相同的, 只是保证出去和进入相同的 !
     * @param G connected graph, for of no sense to for not connected !
     * @return -1 means circle, 1 for path and 0 means neither !
     */
    private int graphCategory(Graph G){
        int odd = 0;
        for(LinkedList<Integer> list: G.getAdjListArray()){
            odd = list.size() % 2;
        }
        if(odd == 0) return -1;
        if(odd == 2) return  1;
        return 0;
    }

    public static void main(String[] args) {
        Euler e = new Euler();
        Graph graph = Graph.makeDG("basic/euler.txt");
        e.findPath(graph);
    }
}
