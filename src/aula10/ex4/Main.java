package aula10.ex4;

public class Main {
    public static void main(String[] args) {
        VoosManager vm = new VoosManager();
        vm.loadCompanhias("companhias.txt");
        vm.loadVoos("voos.txt");

        vm.mostrarTabela();
        vm.guardarTabela("Infopublico.txt");

        System.out.println("\nMédia de atrasos por companhia:");
        vm.mediaAtrasosPorCompanhia();

        vm.guardarChegadasPorCidade("cidades.txt");
    }
}

