package aula09.ex2;

public class Plane {
    protected String id, fabricante, modelo;
    protected int anoProducao, npassageiros, vmax;

    public Plane(String id, String fabricante, String modelo, int anoProducao, int npassageiros, int vmax) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anoProducao = anoProducao;
        this.npassageiros = npassageiros;
        this.vmax = vmax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoProducao() {
        return anoProducao;
    }

    public void setAnoProducao(int anoProducao) {
        this.anoProducao = anoProducao;
    }

    public int getNpassageiros() {
        return npassageiros;
    }

    public void setNpassageiros(int npassageiros) {
        this.npassageiros = npassageiros;
    }

    public int getVmax() {
        return vmax;
    }

    public void setVmax(int vmax) {
        this.vmax = vmax;
    }

    public String getPlaneType(){
        return "Normal";
    }

    @Override

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Aviao: ").append("id : ").append(id);
        sb.append(", fabricante: ").append(fabricante);
        sb.append(", modelo: ").append(modelo);
        sb.append(", ano de produçao: ").append(anoProducao);
        sb.append(", numero de passageiros: ").append(npassageiros);
        sb.append(", velocidade maxima: ").append(vmax);
        return sb.toString();
    }
    
}
