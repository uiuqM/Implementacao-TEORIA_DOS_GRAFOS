package entities;

import java.util.ArrayList;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class Transform {
    
    private ArrayList<GraphI> graphs = new ArrayList<>();
    private GraphI graph;
    Vertex v;
    Integer aux = 0;
    Integer auxE = 0;
    public Transform(ArrayList<String> lines) {
        graph = new GraphI();
        graphs.add(graph);
        for (String line : lines) {    
            if (line != " ") {
                v = new Vertex("v"+aux.toString());
                graph.addVertex(v);
                for (char c : line.replaceAll("\\s+","").toCharArray()) {
                    if (c == '1') {
                        graph.addEdge(v, new Vertex("v"+auxE.toString()));
                    }
                    auxE++;
                }
                auxE = 0;
            }
            aux++;
        }
    }

    public void getGraph(){
        for (GraphI i : graphs) {
            Graph<String, DefaultEdge> g = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
            for (Vertex j : i.getAllV()) {
                g.addVertex(j.getName());

            }
            for (Edge k : i.getAllE()) {
                g.addEdge(k.getV(), k.getU());
            }
            System.out.println(g.toString());
        }
    }
    public String toString() {
        return "Graphs: " + graphs.toString();
    }
}
