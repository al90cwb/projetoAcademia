package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe para objetos do tipo {@code Aluno} com dados do aluno da academia
 * 
 * @author Alan Souza
 * @version 1.00
 * @since 11/06/2024
 */

public class Aluno extends Usuario  implements Serializable{

    private boolean substituirTreino;
    private LocalDate dataInicio, dataFim;
    private Treino treino;
    private int duracaoTreino;
    private String aquecimento, sugestaoDiasTreino;

    public Aluno() {
    }

    public Aluno(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento,
            boolean substituirTreino, Treino treino, int duracaoTreino, String aquecimento, String sugestaoDiasTreino) {
        super(id, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento);
        this.substituirTreino = substituirTreino;
        this.treino = treino;
        this.duracaoTreino = duracaoTreino;
        this.aquecimento = aquecimento;
        this.sugestaoDiasTreino = sugestaoDiasTreino;
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

    public boolean temTreinoCadastrado(){
        return treino!=null;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public void atualizarDataHoje() {
        dataInicio = LocalDate.now();
        dataFim = dataInicio.plusDays(duracaoTreino);
    }

    @Override
    public String toString() {
        return "Aluno [substituirTreino=" + substituirTreino
                + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", treino=" + treino
                + ", duracaoTreino=" + duracaoTreino + ", aquecimento=" + aquecimento + ", sugestaoDiasTreino="
                + sugestaoDiasTreino + "]";
    }

}
