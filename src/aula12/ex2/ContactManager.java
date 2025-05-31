package aula12.ex2;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ContactManager {
    private Set<Contact> contacts = new HashSet<>();
    
    ContactManager(){
        this.contacts = new HashSet<>();
    }

    public void addContact (Contact c){
        if (contacts.stream().equals(c)){
            System.out.println("Contact already exists");
        }else{
            contacts.add(c);
            System.out.println("contact added with success");
        }
    }

    public void removeContact(Contact c) {
        boolean removed = contacts.removeIf(contact -> contact.getiD() == c.getiD());
        if (removed){
            System.out.println("Removed with success");
        }else{
            System.out.println("Contact with the id given does not exist");
        }
    }

    public Contact getContact(int iD) {
        return contacts.stream()
                .filter(contact -> contact.getiD() == iD)
                .findFirst()
                .orElse(null);
    }

    public double calculateContactCost(int iD){
        Contact contact = getContact(iD);
        if (contact == null) return -1;

        StandardCostCalculator calculator = new StandardCostCalculator();
        
        double emailCost = calculator.calculateCost(1, IContactCostCalculator.ContactType.EMAIL);
        double callCost = calculator.calculateCost(1, IContactCostCalculator.ContactType.CELLNUMBER);
        return emailCost + callCost;
    }

    public void printAllContacts(){
        contacts.stream()
            .forEach(System.out::println);
    }

    public List<Contact> getContactsAfter(LocalDate date){
        return contacts.stream()
            .filter(contact -> contact.getBirthDate().isAfter(date))
            .collect(Collectors.toList());
    }


    public void readFile(String file) {
        try {
            Files.lines(Paths.get(file))
                .forEach(line -> {
                    String[] parts = line.split("\\t");
                    if (parts.length == 4) {
                        String name = parts[0].trim();
                        int phone = Integer.parseInt(parts[1].trim());
                        String email = parts[2].trim();
                        String birthDate = parts[3].trim();
                        Contact contact = new Contact(name, phone, email, birthDate);
                        addContact(contact);
                    }
                });
        } catch (Exception e) {
            System.err.println("error reading contacts file: " + e.getMessage());
        }
    }

    public void writeFile( String file){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "utf-8"))) {
            for (Contact contact : contacts) {
                try {
                    writer.write(String.format("%s ; %d ; %s ; %s%n",
                        contact.getName(),
                        contact.getNumTel(),
                        contact.getEmail(),
                        contact.getBirthDate()));
                } catch (IOException e) {
                    System.err.println("erro ao escrever a linha: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("erro ao escrever tabela: " + e.getMessage());
        }
    }

}
