package controller;

import java.util.List;

import model.Exercicio;

/**
 * Este Contrler Gerencia a lista de exercicios cadastrados
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza] Data de criação: [28/05/2024]
 * Autor: [Alan Henrique de Souza] Revisão: [29/05/2024] 
 * Criação da lista , metodos buscar, cadastrar, excluir, criar codigo
 */
public class ExercicioController {
    private List<Exercicio> exercicios;

    public ExercicioController(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }


    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    } 
    

    @Override
    public String toString() {
        return "Exericiciocontroller [exercicios=" + exercicios + "]";
    }

    public String cadastrarExercicio(Exercicio exercicio) {
        if (buscaExercicioId(exercicio.getId() ) == null) {
            exercicio.setId(criarID());
            exercicios.add(exercicio);
            return "Exercicio Cadastrado!";
        }
        return "Exercicio Ja Existe!";
    }

    public void deletarTreino(int id){
        exercicios.removeIf( t -> t.getId() == id);
    }

    public Exercicio buscaExercicioId(int id) {
        return exercicios.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limparExercicios(){
        exercicios.clear();
    }

    public int criarID() {
        int res = 0;
        for (Exercicio p : exercicios) {
            if (p.getId() > res)
                res = p.getId();
        }
        return ++res;
    }

   
}
