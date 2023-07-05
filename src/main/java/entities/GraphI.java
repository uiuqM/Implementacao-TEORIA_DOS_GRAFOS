package entities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;

public class GraphI {
    private ArrayList<Vertex> vertex = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    private Map<Vertex, Integer> indexVertex = new HashMap<>();
    Integer index = 0;
    
    public void addVertex(Vertex v){
        vertex.add(v);
        indexVertex.put(v, index);
        index++;
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

    public Integer getNumberVertex(){
        return vertex.size();
    }

    public Integer getNumberEdge(){
        return edges.size();
    }

    public Map<Vertex, Integer> getIndexMap() {
        return this.indexVertex;
    }

    public void BFS(Vertex v) {
        boolean visited[] = new boolean[vertex.size()];

        LinkedList<Vertex> queue = new LinkedList<>();
        visited[indexVertex.get(v)] = true;
        queue.add(vertex.get(indexVertex.get(v)));

        while (!queue.isEmpty()) {
            v = queue.poll();

            System.out.print(v + " ");
            
            for (Vertex neighbor : neighborhood(v)) {
                if(!visited[indexVertex.get(neighbor)]) {
                    visited[indexVertex.get(neighbor)] = true;
                    queue.add(neighbor);
                }
            }
            
        }
    }

    public void printBFS() {
        BFS(vertex.get(2));
    }

    public ArrayList<Vertex> neighborhood(Vertex v) {
        ArrayList<Vertex> n = new ArrayList<>();
        for (Edge e : this.edges) {
            if (v.equals(e.getUobj())) {
                n.add(e.getVobj());
            }
            if (v.equals(e.getVobj())) {
                n.add(e.getUobj());
            }
        }
        return n;
    }

    private ArrayList<Vertex> getAllVpE() {
        ArrayList<Vertex> listV = new ArrayList<Vertex>();
        for (Edge e : edges) {
            listV.add(e.getUobj());
            listV.add(e.getVobj());
        }
        return listV;
    }

    public String toString(){
        return "Vertex array: " + vertex.toString() + "\n" + "Edges: " + edges.toString();
    }
}