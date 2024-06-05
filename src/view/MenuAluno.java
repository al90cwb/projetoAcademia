package view;

import java.time.LocalDate;

import model.Aluno;
import util.Entrada;

public abstract class MenuAluno extends MenusStandard {

    // ALUNO-----------------------------
    public static void opcoesCadastroAluno() {
        System.out.println("\n\n");
        System.out.println("Cadastro de alunos, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO ALUNO:");
        System.out.println("2 - ALTERAR ALUNO:");
        System.out.println("3 - DELETAR ALUNO:");
        System.out.println("4 - LISTA ALUNO CADATRADOS:");

    }

    public static Aluno cadastroAluno(Aluno aluno) {
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
        aluno.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
        return aluno;
    }

    public static Aluno alterarAluno(Aluno aluno, int id) {

        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("\n\n");
        System.out.println("Alterar Aluno id: " + id);
        aluno.setId(id);// id selecionado
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
        return aluno;
    }

    public static int buscarAluno() {
        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("Informar id do aluno que deseja alterar");
        int id = Entrada.entradaInt();
        return id;
    }

    public static void verAluno(Aluno aluno) {
        // ver exercicio
        System.out.println(aluno.toString());
    }

    /*
     * CADASTRO ALUNO
     * 
     * int = TipoCadastro;
     * do {
     * System.out.println("Selecione o tipo de cadastro:");
     * System.out.println("1. Aluno");
     * System.out.println("2. Professor");
     * System.out.println("3. Admin");
     * tipoCadastro = scanner.nextInt();
     * 
     * switch (tipoCadastro) {
     * case 1:
     * menuAluno(scanner);
     * break;
     * case 2:
     * menuProfessor(scanner);
     * break;
     * case 3:
     * menuAdmin(scanner);
     * break;
     * default:
     * System.out.println("Opção inválida!");
     * }
     * } while (tipoCadastro != 3);
     * 
     * scanner.close();
     * }
     * 
     * do {
     * 
     * SubMenus.opcoesCadastroAluno();
     * opcaoCadastroAluno = Entrada.entradaInt();
     * sairOpcaoCadastroAluno = false;//se for para true sai do menu
     * 
     * switch (opcaoCadastroAluno) {
     * case 0://SAIR
     * sairOpcaoCadastroAluno = true;//sai do menu
     * break;
     * case 1://CADASTRO ALUNO
     * 
     * SubMenus.cadastroAluno(alunoCadastro);
     * System.out.println("Você deseja cadastrar o Aluno?");
     * SubMenus.verAluno(alunoCadastro);
     * 
     * if (SubMenus.confimar()){
     * //alterar o aluno pelo novo
     * controllerAluno.cadastrarAluno(new
     * Aluno(alunoCadastro.getid(),alunoCadastro.getcpf()
     * alunoCadastro.getendereco(),alunoCadastro.getcelular(),alunoCadastro.getemail
     * (),alunoCadastro.getsexo(),alunoCadastro.getsenha(),alunoCadastro.
     * getdataNascimento(),alunoCadastro.gettrieno(),
     * alunoCadastro.getavaliacoesFisicas()));
     * 
     * System.out.println("Aluno Cadastrado:");
     * }else{
     * System.out.println("Operação Cancelada.");
     * }
     * sairOpcaoCadastroAluno = false;//continua no menu
     * 
     * break;
     * case 2://ALTERAR
     * 
     * //BUSCAR ALUNO
     * idBusca = SubMenus.buscarAluno();
     * alunoBusca = controllerAluno.buscaAlunoId(idBusca);
     * 
     * if (alunoBusca==null) {
     * System.out.println("Aluno Não Encontrado");
     * } else {
     * System.out.println("Você deseja alterar o Aluno?");
     * SubMenus.verAluno(AlunoBusca);
     * 
     * if (SubMenus.confimar()){
     * SubMenus.alterarAluno(alunoCadastro, idBusca);
     * 
     * //alterar o aluno pelo novo
     * alunoBusca.setid(alunoCadastro.getid());
     * alunoBusca.setcpf(alunoCadastro.getcpf());
     * alunoBusca.setenderecoa(alunoCadastro.getendereco());
     * alunoBusca.setcelular(alunoCadastro.getcelular());
     * alunoBusca.sexo(alunoCadastro.getemail());
     * alunoBusca.setsenha(alunoCadastro.getemail());
     * alunoBusca.setdataNascimento(alunoCadastro.getemail());
     * alunoBusca.settrieno(alunoCadastro.getemail());
     * alunoBusca.setavaliacoesFisicas(alunoCadastro.getavaliacoesFisicas());
     * 
     * System.out.println("Aluno Alterado:");
     * SubMenus.verAluno(alunoBusca);
     * }else{
     * System.out.println("Operação Cancelada, Aluno não foi alterado:");
     * SubMenus.verAluno(alunoBusca);
     * }
     * }
     * 
     * sairOpcaoCadastroAluno = false;//continua no menu
     * break;
     * case 3://DELETAR
     * 
     * //BUSCAR ALUNO
     * idBusca = SubMenus.buscarAluno();
     * alunoBusca = controllerAluno.buscaAlunoId(idBusca);
     * 
     * if (alunoBusca==null) {
     * System.out.println("Aluno Não Encontrado");
     * } else {
     * System.out.println("Você deseja EXCLUIR o Aluno?");
     * SubMenus.verAluno(alunoBusca);
     * 
     * if (SubMenus.confimar()){
     * controllerAluno.deletarAluno(idBusca);
     * System.out.println("Aluno Excluido:");
     * }else{
     * System.out.println("Operação Cancelada, Aluno não foi deletado:");
     * SubMenus.verAluno(alunoBusca);
     * }
     * }
     * sairOpcaoCadastroAluno = false;//continua no menu
     * break;
     * 
     * case 4://LISTA DE ALUNOS CADASTRADOS
     * System.out.println("Lista de Alunos Cadastrados");
     * controllerAluno.getAlunos().forEach(System.out::println);
     * System.out.println("----------------\n\n");
     * sairOpcaoCadastroAluno = false;//continua no menu
     * break;
     * default:
     * sairOpcaoCadastroAluno = false;//continua no menu
     * break;
     * }
     * 
     * } while (!sairOpcaoCadastroAluno);//se for para true sai do menu
     * 
     */

}
