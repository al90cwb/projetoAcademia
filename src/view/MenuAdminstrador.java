package view;


import java.time.LocalDate;

import controller.AdministradorController;
import controller.AlunoController;
import controller.ProfessorController;
import model.Administrador;
import model.Aluno;
import model.Professor;
import util.Entrada;

public abstract class MenuAdminstrador extends MenusStandard  {
 
    public static void opcoes() {
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


    public static boolean menuPrincipal(AlunoController controllerAluno, ProfessorController controllerProfessor, AdministradorController controllerAdministrador){

        int opcao = 0;
        boolean sair = false;
        Aluno alunoBusca;
        Professor professorBusca;
        Administrador administradorBusca;

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
                case 10:MenuAluno.cadastro(controllerAluno);
                    sair = false;
                    break;
                case 11:
                    MenuAluno.verAlunos(controllerAluno);
                    sair = false;
                break;
                case 12:
                    alunoBusca = MenuAluno.buscar(controllerAluno);
                    MenuAluno.verAluno(alunoBusca);
                    MenuAluno.opcaoAlteracao(controllerAluno, alunoBusca);
                    sair = false;
                break;


                case 20:MenuProfessor.cadastro(controllerProfessor);
                    sair = false;
                    break;
                case 21:
                    MenuProfessor.verProfessores(controllerProfessor);
                    sair = false;
                break;
                case 22:
                    professorBusca = MenuProfessor.buscar(controllerProfessor);
                    MenuProfessor.verProfessor(professorBusca);
                    MenuProfessor.opcaoAlteracao(controllerProfessor, professorBusca);
                    sair = false;
                break;

                case 30:
                    cadastro(controllerAdministrador);
                    sair = false;
                break;
                case 31:
                    verAdministradores(controllerAdministrador);
                    sair = false;
                break;
                case 32:
                    administradorBusca = buscar(controllerAdministrador);
                    verAdministrador(administradorBusca);
                    opcaoAlteracao(controllerAdministrador, administradorBusca);
                    sair = false;
                break;


                default:
                    sair = false;
                    break;
            }

        } while (!sair);

        return false;

    }


    public static void opcaoAlteracao(AdministradorController controller, Administrador administrador){

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
                sair= true;
                break;
                case 1:
                alterar(administrador);
                sair= true;
                break;
                case 2:
                deletar(controller,administrador);
                sair= true;
                break;
                default:
                System.out.println("Opção invalida");
                sair= false;
                break;
            } 
        } while (!sair);
    }


    public static void deletar(AdministradorController controller, Administrador administrador){
        if (administrador == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja deletar o administrador?");
            verAdministrador(administrador);

            if (MenuAdminstrador.confimar()) {
                controller.deletar(administrador.getId());
                System.out.println("administrador Excluido:");
            } else {
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static Administrador buscar(AdministradorController controller){
        Entrada.in.nextLine();
        System.out.println("Informar cpf do Administrador");
        return controller.buscaCpf(Entrada.entradaCPF());
    }

    public static void cadastro(AdministradorController controller){
        Professor cadastro= new Professor();

        Entrada.in.nextLine();
        System.out.println("\n\n");
        System.out.println("1/ Cadastro de Administrador");
        System.out.println("Nome:");
        cadastro.setNome(Entrada.entradaString());
        System.out.println("Digite o CPF:");
        cadastro.setCpf(Entrada.entradaString());
        System.out.println("Digite Endereço:");
        cadastro.setEndereco(Entrada.entradaString());
        System.out.println("Digite o celular:");
        cadastro.setCelular(Entrada.entradaString());
        System.out.println("Digite o email:");
        cadastro.setEmail(Entrada.entradaString());
        System.out.println("Digite o Sexo:");
        cadastro.setSexo(Entrada.entradaString());
        System.out.println("Digite a Senha:");
        cadastro.setSenha(Entrada.entradaString());
        System.out.println("Digite a Data de Nascimento:");
        cadastro.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));

        System.out.println("Você deseja cadastrar o Professor?");
        MenuProfessor.verProfessor(cadastro);

        if (MenuAdminstrador.confimar()) {
            controller.cadastrar(new Administrador(0, cadastro.getNome(), cadastro.getCpf(), cadastro.getEndereco(), cadastro.getCelular(), cadastro.getEmail(),
            cadastro.getSexo(), cadastro.getSenha(), cadastro.getDataNascimento()));
            System.out.println("Professor Cadastrado:");
        } else {
             System.out.println("Professor Cancelada.");
        }

    }

    public static void alterar(Administrador administrador){
        if (administrador == null) {
            System.out.println("Professor Não encontrado");
        } else {
            System.out.println("Você deseja alterar o administrador?");
            verAdministrador(administrador);

            if (MenuAluno.confimar()) {
                Entrada.in.nextLine();
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
                administrador.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
                verAdministrador( administrador);
            }else{
                System.out.println("Operação Cancelada, Administrador não foi deletado:");
            }
        }
    }

    public static void verAdministrador(Administrador administrador){
        System.out.println("Dados do Administrador");
        System.out.println("CPF :"+ administrador.getCpf() + ", Nome: " + administrador.getNome());
    }

    public static void verAdministradores(AdministradorController controller){
        System.out.println("Lista de Administrador Cadastrados");
        for (Administrador administrador : controller.getAdministradores()) {
            System.err.println("CPF :"+ administrador.getCpf() + ", Nome: " + administrador.getNome());
        }
        System.out.println("----------------\n\n");
    }


}
