package model;

import java.time.LocalDate;

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
