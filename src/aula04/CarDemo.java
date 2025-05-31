package aula04;

import java.util.Arrays;
import java.util.Scanner;

class Car {
    public String make;
    public String model;
    public int year;
    public int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        //TODO: acumular distância percorrida
        this.kms += distance;
    }

}

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static int registerCars(Car[] cars) {
        int numCars = 0;
        while (numCars < cars.length) {
            System.out.print("dados do carro (marca modelo ano quilómetros): ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length < 4) {
                System.out.println("dados mal formatados");
                continue;
            }
            try {
                String make = parts[0];
                String model = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length - 2));
                int year = Integer.parseInt(parts[parts.length - 2]);
                int kms = Integer.parseInt(parts[parts.length - 1]);
                if (year < 1000 || year > 9999 || kms < 0) {
                    System.out.println("dados mal formatados");
                    continue;
                }
                cars[numCars] = new Car(make, model, year, kms);
                numCars++;
            } catch (NumberFormatException e) {
                System.out.println("dados mal formatados");
            }
        }
        return numCars;
   }

   static void registerTrips(Car[] cars, int numCars) {
        while (true) {
            System.out.print("viagem no formato \"carro:distância\": ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }
            String[] parts = input.split(":");
            if (parts.length != 2) {
                System.out.println("cados mal formatados");
                continue;
            }
            try {
                int carIndex = Integer.parseInt(parts[0]);
                int distance = Integer.parseInt(parts[1]);
                if (carIndex < 0 || carIndex >= numCars || distance < 0) {
                    System.out.println("dados mal formatados");
                    continue;
                }
                cars[carIndex].drive(distance);
            } catch (NumberFormatException e) {
                System.out.println("dados mal formatados");
            }
        }
    }


    static void listCars(Car[] cars) {
        System.out.println("\nCarros registados: ");
        // TODO: lista todos os carros registados
        // Exemplo de resultado
        // Carros registados: 
        // Toyota Camry, 2010, kms: 234346
        // Renault Megane Sport Tourer, 2015, kms: 32536
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                System.out.printf("%s %s, %d, kms: %d\n", cars[i].make, cars[i].model, cars[i].year, cars[i].kms);
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars>0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}