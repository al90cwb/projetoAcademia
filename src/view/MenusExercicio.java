package view;

import controller.ExercicioController;
import model.Exercicio;
import util.Entrada;

public abstract class MenusExercicio extends MenusStandard {

    // EXERCICIO------------------------
    public static void opcoesCadastroExercicio() {
        // menu com as opçções de cadastro de Exercicio
        System.out.println("\n\n");
        System.out.println("OPÇÕES CADASTRO DE EXERCICIOS, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO EXERCICIO:");
        System.out.println("2 - ALTERAR EXERCICIO:");
        System.out.println("3 - DELETAR EXERCICIO:");
        System.out.println("4 - LISTA EXERCICIOS CADATRADOS:");
    }

    public static Exercicio cadastroExercicio(Exercicio exercicio) {
        // cadastro exercicio
        Entrada.in.nextLine();// LIMPA BUFFER
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

    public static Exercicio alterarExercicio(Exercicio exercicio, int id) {
        // cadastro exercicio
        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("\n\n");
        System.out.println("Alterar Exercicio id: " + id);
        exercicio.setId(id);// id selecionado
        System.out.println("Nome do exercicio");
        exercicio.setNomeExercicio(Entrada.entradaString());
        System.out.println("Quantidade de Repetições");
        exercicio.setRepeticoes(Entrada.entradaString());
        System.out.println("Tempo de Intervalo");
        exercicio.setIntervalo(Entrada.entradaString());
        return exercicio;
    }

    public static int buscarExercicio() {
        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("Informar id do exercicio que deseja alterar");
        int id = Entrada.entradaInt();
        return id;
    }

    public static void verExercicio(Exercicio exercicio) {
        // ver exercicio
        System.out.println(exercicio.toString());
    }

    public static void verExercicios( ExercicioController controller){
        System.out.println("Lista de Exercicios Cadastrados");
        for (Exercicio exercicio : controller.getExercicios()) {
            System.err.println("id :"+ exercicio.getId() + ", Nome: " + exercicio.getNomeExercicio() + ", Intervalo "+ exercicio.getIntervalo()+ ", Repetições :" + exercicio.getRepeticoes());
        }
        System.out.println("----------------\n\n");
    }

    public static void cadastro(ExercicioController controllerExecicio) {

        int opcaoCadastro, idBusca = 0;
        boolean sairOpcaoCadastro = false;
        Exercicio cadastro = new Exercicio(null, null, null);
        Exercicio busca;

        // CADASTRO EXERCICIO
        do {

            MenusExercicio.opcoesCadastroExercicio();
            opcaoCadastro = Entrada.entradaInt();
            sairOpcaoCadastro = false;// se for para true sai do menu

            switch (opcaoCadastro) {
                case 0:// SAIR
                    sairOpcaoCadastro = true;// sai do menu
                    break;
                case 1:// CADASTRO EXERCICIO

                    MenusExercicio.cadastroExercicio(cadastro);
                    System.out.println("Você deseja cadastrar o Exercicio?");
                    MenusExercicio.verExercicio(cadastro);

                    if (MenusTreino.confimar()) {
                        // alterar o exercicio pelo novo
                        controllerExecicio.cadastrarExercicio(new Exercicio(cadastro.getNomeExercicio(),
                                cadastro.getIntervalo(), cadastro.getRepeticoes()));

                        System.out.println("Exercicio Cadastrado:");
                    } else {
                        System.out.println("Operação Cancelada.");
                    }
                    sairOpcaoCadastro = false;// continua no menu

                    break;
                case 2:// ALTERAR

                    // BUSCAR EXERCICIO
                    idBusca = MenusExercicio.buscarExercicio();
                    busca = controllerExecicio.buscaExercicioId(idBusca);

                    if (busca == null) {
                        System.out.println("Exercicio Não Encontrado");
                    } else {
                        System.out.println("Você deseja alterar o Exercicio?");
                        MenusExercicio.verExercicio(busca);

                        if (MenusExercicio.confimar()) {
                            MenusExercicio.alterarExercicio(cadastro, idBusca);

                            // alterar o exercicio pelo novo
                            busca.setNomeExercicio(cadastro.getNomeExercicio());
                            busca.setIntervalo(cadastro.getIntervalo());
                            busca.setRepeticoes(cadastro.getRepeticoes());

                            System.out.println("Exercicio Alterado:");
                            MenusExercicio.verExercicio(busca);
                        } else {
                            System.out.println("Operação Cancelada, Exercicio não foi alterado:");
                            MenusExercicio.verExercicio(busca);
                        }
                    }

                    sairOpcaoCadastro = false;// continua no menu
                    break;
                case 3:// DELETAR

                    // BUSCAR EXERCICIO
                    idBusca = MenusExercicio.buscarExercicio();
                    busca = controllerExecicio.buscaExercicioId(idBusca);

                    if (busca == null) {
                        System.out.println("Exercicio Não Encontrado");
                    } else {
                        System.out.println("Você deseja EXCLUIR o Exercicio?");
                        MenusExercicio.verExercicio(busca);

                        if (MenusTreino.confimar()) {
                            controllerExecicio.deletarTreino(idBusca);
                            System.out.println("Exercicio Excluido:");
                        } else {
                            System.out.println("Operação Cancelada, Exercicio não foi deletado:");
                            MenusExercicio.verExercicio(busca);
                        }
                    }
                    sairOpcaoCadastro = false;// continua no menu
                    break;

                case 4:// LISTA DE EXERCICIOS CADASTRADOS
                    verExercicios(controllerExecicio);
                    sairOpcaoCadastro = false;// continua no menu
                    break;
                default:
                    sairOpcaoCadastro = false;// continua no menu
                    break;
            }

        } while (!sairOpcaoCadastro);// se for para true sai do menu

    }
}
