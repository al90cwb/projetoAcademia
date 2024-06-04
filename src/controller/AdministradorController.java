package controller;

import java.util.List;


import model.Administrador;



/**
 * Este Contrler Gerencia a lista de Administradores cadastrados
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */ 

public class AdministradorController {
    private List<Administrador> administradors;

    public AdministradorController(List<Administrador> administradors) {
        this.administradors = administradors;
    }

    public List<Administrador> getAdministrador() {
        return administradors;
    }

    public void setAdministrador(List<Administrador> administradors) {
        this.administradors = administradors;
    }

    @Override
    public String toString() {
        return "AdministradorContrller [administradors=" + administradors + "]";
    }

    public String cadastrarAdministrador(Administrador administradores ) {
        if (buscaAlunoId(administradores.getId() ) == null) {
            administradores.setId(criarID());
            administradors.add(administradores);
            return "Administrador Cadastrado!";
        }
        return "Administrador Já Existe!";
    }

    public Administrador buscaAdministradorPorCpf(String cpf) {
        for (Administrador administradores : administradors) {
            if (administradores.getCpf().equals(cpf)) {
                return administradores;
            }
        }
        return null;
    }


    public void deletarAdministrador(int id){
        administradors.removeIf( t -> t.getId() == id);
    }

    public void limparAdministrador(){
        administradors.clear();
    }

    public Administrador buscaAlunoId(int id) {
        return administradors.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public int criarID() {
        int res = 0;
        for (Administrador p : administradors) {
            if (p.getId() > res)
                res = p.getId();
        }
        return ++res;
    }
    

    
}