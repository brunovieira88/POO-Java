package aula08.ex1;

public class Main {
    public static void main(String[] args) {
        // Criar empresa
        EmpresaAluguer empresa = new EmpresaAluguer("RentACar", "3810-000", "rent@acar.pt");
        
        // Adicionar viaturas
        empresa.adicionarViatura(new Motociclo("AA-00-AA", "Yamaha", "MT-07", 75, "estrada"));
        empresa.adicionarViatura(new AutomovelLigeiro("BB-11-BB", "Toyota", "Corolla", 120, "123456", 500));
        empresa.adicionarViatura(new Taxi("CC-22-CC", "Mercedes", "E-Class", 190, "789012", 450, "TAXI-123"));
        empresa.adicionarViatura(new PesadoMercadorias("DD-33-DD", "Volvo", "FH16", 540, "345678", 18000, 40000));
        empresa.adicionarViatura(new PesadoPassageiros("EE-44-EE", "MAN", "Lion's Coach", 360, "901234", 12000, 55));
        
        // Simular alguns trajetos
        empresa.getViaturas().get(0).trajeto(150); // Motociclo
        empresa.getViaturas().get(1).trajeto(300); // Automóvel ligeiro
        empresa.getViaturas().get(1).trajeto(200); // Mesmo automóvel
        empresa.getViaturas().get(2).trajeto(1000); // Táxi
        empresa.getViaturas().get(3).trajeto(2500); // Pesado mercadorias
        empresa.getViaturas().get(4).trajeto(1800); // Pesado passageiros
        
        // Criar atleta
        Atleta atleta = new Atleta("Carlos Lopes", "Aveiro");
        atleta.trajeto(15);
        atleta.trajeto(20);
        atleta.trajeto(10);
        
        // Testes parte A
        System.out.println("=== TESTES PARTE A ===");
        System.out.println("Empresa: " + empresa);
        System.out.println("Viatura com mais km: " + empresa.getViaturaComMaisKm());
        System.out.println("Automóvel ligeiro com menos km: " + empresa.getLigeiroComMenosKm());
        
        // Alugar veículo ao atleta
        AutomovelLigeiro veiculoAlugado = empresa.getLigeiroComMenosKm();
        if (veiculoAlugado != null) {
            System.out.println("\nAtleta antes da viagem: " + atleta);
            System.out.println("Veículo antes da viagem: " + veiculoAlugado + " - Km: " + veiculoAlugado.distanciaTotal());
            
            atleta.viajarParaBerlim(veiculoAlugado);
            
            System.out.println("Veículo após viagem: " + veiculoAlugado + " - Km: " + veiculoAlugado.distanciaTotal());
        }
        
        // Testar equals
        Veiculo v1 = new AutomovelLigeiro("BB-11-BB", "Toyota", "Corolla", 120, "123456", 500);
        System.out.println("\nTeste equals (deve ser true): " + v1.equals(empresa.getViaturas().get(1)));

        // ==============================================
        // PARTE B - Testes adicionais para gestão de bateria
        // ==============================================
        
        System.out.println("\n=== TESTES PARTE B ===");
        
        // 1. Criar e adicionar automóvel elétrico
        AutomovelLigeiroEletrico eletrico = new AutomovelLigeiroEletrico(
            "FF-55-FF", "Tesla", "Model S", 670, "ELET-001", 425);
        empresa.adicionarViatura(eletrico);
        
        // 2. Criar telemóvel para o atleta
        Telemovel telemovelAtleta = new Telemovel("912345678", "iPhone", "15 Pro");
        atleta.setTelemovel(telemovelAtleta);
        
        // 3. Simular descarga de baterias
        System.out.println("\nEstado inicial das baterias:");
        System.out.println("- Carro elétrico: " + eletrico.cargaDisponivel() + "%");
        System.out.println("- Telemóvel: " + telemovelAtleta.cargaDisponivel() + "%");
        
        // Descarregar baterias
        eletrico.carregar(-60); // Descarrega para 40%
        telemovelAtleta.carregar(-70); // Descarrega para 30%
        
        System.out.println("\nApós descarregar:");
        System.out.println("- Carro elétrico: " + eletrico.cargaDisponivel() + "%");
        System.out.println("- Telemóvel: " + telemovelAtleta.cargaDisponivel() + "%");
        
        // 4. Limitar carga máxima a 80%
        System.out.println("\nLimitando carga máxima a 80%...");
        limitarCargaDispositivos(empresa, atleta);
        
        System.out.println("\nApós limitar carga:");
        System.out.println("- Carro elétrico: " + eletrico.cargaDisponivel() + "%");
        System.out.println("- Telemóvel: " + telemovelAtleta.cargaDisponivel() + "%");
        
        // 5. Carregar baterias abaixo de 40%
        System.out.println("\nCarregando dispositivos com bateria < 40%...");
        carregarBateriasBaixas(empresa, atleta);
        
        System.out.println("\nEstado final das baterias:");
        System.out.println("- Carro elétrico: " + eletrico.cargaDisponivel() + "%");
        System.out.println("- Telemóvel: " + telemovelAtleta.cargaDisponivel() + "%");
        
        // 6. Testar carregamento além do limite
        System.out.println("\nTestando carregamento além do limite (80%)...");
        System.out.println("Antes de carregar: " + eletrico.cargaDisponivel() + "%");
        eletrico.carregar(30); // Tentar carregar +30%
        System.out.println("Após tentar carregar: " + eletrico.cargaDisponivel() + "% (não deve passar de 80%)");
    }
    
    private static void limitarCargaDispositivos(EmpresaAluguer empresa, Atleta atleta) {
        // Limitar carga nos veículos elétricos da empresa
        for (Veiculo v : empresa.getViaturas()) {
            if (v instanceof IGestaoBateria) {
                IGestaoBateria dispositivo = (IGestaoBateria) v;
                dispositivo.limitarCargaMaxima(80.0);
            }
        }
        
        // Limitar carga no telemóvel do atleta
        if (atleta.getTelemovel() != null) {
            atleta.getTelemovel().limitarCargaMaxima(80.0);
        }
    }
    
    private static void carregarBateriasBaixas(EmpresaAluguer empresa, Atleta atleta) {
        // Carregar veículos elétricos com menos de 40%
        for (Veiculo v : empresa.getViaturas()) {
            if (v instanceof IGestaoBateria) {
                IGestaoBateria dispositivo = (IGestaoBateria) v;
                if (dispositivo.cargaDisponivel() < 40.0) {
                    double cargaNecessaria = 80.0 - dispositivo.cargaDisponivel();
                    dispositivo.carregar(cargaNecessaria);
                }
            }
        }
        
        // Carregar telemóvel se estiver abaixo de 40%
        if (atleta.getTelemovel() != null && atleta.getTelemovel().cargaDisponivel() < 40.0) {
            double cargaNecessaria = 80.0 - atleta.getTelemovel().cargaDisponivel();
            atleta.getTelemovel().carregar(cargaNecessaria);
        }
    }
}