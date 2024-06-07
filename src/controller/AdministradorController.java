package controller;
import java.util.List;
import model.Administrador;

public class AdministradorController {
    private List<Administrador> administradores;

    public AdministradorController(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    @Override
    public String toString() {
        return "AdministradorController [administradores=" + administradores + "]";
    }

    public String cadastrarAdministrador(Administrador administrador) {
        if (buscaAdministradorId(administrador.getId() ) == null) {
            administrador.setId(criarID());
            administradores.add(administrador);
            return "Aluno Cadastrado!";
        }
        return "Aluno Ja Existe!";
    }

    public void deletarAdministrador(int id){
        administradores.removeIf( t -> t.getId() == id);
    }

    public Administrador buscaAdministradorId(int id) {
        return administradores.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void limparAdministradores(){
        administradores.clear();
    }

     public int criarID() {
        int res = 0;
        for (Administrador a : administradores) {
            if (a.getId() > res)
                res = a.getId();
        }
        return ++res;
    }


}