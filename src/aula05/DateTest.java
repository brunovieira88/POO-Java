package aula05;

import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) {
        int day, month, year, op;
        DateYMD date = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Date operations:\r\n" + 
                                "1 - create new date\r\n" + 
                                "2 - show current date\r\n" + 
                                "3 - increment date\r\n" + 
                                "4 - decrement date\r\n" + 
                                "0 - exit");
            System.out.print("escolhe a opcao: ");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.print("dia: ");
                    day = scanner.nextInt();
                    System.out.print("mes: ");
                    month = scanner.nextInt();
                    System.out.print("ano: ");
                    year = scanner.nextInt();
                    date = new DateYMD(day, month, year);
                    break;
                
                case 2:
                    if(date == null) {
                        System.out.println("nenhuma data criada");
                    }else{
                        System.out.println(date.toString());
                    }
                    break;
                case 3:
                    if(date == null) {
                        System.out.println("nenhuma data criada");
                    }else{
                        date.increment();
                    }
                    break;
                case 4:
                    if(date == null) {
                        System.out.println("nenhuma data criada");
                    }else{
                        date.decrement();
                    }
                    break;
                case 0: break;
                default:
                    System.out.println("Opcao nao existe");
            }
        } while (op!=0);
        scanner.close();
    }
}
