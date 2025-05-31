package aula09.ex2;

public class ComercialPlane extends Plane{
    private int tripulantes;

    public ComercialPlane(String id, String fabricante, String modelo, int anoProducao, int npassageiros, int vmax,
            int tripulantes) {
        super(id, fabricante, modelo, anoProducao, npassageiros, vmax);
        this.tripulantes = tripulantes;
    }

    public int getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(int tripulantes) {
        this.tripulantes = tripulantes;
    }

    @Override 

    public String getPlaneType(){
        return "Comercial";
    }

    @Override 
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(", tripulantes: ").append(tripulantes);
        return sb.toString();
    }
    
}
