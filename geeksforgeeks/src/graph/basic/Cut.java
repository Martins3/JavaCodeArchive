package graph.basic;

import graph.Edge;
import graph.Graph;

import java.util.LinkedList;

/**
 * if it's cutVertex: after vertex V has been removed
 * there's more than one components
 *
 *
 *
 * */
public class Cut {

    /**
     * algorithm:
     * 1. ask all the neighbor's lwo value
     * 2. only not visited neighbors will asked again
     * 3. refresh low value from the neighbor
     * 4. for the common value, 判断的方法是查看child low value ,
     * child's low value means the 触手到达的位置, 只有所有的触手到达的位置都是在访问自己之前才是可以的
     *
     * 5. for the root node, understand the child count for the parent value
     *  if the parent can not separate the graph, then use dfs and can find more than
     *  对于root所以需要单独处理
     * 6. 由于处理的为 无方向图, 所以需要放置 parent node 污染
     * 7. 更新low value 的方法:
     *
     * @param G 需要是无向图
     * */

    LinkedList<Edge> bi;
    private void cutVertex(Graph G){
        // create
        boolean[] visited = new boolean[G.getV()];

        int[] parent = new int[G.getV()];

        int[] low = new int[G.getV()];

        int[] depth = new int[G.getV()];

        // this is for the bi_connected graph
        bi = new LinkedList<>();

        // init
        for (int i = 0; i < parent.length; i++) {
           parent[i] = -1;
        }

        // run
        helpVertex(G, visited, parent, low, depth, 0, 0);
    }

    private void helpVertex(Graph G, boolean[] visited, int[] parent, int[] low, int[] depth, int d, int s){
        // init the low depth and child number
        low[s] = d;
        depth[s] = d;
        visited[s] = true;

        int childrenNum = 0;
        boolean isArticulation = false;


        for(int neighbor: G.getAdjListArray()[s]){
            if(!visited[neighbor]){
                childrenNum ++;
                parent[neighbor] = s; // good practice !

                // add edge to the bi_connected graph
                bi.add(new Edge(s, neighbor, 0));


                helpVertex(G, visited, parent, low, depth, d + 1, neighbor);

                if(low[neighbor] >= depth[s]) {
                    if(low[neighbor] > depth[s]){
                        System.out.println(s + " - " + neighbor);
                    }
                    isArticulation = true;
                }

                if(parent[s] == -1 && childrenNum >= 2 || parent[s] != -1 && isArticulation) {
                    while (!(bi.getLast().getX() == s && bi.getLast().getY() == neighbor)){
                        System.out.println(bi.getLast().getX() + " " + bi.getLast().getY());
                        bi.removeLast();
                    }
                    System.out.println(bi.getLast().getX() + " " + bi.getLast().getY());
                    bi.removeLast();
                }


                low[s] = Math.min(low[s], low[neighbor]);
            }else if(neighbor != parent[s]){
                low[s] = Math.min(low[s], depth[neighbor]);

                bi.add(new Edge(s,neighbor,0));
            }
        }

        if(parent[s] == -1 && childrenNum >= 2 || parent[s] != -1 && isArticulation) {
            System.out.println(s + " is articulation vertex");
        }
    }


    /**
     * 对于非连通的图 也是可以使用的, 只是需要在循环的调用此函数 !
     * 为什么判断 cut vertex 的时候, 需要在外面, 应为可以含有很多的边说明的, 但是求解 biConnected 的时候, 需要把
     * edge 内部, 对于所有的部分都是会形成一个边
     */
    private void test(){
        Graph g = Graph.makeDG("basic/cut.txt");
        cutVertex(g);
        while (! bi.isEmpty()){
            System.out.println(bi.getLast().getX() + " " + bi.getLast().getY());
            bi.removeLast();
        }
    }
    public static void main(String[] args) {
        Cut c = new Cut();
        c.test();

    }
}
