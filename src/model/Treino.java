package model;

import java.io.Serializable;
import java.util.List;

/**
 * Classe para objetos do tipo {@code Treino}, onde serão contidos, valores e
 * métodos para o mesmo.
 * 
 * @author Alan Souza
 * @version 1.00
 * @since 11/06/2024
 */

public class Treino implements Serializable {
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

    public void adicionarExercicio(Exercicio exercicio) {
        if (exercicio != null) {
            this.exercicios.add(exercicio);
        }
    }

    @Override
    public String toString() {
        return "Treino [id=" + id + ", nome=" + nome + ", tipoTreino=" + tipoTreino + ", exercicios=" + exercicios
                + "]";
    }

}
