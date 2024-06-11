package model;

import java.time.LocalDate;
import java.util.List;

/**
 * Este Objeto contem os dados de aluno
 * Contem um trieno que é copiado do sistema principal de treinos
 * Contem todos os dados herdados de usuario
 * Contem uma lista de avaliações fisicas desse aluno
 * Tem acesso de visualização do treino, avaliações e solicitaçaõ de novo
 * treino.
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public class Aluno extends Usuario {

    private List<AvaliacaoFisica> avaliacoesFisicas;
    private boolean substituirTreino;
    private LocalDate dataInicio, dataFim;
    private Treino treino;
    private int duracaoTreino;
    private String  aquecimento, sugestaoDiasTreino;


    public Aluno() {
    }

    public Aluno(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento,
            boolean substituirTreino,Treino treino, int duracaoTreino, String aquecimento, String sugestaoDiasTreino) {
        super(id, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento);
        this.substituirTreino = substituirTreino;
        this.treino = treino;
        this.duracaoTreino = duracaoTreino;
        this.aquecimento = aquecimento;
        this.sugestaoDiasTreino = sugestaoDiasTreino;
    }


    public List<AvaliacaoFisica> getAvaliacoesFisicas() {
        return avaliacoesFisicas;
    }

    public void setAvaliacoesFisicas(List<AvaliacaoFisica> avaliacoesFisicas) {
        this.avaliacoesFisicas = avaliacoesFisicas;
    }

    public boolean isSubstituirTreino() {
        return substituirTreino;
    }


    public void setSubstituirTreino(boolean substituirTreino) {
        this.substituirTreino = substituirTreino;
    }


    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }


    public int getDuracaoTreino() {
        return duracaoTreino;
    }


    public void setDuracaoTreino(int duracaoTreino) {
        this.duracaoTreino = duracaoTreino;
        dataFim = dataInicio.plusDays(duracaoTreino);
    }


    public String getAquecimento() {
        return aquecimento;
    }


    public void setAquecimento(String aquecimento) {
        this.aquecimento = aquecimento;
    }


    public String getSugestaoDiasTreino() {
        return sugestaoDiasTreino;
    }


    public void setSugestaoDiasTreino(String sugestaoDiasTreino) {
        this.sugestaoDiasTreino = sugestaoDiasTreino;
    }

 

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public void atualizarDataHoje() {
        dataInicio =LocalDate.now();
        dataFim = dataInicio.plusDays(duracaoTreino);
    }

    @Override
    public String toString() {
        return "Aluno [avaliacoesFisicas=" + avaliacoesFisicas + ", substituirTreino=" + substituirTreino
                + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", treino=" + treino
                + ", duracaoTreino=" + duracaoTreino + ", aquecimento=" + aquecimento + ", sugestaoDiasTreino="
                + sugestaoDiasTreino + "]";
    }

}
