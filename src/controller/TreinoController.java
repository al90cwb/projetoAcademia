package controller;

import java.util.List;

import model.Treino;
import util.Log;
import util.SerTreino;

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
         try {
            carregarDados();
        } catch (Exception e) {
            System.err.println("ERRO AO CARREGAR DADOS TRIENO");
        }
    }

    public void cadastrarTreino(Treino treino) throws Exception {
        if (buscaTreinoId(treino.getId()) == null) {
            treino.setId(criarID());
            treinos.add(treino);
            Log.gravar("Cadastro treino " +treino.getNome());
        }else{
            Log.gravar("Falha no cadastro treino");
        }
        salvarDados();
    }

    public List<Treino> getTreinos() {
        return treinos;
    }


    public void deletar(int id) throws Exception {
        treinos.removeIf(t -> t.getId() == id);
        Log.gravar("Treino Deletado ");
        salvarDados();
    }

    public Treino buscaTreinoId(int id) {
        return treinos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
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

    public void salvarDados() throws Exception{
        SerTreino.salvar(treinos);
    }

    private void carregarDados() throws Exception{
        treinos = SerTreino.ler();
    }


}
