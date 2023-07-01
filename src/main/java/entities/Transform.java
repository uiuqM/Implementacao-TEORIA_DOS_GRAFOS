package entities;

import java.io.IOException;
import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

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

    public void manipulateGraph(String line) {
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

    public void getGraph() throws IOException {
        for (GraphI i : graphs) {
            Graph g = new MultiGraph("h");
            for (Vertex j : i.getAllV()) {
                g.addNode(j.getName());

            }
            for (Edge k : i.getAllE()) {
                g.addEdge(k.getV()+k.getU(), k.getV(), k.getU());
            }
            g.setStrict(false);
            g.setAutoCreate( true );
            g.display();
            // JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<String, DefaultEdge>(g);

            // mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
            // layout.execute(graphAdapter.getDefaultParent());
            
            
            // BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null, null);
            // File imgFile = new File("src/test/resources/graph.png");
            // ImageIO.write(image, "PNG", imgFile);
            
            // assert(imgFile.exists());
        }
    }
    public String toString() {
        return "Graphs: " + graphs.toString();
    }
}
