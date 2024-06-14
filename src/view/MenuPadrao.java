package view;

import util.Entrada;

/**
 * A classe abstrata {@code MenusPadrao} exibe opções de Menu Padrao e executa
 * operações
 * relacionadas aos administradores, alunos e professores.
 * <p>
 * Esta classe faz parte da camada de visualização na arquitetura MVC.
 * </p>
 *
 * @version 1.0
 * @since 2024-06-07
 */

public abstract class MenuPadrao  {

    public static boolean exibirConfirmar() {
        System.out.println("0=NÃO,1=SIM");
        return Entrada.entradaZeroUm() == 1;
    }

}
