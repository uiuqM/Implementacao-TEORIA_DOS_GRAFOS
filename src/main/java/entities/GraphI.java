package entities;
import java.util.ArrayList;

public class GraphI {
    private ArrayList<Vertex> vertex = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    
    public void addVertex(Vertex v){
        vertex.add(v);
    }

    public void addEdge(Vertex v, Vertex u) {
        edges.add(new Edge(v, u));
    }
    public Vertex getVertex(int index){
        return vertex.get(index);
    }

    public ArrayList<Vertex> getAllV(){
        return this.vertex;
    }

    public ArrayList<Edge> getAllE(){
        return this.edges;
    }

    public String toString(){
        return "Vertex array: " + vertex.toString() + "\n" + "Edges: " + edges.toString();
    }
    
}
