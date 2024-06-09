package model;

import java.time.LocalDate;
import java.util.List;

/**
 * Este Objeto contem os dados de aluno
 * Contem um trieno que é copiado do sistema principal de treinos
 * Contem todos os dados herdados de usuario
 * Contem uma lista de avaliações fisicas desse aluno
 * Tem acesso de visualização do treino, avaliações e solicitaçaõ de novo
 * treino.
 * Versão: 1.0
 * Autor: [Alan Henrique de Souza]
 * Data de criação: [28/05/2024]
 */

public class Aluno extends Usuario {

    private Treino treino;
    private List<AvaliacaoFisica> avaliacoesFisicas;
    private boolean substituirTreino;
    private LocalDate dataAtual ;
    private LocalDate dataInicio, dataFim;

    public Aluno() {
    }
    
    public Aluno(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento, Treino trieno, List<AvaliacaoFisica> avaliacoesFisicas,
            boolean substituirTreino) {
        super(id, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento);
        this.treino = trieno;
        this.avaliacoesFisicas = avaliacoesFisicas;
        this.substituirTreino = substituirTreino;
    }


    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setTrieno(Treino trieno) {
        this.treino = trieno;
        dataInicio =LocalDate.now();
        dataFim = dataInicio.plusDays(treino.getDuracao());
        isSubstituirTreino();
    }

    public Treino getTreino() {
        return treino;
    }


    public List<AvaliacaoFisica> getAvaliacoesFisicas() {
        return avaliacoesFisicas;
    }

    public void setAvaliacoesFisicas(List<AvaliacaoFisica> avaliacoesFisicas) {
        this.avaliacoesFisicas = avaliacoesFisicas;
    }

    public int criarID() {
        int res = 0;
        for (AvaliacaoFisica p : avaliacoesFisicas) {
            if (p.getId() > res)
                res = p.getId();
        }
        return ++res;
    }

    public String cadastrarAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        avaliacaoFisica.setId(criarID());
        avaliacoesFisicas.add(avaliacaoFisica);
        return "Avaliação Cadastrada";
    }

    public boolean isSubstituirTreino() {
        return substituirTreino;
    }

    public void setSubstituirTreino(boolean substituirTreino) {
        this.substituirTreino = substituirTreino;
    }

    @Override
    public String toString() {

        return "Aluno [id=" + super.getId() + ", nome=" + super.getNome() + ", cpf=" + super.getCpf() + ", endereco="
                + super.getEndereco() + ", celular="
                + super.getCelular() + ", email=" + super.getEmail() + ", sexo=" + super.getSexo() + ", senha="
                + super.getSenha() + ", dataNascimento="
                + super.getDataNascimento() + ", treino=" + treino + ", avaliacoesFisicas=" + avaliacoesFisicas + ", substituirTreino="  + substituirTreino + "]";
    }



}
