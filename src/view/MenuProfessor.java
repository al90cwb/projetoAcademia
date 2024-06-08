package view;

import java.time.LocalDate;

import controller.ProfessorController;
import model.Professor;
import util.Entrada;

public abstract class MenuProfessor extends MenusStandard  {

    public static void opcaoAlteracao(ProfessorController controller, Professor professor){

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
                alterar(professor);
                sair= true;
                break;
                case 2:
                deletar(controller,professor);
                sair= true;
                break;
                default:
                System.out.println("Opção invalida");
                sair= false;
                break;
            } 
        } while (!sair);
    }


    public static void deletar(ProfessorController controller, Professor professor){
        if (professor == null) {
            System.out.println("Aluno Não encontrado");
        } else {
            System.out.println("Você deseja deletar o Professor?");
            MenuProfessor.verProfessor(professor);

            if (MenusTreino.confimar()) {
                controller.deletar(professor.getId());
                System.out.println("Professor Excluido:");
            } else {
                System.out.println("Operação Cancelada, Professor não foi deletado:");
            }
        }
    }

    public static Professor buscar(ProfessorController controlle) {
        Entrada.in.nextLine();
        System.out.println("Informar cpf do aluno");
        return controlle.buscaCpf(Entrada.entradaCPF());
    }

    public static void cadastro(ProfessorController controller) {
        Professor cadastro= new Professor();

        Entrada.in.nextLine();
        System.out.println("\n\n");
        System.out.println("1/ Cadastro de Professor");
        System.out.println("Nome:");
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

        System.out.println("Você deseja cadastrar o Professor?");
        MenuProfessor.verProfessor(cadastro);

        if (MenusTreino.confimar()) {
            controller.cadastrar(new Professor(0, cadastro.getNome(), cadastro.getCpf(), cadastro.getEndereco(), cadastro.getCelular(), cadastro.getEmail(),
            cadastro.getSexo(), cadastro.getSenha(), cadastro.getDataNascimento()));
            System.out.println("Professor Cadastrado:");
        } else {
             System.out.println("Professor Cancelada.");
        }

    }

    public static void alterar(Professor professor) {
        if (professor == null) {
            System.out.println("Professor Não encontrado");
        } else {
            System.out.println("Você deseja alterar o Professor?");
            MenuProfessor.verProfessor(professor);

            if (MenuAluno.confimar()) {
                Entrada.in.nextLine();
                System.out.println("\n\n");
                System.out.println("Alterar o Nome:");
                professor.setNome(Entrada.entradaString());
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
                professor.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
                verProfessor( professor);
            }else{
                System.out.println("Operação Cancelada, Professor não foi deletado:");
            }
        }
    }

    public static void verProfessor(Professor professor) {
        System.out.println("Dados do Professor");
        System.out.println("CPF :"+ professor.getCpf() + ", Nome: " + professor.getNome());
    }

    public static void verProfessores( ProfessorController controller){
        System.out.println("Lista de Professores Cadastrados");
        for (Professor professor : controller.getProfessores()) {
            System.err.println("CPF :"+ professor.getCpf() + ", Nome: " + professor.getNome());
        }
        System.out.println("----------------\n\n");
    }

}
