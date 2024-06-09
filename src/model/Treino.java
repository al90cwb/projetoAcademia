package model;

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
    private String nome, aquecimento, sugestaoDiasTreino;
    private List<SubTreino> subtreinos;

    public Treino() {
    }

    public Treino(int duracao, String nome, String aquecimento, String sugestaoDiasTreino, List<SubTreino> subtreinos) {
        this.id = 0;
        this.duracao = duracao;
        this.nome = nome;
        this.aquecimento = aquecimento;
        this.sugestaoDiasTreino = sugestaoDiasTreino;
        this.subtreinos = subtreinos;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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


    public List<SubTreino> getSubtreinos() {
        return subtreinos;
    }

    public void setSubtreinos(List<SubTreino> subtreinos) {
        this.subtreinos = subtreinos;
    }
    
 

    @Override
    public String toString() {
        return "Treino [id=" + id + ", duracao=" + duracao + ", nome=" + nome + ", aquecimento=" + aquecimento
                + ", sugestaoDiasTreino=" + sugestaoDiasTreino + ", dataInicio="+ ", subtreinos=" + subtreinos +  "]";
    }

}
