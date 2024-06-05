package view;

import java.time.LocalDate;

import controller.TreinoController;
import javafx.scene.control.TreeItem;
import model.Exercicio;
import model.Treino;
import util.Entrada;

/**
 * Este Contrler Gerencia o menu do sistema
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public abstract class MenusTreino extends MenusStandard {

    public static void opcoesCadastroTreino() {
        System.out.println("\n\n");
        System.out.println("Cadastro de treinos, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO TREINO:");
        System.out.println("2 - ALTERAR TREINO:");
        System.out.println("3 - DELETAR TREINO:");
        System.out.println("4 - LISTA TREINOS CADATRADOS:");
    }

    public static Treino cadastroTreino(Treino treino) {
        // cadastro Treino
        Entrada.in.nextLine();// LIMPA BUFFER

        System.out.println("\n\n");
        System.out.println("Cadastro de Treino");
        System.out.println("Nome do Treino");
        treino.setNome(Entrada.entradaString());
        System.out.println("Data Inicio");
        treino.setDataInicio(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
        System.out.println("Data Fim");
        treino.setDataFim(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
        System.out.println("Dias de duração");
        treino.setDuracao(Entrada.entradaInt());
        System.out.println("Aquecimento: \n");
        treino.setAquecimento(Entrada.entradaString());
        System.out.println("Sugestão dias de treino: ");
        treino.setSugestaoDiasTreino(Entrada.entradaString());
        // precisa dos subtreinos!
        return treino;
    }

    public static Treino alterarTreino(Treino treino, int id) {
        Entrada.in.nextLine();// LIMPA BUFFER

        System.out.println("\n\n");
        System.out.println("Alterar Treino id: " + id);
        treino.setId(id);// id selecionado
        System.out.println("Nome do treino");
        treino.setNome(Entrada.entradaString());
        System.out.println("Alterar Data de Inicio");
        treino.setDataInicio(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
        System.out.println("Alterar Data do Fim");
        treino.setDataFim(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
        System.out.println("Alterar dias de duração");
        treino.setDuracao(Entrada.entradaInt());
        System.out.println("Alterar Aquecimento");
        treino.setAquecimento(Entrada.entradaString());
        System.out.println("Alterar dias de Sugestão para o treino");
        treino.setSugestaoDiasTreino(Entrada.entradaString());
        return treino;
    }

    public static int buscarTreino() {
        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("Informar id do treino que deseja alterar");
        int id = Entrada.entradaInt();
        return id;
    }

    public static void verTreino(Treino treino) {
        // ver treino
        System.out.println(treino.toString());
    }

    public static void cadastro(TreinoController controllerTreino) {

        int opcaoCadastro, idBusca = 0;
        boolean sairOpcaoCadastro = false;
        Treino cadastro = new Treino();
        Treino busca;

        // CADASTRO TREINO
        do {

            MenusTreino.opcoesCadastroTreino();
            opcaoCadastro = Entrada.entradaInt();
            sairOpcaoCadastro = false;// se for para true sai do menu

            switch (opcaoCadastro) {
                case 0:// SAIR
                    sairOpcaoCadastro = true;// sai do menu
                    break;
                case 1:// CADASTRAR TREINO

                    MenusTreino.cadastroTreino(cadastro);
                    System.out.println("Você deseja cadastrar o Treino?");
                    MenusTreino.verTreino(cadastro);
                    if (MenusTreino.confimar()) {

                        controllerTreino.cadastrarTreino(new Treino(cadastro.getDuracao(), cadastro.getNome(),
                                cadastro.getAquecimento(), cadastro.getSugestaoDiasTreino(), cadastro.getDataInicio(),
                                cadastro.getDataFim(), cadastro.getSubtreinos()));

                        System.out.println("Treino Cadastrado:");
                    } else {
                        System.out.println("Operação Cancelada.");
                    }
                    sairOpcaoCadastro = false;// continua no menu

                    break;
                case 2:// ALTERAR TREINO

                    // BUSCAR TREINO
                    idBusca = MenusTreino.buscarTreino();

                    // busca = controllerTreino.buscaTreinoId(idBusca);
                    busca = controllerTreino.buscaTreinoId(idBusca);

                    if (busca == null) {
                        System.out.println("Treino Não Encontrado");
                    } else {
                        System.out.println("Você deseja alterar o Treino?");
                        MenusTreino.verTreino(busca);

                        if (MenusTreino.confimar()) {
                            MenusTreino.alterarTreino(cadastro, idBusca);

                            // Alterar o treino com os novos dados
                            busca.setNome(cadastro.getNome());
                            busca.setDataInicio(cadastro.getDataInicio());
                            busca.setDataFim(cadastro.getDataFim());
                            busca.setDuracao(cadastro.getDuracao());
                            busca.setAquecimento(cadastro.getAquecimento());
                            busca.setSugestaoDiasTreino(cadastro.getSugestaoDiasTreino());

                            System.out.println("Treino Alterado:");
                            MenusTreino.verTreino(busca);
                        } else {
                            System.out.println("Operação Cancelada, Treino não alterado:");
                            MenusTreino.verTreino(busca);
                        }
                    }

                    sairOpcaoCadastro = false;// continua no menu
                    break;
                case 3:// DELETAR TREINO

                    // BUSCAR TREINO
                    idBusca = MenusTreino.buscarTreino();
                    busca = controllerTreino.buscaTreinoId(idBusca);

                    if (busca == null) {
                        System.out.println("Treino Não Encontrado");
                    } else {
                        System.out.println("Você deseja EXCLUIR o Treino?");
                        MenusTreino.verTreino(busca);

                        if (MenusTreino.confimar()) {
                            controllerTreino.deletarTreino(idBusca);
                            System.out.println("Treino Excluido:");
                        } else {
                            System.out.println("Operação Cancelada, Treino não deletado:");
                            MenusTreino.verTreino(busca);
                        }
                    }
                    sairOpcaoCadastro = false;// continua no menu
                    break;

                case 4:// LISTAR TREINOS CADASTRADOS
                    System.out.println("Lista de Treinos Cadastrados");
                    controllerTreino.getTrienos().forEach(System.out::println);
                    System.out.println("----------------\n\n");
                    sairOpcaoCadastro = false;// continua no menu
                    break;
                default:
                    sairOpcaoCadastro = false;// continua no menu
                    break;
            }

        } while (!sairOpcaoCadastro);// se for para true sai do menu
    }

}
