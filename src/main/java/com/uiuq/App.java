package com.uiuq;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Matrix;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("org.graphstream.ui", "javafx");
        String arq = "/home/uiuq/Documentos/ws-java/ImplementacaoTG/ImplementacaoTG/src/teste.txt";
        File arqaux = new File(arq);
        FileReader fr = null;
        BufferedReader br = null;
        Integer aux = 0;
        Scanner sc = new Scanner(arqaux);
        Scanner leitura = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        File imgFile = new File("src/test/resources/graph.png");
        imgFile.createNewFile();
        Integer val;
        Integer op;

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
            // Transform transform = new Transform(lines);
            Matrix matrix = new Matrix(lines);

            System.out.println("Qual grafo deseja manipular?");
            System.out.println("Digite um valor de 1 a " + matrix.getNumber());
            val = leitura.nextInt();
            matrix.selectMatriz(val);

            System.out.printf("|-----------------------------------|\n");
            System.out.printf("|      DIGITE A OPÇÃO DESEJADA      |\n");
            System.out.printf("|-----------------------------------|\n");
            System.out.printf("|1 | VERIFICAR SE O GRAFO É CONEXO  |\n");
            System.out.printf("|2 | APLICAR BUSCA EM LARGURA       |\n");
            System.out.printf("|3 | ENCONTRAR BIPARTIÇÃO           |\n");
            System.out.printf("|-----------------------------------|\n");

            op = leitura.nextInt();

            if ( op == 1) {
                System.out.println(matrix.verifyConnect());
            }

            leitura.close();

            //transform.getGraph();
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
