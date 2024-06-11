package controller;

import java.util.List;
import model.Professor;

/**
 * A classe {@code ProfessorController} é responsável por gerenciar as operações
 * relacionadas aos professores, como criação, atualização, exclusão e
 * recuperação de professores.
 * 
 * @version 1.0
 * @since 2024-06-07
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
        if (buscaId(professor.getId()) == null) {
            professor.setId(criarID());
            professores.add(professor);
            return "Professor Cadastrado!";
        }
        return "Professor Ja Existe!";
    }

    public void deletar(int id) {
        professores.removeIf(t -> t.getId() == id);
    }

    public Professor buscaId(int id) {
        return professores.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limpar() {
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

    public Professor verificarSenha(String cpf, String senha) {
        Professor a = professores.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
        if (a.getSenha().equals(senha)) {
            return a;
        }
        return null;
    }

}
