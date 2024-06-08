package controller;

import java.util.List;
import model.Professor;

/**
 * Este Contrler Gerencia a lista de professores cadastrados
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza] Data de criação: [28/05/2024]
 * Autor: [Alan Henrique de Souza] Revisão: [29/05/2024] 
 * Criação da lista , metodos buscar, cadastrar, excluir, criar codigo
 */
public class ProfessorController {
    private List<Professor> professores;

    public ProfessorController(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Professor> getProfessores() {
        return professores;
    }


    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    } 
    

    @Override
    public String toString() {
        return "Professorcontroller [professores=" + professores + "]";
    }

    public String cadastrar(Professor professor) {
        if (buscaId(professor.getId() ) == null) {
            professor.setId(criarID());
            professores.add(professor);
            return "Professor Cadastrado!";
        }
        return "Professor Ja Existe!";
    }

    public void deletar(int id){
        professores.removeIf( t -> t.getId() == id);
    }

    public Professor buscaId(int id) {
        return professores.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limpar(){
        professores.clear();
    }

    public int criarID() {
        int res = 0;
        for (Professor p : professores) {
            if (p.getId() > res)
                res = p.getId();
        }
        return ++res;
    }

    public Professor buscaCpf(String cpf) {
        return professores.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    public Professor verificarSenha(String cpf,String senha) {
        Professor a = professores.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
        if (a.getSenha().equals(senha)){
            return a;
        }
        return null;
    }
    
}
