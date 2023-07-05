package entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Matrix {
    
    private Map<Integer, ArrayList<String>> mat = new HashMap<Integer, ArrayList<String>>();
    private Integer auxSelect = 1;
    private Transform ts;

    public Matrix(ArrayList<String> matrices) {
        mat.put(auxSelect, new ArrayList<String>());
        for (String line : matrices){
            if (!line.isEmpty()) {
                mat.get(auxSelect).add(line);
            }
            else {
                auxSelect++;
                mat.put(auxSelect, new ArrayList<String>());
            }
        }
        System.out.println("foram detectados " + auxSelect + " matrizes.");
    }

    public void selectMatriz(Integer select) throws IOException{
        ts = new Transform(mat.get(select));
        ts.getGraph();

    }
    
    public boolean check() {
        return ts.verifyGraph();
    }

    public Map<Vertex, Integer> getIndexV() {
        return ts.getIndexes();
    }

    public Map<Vertex, Integer> connected() {
        return ts.buscarComponentesConexos(ts.getGpraphI());
    }

    public String getNumber(){
        return auxSelect.toString();
    }
}
