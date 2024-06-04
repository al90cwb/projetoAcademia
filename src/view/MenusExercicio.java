package view;

import controller.ExercicioController;
import model.Exercicio;
import util.Entrada;

public abstract class MenusExercicio {

       //GERAL---------------------------- 
    public static boolean confimar(){
        //ver exercicio
            System.out.println("0=NÃO,1=SIM");
            boolean op = Entrada.entradaZeroUm()==1;
        return op;
    }

    //EXERCICIO------------------------
    public static void opcoesCadastroExercicio(){
        //menu com as opçções de cadastro de Exercicio
            System.out.println("\n\n");
            System.out.println("OPÇÕES CADASTRO DE EXERCICIOS, digite um numero correspondente:");
            System.out.println("0 - CANCELAR");
            System.out.println("1 - CADASTRAR NOVO EXERCICIO:");
            System.out.println("2 - ALTERAR EXERCICIO:");
            System.out.println("3 - DELETAR EXERCICIO:");
            System.out.println("4 - LISTA EXERCICIOS CADATRADOS:");
    }

    public static Exercicio cadastroExercicio(Exercicio exercicio){
        //cadastro exercicio
            Entrada.in.nextLine();//LIMPA BUFFER
            System.out.println("\n\n");
            System.out.println("Cadastro de Exercicio");
            System.out.println("Nome do exercicio");
            exercicio.setNomeExercicio(Entrada.entradaString());
            System.out.println("Quantidade de Repetições");
            exercicio.setRepeticoes(Entrada.entradaString());
            System.out.println("Tempo de Intervalo");
            exercicio.setIntervalo(Entrada.entradaString());
        return exercicio;
    }

    public static Exercicio alterarExercicio(Exercicio exercicio, int id){
        //cadastro exercicio
            Entrada.in.nextLine();//LIMPA BUFFER
            System.out.println("\n\n");
            System.out.println("Alterar Exercicio id: "  + id);
            exercicio.setId(id);//id selecionado
            System.out.println("Nome do exercicio");
            exercicio.setNomeExercicio(Entrada.entradaString());
            System.out.println("Quantidade de Repetições");
            exercicio.setRepeticoes(Entrada.entradaString());
            System.out.println("Tempo de Intervalo");
            exercicio.setIntervalo(Entrada.entradaString());
        return exercicio;
    }

    public static int buscarExercicio(){
        Entrada.in.nextLine();//LIMPA BUFFER
        System.out.println("Informar id do exercicio que deseja alterar");
        int id = Entrada.entradaInt();
        return id;
    }
    public static void verExercicio(Exercicio exercicio){
        //ver exercicio
            System.out.println(exercicio.toString());
    }

    public static  void cadastro(ExercicioController controllerExecicio){
        
        int opcaoCadastroExercicio,idBusca = 0;
        boolean sairOpcaoCadastroExercicio= false;
        Exercicio exercicioCadastro = new Exercicio( null, null, null);
        Exercicio exercicioBusca;

        //CADASTRO EXERCICIO
            do {
               
                MenusExercicio.opcoesCadastroExercicio();
                opcaoCadastroExercicio = Entrada.entradaInt();
                sairOpcaoCadastroExercicio = false;//se for para true sai do menu

                switch (opcaoCadastroExercicio) {
                    case 0://SAIR
                        sairOpcaoCadastroExercicio = true;//sai do menu
                        break;
                    case 1://CADASTRO EXERCICIO

                        MenusExercicio.cadastroExercicio(exercicioCadastro);
                        System.out.println("Você deseja cadastrar o Exercicio?");
                        MenusExercicio.verExercicio(exercicioCadastro);

                        if (MenusTreino.confimar()){
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
                        idBusca = MenusExercicio.buscarExercicio();
                        exercicioBusca = controllerExecicio.buscaExercicioId(idBusca);

                        if (exercicioBusca==null) {
                            System.out.println("Exercicio Não Encontrado");
                        } else {
                            System.out.println("Você deseja alterar o Exercicio?");
                            MenusExercicio.verExercicio(exercicioBusca);

                            if (MenusExercicio.confimar()){
                                MenusExercicio.alterarExercicio(exercicioCadastro, idBusca);

                                //alterar o exercicio pelo novo 
                                    exercicioBusca.setNomeExercicio(exercicioCadastro.getNomeExercicio());
                                    exercicioBusca.setIntervalo(exercicioCadastro.getIntervalo());
                                    exercicioBusca.setRepeticoes(exercicioCadastro.getRepeticoes());

                                System.out.println("Exercicio Alterado:");
                                MenusExercicio.verExercicio(exercicioBusca);
                            }else{
                                System.out.println("Operação Cancelada, Exercicio não foi alterado:");
                                MenusExercicio.verExercicio(exercicioBusca);
                            }
                        }

                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                    case 3://DELETAR

                        //BUSCAR EXERCICIO
                        idBusca = MenusExercicio.buscarExercicio();
                        exercicioBusca = controllerExecicio.buscaExercicioId(idBusca);

                        if (exercicioBusca==null) {
                            System.out.println("Exercicio Não Encontrado");
                        } else {
                            System.out.println("Você deseja EXCLUIR o Exercicio?");
                            MenusExercicio.verExercicio(exercicioBusca);

                            if (MenusTreino.confimar()){
                                controllerExecicio.deletarTreino(idBusca);
                                System.out.println("Exercicio Excluido:");
                            }else{
                                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
                                MenusExercicio.verExercicio(exercicioBusca);
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

    }
}
