package projeto;

import java.util.ArrayList;

/**
  * @author Itach
 */
public class Departamento {
    private int Codigo;
    private String Nome;
    ArrayList<Funcionario> ListaFunc;

    public Departamento() {
        ListaFunc = new ArrayList();
    }

    public Departamento(int Codigo, String Nome) {
        this.Codigo = Codigo;
        this.Nome = Nome;
        ListaFunc = new ArrayList();
    }

    Departamento(double cod, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public ArrayList<Funcionario> getListaFunc() {
        return ListaFunc;
    }

    public void setListaFunc(ArrayList<Funcionario> ListaFunc) {
        this.ListaFunc = ListaFunc;
    }
    
    public void addFunc(Funcionario F){
        F.setDep(this);
        ListaFunc.add(F);
    }
}
