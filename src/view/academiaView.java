package view;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import controller.ExercicioController;
import controller.SubtreinoController;
import controller.TreinoController;
import model.Administrador;
import model.Exercicio;
import model.SubTreino;
import model.Treino;
import util.Entrada;

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
            SubtreinoController controllerSubtreino = new SubtreinoController(new ArrayList<SubTreino>());
            TreinoController controllerTreino = new TreinoController(new ArrayList<Treino>()) ;

        //DADOS DE CADASTRO
            boolean sairOpcaoCadastroExercicio = false;
            int opcaoCadastroExercicio = 0;
            int idBusca = 0;

        //EXERCICIO
            Exercicio exercicioCadastro = new Exercicio( null, null, null);
            SubTreino subTreinoCadastro = new SubTreino( null, null, null, null, null);
            Treino treinoCadastro = new Treino(opcaoCadastroExercicio, null, null, null, null, null, null);

            Exercicio exercicioBusca;//somente para buscas
            SubTreino subtreinoBusca;//somente para buscas
            Treino treinoBusca;//somente para buscas

        //USUARIO DE INICIALIZAÇÃO
            Administrador adminBase = new Administrador(1, "admin", null, null, null, "admin", null, "admin", null);

        //INICIO DO SISTEMA-------------------------------------------------
            System.out.println("Sistema de Academia-------------------------");



        
        //CADASTRO EXERCICIO
            do {
                SubMenus.opcoesCadastroExercicio();
                opcaoCadastroExercicio = Entrada.entradaInt();
                sairOpcaoCadastroExercicio = false;//se for para true sai do menu

                switch (opcaoCadastroExercicio) {
                    case 1://CADASTRO EXERCICIO
                        SubMenus.cadastroExercicio(exercicioCadastro);
                        controllerExecicio.cadastrarExercicio(new Exercicio(exercicioCadastro.getNomeExercicio(),
                            exercicioCadastro.getIntervalo(), exercicioCadastro.getRepeticoes()));
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break; 
                    case 2://ALTERAR
                        //BUSCAR EXERCICIO
                        System.out.println("Informar id do exercicio que deseja alterar");
                        idBusca = Entrada.entradaInt();
                        exercicioBusca = controllerExecicio.buscaExercicioId(idBusca);

                        if (exercicioBusca==null) {
                            System.out.println("Exercicio Não Encontrado");
                        } else {
                            SubMenus.alterarExercicio(exercicioCadastro, idBusca);
                            //alterar o exercicio pelo novo 
                                exercicioBusca.setNomeExercicio(exercicioCadastro.getNomeExercicio());
                                exercicioBusca.setIntervalo(exercicioCadastro.getIntervalo());
                                exercicioBusca.setRepeticoes(exercicioCadastro.getRepeticoes());
                        }

                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                    case 3://DELETAR
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                    case 4://SAIR
                        sairOpcaoCadastroExercicio = true;//continua no menu
                        break;
                    default:
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                }

            } while (!sairOpcaoCadastroExercicio);//se for para true sai do menu



        //MENU PRINCIPAL

        //CADASTRO DE EXERCICIOS

            
        


    }
}
