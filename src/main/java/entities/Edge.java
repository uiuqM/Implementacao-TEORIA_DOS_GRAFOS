package entities;

public class Edge {
    private Vertex v;
    private Vertex u;
    
    public Edge (Vertex v, Vertex u){
        this.v = v;
        this.u = u;
    }

    public String getName(){
        return "(" + this.v + ", "+ this.u +")";
    }

    public String toString(){
        return "(" + this.v+", "+ this.u +")";
    }
}
