package model;

import java.time.LocalDate;
import java.util.List;

public interface iEntidadeFactory {
    
    Aluno ciarAluno(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento,
            boolean substituirTreino, Treino treino, int duracaoTreino, String aquecimento, String sugestaoDiasTreino);

    Professor criarProfessopr(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento);

    Administrador criarAdministrador(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
    String senha, LocalDate dataNascimento);

    Exercicio criarExercicio(String nomeExercicio, String intervalo, String repeticoes);

    Treino criarTreino(String nome, String tipoTreino, List<Exercicio> exercicios);


}
