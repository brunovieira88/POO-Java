package aula07;

public class ObraDigital extends Obra{
    private String tipoObra, endereço;

    public ObraDigital(String nome, String autor, double basePrice, String tipoObra, String endereço) {
        super(nome, autor, basePrice);
        this.tipoObra = tipoObra;
        this.endereço = endereço;
    }
    
    public String getTipoObra(){
        return tipoObra;
    }

    public void setTipoObra(String tipoObra){
        this.tipoObra = tipoObra;
    }
    
    public String getEndereço(){
        return endereço;    
    }

    public void setEndereço(String endereço){
        this.endereço = endereço;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" Blockchain: ").append(tipoObra);
            sb.append(" Endereço: ").append(endereço);
            return sb.toString();
    }

    
}   
