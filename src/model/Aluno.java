package model;

import java.time.LocalDate;
import java.util.List;

public class Aluno extends Usuario  {

    private Treino trieno;
    private List<AvaliacaoFisica> avaliacoesFisicas;


    public Aluno(Treino trieno, List<AvaliacaoFisica> avaliacoesFisicas) {
        this.trieno = trieno;
        this.avaliacoesFisicas = avaliacoesFisicas;
    }


    public Aluno(int id, String nome, String cpf, String endereco, String celular, String email, String sexo,
            String senha, LocalDate dataNascimento, Treino trieno, List<AvaliacaoFisica> avaliacoesFisicas) {
        super(id, nome, cpf, endereco, celular, email, sexo, senha, dataNascimento);
        this.trieno = trieno;
        this.avaliacoesFisicas = avaliacoesFisicas;
    }
    
    public Treino getTrieno() {
        return trieno;
    }


    public void setTrieno(Treino trieno) {
        this.trieno = trieno;
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

    @Override
    public String toString() {
        return "Aluno [id=" + super.getId() + ", nome=" + super.getNome() + ", cpf=" + super.getCpf() + ", endereco=" + super.getEndereco() + ", celular="
                + super.getCelular() + ", email=" + super.getEmail() + ", sexo=" + super.getSexo() + ", senha=" + super.getSenha() + ", dataNascimento="
                + super.getDataNascimento() + ", trieno=" + trieno + ", avaliacoesFisicas=" + avaliacoesFisicas + "]";
    }
}
