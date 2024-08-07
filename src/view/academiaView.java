package view;

import controller.AdministradorController;
import controller.AlunoController;
import controller.FactoryController;
import controller.ProfessorController;
import controller.TreinoController;
import model.Administrador;
import model.Aluno;
import model.FactoryClasses;
import model.Professor;
import util.Entrada;
import util.Log;

/**
 * A classe {@code AcademiaView} é responsável por exibir informações sobre
 * professores, alunos, e adiministradores
 * e coletar entrada do usuário para operações relacionadas aos professores,
 * alunos, e adiministradores
 * utilizando o console
 * <p>
 * Esta classe faz parte da camada de visualização na arquitetura MVC.
 * </p>
 * 
 * @version 1.0
 * @since 2024-06-07
 */

public class academiaView {
    public static void main(String[] args) throws Exception {

        FactoryController factoryController = new FactoryController();
        FactoryClasses factoryClasses = new FactoryClasses();

        AlunoController controllerAluno = factoryController.ciarAlunoController();
        TreinoController controllerTreino = factoryController.criarTreinoController();
        ProfessorController controllerProfessor = factoryController.criarProfessorController();
        AdministradorController controllerAdministrador = factoryController.criarAdministradorController();

        String cpf, senha;
        Professor professor = null;
        Aluno aluno = null;
        Administrador administrador = null;
        int nivelAcesso = 0;
        boolean sairPrincipal = false;

        do {
            System.out.println("\n\nSistema de Academia-------------------------");

            boolean sairOpcao = false;
            do {

                professor = null;
                administrador = null;
                aluno = null;
                nivelAcesso = 0;

                System.out.println("Login - Informe CPF");
                cpf = Entrada.entradaString();
                System.out.println("Informe senha");
                senha = Entrada.entradaString();

                try {
                    administrador = controllerAdministrador.buscaCpf(cpf);
                } catch (Exception e) {
                    throw new Exception(e + "Falha na busca de administrador");
                }
                try {
                    professor = controllerProfessor.buscaCpf(cpf);
                } catch (Exception e) {
                    throw new Exception(e + "Falha na busca de professor");
                }
                try {
                    aluno = controllerAluno.buscaCpf(cpf);
                } catch (Exception e) {
                    throw new Exception(e + "Falha na busca de aluno");
                }

                if (administrador != null) {
                    if (administrador.getSenha().equals(senha)) {
                        nivelAcesso = 3;
                        sairOpcao = true;
                    }
                }
                if (professor != null) {
                    if (professor.getSenha().equals(senha)) {
                        nivelAcesso = 2;
                        sairOpcao = true;
                    }
                }

                if (aluno != null) {
                    if (aluno.getSenha().equals(senha)) {
                        nivelAcesso = 1;
                        sairOpcao = true;
                    }
                }

                if (nivelAcesso == 0) {
                    Log.gravar("Usuario Não encontrador");
                    System.err.println("Usuario Não encontrador, deseja efetuar novo login");
                    sairOpcao = !MenuPadrao.exibirConfirmar();
                    sairPrincipal = sairOpcao;
                    Entrada.limparBuffer();
                }

            } while (!sairOpcao);

            switch (nivelAcesso) {
                case 1:
                    Log.gravar("Login " + aluno.getNome());
                    System.out.println("\n\nSeja Bem Vindo " + aluno.getNome());
                    sairPrincipal = MenuAluno.exibirMenuPrincipal(aluno,controllerAluno);
                    break;
                case 2:
                    Log.gravar("Login " + professor.getNome());
                    System.out.println("\n\nSeja Bem Vindo " + professor.getNome());
                    sairPrincipal = MenuProfessor.exibirMenuPrincipal(controllerTreino, controllerAluno,
                            factoryClasses);
                    break;
                case 3:
                    Log.gravar("Login " + administrador.getNome());
                    System.out.println("\n\nSeja Bem Vindo " + administrador.getNome());
                    sairPrincipal = MenuAdministrador.exibirMenuPrincipal(controllerAluno, controllerProfessor,
                            controllerAdministrador, factoryClasses);
                    break;
                default:
                    sairPrincipal = true;
                    Log.gravar("Sistema Encerrado");
                    break;
            }

            if (!sairPrincipal)
                Entrada.limparBuffer();

        } while (!sairPrincipal);
        System.out.println("SISTEMA ENCERRADO");

    }
}
