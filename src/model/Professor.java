package model;

import java.time.LocalDate;
/**
 * Este Objeto contem os dados de Professor
 * Contem todos os dados herdados de usuario
 * Tem acesso a cadastro de alunos 
 * Tem acesos a cadastro de exercios/trienos/subtreinos
 * Tem acesso a relatorios de alunos
 * Tem acesso a relatorios de treinos
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public class Professor extends Usuario  {
    
      public Professor(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento) {
            super(id, nome, cpf, endereco, celular, email,sexo,senha,dataNascimento);
    }
    


    @Override
    public String toString() {
        return "Professor [id=" + super.getId() + ", nome=" + super.getNome() + ", cpf=" + super.getCpf() + ", endereco=" + super.getEndereco() + ", celular="
                + super.getCelular() + ", email=" + super.getEmail() + ", sexo=" + super.getSexo() + ", senha=" + super.getSenha() + ", dataNascimento="
                + super.getDataNascimento() + "]";
    }

    
}
