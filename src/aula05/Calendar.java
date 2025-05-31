package aula05;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private int year, firstWeekday;
    private List<List<Integer>> events;

    //construtor
    public Calendar(int year, int firstWeekday){
        this.year = year;
        this.firstWeekday = firstWeekday;
        this.events = new ArrayList<>(12); 
        for (int i = 0; i < 12 ; i++){ 
            events.add(new ArrayList<>()); //cria uma lista para cada mes
        } 
    }

    public int getYear() {
        return year;
    }

    public int getFirstWeekday() {
        return firstWeekday;
    }

    public int firstWeekdayMes(int month){
        int days = 0;
        for (int i = 1; i < month ; i++){
            days += DateYMD.monthDays(i, year); //numero total de dias do inicio do ano ate ao mes anterior
        }
        return (firstWeekday + days) % 7; //%por 7 para estar entre 0-6
    }

    public void addEvent(DateYMD date){
        if (date.getYear() != year){
            throw new IllegalArgumentException("evento tem que estar no mesmo ano do calendario");
        }
        int month = date.getMonth() - 1; //-1 porque comeca em 0
        int day = date.getDay() -1 ; //mesmo que na linha cima

        // criar elementos na lista 
        while (events.get(month).size() <= day) {
            events.get(month).add(0);
        }
        // incrementa o número de eventos no dia específico do mês
        events.get(month).set(day, events.get(month).get(day) + 1);
    }

    public void removeEvent (DateYMD date){
        if (date.getYear() != year){
            throw new IllegalArgumentException("evento tem quie estar no mesmo ano do calendario");
        }
        int month = date.getMonth() - 1; //-1 porque comeca em 0
        int day = date.getDay() -1 ; //mesmo que na linha cima
        
        if ( events.get(month).size() > day && events.get(month).get(day) > 0){
            events.get(month).set(day, events.get(month).get(day) - 1);
        }
    }

    public String printMonth(int month){
        String res = "";
        String[] monthNames = {"January", "February", "March", "April", "May", "June", 
                               "July", "August", "September", "October", "November", "December"};
        res += monthNames[month - 1] + " " + year + "\n";
        res += "Su Mo Tu We Th Fr Sa\n";

        int firstWeekday = firstWeekdayMes(month);
        int daysInMonth = DateYMD.monthDays(month, year);

        //adiciona espaços para os dias iniciais
        for (int i = 0; i < firstWeekday; i++) {
            res += "   ";
        }
        for (int day = 1; day <= daysInMonth; day++) {
            int eventCount = (events.get(month - 1).size() >= day) ? events.get(month - 1).get(day - 1) : 0;
            if (eventCount > 0) {
                res += "*";
                res += String.format("%1d", day); //aqui so uma espaco para o * ficar junto ao numero
            } else {
                res += "";
                res += String.format("%2d", day);
            }
            

            if ((day + firstWeekday) % 7 == 0 || day == daysInMonth) {
                res += "\n";
            } else {
                res += " ";
            }
        }
        return res;
    }

    @Override
    public String toString(){
        String res = "";
        for (int month = 1; month<=12; month++){
            res += printMonth(month) + "\n";
        }
        return res;
    }
    //teste rapido
    public static void main(String[] args) {
        Calendar calendar = new Calendar(2024, 1); 
        calendar.addEvent(new DateYMD(13, 1, 2024));
        calendar.addEvent(new DateYMD(5, 2, 2024));

        System.out.println(calendar.printMonth(1));
        System.out.println(calendar.printMonth(2));
        System.out.println(calendar.toString());
    }
}

