package aula07;

import aula05.DateYMD;

public class DateND extends Date {
    private int daysSince2000;
    private static final DateYMD REFERENCE_DATE = new DateYMD(1, 1, 2000);
   
    public DateND(int daysSince2000) {
        this.daysSince2000 = daysSince2000;
    }
    
    public DateND(int day, int month, int year) {
        if (!valid(day, month, year)) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.daysSince2000 = calculateDaysSince2000(day, month, year);
    }
    
    private int calculateDaysSince2000(int day, int month, int year) {
        int days = 0;
        
        //anos completos
        for (int y = 2000; y < year; y++) {
            days += leapYear(y) ? 366 : 365;
        }
        
        //meses completos
        for (int m = 1; m < month; m++) {
            days += monthDays(m, year);
        }
        
        days += day - 1;
        
        return days;
    }
    
    private int[] convertToYMD() {
        int days = daysSince2000;
        int year = 2000;
        int month = 1;
        int day = 1;
        
        while (days >= (leapYear(year) ? 366 : 365)) {
            days -= leapYear(year) ? 366 : 365;
            year++;
        }
        
        while (days >= monthDays(month, year)) {
            days -= monthDays(month, year);
            month++;
        }
        
        day += days;
        
        return new int[]{day, month, year};
    }
    
    @Override
    public int getDay() {
        return convertToYMD()[0];
    }
    
    @Override
    public int getMonth() {
        return convertToYMD()[1];
    }
    
    @Override
    public int getYear() {
        return convertToYMD()[2];
    }
    
    @Override
    public void setDay(int day) {
        int[] ymd = convertToYMD();
        if (!valid(day, ymd[1], ymd[2])) {
            throw new IllegalArgumentException("Dia inválido");
        }
        this.daysSince2000 = calculateDaysSince2000(day, ymd[1], ymd[2]);
    }
    
    @Override
    public void setMonth(int month) {
        if (!validMonth(month)) {
            throw new IllegalArgumentException("Mês inválido");
        }
        int[] ymd = convertToYMD();
        if (!valid(ymd[0], month, ymd[2])) {
            throw new IllegalArgumentException("Dia inválido para o mês especificado");
        }
        this.daysSince2000 = calculateDaysSince2000(ymd[0], month, ymd[2]);
    }
    
    @Override
    public void setYear(int year) {
        int[] ymd = convertToYMD();
        if (!valid(ymd[0], ymd[1], year)) {
            throw new IllegalArgumentException("Dia inválido para o mês/ano especificado");
        }
        this.daysSince2000 = calculateDaysSince2000(ymd[0], ymd[1], year);
    }
    
    @Override
    public void increment() {
        daysSince2000++;
    }
    
    @Override
    public void decrement() {
        daysSince2000--;
    }
    
    @Override
    public String toString() {
        int[] ymd = convertToYMD();
        return String.format("%d-%d-%d", ymd[2], ymd[1], ymd[0]);
    }
}