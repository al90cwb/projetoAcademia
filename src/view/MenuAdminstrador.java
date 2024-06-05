package view;

import java.time.LocalDate;

import model.Administrador;
import util.Entrada;

public abstract class MenuAdminstrador {
    // ADMINISTRADOR-----------------------------
    public static void opcoesCadastroAdministrador() {
        System.out.println("\n\n");
        System.out.println("Cadastro de professor, digite um numero correspondente:");
        System.out.println("0 - CANCELAR");
        System.out.println("1 - CADASTRAR NOVO ALUNO:");
        System.out.println("2 - ALTERAR ALUNO:");
        System.out.println("3 - DELETAR ALUNO:");
        System.out.println("4 - LISTA ALUNO CADATRADOS:");
    }

    public static Administrador cadastroAdministrador(Administrador administrador) {

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
        administrador.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));
        return administrador;
    }

    public static Administrador alterarAdministrador(Administrador administrador, int id) {

        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("\n\n");
        System.out.println("Alterar Administrador id: " + id);
        administrador.setId(id);// id selecionado
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
        administrador.setDataNascimento(LocalDate.parse(Entrada.entradaData(), Entrada.formatoData));

        return administrador;
    }

    public static int buscarAdministrador() {
        Entrada.in.nextLine();// LIMPA BUFFER
        System.out.println("Informar id do administrador que deseja alterar");
        int id = Entrada.entradaInt();
        return id;
    }

    public static void verAdministrador(Administrador administrador) {

        System.out.println(administrador.toString());
    }

    /*
     * CADASTRO ADMINISTRADOR
     * 
     * //FALTOU MOSTRAR ALUNO, PROF E ADM
     * 
     * do {
     * 
     * SubMenus.opcoesCadastroAdministrador();
     * opcaoCadastroAdministrador = Entrada.entradaInt();
     * sairOpcaoCadastroAdministrador = false;//se for para true sai do menu
     * 
     * switch (opcaoCadastroAdministrador) {
     * case 0://SAIR
     * sairOpcaoCadastroAdministrador = true;//sai do menu
     * break;
     * case 1://CADASTRO ADMINISTRADOR
     * 
     * SubMenus.cadastroAdministrador(administradorCadastro);
     * System.out.println("Você deseja cadastrar o Administrador?");
     * SubMenus.verAdministrador(adminitradorCadastro);
     * 
     * if (SubMenus.confimar()){
     * //alterar o administrador pelo novo
     * controllerAdministrador.cadastrarAdministrador(new
     * Administrador(administradorCadastro.getid(),
     * administradorCadastro.getnome(), administradorCadastro.getcpf,
     * administradorCadastro.getendereco, administradorCadastro.getcelular,
     * administradorCadastro.getemail, administrador.Cadastro.getsexo,
     * administradorCadastro.getsenha, administradorCadastro.getdataNascimento ()));
     * 
     * System.out.println("Administrador Cadastrado:");
     * }else{
     * System.out.println("Operação Cancelada.");
     * }
     * sairOpcaoCadastroAdministrador = false;//continua no menu
     * 
     * break;
     * case 2://ALTERAR
     * 
     * //BUSCAR ADMINISTRADOR
     * idBusca = SubMenus.buscarAdministrador();
     * administradorBusca = controllerAdministrador.buscaAdministradorId(idBusca);
     * 
     * if (administradorBusca==null) {
     * System.out.println("Administrador Não Encontrado");
     * } else {
     * System.out.println("Você deseja alterar o Administrador?");
     * SubMenus.verAdministrador(administradorBusca);
     * 
     * if (SubMenus.confimar()){
     * SubMenus.alterarAdministrador(administradorCadastro, idBusca);
     * 
     * //alterar o administrador pelo novo
     * administradorBusca.setid(administradorCadastro.getid());
     * administradorBusca.setnome(administradorCadastro.getnome());
     * administradorBusca.setcpf(administradorCadastro.getcpf());
     * administradorBusca.setendereco(administradorCadastro.getendereco());
     * administradorBusca.setcelular(administradorCadastro.getcelular());
     * administradorBusca.setemail(administradorCadastro.getemail());
     * administradorBusca.setsexo(administradorCadastro.getsexo());
     * administradorBusca.setsenha(administradorCadastro.getsenha());
     * administradorBusca.setdataNascimento(administradorCadastro.getdataNascimento(
     * ));
     * 
     * System.out.println("Administrador Alterado:");
     * SubMenus.verAdministrador(administradorBusca);
     * }else{
     * System.out.println("Operação Cancelada, Administrador não foi alterado:");
     * SubMenus.verAdministrador(administradorBusca);
     * }
     * }
     * 
     * sairOpcaoCadastroAdministrador = false;//continua no menu
     * break;
     * case 3://DELETAR
     * 
     * //BUSCAR ADMINISTRADOR
     * idBusca = SubMenus.buscarAdministrador();
     * administradorBusca = controllerAdministrador.buscaAdministradorId(idBusca);
     * 
     * if (administradorBusca==null) {
     * System.out.println("Administrador Não Encontrado");
     * } else {
     * System.out.println("Você deseja EXCLUIR o Administrador?");
     * SubMenus.verAdministrador(administradorBusca);
     * 
     * if (SubMenus.confimar()){
     * controllerAdministrador.deletarAdministrador(idBusca);
     * System.out.println("Administrador Excluido:");
     * }else{
     * System.out.println("Operação Cancelada, Administrador não foi deletado:");
     * SubMenus.verAdministrador(administradorBusca);
     * }
     * }
     * sairOpcaoCadastroAdministrador = false;//continua no menu
     * break;
     * 
     * case 4://LISTA DE ADMINISTRADOR CADASTRADOS
     * System.out.println("Lista de Administrador Cadastrados");
     * controllerAdministrador.getAdministradors().forEach(System.out::println);
     * System.out.println("----------------\n\n");
     * sairOpcaoCadastroAdministrador = false;//continua no menu
     * break;
     * default:
     * sairOpcaoCadastroAdministrador = false;//continua no menu
     * break;
     * }
     * 
     * } while (!sairOpcaoCadastroAdministrador);//se for para true sai do menu
     * 
     */
}
