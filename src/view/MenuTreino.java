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

public class MenuTreino extends MenuPadrao  implements iOpcoesPadraoMenu {

    public static void opcoesCadastroTreino() {
        System.out.println("\n\n");
        System.out.println("OPCOES CADASTRO DE TREINOS, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO TRIENO");
        System.out.println("2 - BUSCAR TREINO - DELETAR/ALTERAR");
        System.out.println("3 - LISTA TREINOS CADASTRADOS");
        System.out.println("4 - VER TREINO");

    }

    public static void cadastro(TreinoController controller, FactoryClasses factory) throws Exception {

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
                    cadastroTreino(controller, factory);
                    sairOpcaoCadastro = false;
                    break;
                case 2:
                    busca = buscar(controller);
                    verTreino(busca);
                    opcaoAlteracao(controller, busca, factory);
                    break;

                case 3:
                    System.out.println("Lista de TREINOS Cadastrados");
                    verTreinos(controller.getTreinos());
                    System.out.println("----------------\n\n");
                    sairOpcaoCadastro = false;
                    break;
                case 4:
                    verTreino(buscar(controller));
                    System.out.println("----------------\n\n");
                    sairOpcaoCadastro = false;
                    break;
                default:
                    sairOpcaoCadastro = false;
                    break;
            }

        } while (!sairOpcaoCadastro);

    }

    public static void opcaoAlteracao(TreinoController controller, Treino treino, FactoryClasses factory)
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
                    alterar(treino, factory);
                    sair = true;
                    break;
                case 2:
                    deletar(controller, treino);
                    sair = true;
                    break;
                default:
                    System.out.println("Opção invalida");
                    sair = false;
                    break;
            }
        } while (!sair);
    }

    public static Treino cadastroTreino(TreinoController controller, FactoryClasses factory) throws Exception {

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
        cadastroExercicio(cadastro, factory);

        return cadastro;
    }

    public static void alterar(Treino treino, FactoryClasses factory) {
        if (treino == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja alterar o Treino?");
            verTreino(treino);

            if (confimar()) {
                Entrada.limparBuffer();
                System.out.println("\n\n");
                System.out.println("Alterar o Nome:");
                treino.setNome(Entrada.entradaString());
                System.out.println("Tipo Grupo Muscular");
                treino.setTipoTreino(Entrada.entradaTipoTreino());
                cadastroExercicio(treino, factory);
                verTreino(treino);
            } else {
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static void cadastroExercicio(Treino treino, FactoryClasses factory) {

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
            Exercicio cadastro = factory.criarExercicio(nomeExercicio, intervalo, repticoes);
            System.out.println("Deseja adicioanr mais exercicios?");
            sair = !confimar();
        } while (!sair);
    }

    public static Treino alterarTreino(Treino treino, int id) {
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

    public static int informarId() {
        System.out.println("Informar ID do treino:");
        return Entrada.entradaInt();
    }

    public static Treino buscar(TreinoController controller) {
        return controller.buscaTreinoId(MenuTreino.informarId());
    }

    public static void deletar(TreinoController controller, Treino trieno) throws Exception {
        if (trieno == null) {
            System.out.println("Treino não encontrado");
        } else {
            System.out.println("Você deseja deletar o Trino?");
            verTreino(trieno);

            if (MenuAdminstrador.confimar()) {
                controller.deletar(trieno.getId());
                System.out.println("Treino Excluido:");
            } else {
                System.out.println("Operação Cancelada, Treino não foi deletado:");
            }
        }
    }

    public static void buscarTreinos(TreinoController controller) {
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

    public static void verTreino(Treino treino) {
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

    public static void verTreinos(List<Treino> treinos) {
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
