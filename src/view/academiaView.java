package view;

import java.util.ArrayList;

import controller.AdministradorController;
import controller.AlunoController;
import controller.ProfessorController;
import controller.TreinoController;
import model.Administrador;
import util.Entrada;
import model.Aluno;
import model.Professor;
import model.Treino;

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

public class AcademiaView {
    public static void main(String[] args) throws Exception {

        TreinoController controllerTreino = new TreinoController(new ArrayList<Treino>());
        AlunoController controllerAluno = new AlunoController(new ArrayList<Aluno>());
        ProfessorController controllerProfessor = new ProfessorController(new ArrayList<Professor>());
        AdministradorController controllerAdministrador = new AdministradorController(new ArrayList<Administrador>());
        
        controllerAdministrador
                .cadastrar(new Administrador(0, "admin", "admin", null, null, null, null, "admin", null));
        controllerProfessor
                .cadastrar(new Professor(0, "professor", "professor", null, null, null, null, "professor", null));
        controllerAluno.cadastrar(
                new Aluno(0, "aluno", "aluno", null, null, null, null, "aluno", null, false, null, 10, null, null));

        System.out.println(controllerProfessor); 
        System.out.println(controllerAluno); 

        System.exit(0);


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
                    throw new Exception(e+"Falha na busca de administrador");
                }
                try {
                    professor = controllerProfessor.buscaCpf(cpf);
                } catch (Exception e) {
                    throw new Exception(e+"Falha na busca de professor");
                }
                try {
                    aluno = controllerAluno.buscaCpf(cpf);
                } catch (Exception e) {
                    throw new Exception(e+"Falha na busca de aluno");
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
                    System.out.println("Usuario Não encontrador, deseja efetuar novo login:");
                    sairOpcao = !MenuPadrao.confimar();
                    sairPrincipal = sairOpcao;
                    Entrada.limparBuffer();
                }

            } while (!sairOpcao);

            switch (nivelAcesso) {
                case 1:
                    System.out.println("\n\nSeja Bem Vindo " + aluno.getNome());
                    sairPrincipal = MenuAluno.menuPrincipal(aluno);
                    break;
                case 2:
                    System.out.println("\n\nSeja Bem Vindo " + professor.getNome());
                    sairPrincipal = MenuProfessor.menuPrincipal(controllerTreino, controllerAluno);
                    break;
                case 3:
                    System.out.println("\n\nSeja Bem Vindo " + administrador.getNome());
                    sairPrincipal = MenuAdminstrador.menuPrincipal(controllerAluno, controllerProfessor,
                            controllerAdministrador);
                    break;
                default:
                    sairPrincipal = true;
                    break;
            }

            if (!sairPrincipal)
                Entrada.limparBuffer();

        } while (!sairPrincipal);
        System.out.println("SISTEMA ENCERRADO");

    }
}
