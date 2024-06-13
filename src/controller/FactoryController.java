package controller;

import java.util.ArrayList;
import java.util.List;

import model.Administrador;
import model.Aluno;
import model.Professor;
import model.Treino;

public class FactoryController implements iControllerFactory {

    @Override
    public AlunoController ciarAlunoController() {
        List alunos = new ArrayList<Aluno>();
        return new AlunoController(alunos) ;
    }

    @Override
    public AdministradorController criarAdministradorController() {
        List administradores = new ArrayList<Administrador>();
        return new AdministradorController(administradores) ;
    }

    @Override
    public ProfessorController criarProfessorController() {
        List professores = new ArrayList<Professor>();
        return new ProfessorController(professores) ;
    }

    @Override
    public TreinoController criarTreinoController() {
        List treinos = new ArrayList<Treino>();
        return new TreinoController(treinos) ;
    }
    
}
