package view;

import java.time.LocalDate;

import controller.AlunoController;
import controller.TreinoController;
import model.Aluno;
import model.FactoryClasses;
import model.Treino;
import util.Entrada;

public abstract class MenuAluno extends MenuPadrao  {

    public static void exibirOpcoes() {
        System.out.println("\n\n");
        System.out.println("Menu Aluno:");
        System.out.println("0 - FECHAR SISTEMA");
        System.out.println("1 - LOGOUT");

        System.out.println("\n10 - VISUALIZAR TREINO");
        System.out.println("11 - SOLICITAR TREINO NOVO");
    }

    public static boolean exibirMenuPrincipal(Aluno aluno) {

        int opcao = 0;
        boolean sair = false;

        do {

            exibirOpcoes();
            opcao = Entrada.entradaInt();

            switch (opcao) {
                case 0:
                    sair = true;
                    return true;
                case 1:
                    sair = true;
                    break;

                case 10:
                    if ( aluno.temTreinoCadastrado()) {
                        MenuTreino.exibirTreino(aluno.getTreino());
                    } else {
                        System.out.println("\nVocê não possui treino cadastrado");
                    }
                    break;
                case 11:
                    aluno.setSubstituirTreino(true);
                    System.out.println("\nSolictação de treino confirmada");
                    exibirAluno(aluno);
                    break;
                default:
                    System.err.println("Opção inválida !");
                    break;
            }

        } while (!sair);

        return false;

    }

    public static void exibirOpcaoAlteracao(AlunoController controller, Aluno aluno) throws Exception {

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
                    exibirAlteracao(controller,aluno);
                    sair = true;
                    break;
                case 2:
                    exibirDeletar(controller, aluno);
                    sair = true;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        } while (!sair);
    }

    public static void exibirDeletar(AlunoController controller, Aluno aluno) throws Exception {
        if (aluno == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja deletar o Aluno?");
            exibirAluno(aluno);

            if (MenuAdministrador.exibirConfirmar()) {
                controller.deletar(aluno.getId());
                System.out.println("Aluno Excluido:");
            } else {
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static Aluno exibirBuscar(AlunoController controlle) {
        Entrada.limparBuffer();
        System.out.println("Informar cpf do aluno");
        return controlle.buscaCpf(Entrada.entradaCPF());
    }

    public static void exibirCadastro(AlunoController controller, FactoryClasses factory) throws Exception {
        Entrada.limparBuffer();
        System.out.println("\n\n");
        System.out.println("1/ Cadastro de Aluno");
        System.out.println("Nome:");
        String nome = Entrada.entradaString();
        System.out.println("Digite o CPF:");
        String cpf = Entrada.entradaString();
        System.out.println("Digite Endereço:");
        String endereco = Entrada.entradaString();
        System.out.println("Digite o celular:");
        String celular = Entrada.entradaString();
        System.out.println("Digite o email:");
        String email = Entrada.entradaString();
        System.out.println("Digite o Sexo:");
        String sexo = Entrada.entradaString();
        System.out.println("Digite a Senha:");
        String senha = Entrada.entradaString();
        System.out.println("Digite a Data de Nascimento:");
        LocalDate dataNascimento = LocalDate.parse(Entrada.entradaData(), Entrada.getFormatoData());

        System.out.println("Você deseja cadastrar o Aluno?" + nome);

        if (MenuAluno.exibirConfirmar()) {
            controller.cadastrar(factory.criarAluno(0, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento,
                    false, null, 10, null,
                    null));
            System.out.println("Aluno Cadastrado:");
        } else {
            System.out.println("Operação Cancelada.");
        }
    }

    public static void exibirCadastroTreinoDoAluno(TreinoController controller, Aluno aluno) {

        Treino busca;
        int duracaoTreino;
        String aquecimento, sugestaoDiasTreino;
        boolean sair = false;

        System.out.println("\n\n");
        exibirAluno(aluno);
        System.out.println("Cadastro de Treino");
        System.out.println("Duração do trieno em dias entre 10 e 90 dias");
        duracaoTreino = Entrada.entradaMinMax(10, 90);
        System.out.println("Descrição de aquecimento");
        Entrada.limparBuffer();
        aquecimento = Entrada.entradaString();

        do {
            System.out.println("Treinos disponiveis");
            MenuTreino.exibirTreinos(controller.getTreinos());

            busca = MenuTreino.exibirBuscar(controller);

            if (busca == null) {
                System.out.println("Treino não encontrado, Deseja buscar novamente.");
                sair = !exibirConfirmar();
            } else {
                System.out.println("Adicioanr o treino?");
                MenuTreino.exibirTreino(busca);
                if (exibirConfirmar()) {
                    aluno.setTreino(busca);
                } else {
                    System.out.println("Operação cancelada, Treino não foi adicionado:");
                }
                sair = true;
            }
        } while (!sair);

        System.out.println("Descrição de dias de treino");
        sugestaoDiasTreino = Entrada.entradaString();
    }

    public static void exibirTreinoDoAluno(Aluno aluno) {
        Entrada.limparBuffer();
        System.out.println("\n\n");
        exibirAluno(aluno);
        MenuTreino.exibirTreino(aluno.getTreino());
    }

    public static void exibirAlteracao(AlunoController controller,Aluno aluno) throws Exception {
        if (aluno == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja alterar o Aluno?");
            exibirAluno(aluno);

            if (exibirConfirmar()) {
                Entrada.limparBuffer();
                System.out.println("\n\n");
                System.out.println("Alterar o Nome:");
                aluno.setNome(Entrada.entradaString());
                System.out.println("Alterar o CPF:");
                aluno.setCpf(Entrada.entradaString());
                System.out.println("Altera o Endereço:");
                aluno.setEndereco(Entrada.entradaString());
                System.out.println("Altera o Celular:");
                aluno.setCelular(Entrada.entradaString());
                System.out.println("Altera o Email:");
                aluno.setEmail(Entrada.entradaString());
                System.out.println("Altera o Sexo:");
                aluno.setSexo(Entrada.entradaString());
                System.out.println("Altera a Senha:");
                aluno.setSenha(Entrada.entradaString());
                System.out.println("Altera a Data de Nascimento:");
                aluno.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.getFormatoData()));
                exibirAluno(aluno);
                controller.salvarDados();
            } else {
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static void exibirAluno(Aluno aluno) {
        System.out.println("Dados do Aluno");
        System.out.println("CPF :" + aluno.getCpf() + ", Nome: " + aluno.getNome() + ", Substituir Treino: "
                + ((aluno.isSubstituirTreino()) ? "Sim" : "Não"));
    }

    public static void exibirListaDeUsuarios(AlunoController controller) {
        System.out.println("Lista de Alunos Cadastrados");
        for (Aluno aluno : controller.getAlunos()) {
            System.out.println("CPF :" + aluno.getCpf() + ", Nome: " + aluno.getNome() + ", Substituir Treino: "
                    + ((aluno.isSubstituirTreino()) ? "Sim" : "Não"));
        }
        System.out.println("----------------\n\n");
    }

}
