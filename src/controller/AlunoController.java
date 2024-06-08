package controller;

import java.util.List;

import model.Aluno;
import model.Professor;

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

    public String cadastrar(Aluno aluno) {
        if (buscaId(aluno.getId() ) == null) {
            aluno.setId(criarID());
            alunos.add(aluno);
            return "Aluno Cadastrado!";
        }
        return "Aluno Ja Existe!";
    }


    public void deletar(int id){
        alunos.removeIf( t -> t.getId() == id);
    }

    public Aluno buscaId(int id) {
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

    public Aluno buscaCpf(String cpf) {
        return alunos.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
    }


    public Aluno verificarSenha(String cpf,String senha) {
        Aluno a = alunos.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
        if (a.getSenha().equals(senha)){
            return a;
        }
        return null;
    }

}
