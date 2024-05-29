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


    public static Exercicio cadastroExercicio(Exercicio exercicio){
        //cadastro exercicio
            System.out.println("Cadastro de Exercicio");
            System.out.println("Nome do exercicio");
            exercicio.setNomeExercicio(Entrada.entradaString());
            System.out.println("Quantidade de Repetições");
            exercicio.setRepeticoes(Entrada.entradaString());
            System.out.println("Tempo de Intervalo");
            exercicio.setIntervalo(Entrada.entradaString());
        return exercicio;
    }
    
    public static SubTreino cadastroSubtreino(SubTreino subtreino){
        //cadastro exercicio
            System.out.println("Cadastro de Subtrieno");
            System.out.println("Nome do Subtreino");
            subtreino.setNome(Entrada.entradaString());
            System.out.println("Letra do Subtreino");
            subtreino.setLetra(Entrada.entradaString());
            System.out.println("Sexo");
            subtreino.setSexo(Entrada.entradaString());
            System.out.println("Tipo Grupo Muscular");
            subtreino.setTipoSubtreino(Entrada.entradaString());
        return subtreino;
    }

    public static Treino cadastroTreino(Treino treino){
        //cadastro exercicio
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

    
}
