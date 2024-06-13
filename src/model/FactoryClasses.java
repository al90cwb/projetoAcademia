package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FactoryClasses implements iEntidadeFactory {

    @Override
    public Aluno ciarAluno(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento, boolean substituirTreino, Treino treino, int duracaoTreino,
            String aquecimento, String sugestaoDiasTreino) {
        return new Aluno(id, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento, substituirTreino, treino, duracaoTreino, aquecimento, sugestaoDiasTreino);
    }

    @Override
    public Professor criarProfessor(int id, String nome, String cpf, String endereco, String celular, String email,
            String sexo, String senha, LocalDate dataNascimento) {
        
        return new Professor(id, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento);
    }

    @Override
    public Administrador criarAdministrador(int id, String nome, String cpf, String endereco, String celular,
            String email, String sexo, String senha, LocalDate dataNascimento) {
        return new Administrador(id, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento);
    }

    @Override
    public Exercicio criarExercicio(String nomeExercicio, String intervalo, String repeticoes) {
        return new Exercicio(nomeExercicio, intervalo, repeticoes);
    }

    @Override
    public Treino criarTreino(String nome, String tipoTreino) {
        List exercicios = new ArrayList<Exercicio>();
        return new Treino(nome, tipoTreino, exercicios);
    }

  

}
