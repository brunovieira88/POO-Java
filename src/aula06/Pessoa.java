package aula06;

import aula05.DateYMD;

public class Pessoa {
    private String nome;
    private int cc;
    private DateYMD dataNasc;

    public Pessoa(String nome, int cc, DateYMD dataNasc){
        setName(nome);
        setDateNasc(dataNasc);
        setCC(cc);
    }


    public void setName(String nome){
        if (nome.length() < 3){
            throw new IllegalArgumentException("Nome deve ter no minimo 3 letras");
        }else{
            this.nome = nome;
        }
    }
    public String getName(){
        return this.nome;
    }

    public void setDateNasc(DateYMD dataNasc){
        this.dataNasc = dataNasc;
    }

    public String getDate(){
        return dataNasc.toString();
    }

    public void setCC(int cc){
        String strCC = String.valueOf(cc);
        if( strCC.length() != 9){
            throw new IllegalArgumentException("O cc deve ter 9 numeros");
        }else{
            this.cc = cc;
        }
    }

    public int getCC(){
        return cc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //em termos computacionais e desempenho concatenar strings é menos eficiente
        sb.append(nome).append(";");
        sb.append(" CC: ").append(cc).append(";");
        sb.append(" Data de nascimento: ").append(dataNasc.toString());
        return sb.toString();
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + cc;
        result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cc != other.cc)
            return false;
        if (dataNasc == null) {
            if (other.dataNasc != null)
                return false;
        } else if (!dataNasc.equals(other.dataNasc))
            return false;
        return true;
    }


    public static void main(String[] args) {
        DateYMD d = new DateYMD(5, 12, 1988);
        Pessoa p = new Pessoa("Ana Santos", 980122444, d);
        System.out.println(p.toString());
    }

}

