package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Matrix {
    
    private Map<Integer, ArrayList<String>> mat = new HashMap<Integer, ArrayList<String>>();
    private ArrayList<String> selected;
    private Integer auxSelect = 1;

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

    public void selectMatriz(Integer select){
        System.out.println(mat.get(select));

    }

    public String getNumber(){
        return auxSelect.toString();
    }
}
