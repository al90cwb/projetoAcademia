package view;

/**
 * A interface {@code iMenu} define métodos para exibir diferentes opções de
 * menu
 * em uma aplicação.
 * <p>
 * Esta interface faz parte da camada de visualização na arquitetura MVC.
 * Os métodos definidos aqui são para exibir opções e menus principais,
 * bem como operações de alteração, exclusão, busca, cadastro e visualização de
 * usuários.
 * </p>
 * 
 * @version 1.0
 * @since 2024-06-07
 */
public interface iMenu {
    /**
     * Exibe as opções disponíveis no menu.
     */
    public static void opcoes() {
    };

    /**
     * Exibe o menu principal da aplicação.
     */
    public static void menuPrincipal() {
    };

    /**
     * Exibe as opções de alteração disponíveis no menu.
     */
    public static void opcaoAlteracao() {
    };

    /**
     * Exibe a opção de deletar um item ou usuário no menu.
     */
    public static void deletar() {
    };

    /**
     * Exibe a opção de buscar um item ou usuário no menu.
     */
    public static void buscar() {
    };

    /**
     * Exibe a opção de cadastro de um novo item ou usuário no menu.
     */
    public static void cadastro() {
    };

    /**
     * Exibe a informação de um usuário específico.
     */
    public static void verUsuario() {
    };

    /**
     * Exibe a lista de todos os usuários.
     */
    public static void verListaDeUsuarios() {
    };
}
