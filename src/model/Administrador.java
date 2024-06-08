package model;

import java.time.LocalDate;

/**
 * Este Objeto contem os dados de administrador
 * Tem acesso de criação, edição e exclusão de usuarios
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public class Administrador extends Usuario {

    public Administrador() {
    }

    public Administrador(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento) {
        super(id, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento);
    }

    @Override
    public String toString() {
        return "Administrador [id=" + super.getId() + ", nome=" + super.getNome() + ", cpf=" + super.getCpf()
                + ", endereco=" + super.getEndereco() + ", celular="
                + super.getCelular() + ", email=" + super.getEmail() + ", sexo=" + super.getSexo() + ", senha="
                + super.getSenha() + ", dataNascimento="
                + super.getDataNascimento() + "]";
    }
}
