package aula05;

public class TestAgency {
    public static void main(String[] args) {
        AgenciaLeilao agencia = new AgenciaLeilao();

        agencia.addImovel(new Imovel(2, "Glória", 30000, true, null, null));
        agencia.addImovel(new Imovel(1, "Vera Cruz", 25000, false, null, null));
        agencia.addImovel(new Imovel(3, "Santa Joana", 32000, true, new DateYMD(24, 3, 2023), new DateYMD(24, 3, 2023)));
        agencia.addImovel(new Imovel(2, "Aradas", 24000, true, new DateYMD(3, 4, 2023), new DateYMD(3, 4, 2023)));
        agencia.addImovel(new Imovel(2, "São Bernardo", 20000, true, null, null));

        agencia.sellImovel(1001);
        agencia.verificarDisponibilidade(1001);
        agencia.verificarDisponibilidade(1010);

        agencia.listImoveis();
    }
}
