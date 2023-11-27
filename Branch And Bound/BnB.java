// Trabalho 3 - Branch And Bound
// Análise Comparativa de Algoritmos para o Problema de Sequenciamento de Trabalhos com Prazo e Penalidade: Branch and Bound versus Greedy
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 26/11/2023

import java.util.ArrayList;

// Classe que implementa o algoritmo Branch and Bound
public class BnB {
    // Variáveis globais que armazenam a resposta ótima
    static ArrayList<Job> respGlobal = new ArrayList<>();
    static int penalidadeOtima = 0;

    // Método que chama o algoritmo
    public void call(ArrayList<Job> jobs) {
        int penalidadeTotal = 0;
        for (Job job : jobs) {
            penalidadeTotal += job.getPenalidade();
        }
        penalidadeOtima = penalidadeTotal;

        // Chamada do algoritmo
        ScheduleJobs(jobs, new ArrayList<Job>(), penalidadeTotal, new ArrayList<Job>());

        System.out.println("Penalidade otima: " + penalidadeOtima);

        int count = 1;
        for (Job job : respGlobal) {
            System.out.println(count + ": Job: " + job.getId() + " Deadline: " + job.getDeadline() + " Penalidade: " + job.getPenalidade());
            count++;
        }
    }

    // Método que implementa o algoritmo
    public static void ScheduleJobs(ArrayList<Job> jobs, ArrayList<Job> resp, int penalidade, ArrayList<Job> temp) {
        temp.addAll(resp);

        // Itera sobre todos os jobs e verifica se eles podem ser adicionados na resposta
        for (int i = 0; i < jobs.size(); i++) {
            if (resp.size() + 1 <= jobs.get(i).getDeadline() && !resp.contains(jobs.get(i))) {
                temp.add(jobs.get(i));
                ScheduleJobs(jobs, temp, penalidade - jobs.get(i).getPenalidade(), new ArrayList<Job>());
                if(temp.size() > 0){
                    temp.remove(temp.size() -1);
                }
            }
        }

        // Se a penalidade da resposta for menor que a penalidade ótima, atualiza a resposta ótima
        if (penalidade < penalidadeOtima) {
            respGlobal.clear();
            respGlobal.addAll(temp);
            penalidadeOtima = penalidade;
        }
    }

}

