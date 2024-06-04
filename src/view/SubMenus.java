package view;

import java.time.LocalDate;

import model.Exercicio;
import model.SubTreino;
import model.Treino;
import util.Entrada;
import model.Aluno;
import model.Professor;
import model.Administrador;


/**
 * Este Contrler Gerencia o menu do sistema
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */
public abstract class SubMenus {
    //GERAL---------------------------- 
    public static boolean confimar(){
        //ver exercicio
            System.out.println("0=NÃO,1=SIM");
            boolean op = Entrada.entradaZeroUm()==1;
        return op;
    }


    //

    //EXERCICIO------------------------
    public static void opcoesCadastroExercicio(){
        //menu com as opçções de cadastro de Exercicio
            System.out.println("\n\n");
            System.out.println("OPÇÕES CADASTRO DE EXERCICIOS, digite um numero correspondente:");
            System.out.println("0 - CANCELAR");
            System.out.println("1 - CADASTRAR NOVO EXERCICIO:");
            System.out.println("2 - ALTERAR EXERCICIO:");
            System.out.println("3 - DELETAR EXERCICIO:");
            System.out.println("4 - LISTA EXERCICIOS CADASTRADOS:");
    }

    public static Exercicio cadastroExercicio(Exercicio exercicio){
        //cadastro exercicio
            Entrada.in.nextLine();//LIMPA BUFFER
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
            Entrada.in.nextLine();//LIMPA BUFFER
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

    public static int buscarExercicio(){
        Entrada.in.nextLine();//LIMPA BUFFER
        System.out.println("Informar id do exercicio que deseja alterar");
        int id = Entrada.entradaInt();
        return id;
    }
    public static void verExercicio(Exercicio exercicio){
        //ver exercicio
            System.out.println(exercicio.toString());
    }

    //SUBTREINO-------------------------- 

    public static void opcoesCadastroSubtreino(){
        System.out.println("\n\n");
        System.out.println("OPCOES CADASTRO DE SUBTREINOS, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO SUBTREINO:");
        System.out.println("2 - ALTERAR SUBTREINO:");
        System.out.println("3 - DELETAR SUBTREINO:");
        System.out.println("4 - LISTA SUBTREINOS CADASTRADOS:");
}


    public static SubTreino cadastroSubtreino(SubTreino subtreino){
        //cadastro Subtreino
            Entrada.in.nextLine();//LIMPA BUFFER
            System.out.println("\n\n");
            System.out.println("Cadastro de Subtrieno");
            System.out.println("Nome do Subtreino");
            subtreino.setNome(Entrada.entradaString());
            System.out.println("Letra do Subtreino");
            subtreino.setLetra(Entrada.entradaString());
            System.out.println("Sexo M masculino, F feminino :");
            subtreino.setSexo(Entrada.entradaString());
            System.out.println("Tipo Grupo Muscular");
            subtreino.setTipoSubtreino(Entrada.entradaString());
            

        return subtreino;
    }
    public static SubTreino alterarSubTreino(SubTreino subTreino, int id){
        //alterar subtreino
        Entrada.in.nextLine(); // limpa o buffer
        System.out.println("\n\n");
        System.out.println("Alterar SubTreino ID: "  + id);
        subTreino.setId(id); // define o ID selecionado
        System.out.println("Nome do subtreino:");
        subTreino.setNome(Entrada.entradaString());
        System.out.println("Tipo de subtreino:");
        subTreino.setTipoSubtreino(Entrada.entradaString());
        System.out.println("Sexo:");
        subTreino.setSexo(Entrada.entradaString());
        System.out.println("Letra:");
        subTreino.setLetra(Entrada.entradaString());
        return subTreino;
    }

    public static int buscarSubTreino(){
        //buscar subtreino
        Entrada.in.nextLine(); // limpa o buffer
        System.out.println("Informar ID do subtreino que deseja alterar:");
        return Entrada.entradaInt();
    }

    public static void verSubTreino(SubTreino subTreino){
        //ver informações do subtreino
        System.out.println(subTreino.toString());
    }




    

    //TRIENO-----------------------------
    public static void opcoesCadastroTreino(){
            System.out.println("\n\n");
            System.out.println("Cadastro de treinos, digite um numero correspondente:");
            System.out.println("0 - CANCELAR");
            System.out.println("1 - CADASTRAR NOVO TREINO:");
            System.out.println("2 - ALTERAR TREINO:");
            System.out.println("3 - DELETAR TREINO:");
            System.out.println("4 - LISTA TREINOS CADATRADOS:");
    }
    public static Treino cadastroTreino(Treino treino){
        //cadastro Treino
            Entrada.in.nextLine();//LIMPA BUFFER

            System.out.println("\n\n");
            System.out.println("Cadastro de Treino");
            System.out.println("Nome do Treino");
            treino.setNome(Entrada.entradaString());
            System.out.println("Data Inicio");
            treino.setDataInicio( LocalDate.parse(Entrada.entradaData(), Entrada.formatoData)  );
            System.out.println("Data Fim");
            treino.setDataFim( LocalDate.parse(Entrada.entradaData(), Entrada.formatoData)  );
            System.out.println("Dias de duração");
            treino.setDuracao(Entrada.entradaInt());
            System.out.println("Aquecimento: \n");
            treino.setAquecimento(Entrada.entradaString());
            System.out.println("Sugestão dias de treino: ");
            treino.setSugestaoDiasTreino(Entrada.entradaString());
   //precisa dos subtreinos!
        return treino;
    }
    public static Treino alterarTreino(Treino treino, int id){
            Entrada.in.nextLine();//LIMPA BUFFER

            System.out.println("\n\n");
            System.out.println("Alterar Treino id: "  + id);
            treino.setId(id);//id selecionado
            System.out.println("Nome do treino");
            treino.setNome(Entrada.entradaString());
            System.out.println("Alterar Data de Inicio");
            treino.setDataInicio( LocalDate.parse(Entrada.entradaData(), Entrada.formatoData) );
            System.out.println("Alterar Data do Fim");
            treino.setDataFim( LocalDate.parse(Entrada.entradaData(), Entrada.formatoData) );
            System.out.println("Alterar dias de duração");
            treino.setDuracao(Entrada.entradaInt());
            System.out.println("Alterar Aquecimento");
            treino.setAquecimento(Entrada.entradaString());
            System.out.println("Alterar dias de Sugestão para o treino");
            treino.setSugestaoDiasTreino(Entrada.entradaString());
        return treino;
    }

    public static int buscarTreino(){
        Entrada.in.nextLine();//LIMPA BUFFER
        System.out.println("Informar id do treino que deseja alterar");
        int id = Entrada.entradaInt();
        return id;
    }
    public static void verTreino(Treino treino){
        //ver treino
            System.out.println(treino.toString());
    }

    //ALUNO-----------------------------
    public static void opcoesCadastroAluno(){
        System.out.println("\n\n");
        System.out.println("Cadastro de alunos, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO ALUNO:");
        System.out.println("2 - ALTERAR ALUNO:");
        System.out.println("3 - DELETAR ALUNO:");
        System.out.println("4 - LISTA ALUNO CADATRADOS:");
}
    /*public static Aluno cadastroAluno(Aluno aluno){
    // TREINO E AVANLIAÇÃO FISICA TÃO DANDO ERRO SE ALGUEM PUDER AJUDAR
        Entrada.in.nextLine();
        System.out.println("\n\n");
        System.out.println("Cadastro de Aluno");
        System.out.println("Nome do Aluno:");
        aluno.setNome(Entrada.entradaString());
        System.out.println("Digite o CPF:");
        aluno.setCpf(Entrada.entradaString());
        System.out.println("Digite Endereço:");
        aluno.setEndereco(Entrada.entradaString());
        System.out.println("Digite o celular:");
        aluno.setCelular(Entrada.entradaString());
        System.out.println("Digite o email:");
        aluno.setEmail(Entrada.entradaString());
        System.out.println("Digite o Sexo:");
        aluno.setSexo(Entrada.entradaString());
        System.out.println("Digite a Senha:");
        aluno.setSenha(Entrada.entradaString());
        System.out.println("Digite a Data de Nascimento:");
        aluno.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData) );
        System.out.println("Treino:");
        aluno.setTrieno(Entrada.entradaTreino());
        System.out.println("Avaliação Fisica:");
        aluno.setAvaliacoesFisicas(Entrada.entradaString());
    return aluno;
}

    public static Aluno alterarAluno(Aluno aluno, int id){
    
        Entrada.in.nextLine();//LIMPA BUFFER
        System.out.println("\n\n");
        System.out.println("Alterar Aluno id: "  + id);
        aluno.setId(id);//id selecionado
        System.out.println("Alterar o CPF:");
        aluno.setCpf(Entrada.entradaString());
        System.out.println("Altera o Endereço:");
        aluno.setEndereco(Entrada.entradaString());
        System.out.println("Altera o Celular:");
        aluno.setCelular(Entrada.entradaString());
        System.out.println("Altera o Email:");
        aluno.setEmail(Entrada.entradaString());
        System.out.println("Altera o Sexo:");
        aluno.setSexo(Entrada.entradaString());
        System.out.println("Altera a Senha:");
        aluno.setSenha(Entrada.entradaString());
        System.out.println("Altera a Data de Nascimento:");
        aluno.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData) );
        System.out.println("Altera o Treino:");
        aluno.setTrieno(Entrada.entradaTreino());
        System.out.println("Avaliação Fisica:");
        aluno.setAvaliacoesFisicas(Entrada.entradaString());
    return aluno;
}*/

public static int buscarAluno(){
    Entrada.in.nextLine();//LIMPA BUFFER
    System.out.println("Informar id do aluno que deseja alterar");
    int id = Entrada.entradaInt();
    return id;
}
public static void verAluno(Aluno aluno){
    //ver exercicio
        System.out.println(aluno.toString());
}

//PROFESSOR-----------------------------
public static void opcoesCadastroProfessor(){
    System.out.println("\n\n");
    System.out.println("Cadastro de professor, digite um numero correspondente:");
    System.out.println("0 - CANCELAR");
    System.out.println("1 - CADASTRAR NOVO ALUNO:");
    System.out.println("2 - ALTERAR ALUNO:");
    System.out.println("3 - DELETAR ALUNO:");
    System.out.println("4 - LISTA ALUNO CADATRADOS:");

}
public static Professor cadastroProfessor(Professor professor){
    
    Entrada.in.nextLine();
    System.out.println("\n\n");
    System.out.println("Cadastro de Professor");
    System.out.println("Nome do Professor:");
    professor.setNome(Entrada.entradaString());
    System.out.println("Digite o CPF:");
    professor.setCpf(Entrada.entradaString());
    System.out.println("Digite Endereço:");
    professor.setEndereco(Entrada.entradaString());
    System.out.println("Digite o celular:");
    professor.setCelular(Entrada.entradaString());
    System.out.println("Digite o email:");
    professor.setEmail(Entrada.entradaString());
    System.out.println("Digite o Sexo:");
    professor.setSexo(Entrada.entradaString());
    System.out.println("Digite a Senha:");
    professor.setSenha(Entrada.entradaString());
    System.out.println("Digite a Data de Nascimento:");
    professor.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData) );
return professor;
}

public static Professor alterarProfessor(Professor professor, int id){
    
    Entrada.in.nextLine();//LIMPA BUFFER
    System.out.println("\n\n");
    System.out.println("Alterar Aluno id: "  + id);
    professor.setId(id);//id selecionado
    System.out.println("Alterar o CPF:");
    professor.setCpf(Entrada.entradaString());
    System.out.println("Altera o Endereço:");
    professor.setEndereco(Entrada.entradaString());
    System.out.println("Altera o Celular:");
    professor.setCelular(Entrada.entradaString());
    System.out.println("Altera o Email:");
    professor.setEmail(Entrada.entradaString());
    System.out.println("Altera o Sexo:");
    professor.setSexo(Entrada.entradaString());
    System.out.println("Altera a Senha:");
    professor.setSenha(Entrada.entradaString());
    System.out.println("Altera a Data de Nascimento:");
    professor.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData) );
    
return professor;
}
public static int buscarProfessor(){
    Entrada.in.nextLine();//LIMPA BUFFER
    System.out.println("Informar id do professor que deseja alterar");
    int id = Entrada.entradaInt();
    return id;
}
public static void verProfessor(Professor professor){
   
        System.out.println(professor.toString());
}

//ADMINISTRADOR-----------------------------
public static void opcoesCadastroAdministrador(){
    System.out.println("\n\n");
    System.out.println("Cadastro de professor, digite um numero correspondente:");
    System.out.println("0 - CANCELAR");
    System.out.println("1 - CADASTRAR NOVO ALUNO:");
    System.out.println("2 - ALTERAR ALUNO:");
    System.out.println("3 - DELETAR ALUNO:");
    System.out.println("4 - LISTA ALUNO CADATRADOS:");
}
public static Administrador cadastroAdministrador(Administrador administrador){
    
    Entrada.in.nextLine();
    System.out.println("\n\n");
    System.out.println("Cadastro de Professor");
    System.out.println("Nome do Professor:");
    administrador.setNome(Entrada.entradaString());
    System.out.println("Digite o CPF:");
    administrador.setCpf(Entrada.entradaString());
    System.out.println("Digite Endereço:");
    administrador.setEndereco(Entrada.entradaString());
    System.out.println("Digite o celular:");
    administrador.setCelular(Entrada.entradaString());
    System.out.println("Digite o email:");
    administrador.setEmail(Entrada.entradaString());
    System.out.println("Digite o Sexo:");
    administrador.setSexo(Entrada.entradaString());
    System.out.println("Digite a Senha:");
    administrador.setSenha(Entrada.entradaString());
    System.out.println("Digite a Data de Nascimento:");
    administrador.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData) );
return administrador;
}

public static Administrador alterarAdministrador(Administrador administrador, int id){
    
    Entrada.in.nextLine();//LIMPA BUFFER
    System.out.println("\n\n");
    System.out.println("Alterar Administrador id: "  + id);
    administrador.setId(id);//id selecionado
    System.out.println("Alterar o CPF:");
    administrador.setCpf(Entrada.entradaString());
    System.out.println("Altera o Endereço:");
    administrador.setEndereco(Entrada.entradaString());
    System.out.println("Altera o Celular:");
    administrador.setCelular(Entrada.entradaString());
    System.out.println("Altera o Email:");
    administrador.setEmail(Entrada.entradaString());
    System.out.println("Altera o Sexo:");
    administrador.setSexo(Entrada.entradaString());
    System.out.println("Altera a Senha:");
    administrador.setSenha(Entrada.entradaString());
    System.out.println("Altera a Data de Nascimento:");
    administrador.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData) );
    
return administrador;
}

public static int buscarAdministrador(){
    Entrada.in.nextLine();//LIMPA BUFFER
    System.out.println("Informar id do administrador que deseja alterar");
    int id = Entrada.entradaInt();
    return id;
}
public static void verAdministrador(Administrador administrador){
   
    System.out.println(administrador.toString());
}
}