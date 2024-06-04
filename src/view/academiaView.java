package view;

import java.util.ArrayList;
import controller.ExercicioController;
import controller.TreinoController;
import model.Exercicio;
import model.Treino;
/**
 * Este programa é um exemplo simples de gestão de academia
 * Ele realiza operações de cadastro de usuarios e treinos 
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public class academiaView {
    public static void main(String[] args)throws Exception {
        //DECLARAÇÃO DE VARIAVEIS
        //CONTROLLER
            ExercicioController controllerExecicio  = new ExercicioController(new ArrayList<Exercicio>());
            TreinoController controllerTreino  = new TreinoController(new ArrayList<Treino>());

        //DADOS DE CADASTRO
            boolean modoTeste= true;

        //INICIO DO SISTEMA-------------------------------------------------
            System.out.println("Sistema de Academia-------------------------");


        //CADASTRO BASICO DE EXERCICIOS MODO TESTE
            if(modoTeste){
                for (int i = 0; i < 25; i++) {
                    controllerExecicio.cadastrarExercicio(new Exercicio("Exercicio"+i,i+"min", "10x"));
                }
            }

        //MENU Exericio teste
           MenusExercicio.cadastro(controllerExecicio);

        //MENU Treino teste
           MenusTreino.cadastro(controllerTreino);
            

    }

}

