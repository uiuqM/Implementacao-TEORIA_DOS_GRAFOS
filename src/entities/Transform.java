package entities;

import java.util.ArrayList;

public class Transform {
    
    private ArrayList<Graph> graphs = new ArrayList<>();
    private Graph graph;
    Vertex v;
    Integer aux = 0;
    Integer auxE = 0;
    public Transform(ArrayList<String> lines) {
        graph = new Graph();
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

    public String toString() {
        return "Graphs: " + graphs.toString();
    }
}
