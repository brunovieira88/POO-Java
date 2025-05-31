package aula05;

import aula07.Date;

public class DateYMD extends Date implements Comparable<DateYMD>{
    private int day, month, year;
    
    // Construtor mantido exatamente igual
    public DateYMD(int day, int month, int year) {
        if (!valid(day, month, year)) {
            throw new IllegalArgumentException("Data inválida");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    @Override
    public void setDay(int day) {
        if (day > monthDays(this.month, this.year) || day < 1) {
            throw new IllegalArgumentException("Dia invalido");
        }
        this.day = day;
    }

    @Override
    public int getDay() {
        return this.day;
    }

    @Override
    public void setMonth(int month) {
        if (!validMonth(month)) {
            throw new IllegalArgumentException("Mes invalido");
        }
        this.month = month;
    }

    @Override
    public int getMonth() {
        return this.month;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public void increment() {
        day++;
        if (day > monthDays(month, year)) {
            if (month == 12) {
                day = 1;
                month = 1;
                year++;
            }
            else {
                month++;
                day = 1;
            }
        }
    }

    @Override
    public void decrement() {
        day--;
        if (day <= 0) {
            if (month == 1) {
                month = 12;
                year--;
                day = monthDays(month, year);
            }
            else {
                month--;
                day = monthDays(month, year);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%d-%d-%d", year, month, day);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DateYMD other = (DateYMD) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        return true;
    }
    
    @Override
    public int compareTo(DateYMD other) {
        if (this.getYear() != other.getYear()) {
            return Integer.compare(this.getYear(), other.getYear());
        }
        if (this.getMonth() != other.getMonth()) {
            return Integer.compare(this.getMonth(), other.getMonth());
        }
        return Integer.compare(this.getDay(), other.getDay());
    }

}