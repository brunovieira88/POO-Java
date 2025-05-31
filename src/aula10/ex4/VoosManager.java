package aula10.ex4;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VoosManager {
    private Map<Companhia, List<Voo>> voosPorCompanhias = new HashMap<>();
    private Map<String, Companhia> companhias = new HashMap<>();

    public void loadCompanhias(String file){
        try {
            Files.lines(Paths.get(file))
            .skip(1)
            .forEach(line -> {
                String[] parts = line.split("\\t");
                String sigla = parts[0].trim(); 
                String nome = parts[1].trim(); 
                Companhia c = new Companhia(sigla, nome);
                companhias.put(sigla, c);
                voosPorCompanhias.put(c, new ArrayList<>());
            });
        } catch (Exception e) {
            System.err.println("erro ao ler ficheiro de companhias: " + e.getMessage());
        }
    }

    public void loadVoos(String file){
        try {
            Files.lines(Paths.get(file))
                .skip(1)
                .forEach(line -> {
                    String[] parts = line.split("\\t");
                    String atraso = (parts.length == 4) ? parts[3].trim() : "";
                    Voo v = new Voo(parts[0].trim(), parts[1].trim(), parts[2].trim(), atraso);
                    Companhia c;
                    if (companhias.containsKey(v.getSigla())){
                        c = companhias.get(v.getSigla());
                    }else{
                        c = new Companhia(v.getSigla(), "Unknown");
                    }
                    if(!voosPorCompanhias.containsKey(c)){
                        voosPorCompanhias.put(c, new ArrayList<>());
                    }

                    voosPorCompanhias.get(c).add(v);
                });
        } catch (IOException e) {
            System.err.println("erro ao ler ficheiro voos: " + e.getMessage());
        }
    }

    public void mostrarTabela() {
        System.out.printf("%-6s %-10s %-25s %-20s %-7s %-15s\n",
            "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");

        voosPorCompanhias.forEach((comp, lista) -> {
            for (Voo v : lista) {
                String obs = v.getAtraso().isEmpty() ? "" : "Previsto: " + v.horaPrevista();
                System.out.printf("%-6s %-10s %-25s %-20s %-7s %-15s\n",
                    v.getHora(), v.getSigla() + " " + v.getNumero(), comp.getNome(),
                    v.getOrigem(), v.getAtraso(), obs);
            }
        });
    }

    public void guardarTabela(String file) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "utf-8"))) {
            voosPorCompanhias.forEach((comp, lista) -> {
                for (Voo v : lista) {
                    String obs = v.getAtraso().isEmpty() ? "" : "Previsto: " + v.horaPrevista();
                    try {
                        writer.write(String.format("%s\t%s %s\t%s\t%s\t%s\t%s%n",
                            v.getHora(), v.getSigla(), v.getNumero(), comp.getNome(),
                            v.getOrigem(), v.getAtraso(), obs));
                    } catch (IOException e) {
                        System.err.println("erro ao escrever a linha: " + e.getMessage());
                    }
                }
            });
        } catch (IOException e) {
            System.err.println("erro ao escrever tabela: " + e.getMessage());
        }
    }

    public void mediaAtrasosPorCompanhia() {
        voosPorCompanhias.entrySet().stream()
            .map(e -> Map.entry(
                e.getKey(),
                e.getValue().stream()
                    .filter(v -> !v.getAtraso().isEmpty())
                    .mapToInt(Voo::atrasoMinutos)
                    .average().orElse(0)))
            .sorted(Map.Entry.comparingByValue())
            .forEach(e -> System.out.printf("%-25s : %.2f min\n", e.getKey().getNome(), e.getValue()));
    }

    public void guardarChegadasPorCidade(String file) {
        Map<String, Long> cidades = voosPorCompanhias.values().stream()
        .flatMap(List::stream)
        .collect(Collectors.groupingBy(Voo::getOrigem, Collectors.counting()));

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "utf-8"))) {
            cidades.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(e -> {
                    try {
                        writer.write(String.format("%-25s %d%n", e.getKey(), e.getValue()));
                    } catch (IOException ex) {
                        System.err.println("erro ao escrever linha: " + ex.getMessage());
                    }
                });
        } catch (IOException e) {
            System.err.println("erro ao escrever cidades.txt: " + e.getMessage());
        }
    }
}
