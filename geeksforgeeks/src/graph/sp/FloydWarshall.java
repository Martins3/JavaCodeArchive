package graph.sp;

import graph.Edge;
import graph.WeightedGraph;

import java.util.LinkedList;

/**
 * 算导 使用此算法解决了 传递闭包问题,
 * 计算有向图的传递闭包在于分析是不是存在从 a -> b 含有路径, 如果是判断是否连通, 那么问题将会变成
 * 判断是不是强连通分量
 *
 */
public class FloydWarshall {

    /**
     * question:
     * 1. how to prove the correctness
     * 2. disTo[i][j] 到底是不是需要的修改为 0 需要分析 !
     *
     * what to init:
     * 1. disTo[i][i] = 0
     * 2. disTo[i][j] if there is an edge !
     *
     * 3. next[i][j] = -1
     * 4. next[i][j] = j;
     *
     *
     *
     * careful:
     * 1. when we use maxValue make sure there is no adding !
     * */
    private void findAllSP(WeightedGraph G){
        int[][] disTo = new int[G.getV()][G.getV()];
        int[][] next = new int[G.getV()][G.getV()]; // this next , not the parent

        for (int i = 0; i < G.getV(); i++) {
            for (int j = 0; j < G.getV(); j++) {
                if(i != j){
                    disTo[i][j] = 100000;
                }else{
                    disTo[i][j] = 0;
                }
            }
        }

        for(LinkedList<Edge> list: G.getAdjListArray()){
            for(Edge e: list){
                int x = e.getX();
                int y = e.getY();
                int weight =  e.getWeight();

                disTo[x][y] = weight;
                next[x][y] = y;
            }
        }


        for (int k = 0; k < G.getV(); k++) {
            for (int i = 0; i < G.getV(); i++) {
                for (int j = 0; j < G.getV(); j++) {
                    if(disTo[i][j] < disTo[i][k] + disTo[k][j]){
                        next[i][j] = next[i][k];
                        disTo[i][j] = disTo[i][k] + disTo[k][j];
                    }
                }
            }
        }

        // print the path !
        for (int i = 0; i < G.getV(); i++) {
            for (int j = 0; j < G.getV(); j++) {
                if(next[i][j] == -1){
                    System.out.println("there is no path from " + i + " to " + j);
                }else{
                    System.out.print("the path from " + i + " to " + j + " is ");
                    int s = i;
                    while (s != j){
                        System.out.print(s + " ");
                        s = next[s][j];
                    }
                    System.out.println();
                }
            }
        }
    }
}
