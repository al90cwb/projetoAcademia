package controller;



public interface iControllerFactory {
    AlunoController ciarAlunoController();
    ProfessorController criarProfessorController();
    AdministradorController criarAdministradorController();
    TreinoController criarTreinoController();
}
