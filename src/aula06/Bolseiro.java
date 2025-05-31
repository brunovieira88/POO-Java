package aula06;

import aula05.DateYMD;

public class Bolseiro extends Aluno{
    private double bolsa;
    private Professor profAux;

    public Bolseiro(String nome, int cc, DateYMD dataNasc, DateYMD dataInsc, double bolsa, Professor profAux) {
        super(nome, cc, dataNasc, dataInsc);
        setBolsa(bolsa);
        setProfAux(profAux);
    }

    

    public Bolseiro(String nome, int cc, DateYMD dataNasc, double bolsa, Professor profAux) {
        super(nome, cc, dataNasc);
        setBolsa(bolsa);
        setProfAux(profAux);
    }



    public void setBolsa(double bolsa){
        if(bolsa>0){
            this.bolsa=bolsa;
        }else{
            throw new IllegalArgumentException("Valor bolsa invalido");    
        }
    }

    public double getBolsa(){
        return bolsa;
    }

    public void setProfAux(Professor profAux){
        this.profAux = profAux;
    }

    public String getProfAux(){
        return profAux.toString();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; Bolseiro: valor da bolsa: ").append(bolsa);
        sb.append(", professor auxiliar: ").append(profAux.toString());
        return sb.toString();
    }

    
}
