package model;

/**
 * Este Objeto contem os dados de exercicio 
 * Os exercicios são comunus par todos os subtreinos
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public class Exercicio implements Comparable<Exercicio>  {
    private int id;
    private String nomeExercicio, intervalo,repeticoes;
    
    public Exercicio( String nomeExercicio, String intervalo, String repeticoes) {
        this.id = 0;
        this.nomeExercicio = nomeExercicio;
        this.intervalo = intervalo;
        this.repeticoes = repeticoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public String getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(String repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return "Exercicio [id=" + id + ", nomeExercicio=" + nomeExercicio + ", intervalo=" + intervalo + ", repeticoes="
                + repeticoes + "]";
    }


    @Override
    public int compareTo(Exercicio exercicio) {
        return nomeExercicio.compareTo(exercicio.getNomeExercicio());
    }

}
