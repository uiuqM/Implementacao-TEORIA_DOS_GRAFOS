package entities;
import java.util.ArrayList;

public class GraphI {
    private static ArrayList<Vertex> vertex = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    
    public static void addVertex(Vertex v){
        vertex.add(v);
    }

    public void addEdge(Vertex v, Vertex u) {
        edges.add(new Edge(v, u));
    }
    public Vertex getVertex(int index){
        return vertex.get(index);
    }

    public String toString(){
        return "Vertex array: " + vertex.toString() + "\n" + "Edges: " + edges.toString();
    }
    
}
