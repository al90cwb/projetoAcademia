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
           // SubtreinoController controllerSubtreino = new SubtreinoController(new ArrayList<SubTreino>());
            TreinoController controllerTreino = new TreinoController(new ArrayList<Treino>()) ;

        //DADOS DE CADASTRO
            boolean modoTeste= true;
            boolean sairOpcaoCadastroExercicio = false;
            int opcaoCadastroExercicio = 0;
            int idBusca = 0;
            boolean sairOpcaoCadastroTreino = false;
            int opcaoCadastroTreino = 0;

    

        //EXERCICIO
            Exercicio exercicioCadastro = new Exercicio( null, null, null);
            //SubTreino subTreinoCadastro = new SubTreino( null, null, null, null, null);
            Treino treinoCadastro = new Treino(opcaoCadastroExercicio, null, null, null, null, null, null);
            
            Exercicio exercicioBusca;//somente para buscas
           // SubTreino subtreinoBusca;//somente para buscas
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
        

            
        /*CADASTRO EXERCICIO
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
                            System.out.println("Você deseja EXCLUIR o Exercicio?");
                            SubMenus.verExercicio(exercicioBusca);

                            if (SubMenus.confimar()){
                                controllerExecicio.deletarTreino(idBusca);
                                System.out.println("Exercicio Excluido:");
                            }else{
                                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
                                SubMenus.verExercicio(exercicioBusca);
                            }
                        }
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;

                    case 4://LISTA DE EXERCICIOS CADASTRADOS
                        System.out.println("Lista de Exercicios Cadastrados");
                        controllerExecicio.getExercicios().forEach(System.out::println);
                        System.out.println("----------------\n\n");
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                    default:
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                }

            } while (!sairOpcaoCadastroExercicio);//se for para true sai do menu

            */







            //CADASTRO TREINO

            //PRECISA IMPLEMENTAR OS SUBTREINOS - NÃO CONSEGUI - JUAN.
            //ALGUM BUG NO CADASTRAR AQUECIMENTO, ESTÁ SENDO PULADO NA HORA DO CADASTRO.

            do {

                SubMenus.opcoesCadastroTreino();
                opcaoCadastroTreino = Entrada.entradaInt();
                sairOpcaoCadastroTreino = false;// se for para true sai do menu
        
                switch (opcaoCadastroTreino) {
                    case 0:// SAIR
                        sairOpcaoCadastroTreino = true;// sai do menu
                        break;
                    case 1:// CADASTRAR TREINO

                        SubMenus.cadastroTreino(treinoCadastro);
                        System.out.println("Você deseja cadastrar o Treino?");
                        SubMenus.verTreino(treinoCadastro);
                        if (SubMenus.confimar()){

                            controllerTreino.cadastrarTreino(new Treino(treinoCadastro.getDuracao(),treinoCadastro.getNome(),treinoCadastro.getAquecimento(),treinoCadastro.getSugestaoDiasTreino(),treinoCadastro.getDataInicio(),treinoCadastro.getDataFim(),treinoCadastro.getSubtreinos()));

                            System.out.println("Treino Cadastrado:");
                        }else{
                            System.out.println("Operação Cancelada.");
                        }
                        sairOpcaoCadastroExercicio = false;//continua no menu

                        break;
                    case 2:// ALTERAR TREINO
        
                        // BUSCAR TREINO
                        idBusca = SubMenus.buscarTreino();
                        treinoBusca = controllerTreino.buscaTreinoId(idBusca);
        
                        if (treinoBusca == null) {
                            System.out.println("Treino Não Encontrado");
                        } else {
                            System.out.println("Você deseja alterar o Treino?");
                            SubMenus.verTreino(treinoBusca);
        
                            if (SubMenus.confimar()) {
                                SubMenus.alterarTreino(treinoCadastro, idBusca);
        
                                // Alterar o treino com os novos dados
                                treinoBusca.setNome(treinoCadastro.getNome());
                                treinoBusca.setDataInicio(treinoCadastro.getDataInicio());
                                treinoBusca.setDataFim(treinoCadastro.getDataFim());
                                treinoBusca.setDuracao(treinoCadastro.getDuracao());
                                treinoBusca.setAquecimento(treinoCadastro.getAquecimento());
                                treinoBusca.setSugestaoDiasTreino(treinoCadastro.getSugestaoDiasTreino());

        
                                System.out.println("Treino Alterado:");
                                SubMenus.verTreino(treinoBusca);
                            } else {
                                System.out.println("Operação Cancelada, Treino não alterado:");
                                SubMenus.verTreino(treinoBusca);
                            }
                        }
        
                        sairOpcaoCadastroTreino = false;// continua no menu
                        break;
                    case 3:// DELETAR TREINO
        
                        // BUSCAR TREINO
                        idBusca = SubMenus.buscarTreino();
                        treinoBusca = controllerTreino.buscaTreinoId(idBusca);
        
                        if (treinoBusca == null) {
                            System.out.println("Treino Não Encontrado");
                        } else {
                            System.out.println("Você deseja EXCLUIR o Treino?");
                            SubMenus.verTreino(treinoBusca);
        
                            if (SubMenus.confimar()) {
                                controllerTreino.deletarTreino(idBusca);
                                System.out.println("Treino Excluido:");
                            } else {
                                System.out.println("Operação Cancelada, Treino não deletado:");
                                SubMenus.verTreino(treinoBusca);
                            }
                        }
                        sairOpcaoCadastroTreino = false;// continua no menu
                        break;
        
                    case 4:// LISTAR TREINOS CADASTRADOS
                        System.out.println("Lista de Treinos Cadastrados");
                        controllerTreino.getTrienos().forEach(System.out::println);
                        System.out.println("----------------\n\n");
                        sairOpcaoCadastroTreino = false;// continua no menu
                        break;
                    default:
                        sairOpcaoCadastroTreino = false;// continua no menu
                        break;
                }
        
            } while (!sairOpcaoCadastroTreino);// se for para true sai do menu
        }

            



            
    }

