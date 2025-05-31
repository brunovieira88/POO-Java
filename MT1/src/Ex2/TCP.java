package Ex2;


public class TCP extends Pacote{
    private static int contadorNum = 100;
    private int numSequencia;
    private String mensagem;

    TCP(String source , String destino, String mensagem){
        super(source, destino);
        if (validMensagem(mensagem)){
            this.mensagem = mensagem;
        }
        else{
            System.out.println("mensagem excedeu o limite (1460)");
        }
        this.numSequencia = contadorNum++;
    }

    public int getNumSequencia(){
        return numSequencia;
    }

    public String getMensagem(){
        return mensagem;
    }

    public void setMensagem(String mensagem){
        if (validMensagem(mensagem)){
            this.mensagem = mensagem;
        }
        else{
            System.out.println("mensagem excedeu o limite (1460)");
        }
    }

    private boolean validMensagem(String mensagem){
        if (mensagem.length()<1461){
            return true;
        }
        else return false;
    }

    @Override

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(", seq:").append(numSequencia).append(")");
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
        TCP other = (TCP) obj;
        if (numSequencia != other.numSequencia)
            return false;
        if (mensagem == null) {
            if (other.mensagem != null)
                return false;
        } else if (!mensagem.equals(other.mensagem))
            return false;
        return true;
    }

    
}
