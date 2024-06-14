package view;

import java.time.LocalDate;

import controller.AdministradorController;
import controller.AlunoController;
import controller.ProfessorController;
import model.Administrador;
import model.Aluno;
import model.FactoryClasses;
import model.Professor;
import util.Entrada;

/**
 * A classe {@code MenuAdministrador} exibe opções de menu e executa operações
 * relacionadas aos administradores, alunos e professores.
 * <p>
 * Esta classe faz parte da camada de visualização na arquitetura MVC.
 * </p>
 *
 * @version 1.0
 * @since 2024-06-07
 */

public abstract class MenuAdministrador extends MenuPadrao {

    public static void exibirOpcoes() {
        System.out.println("\n\n");
        System.out.println("Menu Administrador:");
        System.out.println("0 - FECHAR SISTEMA");
        System.out.println("1 - LOGOUT");
        System.out.println("\n10 - CADASTRO DE ALUNO");
        System.out.println("11 - VER ALUNOS CADASTRADOS");
        System.out.println("12 - BUSCAR ALUNO - DELETAR/ALTERAR");
        System.out.println("\n20 - CADASTRO DE PROFESSOR");
        System.out.println("21 - VER PROFESSORES CADASTRADOS");
        System.out.println("22 - BUSCAR PROFESSORES - DELETAR/ALTERAR");
        System.out.println("\n30 - CADASTRO DE ADMINISTRADORES");
        System.out.println("31 - VER ADMINISTRADORES CADASTRADOS");
        System.out.println("32 - BUSCAR ADMINISTRADORES - DELETAR/ALTERAR");
    }

    public static boolean exibirMenuPrincipal(AlunoController controllerAluno, ProfessorController controllerProfessor,
            AdministradorController controllerAdministrador, FactoryClasses factory) throws Exception {

        int opcao = 0;
        boolean sair = false;
        Aluno alunoBusca;
        Professor professorBusca;
        Administrador administradorBusca;

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
                    MenuAluno.exibirCadastro(controllerAluno, factory);
                    sair = false;
                    break;
                case 11:
                    MenuAluno.exibirListaDeUsuarios(controllerAluno);
                    sair = false;
                    break;
                case 12:
                    alunoBusca = MenuAluno.exibirBuscar(controllerAluno);
                    MenuAluno.exibirAluno(alunoBusca);
                    MenuAluno.exibirOpcaoAlteracao(controllerAluno, alunoBusca);
                    sair = false;
                    break;

                case 20:
                    MenuProfessor.cadastro(controllerProfessor, factory);
                    sair = false;
                    break;
                case 21:
                    MenuProfessor.exibirProfessores(controllerProfessor);
                    sair = false;
                    break;
                case 22:
                    professorBusca = MenuProfessor.buscar(controllerProfessor);
                    MenuProfessor.exibirProfessor(professorBusca);
                    MenuProfessor.exibirOpcaoAlteracao(controllerProfessor, professorBusca);
                    sair = false;
                    break;

                case 30:
                    exibirCadastro(controllerAdministrador, factory);
                    sair = false;
                    break;
                case 31:
                    exibirAdministradores(controllerAdministrador);
                    sair = false;
                    break;
                case 32:
                    administradorBusca = exibirBuscar(controllerAdministrador);
                    exibirAdministrador(administradorBusca);
                    exibirOpcaoAlteracao(controllerAdministrador, administradorBusca);
                    sair = false;
                    break;

                default:
                    sair = false;
                    break;
            }

        } while (!sair);

        return false;

    }

    public static void exibirOpcaoAlteracao(AdministradorController controller, Administrador administrador)
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
                    exibirAlteracao(administrador);
                    sair = true;
                    break;
                case 2:
                    exibirDeletar(controller, administrador);
                    sair = true;
                    break;
                default:
                    System.out.println("Opção invalida");
                    sair = false;
                    break;
            }
        } while (!sair);
    }

    public static void exibirDeletar(AdministradorController controller, Administrador administrador) throws Exception {
        if (administrador == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja deletar o administrador?");
            exibirAdministrador(administrador);

            if (MenuAdministrador.exibirConfirmar()) {
                controller.deletar(administrador.getId());
                System.out.println("administrador Excluido:");
            } else {
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static Administrador exibirBuscar(AdministradorController controller) {
        Entrada.limparBuffer();
        System.out.println("Informar cpf do Administrador");
        return controller.buscaCpf(Entrada.entradaCPF());
    }

    public static void exibirCadastro(AdministradorController controller, FactoryClasses factory) throws Exception {

        Entrada.limparBuffer();
        System.out.println("\n\n");
        System.out.println("1/ Cadastro de Administrador");
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

        System.out.println("Você deseja cadastrar o Administrador?" + nome);
        if (MenuAdministrador.exibirConfirmar()) {
            controller.cadastrar(
                    factory.criarAdministrador(0, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento));
            System.out.println("Professor Cadastrado:");
        } else {
            System.out.println("Professor Cancelada.");
        }

    }

    public static void exibirAlteracao(Administrador administrador) {
        if (administrador == null) {
            System.out.println("Professor Não encontrado");
        } else {
            System.out.println("Você deseja alterar o administrador?");
            exibirAdministrador(administrador);

            if (MenuAluno.exibirConfirmar()) {
                Entrada.limparBuffer();
                System.out.println("\n\n");
                System.out.println("Alterar o Nome:");
                administrador.setNome(Entrada.entradaString());
                System.out.println("Alterar o CPF:");
                administrador.setCpf(Entrada.entradaString());
                System.out.println("Altera o Endereço:");
                administrador.setEndereco(Entrada.entradaString());
                System.out.println("Altera o Celular:");
                administrador.setCelular(Entrada.entradaString());
                System.out.println("Altera o Email:");
                administrador.setEmail(Entrada.entradaString());
                System.out.println("Altera o Sexo:");
                administrador.setSexo(Entrada.entradaString());
                System.out.println("Altera a Senha:");
                administrador.setSenha(Entrada.entradaString());
                System.out.println("Altera a Data de Nascimento:");
                administrador.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.getFormatoData()));
                exibirAdministrador(administrador);
            } else {
                System.out.println("Operação Cancelada, Administrador não foi deletado:");
            }
        }
    }

    public static void exibirAdministrador(Administrador administrador) {
        System.out.println("Dados do Administrador");
        System.out.println("CPF :" + administrador.getCpf() + ", Nome: " + administrador.getNome());
    }

    public static void exibirAdministradores(AdministradorController controller) {
        System.out.println("Lista de Administrador Cadastrados");
        for (Administrador administrador : controller.getAdministradores()) {
            System.err.println("CPF :" + administrador.getCpf() + ", Nome: " + administrador.getNome());
        }
        System.out.println("----------------\n\n");
    }

}
