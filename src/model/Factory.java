package model;

import java.time.LocalDate;
import java.util.List;

public abstract class Factory implements iEntidadeFactory {
    
    private Factory(){}

    @Override
    public Aluno ciarAluno(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento, boolean substituirTreino, Treino treino, int duracaoTreino,
            String aquecimento, String sugestaoDiasTreino) {
        return new Aluno(id, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento, substituirTreino, treino, duracaoTreino, aquecimento, sugestaoDiasTreino);
    }

    @Override
    public Professor criarProfessopr(int id, String nome, String cpf, String endereco, String celular, String email,
            String sexo, String senha, LocalDate dataNascimento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarProfessopr'");
    }

    @Override
    public Administrador criarAdministrador(int id, String nome, String cpf, String endereco, String celular,
            String email, String sexo, String senha, LocalDate dataNascimento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarAdministrador'");
    }

    @Override
    public Exercicio criarExercicio(String nomeExercicio, String intervalo, String repeticoes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarExercicio'");
    }

    @Override
    public Treino criarTreino(String nome, String tipoTreino, List<Exercicio> exercicios) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarTreino'");
    }

}
