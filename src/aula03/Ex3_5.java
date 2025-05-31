package aula03;

import java.io.*;
import java.util.*;

public class Ex3_5 {
    record Person(String name, double noteP, double noteT, double noteF) {}

    public static void main(String[] args) {
        String filePath = "notas.txt"; // Replace with your file path
        List<Person> persons = new ArrayList<>();
        double totalNoteP = 0;
        double totalNoteT = 0;
        double totalNoteF = 0;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\t");
                if (parts.length == 3) {
                    String name = parts[0];
                    double noteP = Double.parseDouble(parts[1]);
                    double noteT = Double.parseDouble(parts[2]);
                    double noteF = noteP * 0.6 + noteT * 0.4;
                    persons.add(new Person(name, noteP, noteT, noteF));
                    totalNoteP += noteP;
                    totalNoteT += noteT;
                    totalNoteF += noteF;
                    count++;
                }
            }

            if (count > 0) {
                double averageNoteP = totalNoteP / count;
                double averageNoteT = totalNoteT / count;
                double averageNoteF = totalNoteF / count;

                System.out.printf("Average noteP: %.2f\n", averageNoteP);
                System.out.printf("Average noteT: %.2f\n", averageNoteT);
                System.out.printf("Average noteF: %.2f\n", averageNoteF);

                System.out.println("Persons with noteT above the overall average:");
                persons.stream()
                        .filter(person -> person.noteT() > averageNoteT)
                        .map(Person::name)
                        .forEach(System.out::println);
                System.out.println("Persons with noteF above the overall average:");
                persons.stream()
                        .filter(person -> person.noteF() > averageNoteF)
                        .map(Person::name)
                        .forEach(System.out::println);

            } else {
                System.out.println("No data found in the file.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in file: " + e.getMessage());
        }
    }
}

