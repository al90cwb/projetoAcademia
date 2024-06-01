package controller;

import java.util.List;

import model.Professor;

/**
 * Este Contrler Gerencia a lista de Prodessores cadastrados
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza] Data de criação: [28/05/2024]
 */
public class ProfessorController {
    private List<Professor> professors;

    public ProfessorController(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Professor> getProfessor() {
        return professors;
    }

    public void setProfessor(List<Professor> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "ProfessorContrller [professors=" + professors + "]";
    }

    public String cadastrarProfessor(Professor professores) {
        if (buscaProfessorId(professores.getId() ) == null) {
            professores.setId(criarID());
            professors.add(professores);
            return "Professor Cadastrado!";
        }
        return "Professor Já Existe!";
    }


    public void deletarProfessor(int id){
        professors.removeIf( t -> t.getId() == id);
    }

    public void limparProfessor(){
        professors.clear();
    }

    public Professor buscaProfessorId(int id) {
        return professors.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public int criarID() {
        int res = 0;
        for (Professor p : professors) {
            if (p.getId() > res)
                res = p.getId();
        }
        return ++res;
    }
    

    
}
    

