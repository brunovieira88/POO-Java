import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class TransactionManager {
    private Set<Transaction> transactions = new HashSet<>();

    public void addTransaction (Transaction c){
        if (transactions.stream().equals(c)){
            System.out.println("transaçao ja existe");
        }else{
            transactions.add(c);
        }
    }

    public void removeTransaction(int iD) {
        boolean removed = transactions.removeIf(contact -> contact.getiD() == iD);
        if (removed){
            System.out.println("transaçao removida com sucesso");
        }else{
            System.out.println("transaçao nao existe");
        }
    }

    public Transaction getTransaction(int iD) {
        return transactions.stream()
                .filter(contact -> contact.getiD() == iD)
                .findFirst()
                .orElse(null);
    }

    public double calculateTransactionCost(int iD){
        Transaction transaction = getTransaction(iD);
        if (transaction == null) return -1;

        StandardTransactionCostCalculator calculator = new StandardTransactionCostCalculator();
        return calculator.calculateTransactionCost(transaction);
    }

    public void printAllTransactions() {
        transactions.stream()
            .sorted((t1, t2) -> Integer.compare(t1.getiD(), t2.getiD()))
            .forEach(System.out::println);
    }

    public void sortTransactionsByCost() {
        transactions.stream()
            .sorted((t1, t2) -> {
                int cmp = t1.getServiceDate().getDayOfWeek().compareTo(t2.getServiceDate().getDayOfWeek());
                if (cmp == 0) {
                    double cost1 = calculateTransactionCost(t1.getiD());
                    double cost2 = calculateTransactionCost(t2.getiD());
                    return Double.compare(cost1, cost2);
                }
                return cmp;
            })
            .forEach(System.out::println);
    }

    public void readFile(String file) {
        try {
            Files.lines(Paths.get(file))
                .skip(1)
                .forEach(line -> {
                    String[] parts = line.split(";");
                    if (parts.length == 4) {
                        int id = Integer.parseInt(parts[0].trim());
                        double workHours = Double.parseDouble(parts[1].trim());
                        String desc = parts[2].trim();
                        String date = parts[3].trim();
                        Transaction duplicate = getTransaction(id);
                        if (getTransaction(id) != null){
                            duplicate.setWorkHours(workHours);
                            duplicate.setDescService(desc);
                            duplicate.setServiceDate(date);
                        }else{
                            Transaction transaction = new Transaction(desc, date, workHours);
                            transactions.add(transaction);
                        }
                    }
                });
        } catch (Exception e) {
            System.err.println("erro ao ler ficheiro: " + e.getMessage());
        }
    }

    public void writeFile(String file) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "utf-8"))) {
            for (Transaction transaction : transactions) {
                try {
                    writer.write(String.format("%d ; %.2f ; %s ; %s ; %.2f%n",
                        transaction.getiD(),
                        transaction.getWorkHours(),
                        transaction.getDescService(),
                        transaction.getdateString(),
                        calculateTransactionCost(transaction.getiD())));
                } catch (IOException e) {
                    System.err.println("erro ao escrever a linha: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("erro ao escrever ficheiro " + e.getMessage());
        }
    }

    
}
