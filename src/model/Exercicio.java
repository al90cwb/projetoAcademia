package model;

/**
 * Classe para objetos do tipo {@code Exercicio} com dados do exercicio
 * 
 * @author Alan Souza
 * @version 1.00
 * @since 11/06/2024
 */
public class Exercicio implements Comparable<Exercicio> {
    private String nomeExercicio, intervalo, repeticoes;

    public Exercicio() {

    }

    public Exercicio(String nomeExercicio, String intervalo, String repeticoes) {
        this.nomeExercicio = nomeExercicio;
        this.intervalo = intervalo;
        this.repeticoes = repeticoes;
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
        return "Exercicio [ nomeExercicio=" + nomeExercicio + ", intervalo=" + intervalo + ", repeticoes="
                + repeticoes + "]";
    }

    @Override
    public int compareTo(Exercicio exercicio) {
        return nomeExercicio.compareTo(exercicio.getNomeExercicio());
    }

}
