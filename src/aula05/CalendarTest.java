package aula05;

import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = null;
        int choice;

        do {
            System.out.println("Calendar operations:");
            System.out.println("1 - create new calendar");
            System.out.println("2 - print calendar month");
            System.out.println("3 - print calendar");
            System.out.println("4 - create event");
            System.out.println("5 - remove event");
            System.out.println("0 - exit");
            System.out.print("option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("year: ");
                    int year = scanner.nextInt();
                    System.out.print("first weekday of year (1-Sunday, 7-Saturday): ");
                    int firstWeekday = scanner.nextInt();
                    calendar = new Calendar(year, firstWeekday);
                    break;
                case 2:
                    if (calendar == null) {
                        System.out.println("calendar not created yet");
                        break;
                    }
                    System.out.print("month (1-12): ");
                    int month = scanner.nextInt();
                    System.out.println(calendar.printMonth(month));
                    break;
                case 3:
                    if (calendar == null) {
                        System.out.println("calendar not created yet");
                        break;
                    }
                    System.out.println(calendar.toString());
                    break;
                case 4:
                    if (calendar == null) {
                        System.out.println("calendar not created yet\n");
                    } else {
                        System.out.print("day: ");
                        int day = scanner.nextInt();
                        System.out.print("month: ");
                        month = scanner.nextInt();
                        System.out.print("year: ");
                        year = scanner.nextInt();                      
                        DateYMD date = new DateYMD(day, month, year);
                        calendar.addEvent(date);
                        System.out.println("event added to " + date + ".\n");
                        System.out.println("invalid date\n");
                    }
                    break;
                case 5:
                    if (calendar == null) {
                        System.out.println("calendar not created yet\n");
                    } else {
                        System.out.print("day: ");
                        int day = scanner.nextInt();
                        System.out.print("month: ");
                        month = scanner.nextInt();
                        System.out.print("year: ");
                        year = scanner.nextInt();
                        DateYMD date = new DateYMD(day, month, year);
                        calendar.removeEvent(date);
                        System.out.println("evento removed from " + date + ".\n");
                    }
                    break;
                default:
                    System.out.println("invalid choice.");
            }
        } while (choice != 0);
        scanner.close();
    }
}
