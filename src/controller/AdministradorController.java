package controller;

import java.util.List;
import model.Administrador;

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
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    @Override
    public String toString() {
        return "AdministradorController [administradores=" + administradores + "]";
    }

    public String cadastrar(Administrador administrador) {
        if (buscarId(administrador.getId()) == null) {
            administrador.setId(criarID());
            administradores.add(administrador);
            return "Aluno Cadastrado!";
        }
        return "Aluno Ja Existe!";
    }

    public void deletar(int id) {
        administradores.removeIf(t -> t.getId() == id);
    }

    public Administrador buscarId(int id) {
        return administradores.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limpar() {
        administradores.clear();
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

}