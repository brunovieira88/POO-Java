package aula10.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PairCounter {
    private static final String separadores = "[\\s\\t\\n\\p{Punct}‘’“”\"'—-]+";
    public static void main(String[] args) {
        String ficheiro = "major.txt";
        Map<String, Map<String, Integer>> wordPairs = new TreeMap<>();
        
        /*
         Um mapa onde:
        Chave: Palavra atual (String)
        Valor: Outro mapa (TreeMap) que contém:
        Chave: Palavra seguinte (String)
        Valor: Contagem de vezes que essa palavra segue a palavra atual (Integer)
        */
        
        try {
            List<String> words = Files.lines(Paths.get(ficheiro)) //Files.lines(Paths.get(ficheiro)): lê todas as linhas do arquivo "major.txt"
                .flatMap(line -> Arrays.stream(line.split(separadores)))//divide cada linha em palavras usando os separadores definidos
                .map(String::toLowerCase)
                .filter(w -> w.length() >= 3)
                .toList();//todas as palavras para uma lista

            for (int i = 0; i < words.size() - 1; i++) {
                String current = words.get(i);
                String next = words.get(i + 1);

                wordPairs
                    .computeIfAbsent(current, k -> new TreeMap<>()) //se a palavra atual não estiver no mapa, cria uma entrada com treeMap vazio
                    .merge(next, 1, Integer::sum); //incrementa a contagem para o par de palavras 
            }
            wordPairs.forEach((word, followingMap) -> { //followingMap o outro map dentro do wordpairs
                System.out.print(word + "={");
                followingMap.forEach((nextWord, count) -> 
                    System.out.print(nextWord + "=" + count + ", "));
                System.out.println("}");
            
            });        
        
        } catch (IOException e) {
            System.err.println("erro ao ler file");
        } 
    }
}
