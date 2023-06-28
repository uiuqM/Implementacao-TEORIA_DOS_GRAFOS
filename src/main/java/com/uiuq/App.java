package app;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Graph;
import entities.Transform;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> teste = new ArrayList<>();
        String arq = "/home/uiuq/Documentos/ws-java/ImplementacaoTG/ImplementacaoTG/src/teste.txt";
        File arqaux = new File(arq);
        FileReader fr = null;
        BufferedReader br = null;
        Integer aux = 0;
        Scanner sc = new Scanner(arqaux);
        ArrayList<String> lines = new ArrayList<>();
        Graph g1 = new Graph();

        try {
            fr = new FileReader(arq);
            br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                lines.add(line);
                sc.next();
                line = br.readLine();
                aux++;
            }
            fr.close();
            System.out.println(lines);
            Transform transform = new Transform(lines);

            System.out.println(transform);
        } catch (FileNotFoundException e) {
            System.out.println("ocorreu um erro ao abrir o arquivo.");
            e.printStackTrace();
        } finally{
            try{
                if (br != null) {
                    br.close();
                }
                if (br != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
