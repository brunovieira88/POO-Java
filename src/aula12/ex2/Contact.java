package aula12.ex2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contact {
    private static int idCounter = 1;
    private int iD;
    private String name, email;
    private int numTel;
    private LocalDate birthDate;

    Contact(String name, int numTel, String email, String birthDate){
        this.iD = idCounter++;
        setName(name);
        setEmail(email);
        this.numTel = numTel;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthDate, formatter);
        this.birthDate = date;
    }

    public int getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(validateEmail(email)){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Contact not created: not valid email");
        }
        
    }
    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        if(validatePhone(numTel)){
            this.numTel = numTel;
        }else{
            throw new IllegalArgumentException("Contact not created: not valid phone number");
        }
        
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    private boolean validateEmail( String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(regexPattern);
    }

    private boolean validatePhone(int phoneNumber){
        String phoneStr = String.valueOf(phoneNumber);
        return phoneStr.matches("^\\d{9}$");
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append(", Id: ").append(iD).append(", Telephone number: ").append(numTel)
        .append(", Email: ").append(email).append(", Date of birth: ").append(birthDate);
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
        Contact other = (Contact) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (numTel != other.numTel)
            return false;
        return true;
    }
    
}
