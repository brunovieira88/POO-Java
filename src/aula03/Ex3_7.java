package aula03;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;

public class Ex3_7 {
    public static void main(String[] args) throws IOException{
        HashSet<String> words = new HashSet<>();
        Scanner input = new Scanner(new FileReader("words.txt"));
        while (input.hasNext()) {
            String word = input.next();
            if (word.length() > 2){
                words.add(word);
            }
            if (word.endsWith("s")){
                System.out.println(word);
            }

        }
        input.close();
        for (String word : words){
            if(word.matches("[a-zA-Z]")){
                words.remove(word);
            }
        }
    }
}
