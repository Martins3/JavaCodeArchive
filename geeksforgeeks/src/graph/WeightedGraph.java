package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class WeightedGraph {
    private int V;
    private LinkedList<Edge>[] linkedArray;

    public WeightedGraph(int V){
        this.V = V;
        linkedArray = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            linkedArray[i] = new LinkedList<>();
        }
    }

    public WeightedGraph(){

    }


    public int getV() {
        return V;
    }

    public void addEdge(Edge e){
        linkedArray[e.getX()].add(e);
    }

    public LinkedList<Edge>[] getAdjListArray() {
        return linkedArray;
    }

    public WeightedGraph makeWG(String fileName){
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

        WeightedGraph graph = new WeightedGraph(vertexNum);
        for (int i = 0; i < edgeNum; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int weight = in.nextInt();
            Edge edge = new Edge(x, y, weight);
            graph.addEdge(edge);
        }
        printGraph(graph);
        return graph;
    }

    private void printGraph(WeightedGraph weightedGraph){
        for (LinkedList<Edge> a: weightedGraph.linkedArray){
            for(Edge e: a){
                System.out.println(e.getX() + " --" + e.getWeight() + "--->" + e.getY());
            }
        }
    }

    public WeightedGraph fromNormalGraph(Graph G){
        WeightedGraph wGraph = new WeightedGraph(G.getV());
        for (int i = 0; i < G.getAdjListArray().length; i++) {
            for(int j: G.getAdjListArray()[i]){
                wGraph.addEdge(new Edge(i, j, 1));
            }
        }
        return wGraph;
    }

}

