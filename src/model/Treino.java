package model;

import java.time.LocalDate;
import java.util.List;

/**
 * Este Objeto contem os dados de subtreino
 * Contem uma lista de subtrienos
 * com informações gerais sobre aquele treino
 * Os treinos servem de base , e são copiados para os alunos
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */
public class Treino {
    private int id, duracao;
    private String aquecimento, sugestaoDiasTreino;
    private LocalDate dataInicio, dataFim;
    private List<SubTreino> subtreinos;


    public Treino(int id, int duracao, String aquecimento, String sugestaoDiasTreino, LocalDate dataInicio,
            LocalDate dataFim, List<SubTreino> subtreinos) {
        this.id = id;
        this.duracao = duracao;
        this.aquecimento = aquecimento;
        this.sugestaoDiasTreino = sugestaoDiasTreino;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.subtreinos = subtreinos;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getDuracao() {
        return duracao;
    }


    public void setDuracao(int duracao) {
        this.duracao = duracao;
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


    public LocalDate getDataInicio() {
        return dataInicio;
    }


    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }


    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public List<SubTreino> getSubtreinos() {
        return subtreinos;
    }

    public void setSubtreinos(List<SubTreino> subtreinos) {
        this.subtreinos = subtreinos;
    }

    @Override
    public String toString() {
        return "Treino [id=" + id + ", duracao=" + duracao + ", aquecimento=" + aquecimento + ", sugestaoDiasTreino="
                + sugestaoDiasTreino + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", subtreinos="
                + subtreinos + "]";
    }


}
