package view;

import java.time.LocalDate;
import java.util.Arrays;

import controller.AdministradorController;
import controller.AlunoController;
import controller.FactoryController;
import controller.ProfessorController;
import controller.TreinoController;
import model.Administrador;
import util.Entrada;
import util.Log;
import model.Aluno;
import model.Exercicio;
import model.FactoryClasses;
import model.Professor;
import model.Treino;

/**
 * A classe {@code AcademiaView} é responsável por exibir informações sobre
 * professores, alunos, e adiministradores
 * e coletar entrada do usuário para operações relacionadas aos professores,
 * alunos, e adiministradores
 * utilizando o console
 * <p>
 * Esta classe faz parte da camada de visualização na arquitetura MVC.
 * </p>
 * 
 * @version 1.0
 * @since 2024-06-07
 */

public class AcademiaView {
    public static void main(String[] args) throws Exception {

        FactoryController factoryController = new FactoryController();
        FactoryClasses factoryClasses = new FactoryClasses();

        AlunoController controllerAluno = factoryController.ciarAlunoController();
        TreinoController controllerTreino = factoryController.criarTreinoController();
        ProfessorController controllerProfessor = factoryController.criarProfessorController();
        AdministradorController controllerAdministrador = factoryController.criarAdministradorController();

        boolean modoTeste = false;

        if (modoTeste) {

            // Criando um adm
            controllerAdministrador.cadastrar(factoryClasses.criarAdministrador(0, "Alan", "1111", "Rua A",
                    "41999999999", "alan@email.com", "masculino", "1111",
                    LocalDate.parse("15/05/1980", Entrada.getFormatoData())));

            // Criando dois professores
            controllerProfessor.cadastrar(factoryClasses.criarProfessor(1, "Pedro", "07605408591", "Rua Do meio",
                    "41995362145", "pedro@email.com", "masculino", "123456789",
                    LocalDate.parse("29/12/1990", Entrada.getFormatoData())));

            controllerProfessor.cadastrar(factoryClasses.criarProfessor(0, "Maria", "07605408592", "Rua Da frente",
                    "41995362146", "maria@email.com", "feminino", "987654321",
                    LocalDate.parse("15/08/1985", Entrada.getFormatoData())));

            // Criando quatro alunos
            controllerAluno.cadastrar(factoryClasses.criarAluno(1, "Carlos", "12345678901", "Rua A",
                    "41999999999", "carlos@email.com", "masculino", "111111111",
                    LocalDate.parse("15/05/2000", Entrada.getFormatoData()), false, null, 0, null, null));

            controllerAluno.cadastrar(factoryClasses.criarAluno(2, "Ana", "98765432109", "Rua B",
                    "41988888888", "ana@email.com", "feminino", "222222222",
                    LocalDate.parse("20/10/1998", Entrada.getFormatoData()), false, null, 0, null, null));

            controllerAluno.cadastrar(factoryClasses.criarAluno(3, "Paulo", "12312312312", "Rua C",
                    "41977777777", "paulo@email.com", "masculino", "333333333",
                    LocalDate.parse("05/12/2001", Entrada.getFormatoData()), false, null, 0, null, null));

            controllerAluno.cadastrar(factoryClasses.criarAluno(4, "Maria", "32132132132", "Rua D",
                    "41966666666", "maria@email.com", "feminino", "444444444",
                    LocalDate.parse("30/01/1999", Entrada.getFormatoData()), false, null, 0, null, null));

            // Criando treinos com listas de exercícios
            Treino treino1 = factoryClasses.criarTreino("Treino A", "Hipertrofia");
            Treino treino2 = factoryClasses.criarTreino("Treino B", "Resistência");
            Treino treino3 = factoryClasses.criarTreino("Treino C", "Força");
            Treino treino4 = factoryClasses.criarTreino("Treino D", "Iniciante");

            // Adicionando exercícios ao treino 1
            treino1.adicionarExercicio(factoryClasses.criarExercicio("Supino", "1 min", "10 repetições"));
            treino1.adicionarExercicio(factoryClasses.criarExercicio("Agachamento", "1 min", "12 repetições"));
            treino1.adicionarExercicio(factoryClasses.criarExercicio("Cadeira Extensora", "1 min", "15 repetições"));
            treino1.adicionarExercicio(factoryClasses.criarExercicio("Puxada Frontal", "1 min", "12 repetições"));
            treino1.adicionarExercicio(
                    factoryClasses.criarExercicio("Desenvolvimento de Ombros", "1 min", "10 repetições"));
            treino1.adicionarExercicio(factoryClasses.criarExercicio("Rosca Direta", "1 min", "12 repetições"));
            treino1.adicionarExercicio(factoryClasses.criarExercicio("Tríceps Corda", "1 min", "15 repetições"));
            treino1.adicionarExercicio(factoryClasses.criarExercicio("Leg Press", "1 min", "12 repetições"));
            treino1.adicionarExercicio(factoryClasses.criarExercicio("Panturrilha", "1 min", "15 repetições"));
            treino1.adicionarExercicio(factoryClasses.criarExercicio("Abdominal", "1 min", "20 repetições"));

            // Adicionando exercícios ao treino 2
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Corrida", "2 min", "5 séries"));
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Ciclismo", "2 min", "5 séries"));
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Elíptico", "2 min", "5 séries"));
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Remo", "2 min", "5 séries"));
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Salto no Banco", "2 min", "5 séries"));
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Burpees", "2 min", "5 séries"));
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Escalada", "2 min", "5 séries"));
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Pular Corda", "2 min", "5 séries"));
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Flexão", "2 min", "5 séries"));
            treino2.adicionarExercicio(factoryClasses.criarExercicio("Mountain Climbers", "2 min", "5 séries"));

            // Adicionando exercícios ao treino 3
            treino3.adicionarExercicio(factoryClasses.criarExercicio("Levantamento Terra", "1 min", "8 repetições"));
            treino3.adicionarExercicio(factoryClasses.criarExercicio("Supino Inclinado", "1 min", "8 repetições"));
            treino3.adicionarExercicio(factoryClasses.criarExercicio("Agachamento Frontal", "1 min", "8 repetições"));
            treino3.adicionarExercicio(factoryClasses.criarExercicio("Remada Curvada", "1 min", "8 repetições"));
            treino3.adicionarExercicio(
                    factoryClasses.criarExercicio("Desenvolvimento Militar", "1 min", "8 repetições"));
            treino3.adicionarExercicio(factoryClasses.criarExercicio("Barra Fixa", "1 min", "8 repetições"));
            treino3.adicionarExercicio(factoryClasses.criarExercicio("Rosca Scott", "1 min", "8 repetições"));
            treino3.adicionarExercicio(factoryClasses.criarExercicio("Tríceps Testa", "1 min", "8 repetições"));
            treino3.adicionarExercicio(factoryClasses.criarExercicio("Leg Press", "1 min", "8 repetições"));
            treino3.adicionarExercicio(factoryClasses.criarExercicio("Panturrilha", "1 min", "12 repetições"));

            // Adicionando exercícios ao treino 4
            treino4.adicionarExercicio(factoryClasses.criarExercicio("Caminhada", "2 min", "5 séries"));
            treino4.adicionarExercicio(factoryClasses.criarExercicio("Alongamento", "2 min", "5 séries"));
            treino4.adicionarExercicio(factoryClasses.criarExercicio("Agachamento Livre", "2 min", "10 repetições"));
            treino4.adicionarExercicio(factoryClasses.criarExercicio("Polichinelos", "2 min", "10 repetições"));
            treino4.adicionarExercicio(factoryClasses.criarExercicio("Flexão de Braço", "2 min", "10 repetições"));
            treino4.adicionarExercicio(factoryClasses.criarExercicio("Abdominal Supra", "2 min", "10 repetições"));
            treino4.adicionarExercicio(
                    factoryClasses.criarExercicio("Levantamento de Pernas", "2 min", "10 repetições"));
            treino4.adicionarExercicio(factoryClasses.criarExercicio("Prancha", "2 min", "30 segundos"));
            treino4.adicionarExercicio(factoryClasses.criarExercicio("Remada Curvada", "2 min", "10 repetições"));
            treino4.adicionarExercicio(factoryClasses.criarExercicio("Rosca Direta", "2 min", "10 repetições"));

            controllerTreino.cadastrar(treino1);
            controllerTreino.cadastrar(treino2);
            controllerTreino.cadastrar(treino3);
            controllerTreino.cadastrar(treino4);

        }

        String cpf, senha;
        Professor professor = null;
        Aluno aluno = null;
        Administrador administrador = null;
        int nivelAcesso = 0;
        boolean sairPrincipal = false;

        do {
            System.out.println("\n\nSistema de Academia-------------------------");

            boolean sairOpcao = false;
            do {

                professor = null;
                administrador = null;
                aluno = null;
                nivelAcesso = 0;

                System.out.println("Login - Informe CPF");
                cpf = Entrada.entradaString();
                System.out.println("Informe senha");
                senha = Entrada.entradaString();

                try {
                    administrador = controllerAdministrador.buscaCpf(cpf);
                } catch (Exception e) {
                    throw new Exception(e + "Falha na busca de administrador");
                }
                try {
                    professor = controllerProfessor.buscaCpf(cpf);
                } catch (Exception e) {
                    throw new Exception(e + "Falha na busca de professor");
                }
                try {
                    aluno = controllerAluno.buscaCpf(cpf);
                } catch (Exception e) {
                    throw new Exception(e + "Falha na busca de aluno");
                }

                if (administrador != null) {
                    if (administrador.getSenha().equals(senha)) {
                        nivelAcesso = 3;
                        sairOpcao = true;
                    }
                }
                if (professor != null) {
                    if (professor.getSenha().equals(senha)) {
                        nivelAcesso = 2;
                        sairOpcao = true;
                    }
                }

                if (aluno != null) {
                    if (aluno.getSenha().equals(senha)) {
                        nivelAcesso = 1;
                        sairOpcao = true;
                    }
                }

                if (nivelAcesso == 0) {
                    Log.gravar("Usuario Não encontrador");
                    System.err.println("Usuario Não encontrador, deseja efetuar novo login");
                    sairOpcao = !MenuPadrao.exibirConfirmar();
                    sairPrincipal = sairOpcao;
                    Entrada.limparBuffer();
                }

            } while (!sairOpcao);

            switch (nivelAcesso) {
                case 1:
                    Log.gravar("Login " + aluno.getNome());
                    System.out.println("\n\nSeja Bem Vindo " + aluno.getNome());
                    sairPrincipal = MenuAluno.exibirMenuPrincipal(aluno);
                    break;
                case 2:
                    Log.gravar("Login " + professor.getNome());
                    System.out.println("\n\nSeja Bem Vindo " + professor.getNome());
                    sairPrincipal = MenuProfessor.exibirMenuPrincipal(controllerTreino, controllerAluno,
                            factoryClasses);
                    break;
                case 3:
                    Log.gravar("Login " + administrador.getNome());
                    System.out.println("\n\nSeja Bem Vindo " + administrador.getNome());
                    sairPrincipal = MenuAdministrador.exibirMenuPrincipal(controllerAluno, controllerProfessor,
                            controllerAdministrador, factoryClasses);
                    break;
                default:
                    sairPrincipal = true;
                    Log.gravar("Sistema Encerrado");
                    break;
            }

            if (!sairPrincipal)
                Entrada.limparBuffer();

        } while (!sairPrincipal);
        System.out.println("SISTEMA ENCERRADO");

    }
}
