package view;

import java.util.ArrayList;
import java.util.List;

import controller.TreinoController;
import model.Aluno;
import model.Exercicio;
import model.Treino;
import util.Entrada;

public class MenuTreino extends MenusStandard {

    public static void opcoesCadastroTreino() {
        System.out.println("\n\n");
        System.out.println("OPCOES CADASTRO DE TREINOS, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO Treino:");
        System.out.println("2 - ALTERAR Treino:");
        System.out.println("3 - DELETAR Treino:");
        System.out.println("4 - LISTA TREINOS CADASTRADOS:");
        System.out.println("5 - VER TREINO:");

    }

    
    public static void cadastro(TreinoController controller) {

        int opcaoCadastro;
        boolean sairOpcaoCadastro = false;

        do {
            MenuTreino.opcoesCadastroTreino();
            opcaoCadastro = Entrada.entradaInt();
            sairOpcaoCadastro = false; 

            switch (opcaoCadastro) {
                case 0:
                    sairOpcaoCadastro = true;
                    break;
                case 1:
                    System.out.println("Cadastrar novo Treino");
                    sairOpcaoCadastro = false; 
                    break;
                case 2:
                    System.out.println("Não funciona");
                    sairOpcaoCadastro = false;
                    break;
                case 3:
                    System.out.println("Não funciona");
                    sairOpcaoCadastro = false;
                    break;
                case 4:
                    System.out.println("Lista de TREINOS Cadastrados");
                    verTreinos(controller.getTreinos());
                    System.out.println("----------------\n\n");
                    sairOpcaoCadastro = false;
                    break;
                case 5:
                    verTreino( buscarTreinoId(controller));
                    System.out.println("----------------\n\n");
                    sairOpcaoCadastro = false;
                    break;
                default:
                    sairOpcaoCadastro = false;
                    break;
            }

        } while (!sairOpcaoCadastro);

    }

    public static void cadastroTreino(TreinoController controller) {
        Treino cadastro= new Treino();
        Entrada.in.nextLine();
        System.out.println("\n\n");
        System.out.println("Cadastro de Treino");
        System.out.println("Nome do Treino");
        cadastro.setNome(Entrada.entradaString());
        System.out.println("Tipo Grupo Muscular");
        cadastro.setTipoTreino(Entrada.entradaTipoTreino());
        System.out.println("Tipo Grupo Muscular");
    }

    public static Treino alterarTreino(Treino treino, int id) {
        Entrada.in.nextLine();
        System.out.println("\n\n");
        System.out.println("Alterar Treino ID: " + id);
        treino.setId(id);
        System.out.println("Nome do treino:");
        treino.setNome(Entrada.entradaString());
        System.out.println("Tipo de treino:");
        treino.setTipoTreino(Entrada.entradaString());
        return treino;
    }

    public static int informarId() {
        System.out.println("Informar ID do treino:");
        return Entrada.entradaInt();
    }
    

    public static Treino buscarTreinoId(TreinoController controller){
        int idBusca = 0;
        Treino busca;
        idBusca = MenuTreino.informarId();
        busca = controller.buscaTreinoId(idBusca);
        return busca;
    }

  
    public static void buscarTreinos(TreinoController controller) {
        String tipo ;
        List<Treino> treinos;
        System.out.println("Informar o Tipo do treino");
        Entrada.in.nextLine();
        tipo = Entrada.entradaTipoTreino();
        treinos = controller.pesquisaPorTipo(tipo);
        if (treinos!= null){
            for (Treino treino : treinos) {
                System.out.println("Id:"+ treino.getId() +", nome do treino "+ treino.getNome() );
            }
        }else{
            System.out.println("Lista de trienos vazia");
        }
        return  ;
    }

    public static void verTreino(Treino treino) {
        if (treino!= null){
            List<Exercicio> exercicios = treino.getExercicios();
            for (Exercicio exercicio : exercicios) {
                System.out.println("Nome do Exercicio:"+ exercicio.getNomeExercicio()+ ", repetições:"+ exercicio.getRepeticoes() + ", intervalo:"+ exercicio.getIntervalo()+ "." );
            }
        }else{
            System.out.println("Lista de exercicios vazia");
        }
    }

    public static void verTreinos(List<Treino> treinos) {
        if (treinos!= null){
            for (Treino treino : treinos) {
                System.out.println("Id " + treino.getId() + ", nome "+treino.getNome()+ ", tipo: "+ treino.getTipoTreino() );
            }
        }else{
            System.out.println("Lista de trienos vazia");
        }
    }

   


}
