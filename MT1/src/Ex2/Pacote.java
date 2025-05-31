package Ex2;

public class Pacote {
    private String source, destino;

    Pacote (String source , String destino){
        if(validEndereco(source)){
            this.source = source;
        }else{
            System.out.println("endereco da source nao valido");
        }
        if(validEndereco(destino)){
            this.destino = destino;
        }else{
            System.out.println("endereco do destino nao valido");
        }
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        if (validEndereco(source)){
            this.source = source;
        }
        else{
            System.out.println("endereco da source nao valido");
        }
        
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        if(validEndereco(destino)){
            this.destino = destino;
        }
        else{
            System.out.println("endereco do destino nao valido");
        }
    }

    private Boolean validEndereco(String endereco){
        if( endereco.matches("^([0-255][.]){3}[0-255]$")){
            return true;
        }
        else return false;
    }

    @Override

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("(").append("source: ").append(source).append(", destination: ").append(destino);
        return sb.toString();
    } 

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pacote other = (Pacote) obj;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        return true;
    }
    
    
}
