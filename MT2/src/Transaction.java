import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int idCounter = 1;
    private int iD;
    private double workHours;
    private String descService;
    private LocalDateTime serviceDate;
    private String dateString; //para usar no toString

    Transaction(String descService, String serviceDate, double workHours){
        this.iD = idCounter++;
        this.workHours = workHours;
        this.descService = descService;
        this.dateString = serviceDate;
        setServiceDate(serviceDate);
    }

    
    public int getiD() {
        return iD;
    }


    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    public String getDescService() {
        return descService;
    }

    public void setDescService(String descService) {
        this.descService = descService;
    }

    public String getdateString(){
        return this.dateString;
    }

    public LocalDateTime getServiceDate() {
        return serviceDate;
    }


    public void setServiceDate(String serviceDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(serviceDate, formatter);
        this.serviceDate = date;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("serviço: ").append(descService).append(", data: ").append(dateString)
        .append(", horas de trabalho: ").append(workHours).append(", id: ").append(iD);
        return sb.toString();
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (iD != other.iD)
            return false;
        if (Double.doubleToLongBits(workHours) != Double.doubleToLongBits(other.workHours))
            return false;
        if (descService == null) {
            if (other.descService != null)
                return false;
        } else if (!descService.equals(other.descService))
            return false;
        if (serviceDate == null) {
            if (other.serviceDate != null)
                return false;
        } else if (!serviceDate.equals(other.serviceDate))
            return false;
        return true;
    }

}
