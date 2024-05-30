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
            boolean modoTeste= true;
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


        //CADASTRO BASICO DE EXERCICIOS MODO TESTE
            if(modoTeste){
                for (int i = 0; i < 25; i++) {
                    controllerExecicio.cadastrarExercicio(new Exercicio("Exercicio"+i,i+"min", "10x"));
                }
            }
        

            
        //CADASTRO EXERCICIO
            do {
                SubMenus.opcoesCadastroExercicio();
                opcaoCadastroExercicio = Entrada.entradaInt();
                sairOpcaoCadastroExercicio = false;//se for para true sai do menu

                switch (opcaoCadastroExercicio) {
                    case 0://SAIR
                        sairOpcaoCadastroExercicio = true;//sai do menu
                        break;
                    case 1://CADASTRO EXERCICIO

                        SubMenus.cadastroExercicio(exercicioCadastro);
                        System.out.println("Você deseja cadastrar o Exercicio?");
                        SubMenus.verExercicio(exercicioCadastro);

                        if (SubMenus.confimar()){
                            SubMenus.alterarExercicio(exercicioCadastro, idBusca);

                            //alterar o exercicio pelo novo 

                            controllerExecicio.cadastrarExercicio(new Exercicio(exercicioCadastro.getNomeExercicio(),
                            exercicioCadastro.getIntervalo(), exercicioCadastro.getRepeticoes()));

                            System.out.println("Exercicio Cadastrado:");
                        }else{
                            System.out.println("Operação Cancelada.");
                        }
                        sairOpcaoCadastroExercicio = false;//continua no menu

                        break; 
                    case 2://ALTERAR

                        //BUSCAR EXERCICIO
                        idBusca = SubMenus.buscarExercicio();
                        exercicioBusca = controllerExecicio.buscaExercicioId(idBusca);

                        if (exercicioBusca==null) {
                            System.out.println("Exercicio Não Encontrado");
                        } else {
                            System.out.println("Você deseja alterar o Exercicio?");
                            SubMenus.verExercicio(exercicioBusca);

                            if (SubMenus.confimar()){
                                SubMenus.alterarExercicio(exercicioCadastro, idBusca);

                                //alterar o exercicio pelo novo 
                                    exercicioBusca.setNomeExercicio(exercicioCadastro.getNomeExercicio());
                                    exercicioBusca.setIntervalo(exercicioCadastro.getIntervalo());
                                    exercicioBusca.setRepeticoes(exercicioCadastro.getRepeticoes());

                                System.out.println("Exercicio Alterado:");
                                SubMenus.verExercicio(exercicioBusca);
                            }else{
                                System.out.println("Operação Cancelada, Exercicio não foi alterado:");
                                SubMenus.verExercicio(exercicioBusca);
                            }
                        }

                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                    case 3://DELETAR

                        //BUSCAR EXERCICIO
                        idBusca = SubMenus.buscarExercicio();
                        exercicioBusca = controllerExecicio.buscaExercicioId(idBusca);

                        if (exercicioBusca==null) {
                            System.out.println("Exercicio Não Encontrado");
                        } else {
                            

                        }


                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;

                    default:
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                }

            } while (!sairOpcaoCadastroExercicio);//se for para true sai do menu



            
        //TESTE JUAN


    }
}
