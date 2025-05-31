package aula09.ex2;

public class MilitaryPlane extends Plane{
    private int municoes;

    public MilitaryPlane(String id, String fabricante, String modelo, int anoProducao, int npassageiros, int vmax,
            int municoes) {
        super(id, fabricante, modelo, anoProducao, npassageiros, vmax);
        this.municoes = municoes;
    }

    public int getMunicoes() {
        return municoes;
    }

    public void setMunicoes(int municoes) {
        this.municoes = municoes;
    }

    @Override
    public String getPlaneType(){
        return "Militar";
    }

    @Override 
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(", municoes: ").append(municoes);
        return sb.toString();
    }

    
}
