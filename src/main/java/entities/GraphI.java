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

    public Integer getNumberVertex(){
        return vertex.size();
    }

    public Integer getNumberEdge(){
        return edges.size();
    }

    public boolean isConnected(){
        if (getAllVpE().containsAll(vertex)) {
            return true;
        }
        return false;

        // for (Vertex v : vertex) {
        //     for (Edge e : edges) {
        //         if (v.getName() == e.getV() || v.getName() == e.getU()) {
        //             break;
        //         }
                
        //     }
        //     return true;
        // }
        // return false;
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
