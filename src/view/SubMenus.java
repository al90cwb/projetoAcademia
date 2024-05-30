package view;

import java.time.LocalDate;

import model.Exercicio;
import model.SubTreino;
import model.Treino;
import util.Entrada;

/**
 * Este Contrler Gerencia o menu do sistema
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */
public abstract class SubMenus {

    public static void opcoesCadastroExercicio(){
        //menu com as opçções de cadastro de Exercicio
            System.out.println("\n\n");
            System.out.println("OPÇÕES CADASTRO DE EXERCICIOS, digite um numero correspondente:");
            System.out.println("0 - CANCELAR");
            System.out.println("1 - CADASTRAR NOVO EXERCICIO:");
            System.out.println("2 - ALTERAR EXERCICIO:");
            System.out.println("3 - DELETAR EXERCICIO:");
            System.out.println("4 - LISTA EXERCICIOS CADATRADOS:");
    }

    public static Exercicio cadastroExercicio(Exercicio exercicio){
        //cadastro exercicio
            System.out.println("\n\n");
            System.out.println("Cadastro de Exercicio");
            System.out.println("Nome do exercicio");
            exercicio.setNomeExercicio(Entrada.entradaString());
            System.out.println("Quantidade de Repetições");
            exercicio.setRepeticoes(Entrada.entradaString());
            System.out.println("Tempo de Intervalo");
            exercicio.setIntervalo(Entrada.entradaString());
        return exercicio;
    }

    public static Exercicio alterarExercicio(Exercicio exercicio, int id){
        //cadastro exercicio
            System.out.println("\n\n");
            System.out.println("Alterar Exercicio id: "  + id);
            exercicio.setId(id);//id selecionado
            System.out.println("Nome do exercicio");
            exercicio.setNomeExercicio(Entrada.entradaString());
            System.out.println("Quantidade de Repetições");
            exercicio.setRepeticoes(Entrada.entradaString());
            System.out.println("Tempo de Intervalo");
            exercicio.setIntervalo(Entrada.entradaString());
        return exercicio;
    }
    
    public static SubTreino cadastroSubtreino(SubTreino subtreino){
        //cadastro Subtreino
            System.out.println("\n\n");
            System.out.println("Cadastro de Subtrieno");
            System.out.println("Nome do Subtreino");
            subtreino.setNome(Entrada.entradaString());
            System.out.println("Letra do Subtreino");
            subtreino.setLetra(Entrada.entradaString());
            System.out.println("Sexo M masculino, F feminino :");
            subtreino.setSexo(Entrada.entradaSexo());
            System.out.println("Tipo Grupo Muscular");
            subtreino.setTipoSubtreino(Entrada.entradaString());
        return subtreino;
    }

    public static void verExercicio(Exercicio exercicio){
        //ver exercicio
            System.out.println("\n\n");
            System.out.println(exercicio.toString());
    }

    public static boolean confimar(){
        //ver exercicio
            System.out.println("\n\n");
            System.out.println("0=NÃO,1=SIM");
        return Entrada.entradaZeroUm()==1;
    }

    public static Treino cadastroTreino(Treino treino){
        //cadastro Treino
            System.out.println("\n\n");
            System.out.println("Cadastro de Treino");
            System.out.println("Nome do Treino");
            treino.setNome(Entrada.entradaString());
            System.out.println("Data Inicio");
            treino.setDataInicio( LocalDate.parse(Entrada.entradaData(), Entrada.formatoData)  );
            System.out.println("Dias de duração");
            treino.setDuracao(Entrada.entradaInt());
            System.out.println("Aquecimento: ");
            treino.setAquecimento(Entrada.entradaString());
            System.out.println("Sugetão dias de treino: ");
            treino.setSugestaoDiasTreino(Entrada.entradaString());
        return treino;
    }

    public static int buscarExercicio(){
        System.out.println("Informar id do exercicio que deseja alterar");
        int id = Entrada.entradaInt();
        return id;
    }

    
}
