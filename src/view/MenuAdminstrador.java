package view;


import controller.AlunoController;
import controller.ProfessorController;
import model.Aluno;
import model.Professor;
import util.Entrada;

public abstract class MenuAdminstrador extends MenusStandard  {
 
    public static void opcoes() {
        System.out.println("\n\n");
        System.out.println("Menu Administrador:");
        System.out.println("0 - FECHAR SISTEMA");

        System.out.println("10 - CADASTRO DE ALUNO");
        System.out.println("11 - VER ALUNOS CADASTRADOS");
        System.out.println("12 - BUSCAR ALUNO - DELETAR/ALTERAR");

        System.out.println("20 - CADASTRO DE PROFESSOR");
        System.out.println("21 - VER PROFESSORES CADASTRADOS");
        System.out.println("22 - BUSCAR PROFESSORES - DELETAR/ALTERAR");

        System.out.println("30 - CADASTRO DE ADMINISTRADORES");
        System.out.println("31 - VER ADMINISTRADORES CADASTRADOS");
        System.out.println("32 - BUSCAR ADMINISTRADORES - DELETAR/ALTERAR");
    }


    public static void menuPrincipal(AlunoController controllerAluno, ProfessorController controllerProfessor){

        int opcao = 0;
        boolean sair = false;
        Aluno alunoBusca;
        Professor professorBusca;

        do {

            MenuAdminstrador.opcoes();
            opcao = Entrada.entradaInt();
            sair = false;

            switch (opcao) {
                case 0:
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



                default:
                    sair = false;
                    break;
            }

        } while (!sair);



        
        

    }





  


}
