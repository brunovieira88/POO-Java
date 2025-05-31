package aula10.ex3;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnergyUsageReport {
        
    private Map<Integer, List<Double>> clients = new HashMap<>();
    
    EnergyUsageReport(){
        load("clients.txt");
    }

    public void load (String ficheiro){
        try {
            Files.lines(Paths.get(ficheiro))
                 .forEach(line -> {
                     String[] parts = line.split("\\|");
                     int clientID = Integer.parseInt(parts[0].trim());
                     List<Double> leituras = new ArrayList<>(Arrays.stream(parts, 1, parts.length)
                                                 .map(String::trim)
                                                 .map(Double::parseDouble)
                                                 .toList());
                     clients.put(clientID, leituras);
                 });
        } catch (IOException e) {
            System.err.println("error reading the file: " + e.getMessage());
        }
    }  
    
    public void addCustomer(Customer customer){
        if(clients.containsKey(customer.getCustomerId())){
            System.out.println("customer already exists");
        }else{
            clients.put(customer.getCustomerId(), customer.getMeterReadings());
        }
    }

    public void removeCustomer(int ID){
        if(clients.containsKey(ID)){
            clients.remove(ID);
        }else{
            System.out.println("customer does not exist");
        }
    }

    public Customer getCustomer(int ID){
        Customer customer = new Customer(ID, clients.get(ID));
        return customer;
    }
    
    public double calculateTotalUsage(int ID){
        double average = clients.get(ID).stream()
                                  .mapToDouble(Double::doubleValue)
                                  .average()
                                  .orElse(0.0);
        return average;
    }

    public void generateReport(String outputFile){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream(outputFile), "utf-8"))) {
            for(Map.Entry<Integer, List<Double>> entry : clients.entrySet()){
                StringBuilder sb = new StringBuilder();
                sb.append("Customer id: ").append(entry.getKey()).append(", Leituras: ").append(entry.getValue()).append("\n");
                writer.write(sb.toString());
            }
        } catch (IOException e) {
            System.err.println("error writing to file: " + e.getMessage());
        }
    }
}

