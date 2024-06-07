package controller;

import java.util.List;

import model.Aluno;

/**
 * Este Contrler Gerencia a lista de alunos cadastrados
 * Versão: 1.0
 * Autor: [Leonardo Pilato] Data de criação: [01/06/2024]
 * Autor: [Leonardo Pilato] Revisão: [01/06/2024] 
 * Criação da lista , metodos buscar, cadastrar, excluir, criar codigo
 */
public class AlunoController {
    private List<Aluno> alunos;

    public AlunoController(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }


    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    } 
    

    @Override
    public String toString() {
        return "Alunocontroller [alunos=" + alunos + "]";
    }

    public String cadastrarAluno(Aluno aluno) {
        if (buscaAlunoId(aluno.getId() ) == null) {
            aluno.setId(criarID());
            alunos.add(aluno);
            return "Aluno Cadastrado!";
        }
        return "Aluno Ja Existe!";
    }

    public void deletarAluno(int id){
        alunos.removeIf( t -> t.getId() == id);
    }

    public Aluno buscaAlunoId(int id) {
        return alunos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limparAlunos(){
        alunos.clear();
    }

    public int criarID() {
        int res = 0;
        for (Aluno a : alunos) {
            if (a.getId() > res)
                res = a.getId();
        }
        return ++res;
    }

   
}
