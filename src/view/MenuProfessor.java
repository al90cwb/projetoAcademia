package view;

import java.time.LocalDate;

import model.Professor;
import util.Entrada;

public abstract class MenuProfessor extends MenusStandard  {

    // PROFESSOR-----------------------------
    public static void opcoesCadastroProfessor() {
        System.out.println("\n\n");
        System.out.println("Cadastro de professor, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO ALUNO:");
        System.out.println("2 - ALTERAR ALUNO:");
        System.out.println("3 - DELETAR ALUNO:");
        System.out.println("4 - LISTA ALUNO CADATRADOS:");

    }

    public static Professor cadastroProfessor(Professor professor) {

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
        professor.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
        return professor;
    }

    public static Professor alterarProfessor(Professor professor, int id) {

        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("\n\n");
        System.out.println("Alterar Aluno id: " + id);
        professor.setId(id);// id selecionado
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

        return professor;
    }

    public static int buscarProfessor() {
        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("Informar id do professor que deseja alterar");
        int id = Entrada.entradaInt();
        return id;
    }

    public static void verProfessor(Professor professor) {

        System.out.println(professor.toString());
    }

    /*
     * CADASTRO PROFESSOR
     * do {
     * 
     * SubMenus.opcoesCadastroProfessor();
     * opcaoCadastroProfessor = Entrada.entradaInt();
     * sairOpcaoCadastroProfessor = false;//se for para true sai do menu
     * 
     * switch (opcaoCadastroProfessor) {
     * case 0://SAIR
     * sairOpcaoCadastroProfessor = true;//sai do menu
     * break;
     * case 1://CADASTRO PROFESSOR
     * 
     * SubMenus.cadastroProfessor(professorCadastro);
     * System.out.println("Você deseja cadastrar o Professor?");
     * SubMenus.verProfessor(professorCadastro);
     * 
     * if (SubMenus.confimar()){
     * //alterar o professor pelo novo
     * controllerProfessor.cadastrarProfessor(new
     * Professor(professorCadastro.getid(), professorCadastro.getnome(),
     * professorCadastro.getcpf(), professorCadastro.getendereco(),
     * professorCadastro.getcelular(),professorCadastro.getemail(),
     * professorCadastro.getsexo(), professorCadastro.getsenha(),
     * professorCadastro.getdatanascimento()));
     * 
     * System.out.println("ProfessorCadastrado:");
     * }else{
     * System.out.println("Operação Cancelada.");
     * }
     * sairOpcaoCadastroProfessor = false;//continua no menu
     * 
     * break;
     * case 2://ALTERAR
     * 
     * //BUSCAR PROFESSOR
     * idBusca = SubMenus.buscarProfessor();
     * professorBusca = controllerProfessor.buscaProfessorId(idBusca);
     * 
     * if (professorBusca==null) {
     * System.out.println("Professor Não Encontrado");
     * } else {
     * System.out.println("Você deseja alterar o Professor?");
     * SubMenus.verProfessor(ProfessorBusca);
     * 
     * if (SubMenus.confimar()){
     * SubMenus.alterarProfessor(professorCadastro, idBusca);
     * 
     * //alterar o professor pelo novo
     * professorBusca.setid(professorCadastro.getid());
     * professorBusca.setnome(professorCadastro.getnome());
     * professorBusca.setcpf(professorCadastro.getcpf());
     * professorBusca.setendereco(professorCadastro.getendereco());
     * professorBusca.setcelular(professorCadastro.getcelular());
     * professorBusca.setemail(professorCadastro.getemail());
     * professorBusca.setsexo(professorCadastro.getsexo());
     * professorBusca.setsenha(professorCadastro.getsenha());
     * professorBusca.setdatanascimento(professorCadastro.getdatanascimento());
     * 
     * System.out.println("Professor Alterado:");
     * SubMenus.verProfessor(professorBusca);
     * }else{
     * System.out.println("Operação Cancelada, Professor não foi alterado:");
     * SubMenus.verProfessor(professorBusca);
     * }
     * }
     * 
     * sairOpcaoCadastroProfessor = false;//continua no menu
     * break;
     * case 3://DELETAR
     * 
     * //BUSCAR PROFESSOR
     * idBusca = SubMenus.buscarProfessor();
     * professorBusca = controllerProfessor.buscaProfessorId(idBusca);
     * 
     * if (professorBusca==null) {
     * System.out.println("Professor Não Encontrado");
     * } else {
     * System.out.println("Você deseja EXCLUIR o Professor?");
     * SubMenus.verProfessor(professorBusca);
     * 
     * if (SubMenus.confimar()){
     * controllerProfessor.deletarProfessor(idBusca);
     * System.out.println("Professor Excluido:");
     * }else{
     * System.out.println("Operação Cancelada, Professor não foi deletado:");
     * SubMenus.verProfessor(professorBusca);
     * }
     * }
     * sairOpcaoCadastroProfessor = false;//continua no menu
     * break;
     * 
     * case 4://LISTA DE PROFESSOR CADASTRADOS
     * System.out.println("Lista de Professores Cadastrados");
     * controllerProfessor.getProfessores().forEach(System.out::println);
     * System.out.println("----------------\n\n");
     * sairOpcaoCadastroProfessor = false;//continua no menu
     * break;
     * default:
     * sairOpcaoCadastroProfessor = false;//continua no menu
     * break;
     * }
     * 
     * } while (!sairOpcaoCadastroProfessor);//se for para true sai do menu
     * 
     */

}
