package controller;

import model.Exercicio;
import model.SubTreino;
import util.Entrada;

/**
 * Este Contrler Gerencia o menu do sistema
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */
public class MenuController {

    public static Exercicio cadastroExercicio(Exercicio exercicio){
        //cadastro exercicio
            System.out.println("Cadastro de Exercicio");
            System.out.println("Nome do exercicio");
            exercicio.setNomeExercicio(Entrada.entradaString());
            System.out.println("Quantidade de Repetições");
            exercicio.setRepeticoes(Entrada.entradaString());
            System.out.println("Tempo de Intervalo");
            exercicio.setIntervalo(Entrada.entradaString());
        return exercicio;
    }
    
    public static SubTreino cadastroExercicio(SubTreino subtreino){
        //cadastro exercicio
            System.out.println("Cadastro de Subtrieno");
            System.out.println("Nome do Subtreino");
            subtreino.setNome(Entrada.entradaString());
            System.out.println("Letra do Subtreino");
            subtreino.setLetra(Entrada.entradaString());
            System.out.println("Sexo");
            subtreino.setSexo(Entrada.entradaString());
            System.out.println("Tipo Grupo Muscular");
            subtreino.setTipoSubtreino(Entrada.entradaString());
        return subtreino;
    }

    
}
