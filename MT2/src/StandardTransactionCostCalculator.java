import java.time.LocalDateTime;

public class StandardTransactionCostCalculator implements ITransactionCostCalculator{
    private static int hourCost= 50;

    @Override
    public double calculateTransactionCost(Transaction t) {
        LocalDateTime serviceDate = t.getServiceDate();
        java.time.DayOfWeek diaDaSemana = serviceDate.getDayOfWeek();
        double workHours = t.getWorkHours();
    
        switch (diaDaSemana) {
            case SATURDAY:
            case SUNDAY:
                return workHours * hourCost *2;
            case WEDNESDAY:
                return  workHours * hourCost * 0.9;
            default:
                return  workHours * hourCost;
        }
    }


    
}
