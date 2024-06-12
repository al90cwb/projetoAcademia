package controller;

import java.util.List;
import model.Aluno;
import util.Log;
import util.SerAluno;

/**
 * A classe {@code AlunoController} é responsável por gerenciar as operações
 * relacionadas aos professores, como criação, atualização, exclusão e
 * recuperação de aluno.
 * 
 * @version 1.0
 * @since 2024-06-07
 */

public class AlunoController {
    private List<Aluno> alunos;

    public AlunoController(List<Aluno> alunos) {
        this.alunos = alunos;
        try {
            carregarDados();
        } catch (Exception e) {
            System.err.println("ERRO AO CARREGAR DADOS ALUNO");
        }
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Alunocontroller [alunos=" + alunos + "]";
    }

    public void cadastrar(Aluno aluno) throws Exception {
        if (buscaId(aluno.getId()) == null) {
            aluno.setId(criarID());
            alunos.add(aluno);
            Log.gravar("Cadastro Aluno " +aluno.getNome());
        }else{
            Log.gravar("Falha no cadastro aluno");
        }
        salvarDados();
    }

    public void deletar(int id) throws Exception {
        alunos.removeIf(t -> t.getId() == id);
        salvarDados();
        Log.gravar("Aluno Deletado ");
    }

    public Aluno buscaId(int id) {
        return alunos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
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

    public Aluno verificarSenha(String cpf, String senha) {
        Aluno a = alunos.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
        if (a.getSenha().equals(senha)) {
            return a;
        }
        return null;
    }

    public void salvarDados() throws Exception{
        SerAluno.salvar(alunos);
    }

    private void carregarDados() throws Exception{
        alunos = SerAluno.ler();
    }

}
