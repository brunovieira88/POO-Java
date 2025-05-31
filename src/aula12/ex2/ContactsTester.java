package aula12.ex2;

import java.time.LocalDate;
import java.util.List;

public class ContactsTester {
    public static void main(String[] args) {
        ContactManager cm = new ContactManager();

        // --------------------------
        Contact c1 = new Contact("Maria Joaquina", 911234567, "joaquina@ua.pt", "1985-01-01");      
        Contact c2 = new Contact("João Miguel", 911234568, "joao@ua.pt", "1988-01-01");
        cm.addContact(c1);
        cm.addContact(c2);
        // Adicionar alguns contatos (exemplo)
        cm.addContact(new Contact("Ana", 912345678, "ana@email.com", "1999-12-31"));
        cm.addContact(new Contact("João", 923456789, "joao@email.com", "2000-01-02"));
        cm.addContact(new Contact("Maria", 934567890, "maria@email.com", "2005-06-15"));
        
        // Pesquisar contatos nascidos após 01/01/2000
        LocalDate cutoffDate = LocalDate.parse("2000-01-01");
        List<Contact> youngContacts = cm.getContactsAfter(cutoffDate);
        
        // Exibir resultados
        System.out.println("Contatos nascidos após " + cutoffDate + ":");
        youngContacts.forEach(System.out::println);
        cm.printAllContacts();
        // --------------------------

        c1 = cm.getContact(1);
        System.out.println(c1);
        c2 = cm.getContact(2);
        System.out.println(c2);
        System.out.println(cm.getContact(5));           // -- não existe!
        System.out.println(cm.calculateContactCost(5)); // -- não existe!
        // --------------------------

  
        cm.printAllContacts();
        // --------------------------

        cm.readFile("contatos.txt");
        cm.printAllContacts();
        // --------------------------

        c1 = cm.getContact(1);
        System.out.println(c1);
        c2 = cm.getContact(2);
        System.out.println(c2);
        System.out.println(cm.getContact(5));
        System.out.println(cm.calculateContactCost(5));
        // --------------------------

        cm.writeFile("out.txt");
    }
}
