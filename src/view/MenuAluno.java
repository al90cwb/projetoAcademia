package view;


import java.time.LocalDate;

import controller.AlunoController;
import model.Aluno;
import util.Entrada;

public abstract class MenuAluno extends MenusStandard {

    public static void opcaoAlteracao(AlunoController controller, Aluno aluno){

        int opcao = 0;
        boolean sair = false;
       

        do {
            System.out.println("\n\n Informar opções");
            System.out.println("0- Cancelar");
            System.out.println("1- Alterar");
            System.out.println("2- Deletar");
            opcao = 0;
            opcao = Entrada.entradaInt();

            switch (opcao) {
                case 0:
                sair= true;
                break;
                case 1:
                alterar(aluno);
                sair= true;
                break;
                case 2:
                deletar(controller,aluno);
                sair= true;
                break;
                default:
                System.out.println("Opção invalida");
                sair= false;
                break;
            } 
        } while (!sair);
    }


    public static void deletar(AlunoController controller,Aluno aluno){
        if (aluno == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja deletar o Aluno?");
            MenuAluno.verAluno(aluno);

            if (MenusTreino.confimar()) {
                controller.deletar(aluno.getId());
                System.out.println("Aluno Excluido:");
            } else {
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static Aluno buscar(AlunoController controlle) {
        Entrada.in.nextLine();
        System.out.println("Informar cpf do aluno");
        return controlle.buscaCpf(Entrada.entradaCPF());
    }

    public static void cadastro(AlunoController controller) {
        Aluno cadastro= new Aluno();

        Entrada.in.nextLine();
        System.out.println("\n\n");
        System.out.println("1/ Cadastro de Aluno");
        System.out.println("Nome do Aluno:");
        cadastro.setNome(Entrada.entradaString());
        System.out.println("Digite o CPF:");
        cadastro.setCpf(Entrada.entradaString());
        System.out.println("Digite Endereço:");
        cadastro.setEndereco(Entrada.entradaString());
        System.out.println("Digite o celular:");
        cadastro.setCelular(Entrada.entradaString());
        System.out.println("Digite o email:");
        cadastro.setEmail(Entrada.entradaString());
        System.out.println("Digite o Sexo:");
        cadastro.setSexo(Entrada.entradaString());
        System.out.println("Digite a Senha:");
        cadastro.setSenha(Entrada.entradaString());
        System.out.println("Digite a Data de Nascimento:");
        cadastro.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));

        System.out.println("Você deseja cadastrar o Aluno?");
        MenuAluno.verAluno(cadastro);

        if (MenusTreino.confimar()) {
            controller.cadastrar(new Aluno(0, cadastro.getNome(), cadastro.getCpf(), cadastro.getEndereco(), cadastro.getCelular(), cadastro.getEmail(),
            cadastro.getSexo(), cadastro.getSenha(), cadastro.getDataNascimento(), null, null));
            System.out.println("Aluno Cadastrado:");
        } else {
             System.out.println("Operação Cancelada.");
        }

    }

    public static void alterar(Aluno aluno) {
        if (aluno == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja alterar o Aluno?");
            MenuAluno.verAluno(aluno);

            if (MenuAluno.confimar()) {
                Entrada.in.nextLine();
                System.out.println("\n\n");
                System.out.println("Alterar o Nome:");
                aluno.setNome(Entrada.entradaString());
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
                aluno.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
                verAluno( aluno);
            }else{
                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
            }
        }
    }

    public static void verAluno(Aluno aluno) {
        //System.out.println(aluno.toString());
        System.out.println("Dados do Aluno");
        System.out.println("CPF :"+ aluno.getCpf() + ", Nome: " + aluno.getNome());
    }

    public static void verAlunos( AlunoController controller){
        System.out.println("Lista de Alunos Cadastrados");
        for (Aluno aluno : controller.getAlunos()) {
            System.err.println("CPF :"+ aluno.getCpf() + ", Nome: " + aluno.getNome());
        }
        System.out.println("----------------\n\n");
    }

}
