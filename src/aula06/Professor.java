package aula06;

import aula05.DateYMD;

public class Professor extends Pessoa{
    private String categoria, departamento;

    public Professor(String nome, int cc, DateYMD dataNasc, String categoria, String departamento){
        super(nome, cc, dataNasc);
        setCategoria(categoria);
        setDepartamento(departamento);
    }

    public void setCategoria(String categoria){
        if (categoria.toLowerCase().equals("auxiliar")|| categoria.toLowerCase().equals("associado") || categoria.toLowerCase().equals("“catedrático")) {
            this.categoria = categoria;
        }else{
            throw new IllegalArgumentException("Categoria invalida");
        }
    }

    public String getCategoria(){
        return categoria;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public String getDepartamento(String departamento){
        return departamento;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" ;Professor: categoria: ").append(categoria);
        sb.append(", departamento: ").append(departamento);
        return sb.toString();
    }
}
