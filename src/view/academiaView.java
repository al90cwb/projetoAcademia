package view;

import java.util.ArrayList;

import controller.ExercicioController;
import controller.AdministradorController;
import controller.AlunoController;
import controller.ProfessorController;
import model.Administrador;
import model.Exercicio;
import util.Entrada;
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
        
        ExercicioController controllerExecicio = new ExercicioController(new ArrayList<Exercicio>());
        AlunoController controllerAluno = new AlunoController(new ArrayList<Aluno>());
        ProfessorController controllerProfessor = new ProfessorController(new ArrayList<Professor>());
        AdministradorController controllerAdministrador = new AdministradorController(new ArrayList<Administrador>());

        controllerAdministrador.cadastrar(new Administrador(0, "admin", "admin", null, null, null, null, "admin", null));
        controllerProfessor.cadastrar(new Professor(0, "professor", "professor", null, null, null, null, "professor", null));
        controllerAluno.cadastrar(new Aluno(0, "aluno", "aluno", null, null, null, null, "aluno", null, null, null));
        
        String cpf, senha;
        Professor professor = null;
        Aluno aluno = null;
        Administrador administrador = null;
        int nivelAcesso=0;//0 sem acesso,1 aluno, 2 professor ,3 administrador


        boolean modoTeste = true;
        if (modoTeste) {
            for (int i = 0; i < 25; i++) {
                controllerExecicio.cadastrarExercicio(new Exercicio("Exercicio" + i, i + "min", "10x"));
            }
        }

        System.out.println("Sistema de Academia-------------------------");
        
        boolean sairOpcao= false;
        do{

            professor = null;
            administrador = null;
            aluno = null;
            nivelAcesso = 0;

            
            System.out.println( "Login - Informe CPF");
            cpf =  Entrada.entradaString();
            System.out.println( "Informe senha");
            senha =  Entrada.entradaString();

            administrador = controllerAdministrador.buscaCpf(cpf);
            professor = controllerProfessor.buscaCpf(cpf);
            aluno = controllerAluno.buscaCpf(cpf);
            
            if (administrador!= null  ){
                if (administrador.getSenha().equals(senha)){
                    nivelAcesso = 3;
                    sairOpcao = true;
                }
            }
            if (professor!= null  ){
                if (professor.getSenha().equals(senha)){
                    nivelAcesso = 2;
                    sairOpcao = true;
                }
            }
            
            if (aluno!= null  ){
                if (aluno.getSenha().equals(senha)){
                    nivelAcesso = 1;
                    sairOpcao = true;
                }
            }
    
            if (nivelAcesso==0){
                System.out.println("Usuario Não encontrador, deseja efetuar novo login:");
                sairOpcao = !MenusStandard.confimar();
                Entrada.in.nextLine();
            }


        }while(!sairOpcao);


        System.out.println( "Nivel de acesso " + nivelAcesso);

        switch (nivelAcesso) {
            case 1:

                    System.out.println( aluno);
                
                break;
                
            case 2:

                    System.out.println( professor);
                
            break;
            case 3:

                    System.out.println( administrador);
                
            break;
            case 0:
                    System.out.println( "SISTEMA ENCERRADO");
                
                break;
        
            default:
                break;
        }
            



        
    }
}
