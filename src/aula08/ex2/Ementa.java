package aula08.ex2;

import java.util.EnumMap;
import java.util.Map;

public class Ementa {
    public enum DiaSemana {
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }
    public enum VariedadeCarne {
        VACA, PORCO, PERU, FRANGO, OUTRA
    }
    
    public enum TipoPeixe {
        CONGELADO, FRESCO
    }
    
    private String nome;
    private String local;
    private Map<DiaSemana, Prato> pratos;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        this.pratos = new EnumMap<>(DiaSemana.class);
    }
    
    public void addPrato(Prato prato, DiaSemana dia) {
        pratos.put(dia, prato);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Ementa final\n");
        sb.append("--------------------\n");
        
        for (DiaSemana dia : DiaSemana.values()) {
            Prato prato = pratos.get(dia);
            if (prato != null) {
                sb.append(prato).append(", dia ").append(dia).append("\n");
            }
        }
        return sb.toString();
    }
}
