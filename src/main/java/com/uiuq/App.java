package com.uiuq;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Transform;

public class App {
    public static void main(String[] args) throws Exception {
        String arq = "/home/uiuq/Documentos/ws-java/ImplementacaoTG/ImplementacaoTG/src/teste.txt";
        File arqaux = new File(arq);
        FileReader fr = null;
        BufferedReader br = null;
        Integer aux = 0;
        Scanner sc = new Scanner(arqaux);
        ArrayList<String> lines = new ArrayList<>();
        File imgFile = new File("src/test/resources/graph.png");
        imgFile.createNewFile();

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

            transform.getGraph();
        } catch (FileNotFoundException e) {
            System.out.println("ocorreu um erro ao abrir o arquivo.");
            e.printStackTrace();
        } finally{
            try{
                if (br != null) {
                    br.close();
                    sc.close();
                }
                if (br != null) {
                    fr.close();
                    sc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
