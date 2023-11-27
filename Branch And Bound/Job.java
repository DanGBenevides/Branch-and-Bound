// Trabalho 3 - Branch And Bound
// Análise Comparativa de Algoritmos para o Problema de Sequenciamento de Trabalhos com Prazo e Penalidade: Branch and Bound versus Greedy
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 26/11/2023

// Classe que implementa o Job
class Job {
   private int id;
   private int deadline;
   private int penalidade;

    Job(int id, int deadline, int penalidade) {
        this.id = id;
        this.deadline = deadline;
        this.penalidade = penalidade;
    }

    Job() {
        this.id = 0;
        this.deadline = -1;
        this.penalidade = 0;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getDeadline() {
        return this.deadline;
    }
    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getPenalidade() {
        return this.penalidade;
    }
    public void setPenalidade(int penalidade) {
        this.penalidade = penalidade;
    }
}