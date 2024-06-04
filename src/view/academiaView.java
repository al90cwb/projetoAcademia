package view;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import controller.ExercicioController;
import controller.SubtreinoController;
import controller.TreinoController;
import controller.AdministradorController;
import controller.AlunoController;
import controller.ProfessorController;
import model.Administrador;
import model.Exercicio;
import model.SubTreino;
import model.Treino;
import util.Entrada;
import model.Aluno;
import model.Professor;
import model.Administrador;

/**
 * Este programa é um exemplo simples de gestão de academia
 * Ele realiza operações de cadastro de usuarios e treinos 
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public class academiaView {
    public static void main(String[] args)throws Exception {
        //DECLARAÇÃO DE VARIAVEIS
        //CONTROLLER
            ExercicioController controllerExecicio  = new ExercicioController(new ArrayList<Exercicio>());
            SubtreinoController controllerSubtreino = new SubtreinoController(new ArrayList<SubTreino>());
            TreinoController controllerTreino = new TreinoController(new ArrayList<Treino>()) ;
            AlunoController controllerAluno = new AlunoController(new ArrayList<Aluno>());
            ProfessorController controllerProfessor = new ProfessorController(new ArrayList<Professor>());
            AdministradorController controllerAdministrador = new AdministradorController(new ArrayList<Administrador>());

        //DADOS DE CADASTRO
            boolean modoTeste= true;
            boolean sairOpcaoCadastroExercicio = false;
            int opcaoCadastroExercicio = 0;
    
            boolean sairOpcaoCadastroTreino = false;
            int opcaoCadastroTreino = 0;

            boolean sairOpcaoCadastroSubtreino = false;
            int opcaoCadastroSubtreino = 0;

            int idBusca = 0;

    

        //EXERCICIO
            Exercicio exercicioCadastro = new Exercicio( null, null, null);
            SubTreino subTreinoCadastro = new SubTreino( null, null, null, null, null);
            Treino treinoCadastro = new Treino(opcaoCadastroExercicio, null, null, null, null, null, null);
            
            Exercicio exercicioBusca;//somente para buscas
            SubTreino subtreinoBusca;//somente para buscas
            Treino treinoBusca;//somente para buscas


        //USUARIO DE INICIALIZAÇÃO
            Administrador adminBase = new Administrador(1, "admin", null, null, null, "admin", null, "admin", null);

        //INICIO DO SISTEMA-------------------------------------------------
            System.out.println("Sistema de Academia-------------------------");


        //CADASTRO BASICO DE EXERCICIOS MODO TESTE
            if(modoTeste){
                for (int i = 0; i < 25; i++) {
                    controllerExecicio.cadastrarExercicio(new Exercicio("Exercicio"+i,i+"min", "10x"));
                }
            }
        

            
        //CADASTRO EXERCICIO
            /*  do {
               
                SubMenus.opcoesCadastroExercicio();
                opcaoCadastroExercicio = Entrada.entradaInt();
                sairOpcaoCadastroExercicio = false;//se for para true sai do menu

                switch (opcaoCadastroExercicio) {
                    case 0://SAIR
                        sairOpcaoCadastroExercicio = true;//sai do menu
                        break;
                    case 1://CADASTRO EXERCICIO

                        SubMenus.cadastroExercicio(exercicioCadastro);
                        System.out.println("Você deseja cadastrar o Exercicio?");
                        SubMenus.verExercicio(exercicioCadastro);

                        if (SubMenus.confimar()){
                            //alterar o exercicio pelo novo
                            controllerExecicio.cadastrarExercicio(new Exercicio(exercicioCadastro.getNomeExercicio(),
                            exercicioCadastro.getIntervalo(), exercicioCadastro.getRepeticoes()));

                            System.out.println("Exercicio Cadastrado:");
                        }else{
                            System.out.println("Operação Cancelada.");
                        }
                        sairOpcaoCadastroExercicio = false;//continua no menu

                        break; 
                    case 2://ALTERAR

                        //BUSCAR EXERCICIO
                        idBusca = SubMenus.buscarExercicio();
                        exercicioBusca = controllerExecicio.buscaExercicioId(idBusca);

                        if (exercicioBusca==null) {
                            System.out.println("Exercicio Não Encontrado");
                        } else {
                            System.out.println("Você deseja alterar o Exercicio?");
                            SubMenus.verExercicio(exercicioBusca);

                            if (SubMenus.confimar()){
                                SubMenus.alterarExercicio(exercicioCadastro, idBusca);

                                //alterar o exercicio pelo novo 
                                    exercicioBusca.setNomeExercicio(exercicioCadastro.getNomeExercicio());
                                    exercicioBusca.setIntervalo(exercicioCadastro.getIntervalo());
                                    exercicioBusca.setRepeticoes(exercicioCadastro.getRepeticoes());

                                System.out.println("Exercicio Alterado:");
                                SubMenus.verExercicio(exercicioBusca);
                            }else{
                                System.out.println("Operação Cancelada, Exercicio não foi alterado:");
                                SubMenus.verExercicio(exercicioBusca);
                            }
                        }

                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                    case 3://DELETAR

                        //BUSCAR EXERCICIO
                        idBusca = SubMenus.buscarExercicio();
                        exercicioBusca = controllerExecicio.buscaExercicioId(idBusca);

                        if (exercicioBusca==null) {
                            System.out.println("Exercicio Não Encontrado");
                        } else {
                            System.out.println("Você deseja EXCLUIR o Exercicio?");
                            SubMenus.verExercicio(exercicioBusca);

                            if (SubMenus.confimar()){
                                controllerExecicio.deletarTreino(idBusca);
                                System.out.println("Exercicio Excluido:");
                            }else{
                                System.out.println("Operação Cancelada, Exercicio não foi deletado:");
                                SubMenus.verExercicio(exercicioBusca);
                            }
                        }
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;

                    case 4://LISTA DE EXERCICIOS CADASTRADOS
                        System.out.println("Lista de Exercicios Cadastrados");
                        controllerExecicio.getExercicios().forEach(System.out::println);
                        System.out.println("----------------\n\n");
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                    default:
                        sairOpcaoCadastroExercicio = false;//continua no menu
                        break;
                }

            } while (!sairOpcaoCadastroExercicio);//se for para true sai do menu

            
*/


            //CADASTRO TREINO

            //PRECISA IMPLEMENTAR OS SUBTREINOS - NÃO CONSEGUI - JUAN.
            //ALGUM BUG NO CADASTRAR AQUECIMENTO, ESTÁ SENDO PULADO NA HORA DO CADASTRO.
            //Manti totalmente o padrão feito acima para mais fácil visualização.

             /*  do {

                SubMenus.opcoesCadastroTreino();
                opcaoCadastroTreino = Entrada.entradaInt();
                sairOpcaoCadastroTreino = false;// se for para true sai do menu
        
                switch (opcaoCadastroTreino) {
                    case 0:// SAIR
                        sairOpcaoCadastroTreino = true;// sai do menu
                        break;
                    case 1:// CADASTRAR TREINO

                        SubMenus.cadastroTreino(treinoCadastro);
                        System.out.println("Você deseja cadastrar o Treino?");
                        SubMenus.verTreino(treinoCadastro);
                        if (SubMenus.confimar()){

                            controllerTreino.cadastrarTreino(new Treino(treinoCadastro.getDuracao(),treinoCadastro.getNome(),treinoCadastro.getAquecimento(),treinoCadastro.getSugestaoDiasTreino(),treinoCadastro.getDataInicio(),treinoCadastro.getDataFim(),treinoCadastro.getSubtreinos()));

                            System.out.println("Treino Cadastrado:");
                        }else{
                            System.out.println("Operação Cancelada.");
                        }
                        sairOpcaoCadastroExercicio = false;//continua no menu

                        break;
                    case 2:// ALTERAR TREINO
        
                        // BUSCAR TREINO
                        idBusca = SubMenus.buscarTreino();
                        treinoBusca = controllerTreino.buscaTreinoId(idBusca);
        
                        if (treinoBusca == null) {
                            System.out.println("Treino Não Encontrado");
                        } else {
                            System.out.println("Você deseja alterar o Treino?");
                            SubMenus.verTreino(treinoBusca);
        
                            if (SubMenus.confimar()) {
                                SubMenus.alterarTreino(treinoCadastro, idBusca);
        
                                // Alterar o treino com os novos dados
                                treinoBusca.setNome(treinoCadastro.getNome());
                                treinoBusca.setDataInicio(treinoCadastro.getDataInicio());
                                treinoBusca.setDataFim(treinoCadastro.getDataFim());
                                treinoBusca.setDuracao(treinoCadastro.getDuracao());
                                treinoBusca.setAquecimento(treinoCadastro.getAquecimento());
                                treinoBusca.setSugestaoDiasTreino(treinoCadastro.getSugestaoDiasTreino());

        
                                System.out.println("Treino Alterado:");
                                SubMenus.verTreino(treinoBusca);
                            } else {
                                System.out.println("Operação Cancelada, Treino não alterado:");
                                SubMenus.verTreino(treinoBusca);
                            }
                        }
        
                        sairOpcaoCadastroTreino = false;// continua no menu
                        break;
                    case 3:// DELETAR TREINO
        
                        // BUSCAR TREINO
                        idBusca = SubMenus.buscarTreino();
                        treinoBusca = controllerTreino.buscaTreinoId(idBusca);
        
                        if (treinoBusca == null) {
                            System.out.println("Treino Não Encontrado");
                        } else {
                            System.out.println("Você deseja EXCLUIR o Treino?");
                            SubMenus.verTreino(treinoBusca);
        
                            if (SubMenus.confimar()) {
                                controllerTreino.deletarTreino(idBusca);
                                System.out.println("Treino Excluido:");
                            } else {
                                System.out.println("Operação Cancelada, Treino não deletado:");
                                SubMenus.verTreino(treinoBusca);
                            }
                        }
                        sairOpcaoCadastroTreino = false;// continua no menu
                        break;
        
                    case 4:// LISTAR TREINOS CADASTRADOS
                        System.out.println("Lista de Treinos Cadastrados");
                        controllerTreino.getTrienos().forEach(System.out::println);
                        System.out.println("----------------\n\n");
                        sairOpcaoCadastroTreino = false;// continua no menu
                        break;
                    default:
                        sairOpcaoCadastroTreino = false;// continua no menu
                        break;
                }
        
            } while (!sairOpcaoCadastroTreino);// se for para true sai do menu
        }

        */

            
       

        //CADASTRO SUBTREINOS 
        do {
            SubMenus.opcoesCadastroSubtreino();
            opcaoCadastroSubtreino = Entrada.entradaInt();
            sairOpcaoCadastroSubtreino = false; // Se for true, sai do menu
        
            switch (opcaoCadastroSubtreino) {
                case 0: // SAIR
                    sairOpcaoCadastroSubtreino = true; // Sai do menu
                    break;
                case 1: // CADASTRO SUBTREINO
        
                    SubMenus.cadastroSubtreino(subTreinoCadastro);
                    System.out.println("Você deseja cadastrar o Subtreino?");
                    SubMenus.verSubTreino(subTreinoCadastro);
        
                    if (SubMenus.confimar()) {
                        // Cadastrar o subtreino
                        controllerSubtreino.cadastrarSubTreino(new SubTreino(
                                subTreinoCadastro.getNome(),
                                subTreinoCadastro.getTipoSubtreino(),
                                subTreinoCadastro.getSexo(),
                                subTreinoCadastro.getLetra(),
                                new ArrayList<Exercicio>() 
                        ));
                        System.out.println("Subtreino cadastrado!");
                    } else {
                        System.out.println("Operação cancelada.");
                    }
                    sairOpcaoCadastroSubtreino = false; // Continua no menu
        
                    break;
                case 2: // ALTERAR
        
                    // BUSCAR SUBTREINO
                    idBusca = SubMenus.buscarSubTreino();
                    subtreinoBusca = controllerSubtreino.buscaSubTreinoId(idBusca);
        
                    if (subtreinoBusca == null) {
                        System.out.println("Subtreino não encontrado.");
                    } else {
                        System.out.println("Você deseja alterar o Subtreino?");
                        SubMenus.verSubTreino(subtreinoBusca);
        
                        if (SubMenus.confimar()) {
                            SubMenus.alterarSubTreino(subTreinoCadastro, idBusca);
        
                            // Alterar o subtreino
                            subtreinoBusca.setNome(subTreinoCadastro.getNome());
                            subtreinoBusca.setTipoSubtreino(subTreinoCadastro.getTipoSubtreino());
                            subtreinoBusca.setSexo(subTreinoCadastro.getSexo());
                            subtreinoBusca.setLetra(subTreinoCadastro.getLetra());
        
                            System.out.println("Subtreino alterado:");
                            SubMenus.verSubTreino(subtreinoBusca);
                        } else {
                            System.out.println("Operação cancelada, subtreino não foi alterado:");
                            SubMenus.verSubTreino(subtreinoBusca);
                        }
                    }
        
                    sairOpcaoCadastroSubtreino = false; // Continua no menu
                    break;
                case 3: // DELETAR
        
                    // BUSCAR SUBTREINO
                    idBusca = SubMenus.buscarSubTreino();
                    subtreinoBusca = controllerSubtreino.buscaSubTreinoId(idBusca);
        
                    if (subtreinoBusca == null) {
                        System.out.println("Subtreino não encontrado.");
                    } else {
                        System.out.println("Você deseja EXCLUIR o Subtreino?");
                        SubMenus.verSubTreino(subtreinoBusca);
        
                        if (SubMenus.confimar()) {
                            controllerSubtreino.deletarTreino(idBusca);
                            System.out.println("Subtreino excluído.");
                        } else {
                            System.out.println("Operação cancelada, subtreino não foi deletado:");
                            SubMenus.verSubTreino(subtreinoBusca);
                        }
                    }
                    sairOpcaoCadastroSubtreino = false; // Continua no menu
                    break;
                case 4: // LISTA DE SUBTREINOS CADASTRADOS
                    System.out.println("Lista de Subtreinos Cadastrados");
                    controllerSubtreino.getSubTreinos().forEach(System.out::println);
                    System.out.println("----------------\n\n");
                    sairOpcaoCadastroSubtreino = false; // Continua no menu
                    break;
                default:
                    sairOpcaoCadastroSubtreino = false; // Continua no menu
                    break;
            }
        
        } while (!sairOpcaoCadastroSubtreino); // Sai do menu se for true

        






       

        /*CADASTRO ALUNO

        int = TipoCadastro;
             do {
            System.out.println("Selecione o tipo de cadastro:");
            System.out.println("1. Aluno");
            System.out.println("2. Professor");
            System.out.println("3. Admin");
            tipoCadastro = scanner.nextInt();

            switch (tipoCadastro) {
                case 1:
                    menuAluno(scanner);
                    break;
                case 2:
                    menuProfessor(scanner);
                    break;
                case 3:
                    menuAdmin(scanner);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (tipoCadastro != 3);

        scanner.close();
    }

            do {
               
                SubMenus.opcoesCadastroAluno();
                opcaoCadastroAluno = Entrada.entradaInt();
                sairOpcaoCadastroAluno = false;//se for para true sai do menu

                switch (opcaoCadastroAluno) {
                    case 0://SAIR
                        sairOpcaoCadastroAluno = true;//sai do menu
                        break;
                    case 1://CADASTRO ALUNO

                        SubMenus.cadastroAluno(alunoCadastro);
                        System.out.println("Você deseja cadastrar o Aluno?");
                        SubMenus.verAluno(alunoCadastro);

                        if (SubMenus.confimar()){
                            //alterar o aluno pelo novo
                            controllerAluno.cadastrarAluno(new Aluno(alunoCadastro.getid(),alunoCadastro.getcpf()
                            alunoCadastro.getendereco(),alunoCadastro.getcelular(),alunoCadastro.getemail(),alunoCadastro.getsexo(),alunoCadastro.getsenha(),alunoCadastro.getdataNascimento(),alunoCadastro.gettrieno(), alunoCadastro.getavaliacoesFisicas()));

                            System.out.println("Aluno Cadastrado:");
                        }else{
                            System.out.println("Operação Cancelada.");
                        }
                        sairOpcaoCadastroAluno = false;//continua no menu

                        break; 
                    case 2://ALTERAR

                        //BUSCAR ALUNO
                        idBusca = SubMenus.buscarAluno();
                        alunoBusca = controllerAluno.buscaAlunoId(idBusca);

                        if (alunoBusca==null) {
                            System.out.println("Aluno Não Encontrado");
                        } else {
                            System.out.println("Você deseja alterar o Aluno?");
                            SubMenus.verAluno(AlunoBusca);

                            if (SubMenus.confimar()){
                                SubMenus.alterarAluno(alunoCadastro, idBusca);

                                //alterar o aluno pelo novo 
                                    alunoBusca.setid(alunoCadastro.getid());
                                    alunoBusca.setcpf(alunoCadastro.getcpf());
                                    alunoBusca.setenderecoa(alunoCadastro.getendereco());
                                    alunoBusca.setcelular(alunoCadastro.getcelular());
                                    alunoBusca.sexo(alunoCadastro.getemail());
                                    alunoBusca.setsenha(alunoCadastro.getemail());
                                    alunoBusca.setdataNascimento(alunoCadastro.getemail());
                                    alunoBusca.settrieno(alunoCadastro.getemail());
                                    alunoBusca.setavaliacoesFisicas(alunoCadastro.getavaliacoesFisicas());

                                System.out.println("Aluno Alterado:");
                                SubMenus.verAluno(alunoBusca);
                            }else{
                                System.out.println("Operação Cancelada, Aluno não foi alterado:");
                                SubMenus.verAluno(alunoBusca);
                            }
                        }

                        sairOpcaoCadastroAluno = false;//continua no menu
                        break;
                    case 3://DELETAR

                        //BUSCAR ALUNO
                        idBusca = SubMenus.buscarAluno();
                        alunoBusca = controllerAluno.buscaAlunoId(idBusca);

                        if (alunoBusca==null) {
                            System.out.println("Aluno Não Encontrado");
                        } else {
                            System.out.println("Você deseja EXCLUIR o Aluno?");
                            SubMenus.verAluno(alunoBusca);

                            if (SubMenus.confimar()){
                                controllerAluno.deletarAluno(idBusca);
                                System.out.println("Aluno Excluido:");
                            }else{
                                System.out.println("Operação Cancelada, Aluno não foi deletado:");
                                SubMenus.verAluno(alunoBusca);
                            }
                        }
                        sairOpcaoCadastroAluno = false;//continua no menu
                        break;

                    case 4://LISTA DE ALUNOS CADASTRADOS
                        System.out.println("Lista de Alunos Cadastrados");
                        controllerAluno.getAlunos().forEach(System.out::println);
                        System.out.println("----------------\n\n");
                        sairOpcaoCadastroAluno = false;//continua no menu
                        break;
                    default:
                        sairOpcaoCadastroAluno = false;//continua no menu
                        break;
                }

            } while (!sairOpcaoCadastroAluno);//se for para true sai do menu

            */



            /* CADASTRO PROFESSOR
            do {
               
                SubMenus.opcoesCadastroProfessor();
                opcaoCadastroProfessor = Entrada.entradaInt();
                sairOpcaoCadastroProfessor = false;//se for para true sai do menu

                switch (opcaoCadastroProfessor) {
                    case 0://SAIR
                        sairOpcaoCadastroProfessor = true;//sai do menu
                        break;
                    case 1://CADASTRO PROFESSOR

                        SubMenus.cadastroProfessor(professorCadastro);
                        System.out.println("Você deseja cadastrar o Professor?");
                        SubMenus.verProfessor(professorCadastro);

                        if (SubMenus.confimar()){
                            //alterar o professor pelo novo
                            controllerProfessor.cadastrarProfessor(new Professor(professorCadastro.getid(), professorCadastro.getnome(),
                            professorCadastro.getcpf(), professorCadastro.getendereco(), professorCadastro.getcelular(),professorCadastro.getemail(), professorCadastro.getsexo(), professorCadastro.getsenha(), professorCadastro.getdatanascimento()));

                            System.out.println("ProfessorCadastrado:");
                        }else{
                            System.out.println("Operação Cancelada.");
                        }
                        sairOpcaoCadastroProfessor = false;//continua no menu

                        break; 
                    case 2://ALTERAR

                        //BUSCAR PROFESSOR
                        idBusca = SubMenus.buscarProfessor();
                        professorBusca = controllerProfessor.buscaProfessorId(idBusca);

                        if (professorBusca==null) {
                            System.out.println("Professor Não Encontrado");
                        } else {
                            System.out.println("Você deseja alterar o Professor?");
                            SubMenus.verProfessor(ProfessorBusca);

                            if (SubMenus.confimar()){
                                SubMenus.alterarProfessor(professorCadastro, idBusca);

                                //alterar o professor pelo novo 
                                    professorBusca.setid(professorCadastro.getid());
                                    professorBusca.setnome(professorCadastro.getnome());
                                    professorBusca.setcpf(professorCadastro.getcpf());
                                    professorBusca.setendereco(professorCadastro.getendereco());
                                    professorBusca.setcelular(professorCadastro.getcelular());
                                    professorBusca.setemail(professorCadastro.getemail());
                                    professorBusca.setsexo(professorCadastro.getsexo());
                                    professorBusca.setsenha(professorCadastro.getsenha());
                                    professorBusca.setdatanascimento(professorCadastro.getdatanascimento());
                                    
                                System.out.println("Professor Alterado:");
                                SubMenus.verProfessor(professorBusca);
                            }else{
                                System.out.println("Operação Cancelada, Professor não foi alterado:");
                                SubMenus.verProfessor(professorBusca);
                            }
                        }

                        sairOpcaoCadastroProfessor = false;//continua no menu
                        break;
                    case 3://DELETAR

                        //BUSCAR PROFESSOR
                        idBusca = SubMenus.buscarProfessor();
                        professorBusca = controllerProfessor.buscaProfessorId(idBusca);

                        if (professorBusca==null) {
                            System.out.println("Professor Não Encontrado");
                        } else {
                            System.out.println("Você deseja EXCLUIR o Professor?");
                            SubMenus.verProfessor(professorBusca);

                            if (SubMenus.confimar()){
                                controllerProfessor.deletarProfessor(idBusca);
                                System.out.println("Professor Excluido:");
                            }else{
                                System.out.println("Operação Cancelada, Professor não foi deletado:");
                                SubMenus.verProfessor(professorBusca);
                            }
                        }
                        sairOpcaoCadastroProfessor = false;//continua no menu
                        break;

                    case 4://LISTA DE PROFESSOR CADASTRADOS
                        System.out.println("Lista de Professores Cadastrados");
                        controllerProfessor.getProfessores().forEach(System.out::println);
                        System.out.println("----------------\n\n");
                        sairOpcaoCadastroProfessor = false;//continua no menu
                        break;
                    default:
                        sairOpcaoCadastroProfessor = false;//continua no menu
                        break;
                }

            } while (!sairOpcaoCadastroProfessor);//se for para true sai do menu

            */

            /*CADASTRO ADMINISTRADOR

            //FALTOU MOSTRAR ALUNO, PROF E ADM

            do {
               
                SubMenus.opcoesCadastroAdministrador();
                opcaoCadastroAdministrador = Entrada.entradaInt();
                sairOpcaoCadastroAdministrador = false;//se for para true sai do menu

                switch (opcaoCadastroAdministrador) {
                    case 0://SAIR
                        sairOpcaoCadastroAdministrador = true;//sai do menu
                        break;
                    case 1://CADASTRO ADMINISTRADOR

                        SubMenus.cadastroAdministrador(administradorCadastro);
                        System.out.println("Você deseja cadastrar o Administrador?");
                        SubMenus.verAdministrador(adminitradorCadastro);

                        if (SubMenus.confimar()){
                            //alterar o administrador pelo novo
                            controllerAdministrador.cadastrarAdministrador(new Administrador(administradorCadastro.getid(),
                            administradorCadastro.getnome(), administradorCadastro.getcpf, administradorCadastro.getendereco, administradorCadastro.getcelular, administradorCadastro.getemail, administrador.Cadastro.getsexo, administradorCadastro.getsenha, administradorCadastro.getdataNascimento ()));

                            System.out.println("Administrador Cadastrado:");
                        }else{
                            System.out.println("Operação Cancelada.");
                        }
                        sairOpcaoCadastroAdministrador = false;//continua no menu

                        break; 
                    case 2://ALTERAR

                        //BUSCAR ADMINISTRADOR
                        idBusca = SubMenus.buscarAdministrador();
                        administradorBusca = controllerAdministrador.buscaAdministradorId(idBusca);

                        if (administradorBusca==null) {
                            System.out.println("Administrador Não Encontrado");
                        } else {
                            System.out.println("Você deseja alterar o Administrador?");
                            SubMenus.verAdministrador(administradorBusca);

                            if (SubMenus.confimar()){
                                SubMenus.alterarAdministrador(administradorCadastro, idBusca);

                                //alterar o administrador pelo novo 
                                    administradorBusca.setid(administradorCadastro.getid());
                                    administradorBusca.setnome(administradorCadastro.getnome());
                                    administradorBusca.setcpf(administradorCadastro.getcpf());
                                    administradorBusca.setendereco(administradorCadastro.getendereco());
                                    administradorBusca.setcelular(administradorCadastro.getcelular());
                                    administradorBusca.setemail(administradorCadastro.getemail());
                                    administradorBusca.setsexo(administradorCadastro.getsexo());
                                    administradorBusca.setsenha(administradorCadastro.getsenha());
                                    administradorBusca.setdataNascimento(administradorCadastro.getdataNascimento());

                                System.out.println("Administrador Alterado:");
                                SubMenus.verAdministrador(administradorBusca);
                            }else{
                                System.out.println("Operação Cancelada, Administrador não foi alterado:");
                                SubMenus.verAdministrador(administradorBusca);
                            }
                        }

                        sairOpcaoCadastroAdministrador = false;//continua no menu
                        break;
                    case 3://DELETAR

                        //BUSCAR ADMINISTRADOR
                        idBusca = SubMenus.buscarAdministrador();
                        administradorBusca = controllerAdministrador.buscaAdministradorId(idBusca);

                        if (administradorBusca==null) {
                            System.out.println("Administrador Não Encontrado");
                        } else {
                            System.out.println("Você deseja EXCLUIR o Administrador?");
                            SubMenus.verAdministrador(administradorBusca);

                            if (SubMenus.confimar()){
                                controllerAdministrador.deletarAdministrador(idBusca);
                                System.out.println("Administrador Excluido:");
                            }else{
                                System.out.println("Operação Cancelada, Administrador não foi deletado:");
                                SubMenus.verAdministrador(administradorBusca);
                            }
                        }
                        sairOpcaoCadastroAdministrador = false;//continua no menu
                        break;

                    case 4://LISTA DE ADMINISTRADOR CADASTRADOS
                        System.out.println("Lista de Administrador Cadastrados");
                        controllerAdministrador.getAdministradors().forEach(System.out::println);
                        System.out.println("----------------\n\n"); 
                        sairOpcaoCadastroAdministrador = false;//continua no menu
                        break;
                    default:
                        sairOpcaoCadastroAdministrador = false;//continua no menu
                        break;
                }

            } while (!sairOpcaoCadastroAdministrador);//se for para true sai do menu

            */
 
    }
}



