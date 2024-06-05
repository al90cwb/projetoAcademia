package view;

import java.util.ArrayList;

import controller.SubtreinoController;
import model.Exercicio;
import model.SubTreino;
import util.Entrada;

public class MenuSubtreino extends MenusStandard {

    // SUBTREINO--------------------------

    public static void opcoesCadastroSubtreino() {
        System.out.println("\n\n");
        System.out.println("OPCOES CADASTRO DE SUBTREINOS, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO SUBTREINO:");
        System.out.println("2 - ALTERAR SUBTREINO:");
        System.out.println("3 - DELETAR SUBTREINO:");
        System.out.println("4 - LISTA SUBTREINOS CADASTRADOS:");
    }

    public static SubTreino cadastroSubtreino(SubTreino subtreino) {
        // cadastro Subtreino
        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("\n\n");
        System.out.println("Cadastro de Subtrieno");
        System.out.println("Nome do Subtreino");
        subtreino.setNome(Entrada.entradaString());
        System.out.println("Letra do Subtreino");
        subtreino.setLetra(Entrada.entradaString());
        System.out.println("Sexo M masculino, F feminino :");
        subtreino.setSexo(Entrada.entradaString());
        System.out.println("Tipo Grupo Muscular");
        subtreino.setTipoSubtreino(Entrada.entradaString());

        return subtreino;
    }

    public static SubTreino alterarSubTreino(SubTreino subTreino, int id) {
        // alterar subtreino
        Entrada.in.nextLine(); // limpa o buffer
        System.out.println("\n\n");
        System.out.println("Alterar SubTreino ID: " + id);
        subTreino.setId(id); // define o ID selecionado
        System.out.println("Nome do subtreino:");
        subTreino.setNome(Entrada.entradaString());
        System.out.println("Tipo de subtreino:");
        subTreino.setTipoSubtreino(Entrada.entradaString());
        System.out.println("Sexo:");
        subTreino.setSexo(Entrada.entradaString());
        System.out.println("Letra:");
        subTreino.setLetra(Entrada.entradaString());
        return subTreino;
    }

    public static int buscarSubTreino() {
        // buscar subtreino
        Entrada.in.nextLine(); // limpa o buffer
        System.out.println("Informar ID do subtreino que deseja alterar:");
        return Entrada.entradaInt();
    }

    public static void verSubTreino(SubTreino subTreino) {
        // ver informações do subtreino
        System.out.println(subTreino.toString());
    }

    public static void cadastro(SubtreinoController controllerSubtreino) {

        int opcaoCadastro, idBusca = 0;
        boolean sairOpcaoCadastro = false;
        SubTreino cadastro = new SubTreino();
        SubTreino busca;

        // CADASTRO SUBTREINOS
        do {
            MenuSubtreino.opcoesCadastroSubtreino();
            opcaoCadastro = Entrada.entradaInt();
            sairOpcaoCadastro = false; // Se for true, sai do menu

            switch (opcaoCadastro) {
                case 0: // SAIR
                    sairOpcaoCadastro = true; // Sai do menu
                    break;
                case 1: // CADASTRO SUBTREINO

                    MenuSubtreino.cadastroSubtreino(cadastro);
                    System.out.println("Você deseja cadastrar o Subtreino?");
                    MenuSubtreino.verSubTreino(cadastro);

                    if (MenuSubtreino.confimar()) {
                        // Cadastrar o subtreino
                        controllerSubtreino.cadastrarSubTreino(new SubTreino(
                                cadastro.getNome(),
                                cadastro.getTipoSubtreino(),
                                cadastro.getSexo(),
                                cadastro.getLetra(),
                                new ArrayList<Exercicio>()));
                        System.out.println("Subtreino cadastrado!");
                    } else {
                        System.out.println("Operação cancelada.");
                    }
                    sairOpcaoCadastro = false; // Continua no menu

                    break;
                case 2: // ALTERAR

                    // BUSCAR SUBTREINO
                    idBusca = MenuSubtreino.buscarSubTreino();
                    busca = controllerSubtreino.buscaSubTreinoId(idBusca);

                    if (busca == null) {
                        System.out.println("Subtreino não encontrado.");
                    } else {
                        System.out.println("Você deseja alterar o Subtreino?");
                        MenuSubtreino.verSubTreino(busca);

                        if (MenuSubtreino.confimar()) {
                            MenuSubtreino.alterarSubTreino(cadastro, idBusca);

                            // Alterar o subtreino
                            busca.setNome(cadastro.getNome());
                            busca.setTipoSubtreino(cadastro.getTipoSubtreino());
                            busca.setSexo(cadastro.getSexo());
                            busca.setLetra(cadastro.getLetra());

                            System.out.println("Subtreino alterado:");
                            MenuSubtreino.verSubTreino(busca);
                        } else {
                            System.out.println("Operação cancelada, subtreino não foi alterado:");
                            MenuSubtreino.verSubTreino(busca);
                        }
                    }

                    sairOpcaoCadastro = false; // Continua no menu
                    break;
                case 3: // DELETAR

                    // BUSCAR SUBTREINO
                    idBusca = MenuSubtreino.buscarSubTreino();
                    busca = controllerSubtreino.buscaSubTreinoId(idBusca);

                    if (busca == null) {
                        System.out.println("Subtreino não encontrado.");
                    } else {
                        System.out.println("Você deseja EXCLUIR o Subtreino?");
                        MenuSubtreino.verSubTreino(busca);

                        if (MenuSubtreino.confimar()) {
                            controllerSubtreino.deletarTreino(idBusca);
                            System.out.println("Subtreino excluído.");
                        } else {
                            System.out.println("Operação cancelada, subtreino não foi deletado:");
                            MenuSubtreino.verSubTreino(busca);
                        }
                    }
                    sairOpcaoCadastro = false; // Continua no menu
                    break;
                case 4: // LISTA DE SUBTREINOS CADASTRADOS
                    System.out.println("Lista de Subtreinos Cadastrados");
                    controllerSubtreino.getSubTreinos().forEach(System.out::println);
                    System.out.println("----------------\n\n");
                    sairOpcaoCadastro = false; // Continua no menu
                    break;
                default:
                    sairOpcaoCadastro = false; // Continua no menu
                    break;
            }

        } while (!sairOpcaoCadastro); // Sai do menu se for true

    }

}
