package controller;

import java.util.List;

import model.Aluno;

/**
 * Este Contrler Gerencia a lista de Alunos cadastrados
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

 public class AlunoController {
    private List<Aluno> alunos;

    public AlunoController(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAluno(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "AlunoContrller [alunos=" + alunos + "]";
    }

    public String cadastrarAluno(Aluno aluno) {
        if (buscaAlunoId(aluno.getId() ) == null) {
            aluno.setId(criarID());
            alunos.add(aluno);
            return "Aluno Cadastrado!";
        }
        return "Aluno Já Existe!";
    }

    public Aluno buscaAlunoPorCpf(String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    public void deletarAluno(int id){
        alunos.removeIf( t -> t.getId() == id);
    }

    public void limparAluno(){
        alunos.clear();
    }

    public Aluno buscaAlunoId(int id) {
        return alunos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public int criarID() {
        int res = 0;
        for (Aluno p : alunos) {
            if (p.getId() > res)
                res = p.getId();
        }
        return ++res;
    }
    

    
}