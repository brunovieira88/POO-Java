package Ex2;

public class UDP extends Pacote{
    private String mensagem;

    UDP(String source , String destino, String mensagem){
        super(source, destino);
        if (validMensagem(mensagem)){
            this.mensagem = mensagem;
        }
        else{
            System.out.println("mensagem excedeu o limite (1480)");
        }
    }

    public String getMensagem(){
        return mensagem;
    }

    public void setMensagem(String mensagem){
        if (validMensagem(mensagem)){
            this.mensagem = mensagem;
        }
        else{
            System.out.println("mensagem excedeu o limite (1480)");
        }
    }

    private boolean validMensagem(String mensagem){
        if (mensagem.length()<1481){
            return true;
        }
        else return false;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(")");
        sb.append(" msg: ").append("[").append(mensagem).append("]");
        return sb.toString();
    } 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UDP other = (UDP) obj;
        if (mensagem == null) {
            if (other.mensagem != null)
                return false;
        } else if (!mensagem.equals(other.mensagem))
            return false;
        return true;
    }

    

}
