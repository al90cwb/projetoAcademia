package controller;

import java.util.List;

import model.SubTreino;

/**
 * Este Contrler Gerencia a lista de Subtrienos cadastrados
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza] Data de criação: [28/05/2024]
 * Autor: [Alan Henrique de Souza] Revisão: [29/05/2024] 
 * Criação da lista , metodos buscar, cadastrar, excluir, criar codigo
 */
public class SubtreinoController {
    private List<SubTreino> subTreinos;

    public SubtreinoController(List<SubTreino> subTreinos) {
        this.subTreinos = subTreinos;
    }

    public String cadastrarSubTreino(SubTreino subTreino) {
        if (buscaSubTreinoId(subTreino.getId() ) == null) {
            subTreino.setId(criarID());
            subTreinos.add(subTreino);
            return "SubTreino Cadastrado!";
        }
        return "Subtreino Ja Existe!";
    }

    public List<SubTreino> getSubTreinos() {
        return subTreinos;
    }

    public void setSubTreinos(List<SubTreino> subTreinos) {
        this.subTreinos = subTreinos;
    }

    public void deletarTreino(int id){
        subTreinos.removeIf( t -> t.getId() == id);
    }

    public SubTreino buscaSubTreinoId(int id) {
        return subTreinos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limparSubtreinos(){
        subTreinos.clear();
    }

    public int criarID() {
        int res = 0;
        for (SubTreino p : subTreinos) {
            if (p.getId() > res)
                res = p.getId();
        }
        return ++res;
    }
}
