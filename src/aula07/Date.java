package aula07;

public abstract class Date {
    public abstract int getDay();
    public abstract int getMonth();
    public abstract int getYear();
    public abstract void setDay(int day);
    public abstract void setMonth(int month);
    public abstract void setYear(int year);
    public abstract void increment();
    public abstract void decrement();
    
    public static boolean validMonth(int month) {
        if (month >= 1 && month <= 12) {
            return true; 
        } else {
            return false;
        }
    }

    public static int monthDays(int month, int year) {        
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;    
            case 2:
                if (leapYear(year)) { return 29; }
                else { return 28; }
            default: return 30;
        }
    }

    public static boolean leapYear(int year) {
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
        return is_leap_year;
    }

    public static boolean valid(int day, int month, int year) {
        if (!validMonth(month)) {
            return false;
        }
        if (day > monthDays(month, year) || day < 1) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public abstract String toString();
}