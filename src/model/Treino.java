package model;

import java.util.List;

/**
 * Este Objeto contem os dados de subtreino
 * Contem uma lista de exercicios e informações do subtrieno
 * Os subtreinos são comuns para todos os treinos
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */
public class Treino {
    private int id;
    private String nome, tipoTreino;
    private List<Exercicio> exercicios;

    public Treino() {

    }

    public Treino(String nome, String tipoTreino, List<Exercicio> exercicios) {
        this.id = 0;
        this.nome = nome;
        this.tipoTreino = tipoTreino;
        this.exercicios = exercicios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoTreino() {
        return tipoTreino;
    }

    public void setTipoTreino(String tipoTreino) {
        this.tipoTreino = tipoTreino;
    }


    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }


    public void limparExercicios() {
        exercicios.clear();
    }

    public void adicionarExercicio(Exercicio exercicio){
        if (exercicio!= null){
            this.exercicios.add(exercicio);
        }
    }

    @Override
    public String toString() {
        return "Treino [id=" + id + ", nome=" + nome + ", tipoTreino=" + tipoTreino + ", exercicios=" + exercicios
                + "]";
    }




}
