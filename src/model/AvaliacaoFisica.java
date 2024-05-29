package model;

/**
 * Este Objeto contem os dados de avaliação fisica
 * Cada aluno possui uma lista de avaliações fisicas, somente daquele aluno
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public class AvaliacaoFisica  {
    private int id;
    private float peso, altura, percentualGordura, iMC;

    public AvaliacaoFisica(int id, float peso, float altura, float percentualGordura) {
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.percentualGordura = percentualGordura;
        calculaIMC();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(float percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public float getiMC() {
        return iMC;
    }

    public void calculaIMC() {
        if (altura>0) {
            this.iMC = peso/(altura*altura);
        }
    }

    @Override
    public String toString() {
        return "AvaliacaoFisica [id=" + id + ", peso=" + peso + ", altura=" + altura + ", percentualGordura="
                + percentualGordura + ", iMC=" + iMC + "]";
    }
    
}
