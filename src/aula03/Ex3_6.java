package aula03;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Locale;

public class Ex3_6 {
    public static void main(String[] args) {
        int month, year, day, mDays;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date (mm/yyyy)");

        do {
            System.out.print("Enter the month (mm): ");
            month = scanner.nextInt();
        } while (month > 12 || month < 1);
        do {
            System.out.print("Enter the year (yyyy): ");
            year = scanner.nextInt();
        } while (year<0);
        do {
            System.out.print("Enter the day the month started: ");
            day = scanner.nextInt();
            if (day < 1 || day > 7) {
                System.out.println("Invalid day. Please enter a value between 1 and 7.");
            }
        } while (day>7);
        scanner.close();
        mDays = monthDays(month, year);
        printResults(month, year, day, mDays);
    }
    public static int monthDays(int month, int year){
        boolean is_leap_year = false;
        if (year % 4 == 0) {
            is_leap_year = true;
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    is_leap_year = true;
                else
                    is_leap_year = false;
            }
        }
        else
            is_leap_year = false;
        
        switch (month) {
            case 1,3,5,7,8,10,12:
                return 31;    
            case 2:
                if (is_leap_year){return 29;}
                else{return 28;}
            default: return 30;
        }

        

    }
    public static void printResults(int month, int year, int day, int mDays){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.YEAR, year);
        System.out.printf("\n%20s %d\n", cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH), year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int currentDay = 1;
        for (int i = 1; i < day; i++) {
            System.out.print("   ");
        }

        for (int i = day; i <= 7; i++) {
            System.out.printf("%2d ", currentDay++);
        }
        System.out.println();

        while (currentDay <= mDays) {
            for (int i = 1; i <= 7 && currentDay <= mDays; i++) {
            System.out.printf("%2d ", currentDay++);
            }
            System.out.println();
        }
    }
}
