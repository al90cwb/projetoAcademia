package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe para objetos do tipo {@code Administrador} com dados do administrador
 * da academia
 * 
 * @author Alan Souza
 * @version 1.00
 * @since 11/06/2024
 */

public class Administrador extends Usuario implements Serializable {

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
