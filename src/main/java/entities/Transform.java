package entities;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;

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

    public void getGraph() throws IOException {
        for (GraphI i : graphs) {
            Graph<String, DefaultEdge> g = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
            for (Vertex j : i.getAllV()) {
                g.addVertex(j.getName());

            }
            for (Edge k : i.getAllE()) {
                g.addEdge(k.getV(), k.getU());
            }
            System.out.println(g.toString());
            JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<String, DefaultEdge>(g);

            mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
            layout.execute(graphAdapter.getDefaultParent());
            
            
            BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null, null);
            File imgFile = new File("src/test/resources/graph.png");
            ImageIO.write(image, "PNG", imgFile);
            
            assert(imgFile.exists());
        }
    }
    public String toString() {
        return "Graphs: " + graphs.toString();
    }
}
