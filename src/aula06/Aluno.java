package aula06;

import aula05.DateYMD;
import java.time.LocalDate;

public class Aluno extends Pessoa {
    private static int lastNMEC = 100;
    private int nMec;
    private DateYMD dataInsc;

    public Aluno(String nome, int cc, DateYMD dataNasc, DateYMD dataInsc) {
        super(nome, cc, dataNasc);
        this.nMec = lastNMEC++;
        setDataInsc(dataInsc);
    }

    public Aluno(String nome, int cc, DateYMD dataNasc) {
        super(nome, cc, dataNasc);
        this.nMec = lastNMEC++;
        LocalDate today = LocalDate.now(); //nao era necessario ir literalmente buscar a data de atual 
        this.dataInsc = new DateYMD(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
        System.out.println(dataInsc.toString());
    }

    public void setDataInsc(DateYMD dataInsc){
        this.dataInsc = dataInsc;
    }

    public String getDataInsc(){
        return dataInsc.toString();
    }

    public void setNMEC(int nMEC){
        if (nMEC <= lastNMEC){
            throw new IllegalArgumentException("nMEC invalido");
        }
        else{
            this.nMec = nMEC;
        }
    }

    public int getNMEC(){
        return nMec;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; Aluno: nMec= ").append(nMec);
        sb.append(", data de incriçao: ").append(dataInsc);
        return sb.toString();
    }

    public static void main(String[] args) {
        DateYMD d = new DateYMD(5, 12, 2006);
        Aluno p = new Aluno("Ana Santos", 980122444, d);
        System.out.println(p.toString());
        Aluno s = new Aluno("Carlos Gomes", 999122444, d);
        System.out.println(s.toString());
    }
    

}
