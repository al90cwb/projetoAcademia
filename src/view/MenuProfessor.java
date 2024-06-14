package view;

import java.time.LocalDate;

import controller.AlunoController;
import controller.ProfessorController;
import controller.TreinoController;
import model.Aluno;
import model.FactoryClasses;
import model.Professor;
import util.Entrada;

public abstract class MenuProfessor extends MenuPadrao {

    public static void exibirOpcoes() {
        System.out.println("\n\n");
        System.out.println("Menu Professor:");
        System.out.println("0 - FECHAR SISTEMA");
        System.out.println("1 - LOGOUT");

        System.out.println("\n10 - MENU TREINO");
        System.out.println("11 - LISTA DE ALUNOS");
        System.out.println("12 - BUSCAR ALUNO");

    }

    public static boolean exibirMenuPrincipal(TreinoController controllerTreino, AlunoController controllerAluno,
            FactoryClasses factory) throws Exception {

        int opcao = 0;
        boolean sair = false;
        Aluno alunoBusca;

        do {

            exibirOpcoes();
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
                    MenuTreino.exibirCadastro(controllerTreino, factory);
                    sair = false;
                    break;
                case 11:
                    System.out.println("Lista de alunos Cadastrados");
                    MenuAluno.exibirListaDeUsuarios(controllerAluno);
                    break;
                case 12:
                    alunoBusca = MenuAluno.exibirBuscar(controllerAluno);
                    MenuAluno.exibirAluno(alunoBusca);
                    MenuTreino.exibirTreino(alunoBusca.getTreino());
                    System.out.println("Deseja alterar treino?");
                    if (exibirConfirmar())
                        MenuAluno.exibirCadastroTreinoDoAluno(controllerTreino, alunoBusca);

                    sair = false;
                    break;

                default:
                    sair = false;
                    break;
            }

        } while (!sair);

        return false;

    }

    public static void exibirOpcaoAlteracao(ProfessorController controller, Professor professor) throws Exception {

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
                    exibirAlteracao(professor);
                    sair = true;
                    break;
                case 2:
                    exibirDeletar(controller, professor);
                    sair = true;
                    break;
                default:
                    System.out.println("Opção invalida");
                    sair = false;
                    break;
            }
        } while (!sair);
    }

    public static void exibirDeletar(ProfessorController controller, Professor professor) throws Exception {
        if (professor == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja deletar o Professor?");
            MenuProfessor.exibirProfessor(professor);

            if (MenuProfessor.exibirConfirmar()) {
                controller.deletar(professor.getId());
                System.out.println("Professor Excluido:");
            } else {
                System.out.println("Operação Cancelada, Professor não foi deletado:");
            }
        }
    }

    public static Professor buscar(ProfessorController controlle) {
        Entrada.limparBuffer();
        System.out.println("Informar cpf do aluno");
        return controlle.buscaCpf(Entrada.entradaCPF());
    }

    public static void cadastro(ProfessorController controller, FactoryClasses factory) throws Exception {

        Entrada.limparBuffer();
        System.out.println("\n\n");
        System.out.println("1/ Cadastro de Professor");
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

        System.out.println("Você deseja cadastrar o Professor?" + nome);

        if (MenuProfessor.exibirConfirmar()) {
            controller.cadastrar(
                    factory.criarProfessor(0, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento));
            System.out.println("Professor Cadastrado:");
        } else {
            System.out.println("Professor Cancelada.");
        }

    }

    public static void exibirAlteracao(Professor professor) {
        if (professor == null) {
            System.out.println("Professor Não encontrado");
        } else {
            System.out.println("Você deseja alterar o Professor?");
            MenuProfessor.exibirProfessor(professor);

            if (MenuAluno.exibirConfirmar()) {
                Entrada.limparBuffer();
                System.out.println("\n\n");
                System.out.println("Alterar o Nome:");
                professor.setNome(Entrada.entradaString());
                System.out.println("Alterar o CPF:");
                professor.setCpf(Entrada.entradaString());
                System.out.println("Altera o Endereço:");
                professor.setEndereco(Entrada.entradaString());
                System.out.println("Altera o Celular:");
                professor.setCelular(Entrada.entradaString());
                System.out.println("Altera o Email:");
                professor.setEmail(Entrada.entradaString());
                System.out.println("Altera o Sexo:");
                professor.setSexo(Entrada.entradaString());
                System.out.println("Altera a Senha:");
                professor.setSenha(Entrada.entradaString());
                System.out.println("Altera a Data de Nascimento:");
                professor.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.getFormatoData()));
                exibirProfessor(professor);
            } else {
                System.out.println("Operação Cancelada, Professor não foi deletado:");
            }
        }
    }

    public static void exibirProfessor(Professor professor) {
        System.out.println("Dados do Professor");
        System.out.println("CPF :" + professor.getCpf() + ", Nome: " + professor.getNome());
    }

    public static void exibirProfessores(ProfessorController controller) {
        System.out.println("Lista de Professores Cadastrados");
        for (Professor professor : controller.getProfessores()) {
            System.err.println("CPF :" + professor.getCpf() + ", Nome: " + professor.getNome());
        }
        System.out.println("----------------\n\n");
    }

}
