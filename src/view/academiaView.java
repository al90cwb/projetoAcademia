package view;

import java.util.ArrayList;

import controller.ExercicioController;
import controller.SubtreinoController;
import controller.TreinoController;
import controller.AdministradorController;
import controller.AlunoController;
import controller.ProfessorController;
import model.Administrador;
import model.Exercicio;
import model.SubTreino;
import model.Treino;
import model.Aluno;
import model.Professor;

/**
 * Este programa é um exemplo simples de gestão de academia
 * Ele realiza operações de cadastro de usuarios e treinos
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public class academiaView {
    public static void main(String[] args) throws Exception {
        // DECLARAÇÃO DE VARIAVEIS
        // CONTROLLER
        ExercicioController controllerExecicio = new ExercicioController(new ArrayList<Exercicio>());
        SubtreinoController controllerSubtreino = new SubtreinoController(new ArrayList<SubTreino>());
        TreinoController controllerTreino = new TreinoController(new ArrayList<Treino>());
        AlunoController controllerAluno = new AlunoController(new ArrayList<Aluno>());
        ProfessorController controllerProfessor = new ProfessorController(new ArrayList<Professor>());
        AdministradorController controllerAdministrador = new AdministradorController(new ArrayList<Administrador>());

        // USUARIO DE INICIALIZAÇÃO
        Administrador adminBase = new Administrador(1, "admin", null, null, null, "admin", null, "admin", null);

        // INICIO DO SISTEMA-------------------------------------------------
        System.out.println("Sistema de Academia-------------------------");

        // CADASTRO BASICO DE EXERCICIOS MODO TESTE
        boolean modoTeste = true;
        if (modoTeste) {
            for (int i = 0; i < 25; i++) {
                controllerExecicio.cadastrarExercicio(new Exercicio("Exercicio" + i, i + "min", "10x"));
            }
        }

        // CADASTRO DE SUBTREINOS AUTOMATICO

        // CADASTRO DE TRIENOS AUTOMATICO

        // CADASTRO DE ALUNOS AUTOMATICO

        // CADASTRO DE PROFESSORES AUTOMATICO

        // CADASTRO DE ADMINAUTOMATICO

    }
}
