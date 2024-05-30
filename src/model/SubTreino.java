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
public class SubTreino {
    private int id;
    private String nome,tipoSubtreino, sexo, letra;
    private List<Exercicio> exercicios;

    public SubTreino(String nome, String tipoSubtreino, String sexo, String letra, List<Exercicio> exercicios) {
        this.id = 0;
        this.nome = nome;
        this.tipoSubtreino = tipoSubtreino;
        this.sexo = sexo;
        this.letra = letra;
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

    public String getTipoSubtreino() {
        return tipoSubtreino;
    }

    public void setTipoSubtreino(String tipoSubtreino) {
        this.tipoSubtreino = tipoSubtreino;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public Exercicio buscarExercicio(int id) {
        return exercicios.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limparExercicios(){
        exercicios.clear();
    }

    @Override
    public String toString() {
        return "SubTreino [id=" + id + ", nome=" + nome + ", tipoSubtreino=" + tipoSubtreino + ", sexo=" + sexo
                + ", letra=" + letra + ", exercicios=" + exercicios + "]";
    }


    



}
