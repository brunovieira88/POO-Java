package Ex2;

import java.util.ArrayList;

public class Encaminhador {
    private String nome;
    private ArrayList <Pacote> pacotes;
    private Pacote ultimoPacoteEnviado = null;

    Encaminhador (String nome){
        this.nome = nome;
        pacotes = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void addPacote(Pacote p){
        pacotes.add(p);
    }

    public void removePacote(Pacote p){
        for (Pacote p2 : pacotes){
            if(p.equals(p2)){
                pacotes.remove(p2);
                return;
            }
        }
        System.out.println("pacote nao encontrado");
        }

    public void enviarPacote(){
        if(hasPacotes()){
            Pacote pacoteAtual = pacotes.get(0);
            if(!pacoteAtual.equals(ultimoPacoteEnviado)){
                System.out.println(pacoteAtual.toString());
                ultimoPacoteEnviado = pacoteAtual;
                pacotes.remove(0);
            } else {
                System.out.println("(pacote duplicado)");
                pacotes.remove(0); 
            }
        } else {
            System.out.println("nao ha pacotes disponiveis");
        }
    }

        public boolean hasPacotes(){
        if(pacotes.size()>0){
            return true;
        }else return false;
    }

    public int getTamanhoFila(){
        int tamanho=0;
        for(Pacote p: pacotes){
            if(p instanceof TCP){
                tamanho += ((TCP)p).getMensagem().length();
            }
            else{
                if(p instanceof UDP){
                    tamanho += ((UDP)p).getMensagem().length();
            }
            }
        }
        return tamanho;
    }

    @Override

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Encaminhador ").append(nome).append(" esta UP, ");
        sb.append("tamanhoFila= ").append(getTamanhoFila());
        return sb.toString();
    }

}
