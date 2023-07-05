package entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        }
    }

    public boolean verifyGraph(){
        return graph.isConnected();
    }

    public Map <Vertex, Integer> getIndexes() {
        return graph.getIndexMap();
    }
    
    public static Map<Vertex, Integer> buscarComponentesConexos(GraphI g) {
    Map<Vertex, Integer> relacaoComponentesConexos = new HashMap<>();
    int idComponenteConexoInedito = 0;

    for (Vertex v: g.getAllV()) {
        if (relacaoComponentesConexos.get(v) == null) {
            determinaComponenteConexo(v, idComponenteConexoInedito, g, relacaoComponentesConexos);
            idComponenteConexoInedito++;
        }
    }
    return relacaoComponentesConexos;
}

private static void determinaComponenteConexo(Vertex v, int idComponenteConexo, GraphI g, Map<Vertex, Integer> relacaoComponentesConexos) {
    // se eu cheguei aqui, então devo marcar o vértice passado como pertencente ao componente conexo
    relacaoComponentesConexos.put(v, idComponenteConexo);

    // percorre os vizinhos...
    for (Vertex u: g.neighborhood(v)) {
        // se o vizinho u ainda não foi visitado, visite-o
        if (relacaoComponentesConexos.get(u) == null) {
            determinaComponenteConexo(u, idComponenteConexo, g, relacaoComponentesConexos);
        }
    }
}


    public GraphI getGpraphI() {
        return graph;
    }

    public String toString() {
        return "Graphs: " + graphs.toString();
    }
}
