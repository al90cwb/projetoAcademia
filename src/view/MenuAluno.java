package view;

import java.time.LocalDate;

import controller.AlunoController;
import controller.TreinoController;
import model.Aluno;
import model.FactoryClasses;
import model.Treino;
import util.Entrada;

public abstract class MenuAluno extends MenuPadrao implements iOpcoesPadraoMenu {

    public static void opcoes() {
        System.out.println("\n\n");
        System.out.println("Menu Aluno:");
        System.out.println("0 - FECHAR SISTEMA");
        System.out.println("1 - LOGOUT");

        System.out.println("\n10 - VISUALIZAR TREINO");
        System.out.println("11 - SOLICTAR TREINO NOVO");
    }

    public static boolean menuPrincipal(Aluno aluno) {

        int opcao = 0;
        boolean sair = false;

        do {

            opcoes();
            opcao = Entrada.entradaInt();
            sair = false;

            switch (opcao) {
                case 0:
                    sair = true;
                    return true;
                case 1:
                    sair = true;
                    break;

                case 10:
                    if (aluno.getTreino() == null) {
                        System.out.println("\nVocê não possui treino cadastrado");
                    } else {
                        MenuTreino.verTreino(aluno.getTreino());
                    }
                    sair = false;
                    break;
                case 11:
                    aluno.setSubstituirTreino(true);
                    System.out.println("\nSolictação de treino confirmada");
                    verUsuario(aluno);
                    sair = false;
                    break;

                default:
                    sair = false;
                    break;
            }

        } while (!sair);

        return false;

    }

    public static void opcaoAlteracao(AlunoController controller, Aluno aluno) throws Exception {

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
                    alterar(aluno);
                    sair = true;
                    break;
                case 2:
                    deletar(controller, aluno);
                    sair = true;
                    break;
                default:
                    System.out.println("Opção invalida");
                    sair = false;
                    break;
            }
        } while (!sair);
    }

    public static void deletar(AlunoController controller, Aluno aluno) throws Exception {
        if (aluno == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja deletar o Aluno?");
            verUsuario(aluno);

            if (MenuAdminstrador.confimar()) {
                controller.deletar(aluno.getId());
                System.out.println("Aluno Excluido:");
            } else {
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static Aluno buscar(AlunoController controlle) {
        Entrada.limparBuffer();
        System.out.println("Informar cpf do aluno");
        return controlle.buscaCpf(Entrada.entradaCPF());
    }

    public static void cadastro(AlunoController controller, FactoryClasses factory) throws Exception {
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

        if (MenuAluno.confimar()) {
            controller.cadastrar(factory.ciarAluno(0, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento,
                    false, null, 10, null,
                    null));
            System.out.println("Aluno Cadastrado:");
        } else {
            System.out.println("Operação Cancelada.");
        }
    }

    public static void cadastroTreino(TreinoController controller, Aluno aluno) {

        Treino busca;
        int duracaoTreino;
        String aquecimento, sugestaoDiasTreino;
        boolean sair = false;

        System.out.println("\n\n");
        verUsuario(aluno);
        System.out.println("Cadastro de Treino");
        System.out.println("Duração do trieno em dias entre 10 e 90 dias");
        duracaoTreino = Entrada.entradaMinMax(10, 90);
        System.out.println("Descrição de aquecimento");
        Entrada.limparBuffer();
        aquecimento = Entrada.entradaString();

        do {
            System.out.println("Treinos disponiveis");
            MenuTreino.verTreinos(controller.getTreinos());

            busca = MenuTreino.buscar(controller);

            if (busca == null) {
                System.out.println("Treino não encontrado, Deseja buscar novamente.");
                sair = !confimar();
            } else {
                System.out.println("Adicioanr o treino?");
                MenuTreino.verTreino(busca);
                if (confimar()) {
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

    public static void verTreino(Aluno aluno) {
        Entrada.limparBuffer();
        System.out.println("\n\n");
        verUsuario(aluno);
        MenuTreino.verTreino(aluno.getTreino());
    }

    public static void alterar(Aluno aluno) {
        if (aluno == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja alterar o Aluno?");
            verUsuario(aluno);

            if (confimar()) {
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
                verUsuario(aluno);
            } else {
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static void verUsuario(Aluno aluno) {
        System.out.println("Dados do Aluno");
        System.out.println("CPF :" + aluno.getCpf() + ", Nome: " + aluno.getNome() + ", Substituir Treino: "
                + ((aluno.isSubstituirTreino()) ? "Sim" : "Não"));
    }

    public static void verListaDeUsuarios(AlunoController controller) {
        System.out.println("Lista de Alunos Cadastrados");
        for (Aluno aluno : controller.getAlunos()) {
            System.out.println("CPF :" + aluno.getCpf() + ", Nome: " + aluno.getNome() + ", Substituir Treino: "
                    + ((aluno.isSubstituirTreino()) ? "Sim" : "Não"));
        }
        System.out.println("----------------\n\n");
    }

}
