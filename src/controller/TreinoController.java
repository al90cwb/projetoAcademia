package controller;

import java.util.List;

import model.Treino;

/**
 * Este Contrler Gerencia a lista de treinos cadastrados
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza] Data de criação: [28/05/2024]
 * Autor: [Alan Henrique de Souza] Revisão: [29/05/2024] 
 * Criação da lista , metodos buscar, cadastrar, excluir, criar codigo
 * 
 */


public class TreinoController {
    private List<Treino> trienos;

    public TreinoController(List<Treino> trienos) {
        this.trienos = trienos;
    }

    public List<Treino> getTrienos() {
        return trienos;
    }

    public void setTrienos(List<Treino> trienos) {
        this.trienos = trienos;
    }

    @Override
    public String toString() {
        return "TreinoContrller [trienos=" + trienos + "]";
    }

    public String cadastrarTreino(Treino treino) {
        if (buscaTreinoId(treino.getId() ) == null) {
            treino.setId(criarID());
            trienos.add(treino);
            return "Treino Cadastrado!";
        }
        return "Cliente Ja Existe!";
    }

    public void deletarTreino(int id){
        trienos.removeIf( t -> t.getId() == id);
    }

    public void limparTreinos(){
        trienos.clear();
    }

    public Treino buscaTreinoId(int id) {
        return trienos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public int criarID() {
        int res = 0;
        for (Treino p : trienos) {
            if (p.getId() > res)
                res = p.getId();
        }
        return ++res;
    }
    

    
}
