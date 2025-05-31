package aula07;

public class Escultura extends Obra{
    private String material;
    private boolean unica;
    private int exemplares;

    public Escultura(String nome, String autor, double basePrice, String material, boolean unica, int exemplares) {
        super(nome, autor, basePrice);
        this.material = material;
        this.unica = unica;
        this.exemplares = exemplares;
    }

    public String getMaterial(){
        return material;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public String getUnica(){

        return unica?"Sim": "Nao";
    }

    public void setUnica(boolean unica){
        this.unica = unica;
    }

    public int exemplares(){
        return exemplares;
    }

    public void setExemplares(int exemplares){
        this.exemplares = exemplares;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" Tipo de material: ").append(material);
            if (unica){
                sb.append(" Unica: ").append("Sim");
            }else{
                sb.append(" Numero exemplares: ").append(exemplares);
            }
            return sb.toString();
    }
}
