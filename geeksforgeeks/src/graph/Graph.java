package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by martin on 17-10-28.
 *
 */
public class Graph {
    private int V;
    private LinkedList<Integer> adjListArray[];

    // constructor
    Graph(int V) {
        this.V = V;


        adjListArray = new LinkedList[V];
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int x, int y){
        adjListArray[x].add(y);
    }

    public int getV() {
        return V;
    }


    public LinkedList<Integer>[] getAdjListArray() {
        return adjListArray;
    }

    public static Graph makeDG(String fileName){
        URL url = Graph.class.getResource(fileName);
        Scanner in;
        try {
            File file = new File(url.toURI());
            in = new Scanner(file); // submit , just change to System.in
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        int vertexNum = in.nextInt();
        int edgeNum = in.nextInt();

        Graph graph = new Graph(vertexNum);
        for (int i = 0; i < edgeNum; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph.addEdge(x, y);
        }
        return graph;
    }

    /**
     * please make sure the the given graph has no edges such as that
     * a -> b and b -> a
     *
     */
    public static Graph makeUDG(String fileName){
        URL url = Graph.class.getResource(fileName);
        Scanner in;
        try {
            File file = new File(url.toURI());
            in = new Scanner(file); // submit , just change to System.in
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        int vertexNum = in.nextInt();
        int edgeNum = in.nextInt();

        Graph graph = new Graph(vertexNum);
        for (int i = 0; i < edgeNum; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph.addEdge(x, y);
            graph.addEdge(y, x);
        }
        return graph;
    }
}
