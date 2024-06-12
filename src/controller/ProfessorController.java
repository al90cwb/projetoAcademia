package controller;

import java.util.List;
import model.Professor;
import util.Log;
import util.SerAluno;
import util.SerProfessor;

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
        this.professores = professores;  try {
            carregarDados();
        } catch (Exception e) {
            System.err.println("ERRO AO CARREGAR DADOS");
        }
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    @Override
    public String toString() {
        return "Professorcontroller [professores=" + professores + "]";
    }

    public void cadastrar(Professor professor) throws Exception {
        if (buscaId(professor.getId()) == null) {
            professor.setId(criarID());
            professores.add(professor);
            Log.gravar("Cadastro Professor " +professor.getNome());
        }else{
            Log.gravar("Falha no cadastro professor");
        }
        salvarDados();
    }

    public void deletar(int id) throws Exception {
        professores.removeIf(t -> t.getId() == id);
        salvarDados();
        Log.gravar("Professor Deletado ");
    }

    public Professor buscaId(int id) {
        return professores.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
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

    public void salvarDados() throws Exception{
        SerProfessor.salvar(professores);
    }

    private void carregarDados() throws Exception{
        professores = SerProfessor.ler();
    }

}
