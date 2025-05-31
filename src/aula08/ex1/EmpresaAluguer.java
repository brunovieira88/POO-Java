package aula08.ex1;

import java.util.ArrayList;
import java.util.List;

public class EmpresaAluguer {
    private String nome;
    private String codigoPostal;
    private String email;
    private List<Veiculo> viaturas;
    public EmpresaAluguer(String nome, String codigoPostal, String email) {
        this.nome = nome;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.viaturas = new ArrayList<>();
    }
    
    public void adicionarViatura(Veiculo viatura) {
        viaturas.add(viatura);
    }
    
    public List<Veiculo> getViaturas() { return new ArrayList<>(viaturas); }
    
    public Veiculo getViaturaComMaisKm() {
        if (viaturas.isEmpty())  return null;
        Veiculo maisKm = viaturas.get(0);
        for (Veiculo v : viaturas) {
            if (v.distanciaTotal() > maisKm.distanciaTotal()) {
                maisKm = v;
            }
        }
        return maisKm;
    }
    
    public AutomovelLigeiro getLigeiroComMenosKm() {
        AutomovelLigeiro menosKm = null;
        for (Veiculo v : viaturas) {
            if (v instanceof AutomovelLigeiro && !(v instanceof Taxi)) {
                //casting explícito para converter o objeto 'v' do tipo genérico 'Veiculo' para o tipo específico 'AutomovelLigeiro', assumindo que 'v' é uma instância válida desse tipo.
                AutomovelLigeiro al = (AutomovelLigeiro) v;
                if (menosKm == null || al.distanciaTotal() < menosKm.distanciaTotal()) {
                    menosKm = al;
                }
            }
        }
        return menosKm;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s (%s) - %d viaturas", nome, codigoPostal, email, viaturas.size());
    }
}
