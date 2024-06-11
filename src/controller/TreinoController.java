package controller;

import java.util.List;

import model.Treino;

/**
 * A classe {@code TreinoController} é responsável por gerenciar as operações
 * relacionadas aos treinos, como criação, atualização, exclusão e recuperação
 * de treinos.
 * 
 * @version 1.0
 * @since 2024-06-07
 */

public class TreinoController {
    private List<Treino> treinos;
    private List<Treino> listaBusca;

    public TreinoController(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public String cadastrarTreino(Treino treino) {
        if (buscaTreinoId(treino.getId()) == null) {
            treino.setId(criarID());
            treinos.add(treino);
            return "Treino Cadastrado!";
        }
        return "Treino Ja Existe!";
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public void deletar(int id) {
        treinos.removeIf(t -> t.getId() == id);
    }

    public Treino buscaTreinoId(int id) {
        return treinos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limparTreinos() {
        treinos.clear();
    }

    public int criarID() {
        int res = 0;
        for (Treino p : treinos) {
            if (p.getId() > res)
                res = p.getId();
        }
        return ++res;
    }

    public List<Treino> pesquisaPorTipo(String tipo) {
        if (listaBusca != null) {
            listaBusca.clear();
        }
        for (Treino treino : treinos) {
            if (treino.getTipoTreino().equals(tipo)) {
                listaBusca.add(treino);
            }
        }
        return listaBusca;
    }

}
