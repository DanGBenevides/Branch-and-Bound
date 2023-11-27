// Trabalho 3 - Branch And Bound
// Análise Comparativa de Algoritmos para o Problema de Sequenciamento de Trabalhos com Prazo e Penalidade: Branch and Bound versus Greedy
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 26/11/2023

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Classe principal que lê os testes dos arquivos e chama os algoritmos
class TP3 {
    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("testes/teste5.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                Job job = new Job(); 
                String[] valores = linha.split(" ");
                job.setId(Integer.parseInt(valores[0]));
                job.setDeadline(Integer.parseInt(valores[1]));
                job.setPenalidade(Integer.parseInt(valores[2]));
                jobs.add(job);
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        BnB bnb= new BnB();
        Guloso g = new Guloso();

        System.out.println("/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~ Guloso ~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~");

        long startT = System.nanoTime();
        g.call(jobs);
        long endT = System.nanoTime();
        System.out.println("Tempo decorrido: " + (endT - startT)/1000000.0 + "ms");

        System.out.print("\n");
        System.out.println("/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~ Branch And Bound ~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~");

        startT = System.nanoTime();
        bnb.call(jobs);
        endT = System.nanoTime();
        System.out.println("Tempo decorrido: " + (endT - startT)/1000000.0 + "ms");
    }
}
