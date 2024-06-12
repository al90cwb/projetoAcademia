package view;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.AdministradorController;
import controller.AlunoController;
import controller.ProfessorController;
import controller.TreinoController;
import model.Administrador;
import model.Exercicio;
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

        String cpf, senha;
        Professor professor = null;
        Aluno aluno = null;
        Administrador administrador = null;
        int nivelAcesso = 0;
        boolean sairPrincipal = false;

        boolean modoTeste = true;
        if (modoTeste) {

            for (int i = 0; i < 5; i++) {
                controllerProfessor.cadastrar(
                        new Professor(0, "prof" + i, "cpf" + i, "endereco" + i, "celular" + i, "email" + i, "sexo" + i,
                                "senha" + i, LocalDate.parse("10/10/198" + i, Entrada.getFormatoData())));
            }

            for (int i = 0; i < 5; i++) {
                controllerAdministrador.cadastrar(new Administrador(0, "admin" + i, "cpf" + i, "endereco" + i,
                        "celular" + i, "email" + i, "sexo" + i,
                        "senha" + i, LocalDate.parse("10/10/198" + i, Entrada.getFormatoData())));
            }

            ArrayList<Exercicio> exerciciosPerna1 = new ArrayList<Exercicio>();
            for (int i = 0; i < 5; i++) {
                exerciciosPerna1.add(new Exercicio("perna " + i, "1min", "3x10 a 15"));
            }
            controllerTreino.cadastrarTreino(new Treino("Treino Perna", "perna", exerciciosPerna1));

            ArrayList<Exercicio> exerciciosPeitoCosta = new ArrayList<Exercicio>();
            for (int i = 0; i < 5; i++) {
                exerciciosPeitoCosta.add(new Exercicio("peito costas " + i, "1min", "3x10 a 15"));
            }
            controllerTreino.cadastrarTreino(new Treino("Treino Peito Costas", "peito", exerciciosPeitoCosta));

            ArrayList<Exercicio> exerciciosOmbro = new ArrayList<Exercicio>();
            for (int i = 0; i < 5; i++) {
                exerciciosOmbro.add(new Exercicio("ombro " + i, "1min", "3x10 a 15"));
            }
            controllerTreino.cadastrarTreino(new Treino("Treino ombro", "ombro", exerciciosOmbro));

            ArrayList<Exercicio> exerciciosBicepsTriceps = new ArrayList<Exercicio>();
            for (int i = 0; i < 5; i++) {
                exerciciosBicepsTriceps.add(new Exercicio("Biceps Triceps " + i, "1min", "3x10 a 15"));
            }
            controllerTreino.cadastrarTreino(new Treino("Treino Biceps Triceps", "triceps", exerciciosBicepsTriceps));

            ArrayList<Exercicio> exerciciosIniciante = new ArrayList<Exercicio>();
            for (int i = 0; i < 5; i++) {
                exerciciosIniciante.add(new Exercicio("Biceps Triceps " + i, "1min", "3x10 a 15"));
            }
            controllerTreino.cadastrarTreino(new Treino("Iniciante", "todos", exerciciosIniciante));

            controllerTreino.buscaTreinoId(4);

            controllerAluno.cadastrar(new Aluno(0, "aluno1", "cpf1", "endereco1", "celular1", "email", "sexo",
                    "senha1", LocalDate.parse("10/10/1981", Entrada.getFormatoData()), false,
                    controllerTreino.buscaTreinoId(0), 10, "10min esteira", "Segunda Quarta Sexta"));

            controllerAluno.cadastrar(new Aluno(0, "aluno2", "cpf2", "endereco2", "celular2", "email", "sexo",
                    "senha2", LocalDate.parse("10/10/1990", Entrada.getFormatoData()), false,
                    controllerTreino.buscaTreinoId(1), 10, "10min esteira", "Segunda a Sexta"));

            controllerAluno.cadastrar(new Aluno(0, "aluno3", "cpf3", "endereco3", "celular3", "email", "sexo",
                    "senha3", LocalDate.parse("10/10/1995", Entrada.getFormatoData()), false,
                    controllerTreino.buscaTreinoId(2), 10, "10min esteira", "Segunda a Sexta"));
        }

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

                administrador = controllerAdministrador.buscaCpf(cpf);
                professor = controllerProfessor.buscaCpf(cpf);
                aluno = controllerAluno.buscaCpf(cpf);

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
