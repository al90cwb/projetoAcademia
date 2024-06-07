package controller;

import java.util.List;

import model.Usuario;

/**
 * Este Contrler Gerencia a lista de usuarios cadastrados
 * Versão: 1.0
 * Autor: [Leonardo Pilato] Data de criação: [01/06/2024]
 * Autor: [Leonardo Pilato] Revisão: [01/06/2024] 
 * Criação da lista , metodos buscar, cadastrar, excluir, criar codigo
 */
public abstract class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }


    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    } 
    

    @Override
    public String toString() {
        return "Usuariocontroller [usuarios=" + usuarios + "]";
    }

    public String cadastrarUsuario(Usuario usuario) {
        if (buscaUsuarioId(usuario.getId() ) == null) {
            usuario.setId(criarID());
            usuarios.add(usuario);
            return "Usuario Cadastrado!";
        }
        return "Usuario Ja Existe!";
    }

    public void deletarUsuario(int id){
        usuarios.removeIf( t -> t.getId() == id);
    }

    public Usuario buscaUsuarioId(int id) {
        return usuarios.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limparUsuarios(){
        usuarios.clear();
    }
    
    public boolean login(String nomeUsuario, String senha) {
    	Usuario usuario = usuarios.stream().filter(c -> c.getNome() == nomeUsuario).findFirst().orElse(null);
    	
    	if (usuario.getSenha() != senha) {
    	
    		return false;
    	}
    	
    	return true;
    }
   

    public int criarID() {
        int res = 0;
        for (Usuario a : usuarios) {
            if (a.getId() > res)
                res = a.getId();
        }
        return ++res;
    }

   
}
