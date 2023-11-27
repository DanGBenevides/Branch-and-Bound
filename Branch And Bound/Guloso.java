// Trabalho 3 - Branch And Bound
// Análise Comparativa de Algoritmos para o Problema de Sequenciamento de Trabalhos com Prazo e Penalidade: Branch and Bound versus Greedy
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 26/11/2023

import java.util.ArrayList;

// Classe que implementa o algoritmo Guloso
public class Guloso {
    // Método que chama o algoritmo
    public void call(ArrayList<Job> jobs) {          
        int[] ids = new int[jobs.size()];
        int[] deadline =   new int[jobs.size()];
        int[] penalidade = new int[jobs.size()];

        // Preenchimento dos vetores
        for (int i = 0; i < jobs.size(); i++) {
            ids[i] = jobs.get(i).getId();
            deadline[i] = jobs.get(i).getDeadline();
            penalidade[i] = jobs.get(i).getPenalidade();
        }

        // Chamada do algoritmo
        AgendamentoDeJobs(ids, deadline, penalidade);

    }

    public static void AgendamentoDeJobs(int[] jobs, int[] deadline, int[] penalidade) {
        // Ordenação decrescente dos vetores com base na penalidade
        quicksort(0, penalidade.length - 1, jobs, deadline, penalidade);

        // Chamada do algoritmo
        escalonamento(jobs, deadline, penalidade);
    }

    // Método que implementa o algoritmo
    public static int[] escalonamento(int[] jobs, int[] deadline, int[] penalidade) {
        int[] agendamento = new int[jobs.length];
        int[] agendamentoDeadline = new int[jobs.length];
        int[] agendamentoPenalidade = new int[jobs.length];
        int penalidadeOtima = 0;

        // Preenchimento do vetor de penalidade ótima
        for (int i = 0; i < penalidade.length; i++) {
            penalidadeOtima += penalidade[i];
        }

        // Preenchimento do vetor de agendamento
        for (int i = 0; i < jobs.length; i++) {
            agendamento[i] = 0;
        }

        // Itera sobre todos os jobs e verifica se eles podem ser adicionados na resposta
        for (int i = 0; i < jobs.length; i++) {
            // Coloca o job na posição mais próxima da deadline
            for (int j = Math.min(deadline[i], jobs.length) - 1; j >= 0; j--) {
                if (agendamento[j] == 0) {
                    agendamento[j] = jobs[i];
                    agendamentoDeadline[j] = deadline[i];
                    agendamentoPenalidade[j] = penalidade[i];
                    penalidadeOtima -= penalidade[i];
                    break;
                }
            }
        }

        System.out.println("Penalidade da resposta: " + penalidadeOtima);

        for (int i = 0; i < agendamento.length; i++) {
            System.out.println((i + 1) + ": Job: " + agendamento[i] + " Deadline: " + agendamentoDeadline[i] + " Penalidade: " + agendamentoPenalidade[i]);
        }
        
        return agendamento;
    }

    // Método que ordena os vetores de forma decrescente com base na penalidade
    public static void quicksort(int esq, int dir, int[] jobs, int[] deadline, int[] penalidade) {
        int i = esq, j = dir;
        int pivo = penalidade[(dir + esq) / 2];
        while (i <= j) {
            while (penalidade[i] > pivo) i++;  // Condição invertida
            while (penalidade[j] < pivo) j--;  // Condição invertida
            if (i <= j) {
                swap(i, j, jobs, deadline, penalidade);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j, jobs, deadline, penalidade);
        if (i < dir)  quicksort(i, dir, jobs, deadline, penalidade);
    }
    
    public static void swap(int i, int j, int[] jobs, int[] deadline, int[] penalidade) {
        int aux = penalidade[i];
        penalidade[i] = penalidade[j];
        penalidade[j] = aux;
    
        aux = deadline[i];
        deadline[i] = deadline[j];
        deadline[j] = aux;
    
        aux = jobs[i];
        jobs[i] = jobs[j];
        jobs[j] = aux;
    }
}

