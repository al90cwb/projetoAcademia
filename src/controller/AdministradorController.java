package controller;

import java.util.List;
import model.Administrador;
import util.Log;
import util.SerAdministrador;

/**
 * A classe {@code AdministradorContrller} é responsável por gerenciar as
 * operações
 * relacionadas aos administradores, como criação, atualização, exclusão e
 * recuperação de professores e aluno.
 * 
 * @version 1.0
 * @since 2024-06-07
 */

public class AdministradorController {
    private List<Administrador> administradores;

    public AdministradorController(List<Administrador> administradores) {
        this.administradores = administradores;
        try {
            carregarDados();
        } catch (Exception e) {
            System.err.println("ERRO AO CARREGAR DADOS ADMINISTRADOR");
        }
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    @Override
    public String toString() {
        return "AdministradorController [administradores=" + administradores + "]";
    }

    public void cadastrar(Administrador administrador) throws Exception {
        if (buscarId(administrador.getId()) == null) {
            administrador.setId(criarID());
            administradores.add(administrador);
            Log.gravar("Cadastro Adminstrador " +administrador.getNome());
        }else{
            Log.gravar("Falha no cadastro administrador");
        }
        salvarDados();
    }

    public void deletar(int id) throws Exception {
        administradores.removeIf(t -> t.getId() == id);
        salvarDados();
        Log.gravar("Administrador Deletado ");
    }

    public Administrador buscarId(int id) {
        return administradores.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public int criarID() {
        int res = 0;
        for (Administrador a : administradores) {
            if (a.getId() > res)
                res = a.getId();
        }
        return ++res;
    }

    public Administrador buscaCpf(String cpf) {
        return administradores.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    public Administrador verificarSenha(String cpf, String senha) {
        Administrador a = administradores.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
        if (a.getSenha().equals(senha)) {
            return a;
        }
        return null;
    }

    public void salvarDados() throws Exception{
        SerAdministrador.salvar(administradores);
    }

    private void carregarDados() throws Exception{
        administradores = SerAdministrador.ler();
    }

}