package graph;

public class Edge implements  Comparable<Edge>{
    private int x;
    private int y;
    private int weight;

    public Edge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return  x + " " + y + " " + weight;
    }
}
