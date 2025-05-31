package utilitarios;

public class DateYMD {

    private int day, month, year;
    
    public DateYMD(int day, int month, int year){
        if(!valid(day, month, year)){
            throw new IllegalArgumentException("Data inválida");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public void setDay(int day){
        if (day > monthDays(this.month, this.year) || day < 1){
            throw new IllegalArgumentException("Dia invalido");
        }
        this.day = day;
    }

    public int getDay(){
        return this.day;
    }

    public void setMonth(int month){
        if(!validMonth(month)){
            throw new IllegalArgumentException("Mes invalido");
        }
        this.month = month;
    }

    public int getMonth(){
        return this.month;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    public static boolean validMonth(int month){
        if (month>=1 && month<=12){
            return true; 
        }else{
            return false;
        }
        
    }

    public static int monthDays(int month, int year){        
        switch (month) {
            case 1,3,5,7,8,10,12:
                return 31;    
            case 2:
                if (leapYear(year)){return 29;}
                else{return 28;}
            default: return 30;
        }
    }

    public static boolean leapYear(int year){
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
        if (!validMonth(month)){
            return false;
        }
        if (day > monthDays(month, year) || day < 1){
            return false;
        }else{
            return true;
        }
    }

    public void increment() {
        day++;
        if(day > monthDays(month, year)){
            if(month ==12){
                day =1;
                month = 1;
                year++;
            }
            else{
                month++;
                day = 1;
            }
        }
    }

    public void decrement() {
        day--;
        if (day <= 0) {
            if (month == 1){
                month=12;
                year--;
                day = monthDays(month, year);
            }
            else{
                month--;
                day = monthDays(month, year);
            }
        }
    }

    @Override
    public String toString(){
        return String.format("%d-%d-%d", year, month, day);
    }
}

