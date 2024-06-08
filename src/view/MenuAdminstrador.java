package view;


import controller.AlunoController;
import model.Aluno;
import util.Entrada;

public abstract class MenuAdminstrador extends MenusStandard  {
 
    public static void opcoes() {
        System.out.println("\n\n");
        System.out.println("Menu Administrador:");
        System.out.println("0 - FECHAR SISTEMA");
        System.out.println("1 - CADASTRO DE ALUNO");
        System.out.println("2 - VER ALUNOS CADASTRADOS");
        System.out.println("3 - BUSCAR ALUNO - DELETAR/ALTERAR");
    }


    public static void menuPrincipal(AlunoController controllerAluno){

        int opcao = 0;
        boolean sair = false;
        Aluno alunoBusca;

        do {

            MenuAdminstrador.opcoes();
            opcao = Entrada.entradaInt();
            sair = false;

            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:MenuAluno.cadastro(controllerAluno);
                    break;
                case 2:
                    MenuAluno.verAlunos(controllerAluno);
                    sair = false;
                break;
                case 3:
                    alunoBusca = MenuAluno.buscar(controllerAluno);
                    MenuAluno.verAluno(alunoBusca);
                    MenuAluno.opcaoAlteracao(controllerAluno, alunoBusca);
                break;
                default:
                    sair = false;
                    break;
            }

        } while (!sair);

    }





  


}
