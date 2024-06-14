package view;

import java.util.List;
import controller.TreinoController;
import model.Exercicio;
import model.FactoryClasses;
import model.Treino;
import util.Entrada;

/**
 * Classe para objetos do tipo Treino, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author Alan Souza
 * @version 1.00
 * @since 11/06/2024
 */

public class MenuTreino extends MenuPadrao  {

    public static void opcoesCadastroTreino() {
        System.out.println("\n\n");
        System.out.println("OPCOES CADASTRO DE TREINOS, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO TRIENO");
        System.out.println("2 - BUSCAR TREINO - DELETAR/ALTERAR");
        System.out.println("3 - LISTA TREINOS CADASTRADOS");
        System.out.println("4 - VER TREINO");

    }

    public static void exibirCadastro(TreinoController controller, FactoryClasses factory) throws Exception {

        int opcaoCadastro;
        boolean sairOpcaoCadastro = false;
        Treino busca;

        do {
            MenuTreino.opcoesCadastroTreino();
            opcaoCadastro = Entrada.entradaInt();
            sairOpcaoCadastro = false;

            switch (opcaoCadastro) {
                case 0:
                    sairOpcaoCadastro = true;
                    break;
                case 1:
                    System.out.println("Cadastrar novo Treino");
                    exibirCadastroTreino(controller, factory);
                    break;
                case 2:
                    busca = exibirBuscar(controller);
                    exibirTreino(busca);
                    exibirOpcaoAlteracao(controller, busca, factory);
                    break;

                case 3:
                    System.out.println("Lista de TREINOS Cadastrados");
                    exibirTreinos(controller.getTreinos());
                    System.out.println("----------------\n\n");
                    break;
                case 4:
                    exibirTreino(exibirBuscar(controller));
                    System.out.println("----------------\n\n");
                    break;
                default:
                    break;
            }

        } while (!sairOpcaoCadastro);

    }

    public static void exibirOpcaoAlteracao(TreinoController controller, Treino treino, FactoryClasses factory)
            throws Exception {

        int opcao = 0;
        boolean sair = false;

        do {
            System.out.println("\n\n Informar opções");
            System.out.println("0- Cancelar");
            System.out.println("1- Alterar");
            System.out.println("2- Deletar");
            opcao = 0;
            opcao = Entrada.entradaInt();

            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    exibirAlterar(treino, factory);
                    sair = true;
                    break;
                case 2:
                    exibirDeletar(controller, treino);
                    sair = true;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        } while (!sair);
    }

    public static Treino exibirCadastroTreino(TreinoController controller, FactoryClasses factory) throws Exception {

        String nomeTreino, tipoTreino;
        Entrada.limparBuffer();
        System.out.println("\n\n");
        System.out.println("Cadastro de Treino");
        System.out.println("Nome do Treino");
        nomeTreino = Entrada.entradaString();
        System.out.println("Tipo Grupo Muscular");
        tipoTreino = Entrada.entradaTipoTreino();
        Treino cadastro = factory.criarTreino(nomeTreino, tipoTreino);
        controller.cadastrar(cadastro);
        exibirCadastroExercicio(cadastro, factory);

        return cadastro;
    }

    public static void exibirAlterar(Treino treino, FactoryClasses factory) {
        if (treino == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja alterar o Treino?");
            exibirTreino(treino);

            if (exibirConfirmar()) {
                Entrada.limparBuffer();
                System.out.println("\n\n");
                System.out.println("Alterar o Nome:");
                treino.setNome(Entrada.entradaString());
                System.out.println("Tipo Grupo Muscular");
                treino.setTipoTreino(Entrada.entradaTipoTreino());
                exibirCadastroExercicio(treino, factory);
                exibirTreino(treino);
            } else {
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static void exibirCadastroExercicio(Treino treino, FactoryClasses factory) {

        String nomeExercicio, intervalo, repticoes;
        boolean sair = false;
        do {
            treino.limparExercicios();
            Entrada.limparBuffer();
            System.out.println("\n\n");
            System.out.println("Adicionar Exercicio");
            System.out.println("Nome do Exercicio");
            nomeExercicio = Entrada.entradaString();
            System.out.println("Intervalo");
            intervalo = Entrada.entradaString();
            System.out.println("Repticoes");
            repticoes = Entrada.entradaString();
            System.out.println("Deseja adicioanr mais exercicios?");
            sair = !exibirConfirmar();
        } while (!sair);
    }

    public static Treino exibirAlterarTreino(Treino treino, int id) {
        Entrada.limparBuffer();
        System.out.println("\n\n");
        System.out.println("Alterar Treino ID: " + id);
        treino.setId(id);
        System.out.println("Nome do treino:");
        treino.setNome(Entrada.entradaString());
        System.out.println("Tipo de treino:");
        treino.setTipoTreino(Entrada.entradaString());
        return treino;
    }

    public static int exibirInformarId() {
        System.out.println("Informar ID do treino:");
        return Entrada.entradaInt();
    }

    public static Treino exibirBuscar(TreinoController controller) {
        return controller.buscaTreinoId(MenuTreino.exibirInformarId());
    }

    public static void exibirDeletar(TreinoController controller, Treino trieno) throws Exception {
        if (trieno == null) {
            System.out.println("Treino não encontrado");
        } else {
            System.out.println("Você deseja deletar o Trino?");
            exibirTreino(trieno);

            if (MenuAdministrador.exibirConfirmar()) {
                controller.deletar(trieno.getId());
                System.out.println("Treino Excluido:");
            } else {
                System.out.println("Operação Cancelada, Treino não foi deletado:");
            }
        }
    }

    public static void exibirBuscaTreinos(TreinoController controller) {
        String tipo;
        List<Treino> treinos;
        System.out.println("Informar o Tipo do treino");
        Entrada.limparBuffer();
        tipo = Entrada.entradaTipoTreino();
        treinos = controller.pesquisaPorTipo(tipo);
        if (treinos != null) {
            for (Treino treino : treinos) {
                System.out.println("Id:" + treino.getId() + ", nome do treino " + treino.getNome());
            }
        } else {
            System.out.println("Lista de trienos vazia");
        }
        return;
    }

    public static void exibirTreino(Treino treino) {
        if (treino != null) {
            List<Exercicio> exercicios = treino.getExercicios();
            for (Exercicio exercicio : exercicios) {
                System.out.println("Nome do Exercicio:" + exercicio.getNomeExercicio() + ", repetições:"
                        + exercicio.getRepeticoes() + ", intervalo:" + exercicio.getIntervalo() + ".");
            }
        } else {
            System.out.println("Lista de exercicios vazia");
        }
    }

    public static void exibirTreinos(List<Treino> treinos) {
        if (treinos != null) {
            for (Treino treino : treinos) {
                System.out.println(
                        "Id " + treino.getId() + ", nome " + treino.getNome() + ", tipo: " + treino.getTipoTreino());
            }
        } else {
            System.out.println("Lista de trienos vazia");
        }
    }

}
