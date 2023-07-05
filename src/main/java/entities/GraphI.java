package entities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

    public void DFS(Vertex v, boolean visitado[]) {
        visitado[indexVertex.get(v)] = true;

        for (Vertex neighbor : neighborhood(v)) {
            if(!visitado[indexVertex.get(neighbor)]) {
                DFS(neighbor, visitado);
            }
        }
    }

    public boolean isConnected() {
        boolean visitado[] = new boolean[vertex.size()];

        DFS(vertex.get(0), visitado);

        // Verifica se todos os vértices foram visitados a partir do vértice 0
        for (boolean vi : visitado) {
            if (!vi)
                return false;
        }

        return true;
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