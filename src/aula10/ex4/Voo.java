package aula10.ex4;

public class Voo {
    private String hora, codigoVoo, origem, atraso, sigla, numero;

    Voo(String hora, String codigoVoo, String origem, String atraso){
        this.hora = hora;
        this.origem = origem;
        this.atraso = atraso; 
        this.codigoVoo = codigoVoo;
        if(codigoVoo.trim().contains(" ")){
            this.sigla = codigoVoo.split(" ")[0];
            this.numero = codigoVoo.split(" ")[1];
        }else{
            int splitPos = codigoVoo.replaceAll("[^A-Z]", "").length();
            this.sigla = codigoVoo.substring(0, splitPos);   
            this.numero = codigoVoo.substring(splitPos);     
        }
        
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOrigem() {
        return origem;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getAtraso() {
        return atraso;
    }

    public void setAtraso(String atraso) {
        this.atraso = atraso;
    }

    public int atrasoMinutos() {
        if (atraso == null || atraso.isEmpty()){
            return 0;
        } 
        String[] partes = atraso.split(":");
        return Integer.parseInt(partes[0]) * 60 + Integer.parseInt(partes[1]);
    }

    public String horaPrevista() {
        if (atraso == null || atraso.isEmpty()) {
            return this.hora;
        }
        String[] h = hora.split(":");
        int minutos = Integer.parseInt(h[0]) * 60 + Integer.parseInt(h[1]) + atrasoMinutos();
        return String.format("%02d:%02d", (minutos/ 60) % 24, minutos % 60);
    }

}
